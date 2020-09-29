package br.com.anailson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.anailson.model.Post;
import br.com.anailson.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService service;

	@GetMapping("/")
	public ModelAndView inicio() {

		ModelAndView mv = new ModelAndView("/postAdd");
		mv.addObject("post", service.findAll());

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Post post) {

		ModelAndView mv = new ModelAndView("/postAdd");
		mv.addObject("post", post);

		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return add(service.findOne(id));

	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Post post, BindingResult result) {

		if (result.hasErrors()) {
			return add(post);
		}

		service.save(post);

		return findAll();
	}

}