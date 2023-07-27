package com.bluka1.rest.webservices.restfulwebservices.jpa;

import com.bluka1.rest.webservices.restfulwebservices.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
