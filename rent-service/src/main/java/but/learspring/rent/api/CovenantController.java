package but.learspring.rent.api;

import but.learspring.rent.model.Covenant;
import but.learspring.rent.service.CovenantServiceImp;
import but.learspring.rent.template.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/covenant")
public class CovenantController {
    @Autowired
    private CovenantServiceImp service;


    @PostMapping("/")
    public Covenant addUser(@RequestBody Covenant covenant){
        return service.saveCovenant(covenant);
    }

    @GetMapping("/")
    public ResponseEntity<List<Covenant>> getCovenants(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllCovenants());
    }

    @GetMapping("/{covenantId}")
    public ResponseTemplate getCovenantWithUserDepartment(@PathVariable Long covenantId){
        return service.getCovenantUserDepartment(covenantId);
    }


}
