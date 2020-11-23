package io.tenanh.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.tenanh.model.Playbook;
import io.tenanh.util.Workspace;

@Service
public class Ansible {

    Logger log = LoggerFactory.getLogger(Ansible.class);

    @Autowired
    private Workspace workspace;

    @Value("${workspace.basepath}")
    private String ansibleWorkspace;

    public void execute(Playbook playbook) throws IOException {
        
        String yamlString = new YAMLMapper().writeValueAsString(playbook);   

        log.debug("JSON to YAML conversion: {}{}", System.lineSeparator(), yamlString);

        String path = workspace.createPath(this.ansibleWorkspace);
        workspace.createFile(path, "playbook.yml", yamlString);
        

    }    
}
