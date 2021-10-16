package com.obsidiam.encriptacampos.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "obsidiam_information")
@Getter
@Setter
@NoArgsConstructor
public class ObsidiamInformation implements Serializable {

    private static final long serialVersionUID = 1996624493862964444L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oi_id", columnDefinition = "BIGINT", nullable = false, unique = true)
    private BigInteger id;

    @Column(name = "oi_id_jur", nullable = false)
    private String idJuridico;

    @Column(name = "oi_description", nullable = false)
    private String name;

    @Column(name = "oi_address", nullable = false)
    private String address;

    @Column(name = "oi_email_contact", nullable = false)
    private String email;

}
