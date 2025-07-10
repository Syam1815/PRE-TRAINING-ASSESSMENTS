package com.litmus7.retail.dao;

import java.util.List;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.ProductDataAccessException;

public interface ProductDao {
	Product addProduct(Product product) throws ProductDataAccessException;
	Product getProductById(int productId) throws ProductDataAccessException;
	List<Product> getAllProducts() throws ProductDataAccessException;
	boolean updateProduct(Product product) throws ProductDataAccessException;
	boolean deleteProduct(int productId) throws ProductDataAccessException;

}
