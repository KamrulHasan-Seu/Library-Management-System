package demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    @Id
    private String id;
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}
