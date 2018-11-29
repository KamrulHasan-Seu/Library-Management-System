package demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
@Entity
public class StudentRole {
    @Id
    private String roleId;
    @Enumerated
    private RoleType roleType;
    private String password;
}
