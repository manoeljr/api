package med.voll.api.entities;


import jakarta.persistence.Embeddable;
import lombok.*;
import med.voll.api.registy.DataAddressDoctor;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Address(DataAddressDoctor address) {
        this.logradouro = address.logradouro();
        this.bairro = address.bairro();
        this.cep = address.cep();
        this.cidade = address.cidade();
        this.uf = address.uf();
        this.numero = address.numero();
        this.complemento = address.complemento();
    }
}
