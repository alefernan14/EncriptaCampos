package com.obsidiam.encriptacampos.controller;

import com.obsidiam.encriptacampos.service.EncriptadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.obsidiam.encriptacampos.entities.ObsidiamAccount;

import java.util.List;


@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class EncriptadorController {

    @Autowired
    private EncriptadorService encriptadorService;

    @GetMapping(path="/encryptAll",
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public @ResponseBody boolean encryptAll() {
        // This returns a JSON or XML with the users
       boolean repsuesta = false;
        try{
            encriptadorService.encryptAll();
            repsuesta = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return repsuesta;
    }

    @GetMapping(path="/decryptAll",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public @ResponseBody boolean decryptAll() {
        // This returns a JSON or XML with the users
        boolean repsuesta = false;
        try{
            encriptadorService.decryptAll();
            repsuesta = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return repsuesta;
    }

}
