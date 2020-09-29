package br.com.anailson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.anailson.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}

