package com.cg.service;
/*
 * class name : ProductServiceImpl
 * author : @agidda
 * methods : createProduct,updateProduct,viewAllProducts,deleteProducts,findProducts
 */
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.ProductException;
import com.cg.model.Products;
import com.cg.productrepo.IProductRepo;

@Service
@Transactional
@PersistenceContext
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepo repo;
	 
	@Override
	public Products createProduct(Products pd) throws ProductException {
		if(validatePrice(pd.getPrice()) && validateName(pd.getName()) && validateId(pd.getId())) {
		repo.save(pd);
		return pd;
	}
		else {
			throw new ProductException("Product will not be created");
		}
	}

	private boolean validateId(String id) throws ProductException {
		if(id!=null)
		{
		return true;
	}
		else {
			throw new ProductException("Id could not be null");
		}
	}
	

	private boolean validateName(String name) throws ProductException {
		if(name!=null) {
			return true;
		}
		else {
			throw new ProductException("name could not be null");
		}
	}
		


	private boolean validatePrice(double price) throws ProductException {
		if(price!=0) {
		return true;
	}else {
		throw new ProductException("price must greater than 0");
	}
}
		

	@Override
	public Products updateProducts(Products pd) throws ProductException {
		Products pdd = repo.findProductById(pd.getId());
		String name = pd.getName();
		String model = pd.getModel();
		double price = pd.getPrice();
		
		if(name!=null) {
			pdd.setName(name);
		}
		if(price>0) {
			pdd.setPrice(price);
		}
		repo.save(pdd);
		return pdd;
	}

	@Override
	public String deleteProducts(String id) throws ProductException {
    String str = "Enter a valid Id of the product";
    		if(repo.findProductById(id)!=null) {
    			str= "Product Deleted sucessfully";
    			repo.deleteById(id);
    		}
		return str;
	}

	@Override
	public List<Products> viewProducts() throws ProductException {
		
		return repo.findAll();
	}

	@Override
	public Products findProducts(String id) throws ProductException {
		Products pd= repo.findProductById(id);
		if(pd!=null) {
			return pd;
		}
		else {
			throw new ProductException("Product with this Id does not exists");
		}
	}

}
