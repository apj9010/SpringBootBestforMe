package com.cg.controller;
/*
 * class name : ProductController
 * author : @agidda
 * purpose : To integrate with the postman tool 
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.ProductException;
import com.cg.model.Products;
import com.cg.service.IProductService;

@RestController

public class ProductController {
 @Autowired
	private IProductService service; 
	
 @RequestMapping(value = "/createProducts",method=RequestMethod.POST)
	public Products createProduct(@RequestBody Products pd) throws ProductException {
		try {
			pd=service.createProduct(pd);
			
			
		}catch (ProductException e) {
			throw new ProductException(e.getMessage());
		}
		
		return pd;
		
	}
 
 @RequestMapping(value = "/updateProducts",method=RequestMethod.PUT)
	public Products updateProduct(@RequestBody Products pd) throws ProductException {
		try {
			pd=service.updateProducts(pd);
			
			
		}catch (ProductException e) {
			throw new ProductException(e.getMessage());
		}
		
		return pd;
		
	}
 @RequestMapping(value = "/deleteProducts",method=RequestMethod.DELETE)
	public String deleteProduct(String id) throws ProductException {
		String status = service.deleteProducts(id);
		return status;
}
	
@RequestMapping(value = "/viewProducts",method=RequestMethod.GET)
	public List<Products> viewProducts(Products pd) throws ProductException {
		try {
			List<Products> pds =service.viewProducts();
			return pds;
	
		}catch (ProductException e) {
			throw new ProductException(e.getMessage());
		}
}
	
		@RequestMapping(value = "/findProduct",method=RequestMethod.GET)
		public Products findProductss(String id) throws ProductException {
			try {
				Products pd= service.findProducts(id);
				return pd;
		
			}catch (ProductException e) {
				throw new ProductException(e.getMessage());
			}
		
	}
 
}
