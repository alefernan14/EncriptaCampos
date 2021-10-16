package com.obsidiam.encriptacampos.repository;

import com.obsidiam.encriptacampos.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * ObsidiamInformationRepository
 * <p>
 * ObsidiamInformationRepository interface.
 * <p>
 * THIS COMPONENT WAS BUILT BY OBSIDIAM IS PROTECTED BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT.
 *
 * @author Obsidiam Inc.
 * @since 20/04/2021
 */
public interface UserAccountRepository extends CrudRepository<UserAccount, BigInteger>, Serializable {

    @Override
    List<UserAccount> findAll();
}
