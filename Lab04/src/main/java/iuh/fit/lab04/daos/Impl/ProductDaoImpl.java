package iuh.fit.lab04.daos.Impl;

import iuh.fit.lab04.daos.ProductDao;
import iuh.fit.lab04.models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final DataSource datasource;

    public ProductDaoImpl(DataSource datasource) {
        this.datasource = datasource;
    }
    @Override
    public List<Product> findAll() {
        String sql = "SELECT id, name, price, image FROM product";
        List<Product> list = new ArrayList<>();
        try (Connection con = this.datasource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                list.add(new Product(id, name, price, image));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
