package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.enums.Specialty;
import med.voll.api.records.DataDoctorCreate;
import med.voll.api.records.DataDoctorUpdate;


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
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Doctor(DataDoctorCreate data) {
        this.name = data.name();
        this.email = data.email();
        this.telefone = data.telefone();
        this.ativo = data.ativo();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

    public void updateInformation(DataDoctorUpdate dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.address() != null) {
            this.address.updateInformationAddress(dados.address());
        }
    }

    public void delete() {
        this.ativo = false;
    }
}
