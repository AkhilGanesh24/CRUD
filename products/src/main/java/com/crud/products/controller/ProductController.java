package com.crud.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.products.model.Product;
import com.crud.products.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productservice;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("allproductlist", productservice.getProducts());
		return "index";
	}

	@GetMapping("/addnew")
	public String addNewProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "newproduct";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateForm(@PathVariable(value = "id") Integer id, Model model) {
		Product product = productservice.findByProductID(null, id);
		model.addAttribute("product", product);
		return "updateproduct";
	}

	@GetMapping("/deleteProduct/{id}")
	public String deleteThroughId(@PathVariable(value = "id") Integer id) {
		productservice.deleteProduct(id);
		return "redirect:/";

	}

	@PostMapping(value = "/save")
	public String createProduct(@ModelAttribute("product") Product product) {
		productservice.createProduct(product);
		return "redirect:/";
	}

}
