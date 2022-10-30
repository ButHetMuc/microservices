package but.learnspring.userservice.valueobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long departmentId;
    private String ownerId;
    private String name;
    private String address;
    private int price;
    private String description;
    private int area;
    private String image;
}
