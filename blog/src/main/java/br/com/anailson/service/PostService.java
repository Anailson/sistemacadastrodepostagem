package br.com.anailson.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anailson.model.Post;
import br.com.anailson.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	public Optional<Post> findOne(Long id) {
		return postRepository.findById(id);
		
				
	}
	
	public Post save(Post post) {
		return postRepository.saveAndFlush(post);
	}
	
	public void delete (Long id) {
		postRepository.deleteById(id);
	}
	

}
