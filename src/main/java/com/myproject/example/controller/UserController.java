package com.myproject.example.controller;

import com.myproject.example.model.EmployeeVO;
import com.myproject.example.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ubuntu on 31/12/18.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController<T extends EmployeeVO> {

    @Autowired
    private EmployeeManager employeeManager;


    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addUsers(@RequestBody T t) {
        return employeeManager.addItem(t);
    }

    @RequestMapping(value = {"/getList"}, method = RequestMethod.GET)
    public ResponseEntity<List<T>> listUsers() {
        return ResponseEntity.ok().body(employeeManager.getAllList());
    }

}
