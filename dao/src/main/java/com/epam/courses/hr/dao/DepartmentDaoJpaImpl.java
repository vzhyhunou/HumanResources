package com.epam.courses.hr.dao;

import com.epam.courses.hr.model.Department;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class DepartmentDaoJpaImpl implements DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDaoJpaImpl.class);

    private static final String SELECT_SQL ="SELECT departmentId, departmentName, description FROM department";

    private static final String DEPARTMENT_ID = "departmentId";
    private static final String DEPARTMENT_NAME = "departmentName";
    private static final String DESCRIPTION = "description";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DepartmentDaoJpaImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Stream<Department> findAll() {
        LOGGER.debug("findAll()");
        List<Department> departments = namedParameterJdbcTemplate.query(SELECT_SQL, new DepartmentRowMapper());
        return departments.stream();
    }

    @Override
    public Optional<Department> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public int create(Department department) {
        return 0;
    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void delete(Integer id) {

    }

    private class DepartmentRowMapper implements RowMapper<Department> {

        @Override
        public Department mapRow(ResultSet resultSet, int i) throws SQLException {
            Department department = new Department();
            department.setDepartmentId(resultSet.getInt(DEPARTMENT_ID));
            department.setDepartmentName(resultSet.getString(DEPARTMENT_NAME));
            department.setDepartmentDescription(resultSet.getString(DESCRIPTION));
            return department;
        }
    }

}
