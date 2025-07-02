package com.litmus7.retaildiscountsystem.dto;
/**
 * The {@link RegularCustomer} class implements {@link Discountable} to return the amount payable after discount.
 */
public class RegularCustomer implements Discountable {

/**
 * Applies a discount of 5% to totalAmount.
 */
	public double applyDiscount(double totalAmount) {

		return 0.95 * totalAmount;
	}

}
