package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.book;

public interface BooksDao extends JpaRepository<book,Integer> {

}
