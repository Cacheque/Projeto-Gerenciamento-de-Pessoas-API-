package one.digitalinnovation.personaapi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true) // Só será possível cadastrar na tabela pessoas cpfs únicos
    private String cpf;
    private LocalDate birthDate;
   @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<one.digitalinnovation.personaapi.entity.Phone> phones;

}
