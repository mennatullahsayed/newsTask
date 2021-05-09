package com.news.task.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.task.DAO.NewsDAO;
import com.news.task.entity.News;
import com.news.task.service.NewsService;

@Service
public class NewsServiceImp implements NewsService {

	
	@Autowired
   private	NewsDAO NewsDAO; 
	
	
	@Override
	public List<News> findAll() {
		
		return NewsDAO.findAll();
	}

	@Override
	public Optional<News> findById(int id) {
		
		return NewsDAO.findById(id);
	}

	@Override
	public void save(News news) {
		NewsDAO.save(news);

	}

	@Override
	public void deleteById(int id) {
		NewsDAO.deleteById(id);

	}

}
