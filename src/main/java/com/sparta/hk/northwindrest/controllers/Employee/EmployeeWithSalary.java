package com.sparta.hk.northwindrest.controllers.Employee;

        import com.sparta.hk.northwindrest.entities.EmployeeEntities;
        import org.springframework.data.jpa.domain.Specification;

        import javax.persistence.criteria.CriteriaBuilder;
        import javax.persistence.criteria.CriteriaQuery;
        import javax.persistence.criteria.Predicate;
        import javax.persistence.criteria.Root;

public class EmployeeWithSalary implements Specification<EmployeeEntities> {
    private Double salary;

    public EmployeeWithSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public Predicate toPredicate(Root<EmployeeEntities> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (salary.isNaN()){
            return cb.isTrue(cb.literal(true));
        }
        return cb.greaterThan(root.get("salary"),this.salary);
    }

}
