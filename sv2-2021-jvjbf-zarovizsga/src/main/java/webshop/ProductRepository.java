package webshop;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ProductRepository {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public long insertProduct(String productName, int price, int stock) {

        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO `exam-test`.`products` (`product_name`, `price`, `stock`) VALUES (?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, productName);
            ps.setInt(2, price);
            ps.setInt(3, stock);
            return ps;
        }, holder);

        return holder.getKey().intValue();
    }

    public Product findProductById(long id) {

        return jdbcTemplate.queryForObject("SELECT * FROM `exam-test`.`products` WHERE id = ?", (rs, rowNum) -> new Product(
                rs.getInt("id"),
                rs.getString("product_name"),
                rs.getInt("price"),
                rs.getInt("stock")), id);
    }

    public void updateProductStock(long id, int amount) {
        jdbcTemplate.update("UPDATE `exam-test`.`products` SET stock = stock - '" + amount + "' WHERE  `id`=" + id + ";");
    }
}
