package io.tenanh.service;
import java.io.IOException;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.tenanh.model.Playbook;
import io.tenanh.util.Workspace;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ansible {

    @Autowired
    private Workspace workspace;

    @Value("${ansible.workspace.basepath}")
    private String ansibleWorkspace;

    public void execute(Playbook playbook) throws IOException {
        
        String yamlString = new YAMLMapper().writeValueAsString(playbook);   

        log.debug("JSON to YAML conversion: {}{}", System.lineSeparator(), yamlString);

        String path = workspace.createRandomPath(this.ansibleWorkspace);
        workspace.createFile(path, "playbook.yml", yamlString);
        

    }    
}
