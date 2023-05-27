package org.lanqiao.mapper;

import org.lanqiao.pojo.Employee;

/**
 * 定一个 EmployeeMapper 接口
 * @author lanqiao
 */
public interface EmployeeMapper {
    /**
     * 根据员工编号查询员工信息
     * @param eNo 员工编号
     * @return
     */
    public Employee queryEmployeeByNo(int eNo);

    /**
     * 新增一个员工信息
     * @param employee
     */
    public void insertEmployee(Employee employee);

    /**
     * 根据员工编号修改员工信息
     * @param eNo
     */
    public void updateEmployeeByNo(Employee employee);

    /**
     * 根据员工编号删除员工信息
     * @param eNo
     */
    public void deleteEmployeeByNo(int eNo);
}