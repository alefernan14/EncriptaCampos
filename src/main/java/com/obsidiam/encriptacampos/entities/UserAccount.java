package com.obsidiam.encriptacampos.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user_accounts")
@NoArgsConstructor
public class UserAccount implements Serializable {

    private static final long serialVersionUID = -7744381286012683975L;
    private static final String BIGINT = "BIGINT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ua_id", columnDefinition = "BIGINT", nullable = false, unique = true)
    private BigInteger id;

    @Column(name = "ua_account_number", nullable = false)
    private String accountNumber;

    @Column(name = "ua_doc_type", nullable = false)
    private String docType;

    @Column(name = "ua_doc_number", nullable = false)
    private String docNumber;

    @Column(name = "ua_firstname", nullable = false)
    private String firstName;

    @Column(name = "ua_lastname", nullable = false)
    private String lastName;

}
