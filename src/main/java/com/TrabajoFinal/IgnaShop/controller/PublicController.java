package com.TrabajoFinal.IgnaShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.TrabajoFinal.IgnaShop.Constant.ViewConstant;
import com.TrabajoFinal.IgnaShop.entity.ArticleEntity;
import com.TrabajoFinal.IgnaShop.entity.UsersEntity;
import com.TrabajoFinal.IgnaShop.service.ArticleService;

@Controller
@RequestMapping("/public")
public class PublicController {
	
	@Autowired
	public ArticleService articleService;
	
	@RequestMapping(value = "/guest", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView, UsersEntity user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("index2");
		return modelAndView;
	}
	
	
	@GetMapping("/articles")
	public String listAllArticle(Model model,  ArticleEntity articleEntity) {

		model.addAttribute("article", new ArticleEntity());
		model.addAttribute("articles", articleService.listAllArticles(articleService.findArticleById(articleEntity.getId())));
		return ViewConstant.ARTICLE;
	}
	
	@GetMapping("/articlesOrder")
	public String listAllArticleByOrder(Model model) {

		model.addAttribute("article", new ArticleEntity());
		model.addAttribute("articles", articleService.listArticlesByOrder());
		return ViewConstant.ARTICLE;
	}
	

}
