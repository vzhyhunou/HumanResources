package com.epam.courses.hr.dao;

import com.epam.courses.hr.model.Department;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class DepartmentDaoJpaImpl implements DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDaoJpaImpl.class);

    private static final String SELECT_SQL ="SELECT departmentId, departmentName, departmentDescription FROM department";
    private static final String FIND_BY_ID_SQL ="SELECT departmentId, departmentName, departmentDescription FROM department WHERE departmentId = :departmentId";

    private static final String DEPARTMENT_ID = "departmentId";
    private static final String DEPARTMENT_NAME = "departmentName";
    private static final String DESCRIPTION = "departmentDescription";

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
        LOGGER.debug("findById({})", id);
        SqlParameterSource namedParameters = new MapSqlParameterSource(DEPARTMENT_ID, id);
        Department department = namedParameterJdbcTemplate
                .queryForObject(FIND_BY_ID_SQL, namedParameters, BeanPropertyRowMapper.newInstance(Department.class));
        return Optional.ofNullable(department);
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
