package com.epam.courses.hr.dao;

import com.epam.courses.hr.model.Department;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Department DAO Interface.
 */
public interface DepartmentDao {

    /**
     * Get departments.
     *
     * @return departments stream.
     */
    Stream<Department> findAll();

    /**
     * Get Department By Id.
     *
     * @param id id
     * @return Department
     */
    Optional<Department> findById(final Integer id);

    /**
     * Persist new department.
     *
     * @param department new department
     * @return department id.
     */
    int create(final Department department);

    /**
     * Update department.
     *
     * @param department department
     */
    void update(final Department department);

    /**
     * Delete department with specified id.
     *
     * @param id department id
     */
    void delete(final Integer id);

}
