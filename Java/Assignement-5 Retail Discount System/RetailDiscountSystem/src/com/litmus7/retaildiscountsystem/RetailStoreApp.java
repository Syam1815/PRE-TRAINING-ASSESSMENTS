package com.litmus7.retaildiscountsystem;

import java.util.Scanner;

import com.litmus7.retaildiscountsystem.dto.Discountable;
import com.litmus7.retaildiscountsystem.dto.PremiumCustomer;
import com.litmus7.retaildiscountsystem.dto.RegularCustomer;
import com.litmus7.retaildiscountsystem.dto.WholesaleCustomer;

/**
 * The {@link RetailStoreApp} manages the entire system. Reads customerType and
 * totalPurchaseAmount from users. Accordingly creates the required object of
 * {@link RegularCustomer} / {@link PremiumCustomer} / {@link WholesaleCustomer}
 * and facilitates applyDiscount.
 */
public class RetailStoreApp {
	/**
	 * Main method : Entry point of the program.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int customerType;
		double totalPurchaseAmount;
		double amountPayable;
		
		Discountable customer = null;

		// Customer Type input and validation
		while (true) {
			System.out.print("Enter customer type (1: Regular, 2: Premium, 3: Wholesale): ");
			customerType = Integer.parseInt(scanner.nextLine());
			if (customerType > 0 && customerType <= 3) {
				break;
			} else {
				System.out.println("Please enter valid Customer Type !");
			}
		}

		customer = switch (customerType) {

		case 1 -> new RegularCustomer(); // RegularCustomer

		case 2 -> new PremiumCustomer(); // PremiumCustomer

		case 3 -> new WholesaleCustomer(); // WholesaleCustomer

		default -> null; // this condition is never met

		};

		// Amount input and validation
		while (true) {
			System.out.print("Enter total purchase amount: ");
			totalPurchaseAmount = Double.parseDouble(scanner.nextLine());
			if (totalPurchaseAmount > 0)
				break;
			else
				System.out.println("Please enter an amount greater than 0 !");
		}

		//Bill
		System.out.println("Customer Type: " + customer.getClass().getSimpleName());
		System.out.println("Original Amount: " + totalPurchaseAmount);
		amountPayable = customer.applyDiscount(totalPurchaseAmount);
		System.out.println("Discount Applied: " + (totalPurchaseAmount - amountPayable));
		System.out.println("Final Amount Payable: " + amountPayable);

		scanner.close();

	}

}
