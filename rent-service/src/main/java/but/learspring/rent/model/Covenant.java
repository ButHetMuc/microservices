package but.learspring.rent.model;

import but.learspring.rent.template.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Covenant {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long covenantId;
    private Long userId;
    private Long departmentId;
    private String fromDate;
    private String toDate;
    private String cost;

}
