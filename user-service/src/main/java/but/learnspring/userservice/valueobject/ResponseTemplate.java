package but.learnspring.userservice.valueobject;

import but.learnspring.userservice.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
    private Users user;
    private Department department;
}
