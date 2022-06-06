package com.atguigu.crowd;

import entity.Admin;
import mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


// 这里用junit5进行测试
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(locations = "classpath:spring-persist-mybatis.xml")
public class CrowdTest {

        @Autowired
        private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void testInsertAdmin() {
        Admin admin = new Admin(null, "Rachel", "123123", "rui", "rui@qq.com", null);
        int count = adminMapper.insert(admin);
        System.out.println(count);
    }

        @Test
        public void  testConnection() throws SQLException{
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        }



}
