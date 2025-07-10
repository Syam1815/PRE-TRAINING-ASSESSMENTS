package com.litmus7.retail.constant;

public class SqlConstant {
	public final static String INSERT_PRODUCT = "INSERT INTO product(name,category,price,stockQuantity) VALUES (?,?,?,?)";
	public final static String SELECT_ALL_PRODUCTS = "SELECT productId, name, category, price, stockQuantity FROM product";
	public final static String GET_PRODUCT_BY_ID = "SELECT productId,name,category,price,stockQuantity FROM product WHERE productId = ? ";
	public final static String UPDATE_PRODUCT_BY_ID = "UPDATE product SET name = ?, category= ? , price= ?, stockQuantity= ?  WHERE productId = ? ";
	public final static String DELETE_PRODUCT_BY_ID = "DELETE FROM product WHERE productId = ? ";
	public final static String GET_PRODUCTS_BY_CATEGORY = "SELECT productId,name,category,price,stockQuantity FROM product WHERE category = ?  ";


}
