package com.myproject.example.controller;

import com.myproject.example.model.EmployeeVO;
import com.myproject.example.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.myproject.example.utils.ErrorCodes.error_0;
import static com.myproject.example.utils.ErrorCodes.error_0_messg;

/**
 * Created by stpl on 18/12/18.
 */
@RestController
@RequestMapping(value = {"/rest"})
public class EmployeeController<T, I> {
    @Autowired
    private EmployeeManager employeeManager;

    @RequestMapping(value = {"/gelAllEmployeeResponse"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeVO>> getAllEmployeesEntity() {
        return new ResponseEntity(employeeManager.getAllEmployee(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/gelAllEmployeeResponse"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<I> addEmployee(@RequestBody(required = true) T t) {
        if (t != null) {
            employeeManager.addList(t);
        }
        return new ResponseEntity(getSuccessMessage(), HttpStatus.OK);
    }

    public Map<String, String> getSuccessMessage() {
        Map<String, String> data = new HashMap();
        data.put(error_0, error_0_messg);
        return data;
    }
}
