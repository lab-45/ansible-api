package io.tenanh.controller;

import io.tenanh.model.Playbook;
import io.tenanh.service.Ansible;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class Api {

    @Autowired
    private Ansible ansibleManager;

    /**
     * 
     * @param playbook
     */
    @PostMapping("/execute")
    public void execute(@RequestBody Playbook playbook) {
        

        try{
            ansibleManager.execute(playbook);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
