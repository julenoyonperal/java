package com.suraj.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suraj.blog.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
