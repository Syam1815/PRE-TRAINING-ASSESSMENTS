package com.litmus7.retail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.retail.constant.SqlConstant;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.ProductDataAccessException;
import com.litmus7.retail.util.DBConnectionUtil;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Product addProduct(Product product) throws ProductDataAccessException {
		int productId = 0;
		try (Connection connection = DBConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.INSERT_PRODUCT,
						Statement.RETURN_GENERATED_KEYS);) {

			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getCategory());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setInt(4, product.getStockQuantity());

			preparedStatement.executeUpdate();

			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
				if (resultSet.next()) {
					productId = resultSet.getInt(1);
				}
			}
			product.setProductId(productId);

		} catch (SQLException e) {
			throw new ProductDataAccessException(e.getMessage(), e);
		}
		return product;

	}

	@Override
	public Product getProductById(int productId) throws ProductDataAccessException {
		Product product = null;
		try (Connection connection = DBConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.GET_PRODUCT_BY_ID);) {

			preparedStatement.setInt(1, productId);
			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.next()) {

					product = new Product(resultSet.getInt("productId"), resultSet.getString("name"),
							resultSet.getString("category"), resultSet.getDouble("price"),
							resultSet.getInt("stockQuantity"));
				}
			}
		} catch (SQLException e) {
			throw new ProductDataAccessException(e.getMessage(), e);
		}
		return product;
	}

	@Override
	public List<Product> getAllProducts() throws ProductDataAccessException {
		List<Product> products = new ArrayList<Product>();
		try (Connection connection = DBConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.SELECT_ALL_PRODUCTS);) {

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				while (resultSet.next()) {

					products.add(new Product(resultSet.getInt("productId"), resultSet.getString("name"),
							resultSet.getString("category"), resultSet.getDouble("price"),
							resultSet.getInt("stockQuantity")));
				}
			}

		} catch (SQLException e) {
			throw new ProductDataAccessException(e.getMessage(), e);
		}
		return products;
	}

	@Override
	public boolean updateProduct(Product product) throws ProductDataAccessException {
		try (Connection connection = DBConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.UPDATE_PRODUCT_BY_ID);) {

			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getCategory());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setInt(4, product.getStockQuantity());
			preparedStatement.setInt(5, product.getProductId());

			int rows = preparedStatement.executeUpdate();

			return rows != 0;

		} catch (SQLException e) {
			throw new ProductDataAccessException(e.getMessage(), e);
		}
	}

	@Override
	public boolean deleteProduct(int productId) throws ProductDataAccessException {
		try (Connection connection = DBConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.DELETE_PRODUCT_BY_ID);) {

			preparedStatement.setInt(1, productId);

			int rows = preparedStatement.executeUpdate();

			return rows != 0;

		} catch (SQLException e) {
			throw new ProductDataAccessException(e.getMessage(), e);
		}
	}

	public List<Product> getProductsByCategory(String category) throws ProductDataAccessException {
		List<Product> products = new ArrayList<Product>();
		try (Connection connection = DBConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstant.GET_PRODUCTS_BY_CATEGORY);) {
			
			preparedStatement.setString(1, category);
			
			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				while (resultSet.next()) {

					products.add(new Product(resultSet.getInt("productId"), resultSet.getString("name"),
							resultSet.getString("category"), resultSet.getDouble("price"),
							resultSet.getInt("stockQuantity")));
				}
			}
		} catch (SQLException e) {
			throw new ProductDataAccessException(e.getMessage(), e);
		}
		return products;

	}
}
