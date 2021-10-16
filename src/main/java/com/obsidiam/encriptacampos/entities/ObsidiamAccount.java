package com.obsidiam.encriptacampos.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "obsidiam_accounts")
public class ObsidiamAccount implements Serializable {

    private static final long serialVersionUID = -8372119440754128335L;
    private static final String BIGINT = "BIGINT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oa_id", columnDefinition = "BIGINT", nullable = false, unique = true)
    private BigInteger id;

    @Column(name = "oa_account", nullable = false)
    private String account;

    public BigInteger getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}

