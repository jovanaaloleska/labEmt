package lab.emt.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String surname;
   @ManyToOne
   private Country country;

   public Author () {}
   public Author(String name, String surname, Country country){
            this.name=name;
            this.surname=surname;
            this.country=country;
   }

}
