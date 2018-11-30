package demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student extends Profile {
    @Id
    private String studId;
    @OneToOne
    private Department dept;
    @Enumerated
    private RoleType roleType;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Book> bookList;


    public Student(String image, String name, String address, String email, String studId, Department dept, RoleType roleType, String password, Set<Book> bookList) {
        super(image, name, address, email);
        this.studId = studId;
        this.dept = dept;
        this.roleType = roleType;
        this.password = password;
        this.bookList = bookList;
    }
}
