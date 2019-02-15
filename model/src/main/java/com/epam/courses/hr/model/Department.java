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
     * Sets departmentId.
     *
     * @param departmentId.
     */
    public final void setDepartmentId(final Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Returns department name.
     *
     * @return departmentName.
     */
    public final String getDepartmentName() {
        return departmentName;
    }

    /**
     * Sets department name.
     *
     * @param departmentName.
     */
    public final void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Returns department description.
     *
     * @return departmentDescription.
     */
    public final String getDepartmentDescription() {
        return departmentDescription;
    }

    /**
     * Sets department description.
     *
     * @param departmentDescription.
     */
    public final void setDepartmentDescription(final String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    @Override
    public final String toString() {
        return "Department{"
                + "departmentId=" + departmentId
                + ", departmentName='" + departmentName + '\''
                + '}';
    }
}
