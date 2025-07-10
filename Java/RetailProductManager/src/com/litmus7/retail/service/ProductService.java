package com.litmus7.retail.service;

import java.util.Collections;
import java.util.List;

import com.litmus7.retail.dao.ProductDaoImpl;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.ProductDataAccessException;
import com.litmus7.retail.exception.ProductServiceException;
import com.litmus7.retail.util.ComparatorUtil;
public class ProductService {

	private ProductDaoImpl productDao = new ProductDaoImpl();

	public Product addProduct(Product product) throws ProductServiceException {
		try {
			product = productDao.addProduct(product);
			if (product == null)
				throw new ProductServiceException("Failed to add product - Insertion failed: 0 rows affected");
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}
		return product;

	}

	public List<Product> getAllProducts() throws ProductServiceException {
		try {
			List<Product> products = productDao.getAllProducts();
			if (!products.isEmpty())
				return products;
			throw new ProductServiceException("Failed to get products");
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}

	}

	public List<Product> getSortedProducts() throws ProductServiceException {
		try {
			List<Product> products = productDao.getAllProducts();
			if (!products.isEmpty()) {
				Collections.sort(products, ComparatorUtil.comparatorByPrice);
				return products;
			}
			throw new ProductServiceException("Failed to get products");
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}

	}

	public Product getProductById(int productId) throws ProductServiceException {
		try {
			Product product = productDao.getProductById(productId);
			if (product != null)
				return product;
			throw new ProductServiceException("No such product exists");

		} catch (ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}
	}

	public boolean updateProduct(Product product) throws ProductServiceException {
		try {
			Boolean status = productDao.updateProduct(product);
			if (!status)
				throw new ProductServiceException("Failed to update product");
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}
		return true;
	}

	public boolean deleteProduct(int productId) throws ProductServiceException {
		try {
			Boolean status = productDao.deleteProduct(productId);
			if (!status)
				throw new ProductServiceException("Failed to delete product");
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}
		return true;
	}

	public List<Product> getProductsByCategory(String category) throws ProductServiceException {
		try {
			List<Product> products = productDao.getProductsByCategory(category);
			if (!products.isEmpty())
				return products;
			throw new ProductServiceException("Failed to get products");
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}

	}
}
