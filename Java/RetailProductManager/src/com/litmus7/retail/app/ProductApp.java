package com.litmus7.retail.app;

import java.util.List;
import java.util.Scanner;

import com.litmus7.retail.controller.ProductController;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.dto.Response;
import com.litmus7.retail.exception.ProductServiceException;

public class ProductApp {

	public static void main(String[] args) throws ProductServiceException {
		Scanner scanner = new Scanner(System.in);

		ProductController productController = new ProductController();

		int productId;
		int choice;
		String name;
		String category;
		double price;
		int stockQuantity;
		Product product;
		
		System.out.println("1. Add Product \r\n" + "2. View Product by ID \r\n" + "3. View All Products \r\n"
				+ "4. Update Product \r\n" + "5. Delete Product \r\n" + "6. View Product by Category \r\n"
				+ "7. View Sorted Products by Price \r\n" + "8. Exit");
		
		boolean exit=true;
		while (exit) {
			
			System.out.print("\nPlease select an option : ");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				System.out.print("Enter name : ");
				name = scanner.nextLine();
				
				System.out.print("Enter category: ");
				category = scanner.nextLine();
				
				System.out.print("Enter price: ");
				price = Integer.parseInt(scanner.nextLine());
				
				System.out.print("Enter stock quantity: ");
				stockQuantity = Integer.parseInt(scanner.nextLine());

				product = new Product(name, category, price, stockQuantity);
				Response<Product> responseAdd = productController.addProduct(product);
				if (responseAdd.getStatusCode() == 200) {
					System.out.println(responseAdd.getStatusMessage() + "\n" + responseAdd.getData());
				} else {
					System.err.println(responseAdd.getErrorMessage());
				}
				break;
			
			case 2:
				System.out.print("Enter Product ID: ");
				productId = Integer.parseInt(scanner.nextLine());
				Response<Product> responseSearch = productController.getProductById(productId);
				if (responseSearch.getStatusCode() == 200) {
					System.out.println(responseSearch.getStatusMessage() + "\n" + responseSearch.getData());

				} else {
					System.err.println(responseSearch.getErrorMessage());
				}
				break;
			
			case 3:
				Response<List<Product>> responseAllProducts = productController.getAllProducts();
				if (responseAllProducts.getStatusCode() == 200) {
					System.out.println(responseAllProducts.getStatusMessage());
					List<Product> products = responseAllProducts.getData();
					displayAllProducts(products);

				} else {
					System.err.println(responseAllProducts.getErrorMessage());
				}break;
			
			case 4:
				System.out.print("Enter Product ID: ");
				productId = Integer.parseInt(scanner.nextLine());
				
				Response<Product> response = productController.getProductById(productId);
				if (response.getStatusCode() == 200) {
					System.out.println("Data to be updated" + "\n" + response.getData());

				} else {
					System.err.println(response.getErrorMessage());
				}
				
				System.out.print("Enter name : ");
				name = scanner.nextLine();
				
				System.out.print("Enter category: ");
				category = scanner.nextLine();
				
				System.out.print("Enter price: ");
				price = Integer.parseInt(scanner.nextLine());
				
				System.out.print("Enter stock quantity: ");
				stockQuantity = Integer.parseInt(scanner.nextLine());

				product = new Product(productId, name, category, price, stockQuantity);

				Response<Boolean> responseUpdate = productController.updateProduct(product);
				if (responseUpdate.getStatusCode() == 200) {
					System.out.println(responseUpdate.getStatusMessage());

				} else {
					System.err.println(responseUpdate.getErrorMessage());
				}break;
				
			case 5 :
				System.out.print("Enter Product ID: ");
				productId = Integer.parseInt(scanner.nextLine());
				Response<Boolean> responseDelete = productController.deleteProduct(productId);
				if (responseDelete.getStatusCode() == 200) {
					System.out.println(responseDelete.getStatusMessage());
				} else {
					System.err.println(responseDelete.getErrorMessage());
				}break;
			
			case 6:
				System.out.print("Enter category: ");
				category = scanner.nextLine();
				Response<List<Product>> responseCategory = productController.getProductsByCategory(category);
				if (responseCategory.getStatusCode() == 200) {
					System.out.println(responseCategory.getStatusMessage());
					displayAllProducts(responseCategory.getData());

				} else {
					System.err.println(responseCategory.getErrorMessage());
				}break;
			
			case 7:
				Response<List<Product>> responseSorted = productController.getSortedProducts();
				if (responseSorted.getStatusCode() == 200) {
					System.out.println(responseSorted.getStatusMessage());
					displayAllProducts(responseSorted.getData());

				} else {
					System.err.println(responseSorted.getErrorMessage());
				}break;
			
			case 8:
				System.out.println("Thank you...exiting");
				exit=false;
				break;
			
			default:
				System.out.println("Invalid Choice");
			}
		}


	}

	static void displayAllProducts(List<Product> products) {
		for (Product product : products)
			System.out.println(product);
	}

}
