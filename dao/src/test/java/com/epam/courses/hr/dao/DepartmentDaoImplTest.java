package com.epam.courses.hr.dao;

import com.epam.courses.hr.model.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:test-db.xml", "classpath:test-dao.xml"})
@Rollback
@Transactional
public class DepartmentDaoImplTest {

    @Autowired
    DepartmentDao departmentDao;

    @Test
    public void getDepartments() {
        List<Department> departments = departmentDao.findAll().collect(Collectors.toList());
        assertFalse(departments.isEmpty());
    }

}
