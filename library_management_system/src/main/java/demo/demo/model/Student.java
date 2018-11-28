package demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    private String studId;
    private String image;
    private String name;
    private String address;
    private String email;
    @OneToOne
    private Department dept;
    @OneToMany
    private List<Book> bookList;

}
