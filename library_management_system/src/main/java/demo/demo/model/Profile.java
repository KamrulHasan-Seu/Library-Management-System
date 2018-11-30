package demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class Profile {

    private String image;
    private String name;
    private String address;
    private String email;
}
