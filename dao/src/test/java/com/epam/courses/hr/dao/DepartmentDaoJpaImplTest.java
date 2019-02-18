package com.epam.courses.hr.dao;

import com.epam.courses.hr.model.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:test-db.xml", "classpath:test-dao.xml"})
class DepartmentDaoJpaImplTest {

    private static final String DEVELOPMENT_DEPARTMENT = "Development Department";
    private static final String DEV = "DEV";
    private static final int FIRST_DEPARTMENT_ID = 1;
    public static final int FULL_DEPARTMENT_LIST = 4;
    @Autowired
    private DepartmentDao departmentDao;

    @Test
    void findAll() {
        Stream<Department> departments = departmentDao.findAll();
        assertNotNull(departments);
    }

    @Test
    void findAllCheckCount() {
        Stream<Department> departments = departmentDao.findAll();
        assertNotNull(departments);
        assertEquals(FULL_DEPARTMENT_LIST, departments.count());
    }

    @Test
    void findById() {
        Department department = departmentDao.findById(1).get();
        assertNotNull(department);
        assertEquals(FIRST_DEPARTMENT_ID, department.getDepartmentId().intValue());
        assertEquals(DEV, department.getDepartmentName());
        assertEquals(DEVELOPMENT_DEPARTMENT, department.getDepartmentDescription());
    }

    @Test
    void create() {
        Stream<Department> departmentsBeforeInsert = departmentDao.findAll();

        Department department = new Department();
        department.setDepartmentName("TEST");
        department.setDepartmentDescription("TEST DESCRIPTION");
        Department newDepartment = departmentDao.add(department).get();
        assertNotNull(newDepartment.getDepartmentId());

        Stream<Department> departmentsAfterInsert = departmentDao.findAll();
        assertEquals(1, departmentsAfterInsert.count() - departmentsBeforeInsert.count());
    }

    @Test
    void createDuplicateDepartment() {
        Department department2 = new Department();
        department2.setDepartmentName("TEST 2");
        department2.setDepartmentDescription("TEST DESCRIPTION 2");
        Department newDepartment = departmentDao.add(department2).get();
        assertNotNull(newDepartment.getDepartmentId());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            departmentDao.add(department2);
        });
    }

    @Test
    void delete() {
        Stream<Department> departments = departmentDao.findAll();
        Department department = departments.findFirst().get();
        departmentDao.delete(department.getDepartmentId());

        Assertions.assertThrows(DataAccessException.class, () -> {
            departmentDao.findById(department.getDepartmentId());
        });
    }

}