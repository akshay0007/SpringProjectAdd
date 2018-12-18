package com.myproject.example.controller;

import com.myproject.example.model.EmployeeVO;
import com.myproject.example.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by stpl on 18/12/18.
 */
@RestController
public class EmployeeController {
    @Autowired
    protected EmployeeManager employeeManager;

    @RequestMapping(value = {"/gelAllEmployee"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeVO>> getAllEmployees() {
        return new ResponseEntity<List<EmployeeVO>>(employeeManager.getAllEmployee(), HttpStatus.OK);
    }
}
