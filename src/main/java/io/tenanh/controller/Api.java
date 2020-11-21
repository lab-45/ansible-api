package io.tenanh.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.tenanh.model.Playbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Api {

    Logger log = LoggerFactory.getLogger(Api.class);

    @PostMapping("/execute")
    public void execute(@RequestBody Playbook playbook) {

        ObjectMapper mapper = new ObjectMapper();
        try{
            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(playbook);

            log.trace(jsonString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
