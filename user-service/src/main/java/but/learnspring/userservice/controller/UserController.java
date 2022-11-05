package but.learnspring.userservice.controller;

import but.learnspring.userservice.entity.Users;
import but.learnspring.userservice.service.UserService;
import but.learnspring.userservice.valueobject.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Users saveUser(@RequestBody Users user){
        log.info("saving user");
        return userService.saveUser(user);
    }
    @GetMapping("/")
    public ResponseEntity<List<Users>> getAllUsers(){
        log.info("fetching all users");
        List<Users> users = new ArrayList<>();
        users = userService.getAllUsers();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable("userId") Long userId){
        Users user = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

//    public ResponseTemplate getUserWithDepartment (@PathVariable("id") Long userId){
//        log.info("get user with department");
//        return   userService.getUserWithDepartment(userId);
//    }
}
