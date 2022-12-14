package com.Joker.rest.controller;

import com.Joker.rest.bao.EmployeeDao;
import com.Joker.rest.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author Joker
 * @Date 2022/11/30 20:30
 * @Description This is description of class
 * @since version-1.0
 */
@Controller
public class EmployeeController {

    // 自动装配注解
    @Autowired
    public EmployeeDao employeeDao;

    // 查询
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }

    // 删除
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String leleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    // 增加
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    // 根据id查询
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeDao.gat(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    // 修改
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }
}
