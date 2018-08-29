package com.cg.productrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.model.Products;

@Repository
public interface IProductRepo extends JpaRepository<Products, String>{
 @Query("SELECT a from Products  a where a.id= :id")
 Products findProductById(@Param("id")String id);
 @Query("SELECT a from Products a")
 List<Products> viewProducts();
	
}
