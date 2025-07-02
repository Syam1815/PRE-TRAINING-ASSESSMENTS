package com.litmus7.retaildiscountsystem.dto;

/**
 * The {@link WholesaleCustomer} class implements {@link Discountable} to return the amount payable after discount.
 */
public class WholesaleCustomer implements Discountable {
	
	/**
	 * Applies a discount of 15% if totalAmount is greater than 10000. Otherwise 10% discount is applied.
	 */
	@Override
	public double applyDiscount(double totalAmount) {
		return (totalAmount > 10000) ? 0.85 * totalAmount : 0.90 * totalAmount;
	}

}

