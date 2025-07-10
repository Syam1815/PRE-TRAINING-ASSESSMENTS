package com.litmus7.retail.util;

import java.util.Comparator;

import com.litmus7.retail.dto.Product;

public class ComparatorUtil {

	public static Comparator<Product> comparatorByPrice = new Comparator<Product>() {

		public int compare(Product i, Product j) {
			if (i.getPrice() < j.getPrice())
				return -1;
			else if (i.getPrice() == j.getPrice())
				return 0;
			else
				return 1;


		}

	};
}
