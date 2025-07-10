package com.litmus7.retail.controller;

import java.util.List;

import com.litmus7.retail.constant.StatusCode;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.dto.Response;
import com.litmus7.retail.exception.ProductServiceException;
import com.litmus7.retail.service.ProductService;
import com.litmus7.retail.util.ProductValidationUtil;

public class ProductController {
	private ProductService productService = new ProductService();
	private ProductValidationUtil productValidate = new ProductValidationUtil();

	public Response<Product> addProduct(Product product) {
		Response<Product> response = new Response<>();

		if (productValidate.validateProduct(product)) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage("Please enter the details properly");
		}
		try {
			product = productService.addProduct(product);
			response.setData(product);
			response.setStatusCode(StatusCode.SUCCESS);
			response.setStatusMessage("Product added successfully");
		} catch (ProductServiceException e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		} catch (Exception e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		}
		return response;

	}

	public Response<List<Product>> getAllProducts() {
		Response<List<Product>> response = new Response<>();

		try {
			List<Product> products = productService.getAllProducts();
			response.setStatusCode(StatusCode.SUCCESS);
			response.setStatusMessage("Successfully retrieved all products");
			response.setData(products);

		} catch (ProductServiceException e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		} catch (Exception e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	public Response<Product> getProductById(int productId) {
		Response<Product> response = new Response<>();
		if (productValidate.checkInt(productId)) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage("No productId eneterd ");
		}

		try {
			Product product = productService.getProductById(productId);
			response.setStatusCode(StatusCode.SUCCESS);
			response.setStatusMessage("Successfully retrieved the product");
			response.setData(product);
		} catch (ProductServiceException e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		} catch (Exception e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	public Response<Boolean> updateProduct(Product product) {
		Response<Boolean> response = new Response<>();

		if (productValidate.validateProduct(product)) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage("Please enter the details properly");
		}

		try {
			boolean status = productService.updateProduct(product);
			response.setData(status);
			response.setStatusCode(StatusCode.SUCCESS);
			response.setStatusMessage("Product updated successfully");
		} catch (ProductServiceException e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		} catch (Exception e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		}
		return response;

	}

	public Response<Boolean> deleteProduct(int productId) {
		Response<Boolean> response = new Response<>();
		if (productValidate.checkInt(productId)) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage("No productId eneterd ");
		}
		try {
			boolean status = productService.deleteProduct(productId);
			response.setData(status);
			response.setStatusCode(StatusCode.SUCCESS);
			response.setStatusMessage("Product deleted successfully");
		} catch (ProductServiceException e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		} catch (Exception e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	public Response<List<Product>> getProductsByCategory(String category) {
		Response<List<Product>> response = new Response<>();
		if (productValidate.checkString(category)) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage("No category eneterd ");
		}
		try {
			List<Product> products = productService.getProductsByCategory(category);
			response.setStatusCode(StatusCode.SUCCESS);
			response.setStatusMessage("Successfully retrieved all products for category: " + category);
			response.setData(products);

		} catch (ProductServiceException e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		} catch (Exception e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	public Response<List<Product>> getSortedProducts() {
		Response<List<Product>> response = new Response<>();

		try {
			List<Product> products = productService.getSortedProducts();
			response.setStatusCode(StatusCode.SUCCESS);
			response.setStatusMessage("Successfully retrieved all sorted products");
			response.setData(products);

		} catch (ProductServiceException e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		} catch (Exception e) {
			response.setStatusCode(StatusCode.ERROR);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
}
