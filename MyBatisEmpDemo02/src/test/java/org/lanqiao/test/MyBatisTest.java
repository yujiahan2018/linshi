package org.lanqiao.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.lanqiao.mapper.DepartmentMapper;
import org.lanqiao.mapper.EmployeeMapper;
import org.lanqiao.pojo.Department;
import org.lanqiao.pojo.Employee;

public class MyBatisTest {
    SqlSessionFactory sessionFactory = null;
    SqlSession session = null;

    @Before
    public void before() throws IOException{
        String resource = "mybatis-config.xml";
        //加载 MyBatis 的配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //创建 SqlSession 的工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能够执行 SQL 映射文件中 SQL 语句的 SqlSession 对象
        session = sessionFactory.openSession();
    }
    
    @Test
    public void testDepartment() throws IOException {
        // 调用 session 中的 getMapper() 方法，返回接口对象
        DepartmentMapper dMapper = session.getMapper(DepartmentMapper.class);
        // 查询部门编号为 10 的部门信息
        Department department = dMapper.queryDepartmentByNo(10);
        System.out.println(department);
        //关闭 session
        session.close();
    }

    @Test
    public void testEmployee() throws IOException {
        // 调用 session 中的 getMapper() 方法，返回接口对象
        EmployeeMapper eMapper = session.getMapper(EmployeeMapper.class);
        // 查询员工编号为 7369 的员工信息 
        Employee employee = eMapper.queryEmployeeByNo(7369);
        System.out.println(employee);
        // 关闭 session
        session.close();
    }

    @Test
    public void testInsertEmployee() throws IOException { 
        //创建 Employee 对象 
        Employee e = new Employee();
        e.setENo(7935);
        e.setComm(300);
        e.setEName("小蓝");
        e.setDNo(30);
        e.setHireDate(new Date());
        e.setJob("推销员");
        e.setMgr(7689);
        e.setSal(6000);

        // 调用 session 中的 getMapper() 方法，返回接口对象
        EmployeeMapper eMapper = session.getMapper(EmployeeMapper.class);
        eMapper.insertEmployee(e);
        session.commit();
        System.out.println(e);
        // 关闭 session
        session.close();
    }

    @Test
    public void testUpdateEmployee() throws IOException {
        // 将员工编号为 7935 的员工的姓名改为 “蓝桥”，其他信息不变
        Employee e = new Employee();
        e.setENo(7935);
        e.setComm(300);
        e.setEName("蓝桥");
        e.setDNo(30);
        e.setHireDate(new Date());
        e.setJob("推销员");
        e.setMgr(7689);
        e.setSal(6000);

        // 调用 session 中的 getMapper() 方法，返回接口对象
        EmployeeMapper eMapper = session.getMapper(EmployeeMapper.class);
        eMapper.updateEmployeeByNo(e);
        session.commit();
        System.out.println(e);
        // 关闭 session
        session.close();
    }

    @Test
    public void testDeleteEmployee() throws IOException {
        // 调用 session 中的 getMapper() 方法，返回接口对象
        EmployeeMapper eMapper = session.getMapper(EmployeeMapper.class);
        //执行删除操作   将员工编号为 7935 的员工删除
        eMapper.deleteEmployeeByNo(7935);
        session.commit();
        // 关闭 session
        session.close();
    }
}