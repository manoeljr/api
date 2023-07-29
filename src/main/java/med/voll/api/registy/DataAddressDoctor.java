package med.voll.api.registy;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAddressDoctor(

        @NotBlank(message = "LOGRADOURO é obrigatório")
        String logradouro,

        @NotBlank(message = "BAIRRO é obrigatório.")
        String bairro,

        @NotBlank(message = "CEP não pode ser maior de 8 digitos.")
        @Pattern(regexp = "\\{8}")
        String cep,

        @NotBlank(message = "CIDADE é obrigatório.")
        String cidade,

        @NotBlank(message = "UF é obrigatóro.")
        String uf,

        String complemento,
        String numero
) { }
