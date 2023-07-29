package med.voll.api.registy;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.Specialty;

public record DataDoctor(

        @NotBlank(message = "NOME não pode ser vázio.")
        String name,

        @NotBlank(message = "EMAIL não pode ser vázio.")
        @Email
        String email,

        @NotBlank(message = "TELEFONE é obrigatório.")
        String telefone,

        @NotBlank(message = "CRM não pode ser vázio.")
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Specialty specialty,

        @NotNull
        @Valid
        DataAddressDoctor address
) { }
