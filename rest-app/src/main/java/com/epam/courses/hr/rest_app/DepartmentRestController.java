package com.epam.courses.hr.rest_app;

import com.epam.courses.hr.model.Department;
import com.epam.courses.hr.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Home MVC controller.
 */
@RestController
public class DepartmentRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentRestController.class);

    @Autowired
    private DepartmentService service;

    @GetMapping(value = "/departments")
    public Collection<Department> findAll() {
        LOGGER.debug("get all departments");
        return service.findAll().collect(Collectors.toList());
    }
}
