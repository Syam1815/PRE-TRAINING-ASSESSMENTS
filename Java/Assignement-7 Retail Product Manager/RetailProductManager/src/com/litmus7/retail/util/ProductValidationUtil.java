package com.litmus7.retail.util;

import com.litmus7.retail.dto.Product;

public class ProductValidationUtil {

	public boolean validateProduct(Product product) {
		return (product==null || checkString(product.getCategory()) || checkString(product.getName())
				|| checkInt(product.getStockQuantity()) || checkDouble(product.getPrice()));

	}

	public boolean checkString(String string) {
		return (string == null || string.isBlank());
	}

	public boolean checkInt(int number) {
		return (number <= 0);
	}

	private boolean checkDouble(double number) {
		return (number <= 0.0);
	}
}
