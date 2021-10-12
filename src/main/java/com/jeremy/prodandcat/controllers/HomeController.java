package com.jeremy.prodandcat.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeremy.prodandcat.models.Category;
import com.jeremy.prodandcat.models.Product;
import com.jeremy.prodandcat.services.CategoryServ;
import com.jeremy.prodandcat.services.ProductServ;

@Controller
public class HomeController {
	@Autowired
	ProductServ pServ;
	@Autowired
	CategoryServ cServ;

	@RequestMapping("/")
	public String redirect() {

		return "redirect:/new/product";
	}

	@RequestMapping("/new/product")
	public String newProductView(@ModelAttribute("product") Product product) {

		return "newProduct.jsp";
	}
	@RequestMapping("/new/category")
	public String newCategoryView(@ModelAttribute("category") Category category) {
		
		return "newCategory.jsp";
	}
	@RequestMapping("/product/{id}")
	public String productView(Model model, @PathVariable("id") Long id) {
	
		model.addAttribute("product",pServ.findOne(id));
		model.addAttribute("categories", cServ.findAll());
		return "viewProduct.jsp";
	}
	@RequestMapping("/product/category/{prodId}")
	public String productViewAction(Model model, @PathVariable("prodId") Long prodId, @RequestParam("categoryId") Long categoryId) {
		
		pServ.addCatToProd(categoryId, prodId);
		return "redirect:/product/"+prodId;
	}

	@PostMapping("/create/product")
	public String newProductAction(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("product");
			return "newProduct.jsp";
		}
		pServ.create(product);
		return "redirect:/new/product";

	}
	@PostMapping("/create/category")
	public String newCategoryAction(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("category");
			return "newCategory.jsp";
		}
		cServ.create(category);
		return "redirect:/new/product";
		
	}
    @RequestMapping(value="/delete/{prodId}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("prodId") Long prodId, @RequestParam("categoryId") Long categoryId ) {
    	
    	
        pServ.removeCatToProd(categoryId, prodId);
		return "redirect:/product/"+prodId;
    }
}
