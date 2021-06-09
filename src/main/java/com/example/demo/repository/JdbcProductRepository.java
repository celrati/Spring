package com.example.demo.repository;

import com.example.demo.domain.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcProductRepository implements ProductRepository {


    private JdbcTemplate jdbcTemplate;

    public JdbcProductRepository(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Product> findAll() {
        return jdbcTemplate.query("select id, name, type from Product", this::mapRowToProduct);
    }

    private Product mapRowToProduct(ResultSet resultSet, int rowNum) throws SQLException {
        return new Product(
                resultSet.getString("id"),
                resultSet.getString("name"),
                resultSet.getString("type")
        );
    }

    @Override
    public Product findOne(String id) {
        return jdbcTemplate.queryForObject("select id, name, type from Product where id=? ", this::mapRowToProduct, id);
    }

    @Override
    public Product save(Product product) {
        jdbcTemplate.update(
                "insert into Product(id, name, type) values(?, ?, ?)",
                product.getId(),
                product.getName(),
                product.getType()
        );
        return product;
    }
}
