package com.litmus7.retaildiscountsystem.dto;
/**
 * The {@link PremiumCustomer} class implements {@link Discountable} to return the amount payable after discount.
 */
public class PremiumCustomer implements Discountable {
/**
 * Applies a discount of 10% if totalAmount is greater than 5000. Otherwise 7% discount is applied.
 */
	@Override
	public double applyDiscount(double totalAmount) {
		return (totalAmount > 5000) ? 0.9 * totalAmount : 0.93 * totalAmount;
	}

}
