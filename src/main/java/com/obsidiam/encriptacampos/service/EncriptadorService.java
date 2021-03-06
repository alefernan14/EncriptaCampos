package com.obsidiam.encriptacampos.service;

import com.obsidiam.encriptacampos.entities.ObsidiamAccount;
import com.obsidiam.encriptacampos.entities.ObsidiamInformation;
import com.obsidiam.encriptacampos.entities.UserAccount;
import com.obsidiam.encriptacampos.repository.ObsidiamAccountRepository;
import com.obsidiam.encriptacampos.repository.ObsidiamInformationRepository;
import com.obsidiam.encriptacampos.repository.UserAccountRepository;
import com.obsidiam.encriptacampos.utils.AES256Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class EncriptadorService {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ObsidiamAccountRepository obsidiamAccountRepository;
    @Autowired
    private ObsidiamInformationRepository obsidiamInformationRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;


    public boolean encryptAll() throws Exception{
        boolean repsuesta = false;
        try{
            int contador = encryptAllObsidiamAccount().size();
            log.info("Actualizados ObsidiamAccount: " + contador);
            contador = encryptAllObsidiamInformation().size();
            log.info("Actualizados ObsidiamInformation: " + contador);
            contador = encryptAllUserAccounts().size();
            log.info("Actualizados UserAccounts: " + contador);
            repsuesta = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return repsuesta;
    }

    public boolean decryptAll() throws Exception{
        boolean repsuesta = false;
        try{
            int contador = decryptAllObsidiamAccount().size();
            log.info("Actualizandos ObsidiamAccount: " + contador);
            contador = decryptAllObsidiamInformation().size();
            log.info("Actualizados ObsidiamInformation: " + contador);
            contador = decryptAllUserAccounts().size();
            log.info("Actualizados UserAccounts: " + contador);
            repsuesta = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return repsuesta;
    }


    private List<ObsidiamAccount> encryptAllObsidiamAccount() throws Exception{
        List<ObsidiamAccount> list = obsidiamAccountRepository.findAll();
        for (ObsidiamAccount obj: list){
            try{
                obj.setAccount(AES256Helper.encrypt(obj.getAccount()));
                obsidiamAccountRepository.save(obj);
            } catch (Exception e ){
                log.info("Error en encryptAllObsidiamAccount al guardar el objeto Obsidiam Account con id {}", obj.getId());
                throw new Exception("Error en encryptAllObsidiamAccount al guardar el objeto Obsidiam Account ",e);
            }
        }
        return list;
    }

    private List<ObsidiamInformation> encryptAllObsidiamInformation() throws Exception{
        List<ObsidiamInformation> list = obsidiamInformationRepository.findAll();
        for (ObsidiamInformation obj: list){
            try{
                obj.setAddress(AES256Helper.encrypt(obj.getAddress()));
                obj.setEmail(AES256Helper.encrypt(obj.getEmail()));
                obj.setIdJuridico(AES256Helper.encrypt(obj.getIdJuridico()));
                obj.setName(AES256Helper.encrypt(obj.getName()));
                obsidiamInformationRepository.save(obj);
            } catch (Exception e ){
                log.info("Error en encryptAllObsidiamInformation al guardar el objeto con id {}", obj.getId());
                throw new Exception("Error en encryptAllObsidiamInformation al guardar el objeto ObsidiamInformation",e);
            }
        }
        return list;
    }

    private List<UserAccount> encryptAllUserAccounts() throws Exception{
        List<UserAccount> list = userAccountRepository.findAll();
        for (UserAccount obj: list){
            try{
                obj.setAccountNumber(AES256Helper.encrypt(obj.getAccountNumber()));
                obj.setDocNumber(AES256Helper.encrypt(obj.getDocNumber()));
                obj.setDocType(AES256Helper.encrypt(obj.getDocType()));
                obj.setFirstName(AES256Helper.encrypt(obj.getFirstName()));
                obj.setLastName(AES256Helper.encrypt(obj.getLastName()));
                userAccountRepository.save(obj);
            } catch (Exception e ){
                log.info("Error en encryptAllUserAccounts al guardar el objeto con id {}", obj.getId());
                throw new Exception("Error en encryptAllUserAccounts al guardar el objeto UserAccount",e);
            }
        }
        return list;
    }
    private List<ObsidiamAccount> decryptAllObsidiamAccount() throws Exception{
        List<ObsidiamAccount> list = obsidiamAccountRepository.findAll();
        for (ObsidiamAccount obj: list){
            try{
                obj.setAccount(AES256Helper.decrypt(obj.getAccount()));
                obsidiamAccountRepository.save(obj);
            } catch (Exception e ){
                log.info("Error al guardar el objeto Obsidiam Account con id {}", obj.getId());
                //throw new Exception("Error al guardar el objeto Obsidiam Account ObsidiamAccount", e);
            }
        }
        return list;
    }

    private List<ObsidiamInformation> decryptAllObsidiamInformation() throws Exception{
        List<ObsidiamInformation> list = obsidiamInformationRepository.findAll();
        for (ObsidiamInformation obj: list){
            //obj.setAccount(AES256Helper.decrypt(obj.getAccount()));
            try{
                obj.setAddress(AES256Helper.decrypt(obj.getAddress()));
                obj.setEmail(AES256Helper.decrypt(obj.getEmail()));
                obj.setIdJuridico(AES256Helper.decrypt(obj.getIdJuridico()));
                obj.setName(AES256Helper.decrypt(obj.getName()));
                obsidiamInformationRepository.save(obj);
            } catch (Exception e ){
                log.info("Error en decryptAllObsidiamInformation al guardar el objeto con id {}", obj.getId());
                //throw new Exception("Error en decryptAllObsidiamInformation al guardar el objeto ObsidiamInformation");
            }
        }
        return list;
    }

    private List<UserAccount> decryptAllUserAccounts() throws Exception{
        List<UserAccount> list = userAccountRepository.findAll();
        for (UserAccount obj: list){
            try{
                obj.setAccountNumber(AES256Helper.decrypt(obj.getAccountNumber()));
                obj.setDocNumber(AES256Helper.decrypt(obj.getDocNumber()));
                obj.setDocType(AES256Helper.decrypt(obj.getDocType()));
                obj.setFirstName(AES256Helper.decrypt(obj.getFirstName()));
                obj.setLastName(AES256Helper.decrypt(obj.getLastName()));
                userAccountRepository.save(obj);
            } catch (Exception e ){
                log.info("Error en decryptAllUserAccounts al guardar el objeto con id {}", obj.getId());
                //throw new Exception("Error en decryptAllUserAccounts al guardar el objeto UserAccount",e);
            }
        }
        return list;
    }
}
