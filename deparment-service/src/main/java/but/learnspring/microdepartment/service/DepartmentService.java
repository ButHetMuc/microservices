package but.learnspring.microdepartment.service;

import but.learnspring.microdepartment.entity.Department;
import but.learnspring.microdepartment.repository.DepartmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department saveDepartment(Department department) {
        log.info("saving department to repo");
        return  departmentRepo.save(department);
    }
    public Department findByDepartmentId(Long departmentId) {
        log.info("finding");
        return departmentRepo.findByDepartmentId(departmentId);
    }
}
