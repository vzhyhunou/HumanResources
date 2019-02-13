package com.epam.courses.hr.model;

/**
 * POJO Department for model.
 */
public class Department {

    /**
     * Department Id.
     */
    private Integer departmentId;

    /**
     * Department Name.
     */
    private String departmentName;

    /**
     * Department Description.
     */
    private String departmentDescription;

    /**
     * Returns department id.
     *
     * @return departmentId.
     */
    public final Integer getDepartmentId() {
        return departmentId;
    }

    /**
     *
     *
     * @param departmentId
     */
    public void setDepartmentId(final Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    @Override
    public String toString() {
        return "Department{"
                + "departmentId=" + departmentId
                + ", departmentName='" + departmentName + '\''
                + '}';
    }
}
