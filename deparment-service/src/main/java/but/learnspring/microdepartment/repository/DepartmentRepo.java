package but.learnspring.microdepartment.repository;

import but.learnspring.microdepartment.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {


    Department findByDepartmentId(Long departmentId);
}
