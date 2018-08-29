package com.cg.service;

import java.util.List;

import com.cg.exception.ProductException;
import com.cg.model.Products;

public interface IProductService {

	public Products createProduct(Products pd) throws ProductException;
	public Products updateProducts(Products pd) throws ProductException;
	public String deleteProducts(String id) throws ProductException;
	public List<Products> viewProducts() throws ProductException;
	public Products findProducts(String id) throws ProductException;
}
