package com.epam.courses.hr.service;

import com.epam.courses.hr.model.Department;
import com.epam.courses.hr.stub.DepartmentStub;

import java.util.stream.Stream;

public interface DepartmentService {

    /**
     * Find all departments stream.
     *
     * @return departments .
     */
    Stream<Department> findAll();

    /**
     * Get department stubs list.
     *
     * @return department stubs list.
     */
    Stream<DepartmentStub> findAllStubs();

    void add(Department... departments);

    /**
     * Find Department By Id.
     *
     * @param id id
     * @return Department
     */
    Department findById(Integer id);

    /**
     * Update department.
     *
     * @param department department
     */
    void update(Department department);
}
