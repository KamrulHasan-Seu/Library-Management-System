package demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Librarian extends Profile{
    @Id
    private String LibrarianId;
    @Enumerated
    private RoleType roleType;
    private String librarianPassword;

    public Librarian(String image, String name, String address, String email, String librarianId, RoleType roleType, String librarianPassword) {
        super(image, name, address, email);
        LibrarianId = librarianId;
        this.roleType = roleType;
        this.librarianPassword = librarianPassword;
    }
}
