package but.learnspring.userservice.service;

import but.learnspring.userservice.entity.Users;
import but.learnspring.userservice.repo.UserRepo;
import but.learnspring.userservice.valueobject.Department;
import but.learnspring.userservice.valueobject.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;
    public Users saveUser(Users user) {
        log.info("from user service");
        return userRepo.save(user);
    }

    public Users getUserById(Long userId){
        log.info("fetching user where id:" + userId);
        Users user = userRepo.findByUserId(userId);
        return  user;
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        ResponseTemplate rt = new ResponseTemplate();
        Users user = userRepo.findByUserId(userId);
//        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"
//                + user.getDepartmentId(),Department.class);
        Department department = restTemplate.getForObject("http://localhost:8081/department/"
                + user.getDepartmentId(),Department.class);
        rt.setUser(user);
        rt.setDepartment(department);
        return rt;
    }
}
