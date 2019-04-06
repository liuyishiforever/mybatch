package com.cnblogs.liuyishi.FTD;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 把处理后的数据写入数据库
 */
@Component("FTD_productWriter")
public class ProductItemWriter implements ItemWriter<Product> {
    //    private static final String GET_PRODUCT = "select * from PRODUCT where id = ?";
    private static final String INSERT_PRODUCT = "insert into PRODUCT (id,name,description,quantity) values (?,?,?,?)";
    // private static final String UPDATE_PRODUCT = "update PRODUCT set name = ?, description = ?,quantity = ? where id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void write(List<? extends Product> products) throws Exception {
        for (Product product : products) {
            //重复数据无法插入
            jdbcTemplate.update(INSERT_PRODUCT, product.getId(), product.getName(), product.getDescription(), product.getQuantity());
        }
//        {
//            List<Product> productList = jdbcTemplate.query(GET_PRODUCT, new Object[] {product.getId()}, new RowMapper<Product>() {
//                @Override
//                public Product mapRow( ResultSet resultSet, int rowNum ) throws SQLException {
//                    Product p = new Product();
//                    p.setId( resultSet.getInt( 1 ) );
//                    p.setName( resultSet.getString( 2 ) );
//                    p.setDescription( resultSet.getString( 3 ) );
//                    p.setQuantity( resultSet.getInt( 4 ) );
//                    return p;
//                }
//            });
//
//            if( productList.size() > 0 )
//            {
//                jdbcTemplate.update( UPDATE_PRODUCT, product.getName(), product.getDescription(), product.getQuantity(), product.getId() );
//            }
//            else
//            {
//                jdbcTemplate.update( INSERT_PRODUCT, product.getId(), product.getName(), product.getDescription(), product.getQuantity() );
//            }
//        }
    }
}
