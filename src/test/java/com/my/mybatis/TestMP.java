package com.my.mybatis;

import com.com.my.javaBean.Employee;
import com.com.my.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Auther: Administrator
 * @Date: 2019/12/6 22:57
 * @Description:
 */


public class TestMP {
    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);


    @Test
    public void test() throws Exception {

        DataSource ds = ioc.getBean("dataSource", DataSource.class);
        System.out.println(ds);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }

    @Test
    public  void  testInsert(){
        Employee employee = new Employee("d55d","ad",4,4);

//        Integer result = employeeMapper.insertAllColumn(employee);
        Integer result = employeeMapper.insert(employee);
        System.out.println("result:"+result);

    }
}
