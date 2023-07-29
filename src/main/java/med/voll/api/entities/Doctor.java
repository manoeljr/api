package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.enums.Specialty;
import med.voll.api.registy.DataDoctor;


@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Doctor(DataDoctor data) {
        this.name = data.name();
        this.email = data.email();
        this.telefone = data.telefone();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }
}
