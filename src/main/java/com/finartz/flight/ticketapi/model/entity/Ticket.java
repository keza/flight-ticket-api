package com.finartz.flight.ticketapi.model.entity;

import com.finartz.flight.ticketapi.model.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank(message = "Ad alanı boş olamaz.")
    private String name;

    @NotBlank(message = "Soyad alanı boş olamaz.")
    private String lastName;

    @NotNull(message = "Yaş alanı boş olamaz.")
    @Min(0)
    @Max(100)
    private Integer age;

    @Email(message = "E-posta geçerli değildir.")
    @NotBlank(message = "E-posta alanı boş olamaz.")
    @Size(max = 255, message = "E-posta alanı uzunluğu 255 karakter sınırından fazladır.")
    private String email;

    @NotBlank(message = "Cep telefonu alanı boş olamaz.")
    @Pattern(regexp = "(5[0-9]{9})", message = "Cep telefonu geçerli değildir. Cep telefonu numarasınızı kontrol ediniz.")
    private String phoneNumber;

    @OneToOne
    private Flight flight;

    @NotBlank(message = "Kredi Kartı alanı boş olamaz.")
    private String creditCardNumber;

    private Double price;
}
