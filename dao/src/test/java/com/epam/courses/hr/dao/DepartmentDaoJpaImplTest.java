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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:test-db.xml", "classpath:test-dao.xml"})
@Rollback
@Transactional
class DepartmentDaoJpaImplTest {

    @Autowired
    DepartmentDao departmentDao;

    @Test
    public void findAll() {
        List<Department> departments = departmentDao.findAll().collect(Collectors.toList());
        assertFalse(departments.isEmpty());
    }

    @Test
    void findById() {
        Department department = departmentDao.findById(1).get();
        assertNotNull(department);
        assertTrue(department.getDepartmentId().equals(1));
        assertEquals("DEV", department.getDepartmentName());
        assertEquals("Development Department", department.getDepartmentDescription());
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}