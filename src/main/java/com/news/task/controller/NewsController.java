package com.news.task.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.news.task.entity.News;
import com.news.task.service.NewsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewsController.class);

	@Autowired
	private NewsService newsService;

	@GetMapping("view/all")
	public List<News> getNews() {
		return newsService.findAll();
	}

 
	@PostMapping("author/news")
	public void addNews(@RequestPart("file") MultipartFile file, @RequestPart News news) throws IOException {

		try {
			news.setImage(file.getBytes());
			newsService.save(news);
		} catch (Exception e) {
			System.out.println("error");
			log.debug("error in fileUpload " + e);

		}

	}

	@GetMapping("view/{id}")
	public ResponseEntity<News> getNewsById(@PathVariable int id) {

		// test
		Optional<News> newsOptional = newsService.findById(id);

		if (newsOptional.isPresent()) {
			return ResponseEntity.ok(newsOptional.get());
		} else {
			log.debug(id + "id does not exist");
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("author/deleteNews/{id}")
	public void deleteNewsById(@PathVariable int id) {

		try {
			newsService.deleteById(id);
		} catch (Exception e) {
			log.debug(id + "id does not exist");

		}

	}

}
