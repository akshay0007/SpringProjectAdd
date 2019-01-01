package com.myproject.example.controller;

import com.myproject.example.model.EmployeeVO;
import com.myproject.example.model.Student;
import com.myproject.example.service.EmployeeManager;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.myproject.example.utils.ErrorCodes.error_0;
import static com.myproject.example.utils.ErrorCodes.error_0_messg;

/**
 * Created by stpl on 18/12/18.
 */
//@RestController
//@RequestMapping(value = {"/rest"})
public class EmployeeController<T, I> {
    @Autowired
    private EmployeeManager employeeManager;

    @Autowired
    private SessionFactory sessionFactory;


    @RequestMapping(value = {"/gelAllEmployeeResponse"}, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeVO>> getAllEmployeesEntity() {
        return new ResponseEntity(employeeManager.getAllList(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/gelAllEmployeeResponse"}, method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<I> addEmployee(@RequestBody T t) {
        if (t != null) {
        }
        return new ResponseEntity(getSuccessMessage(), HttpStatus.OK);
    }

    public Map<String, String> getSuccessMessage() {
        Map<String, String> data = new HashMap();
        data.put(error_0, error_0_messg);
        return data;
    }


    @RequestMapping(value = "/getAllData/{countryName}/{name}")
    public ModelAndView addPathMultiple(@PathVariable Map<String, String> pathData) {
        return new ModelAndView("login").addAllObjects(pathData);
    }


    //student name inside html tag name
    @RequestMapping(value = "/datasumbimt", method = RequestMethod.GET)
    public void sendingRequest(@RequestParam(value = "studentName", required = false, defaultValue = "namedata") String name, @RequestParam String password) {


    }

    @RequestMapping(value = "/datasumbimt", method = RequestMethod.GET)
    public void sendingRequest(@RequestParam Map<String, String> data) {
        String dataStr = data.get("studentName");

    }

    @RequestMapping(value = "/datasumbimt", method = RequestMethod.GET)
    public ModelAndView sendingmodelObj(@RequestParam Map<String, String> data) {
        Student student = new Student();
//        student.setName(data.get("studentName"));
//        student.setPassword(data.get("studentPassword"));

        ModelAndView md = new ModelAndView("welcome");
        md.addObject("student", student);
        return md;
    }

    @RequestMapping(value = "/datasumbimtd", method = RequestMethod.GET)
    public ModelAndView sendingmodelAnnot(@ModelAttribute("student1") Student data) {
        ModelAndView md = new ModelAndView("welcome");
        md.addObject("student", data);
        return md;
    }

    //if common code share among alls modle and modelview
    //call first before all methods
    @ModelAttribute
    public void addCommonData(Model md){
        md.addAttribute("header","common header");
    }





}
