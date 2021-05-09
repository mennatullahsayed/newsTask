package com.news.task.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.news.task.entity.News;
@Repository
public interface NewsDAO   extends JpaRepository<News, Integer> {

}
