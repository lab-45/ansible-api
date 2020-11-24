package io.tenanh.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Workspace {

    public String createRandomPath(String path) {
        log.debug("Generating GUID");

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        File workspace = new File(path, randomUUIDString);
        workspace.mkdirs();

        log.debug("Workspace path: {}", workspace.getAbsolutePath());
        log.debug("Validate if folder was created: {}", workspace.exists());

        return workspace.getAbsolutePath();
    }

    public void createFile(String path, String fileName, String fileContent) throws IOException {

        String absoluteFileName = String.format("%s/%s", path, fileName);
        FileWriter file = new FileWriter(absoluteFileName);
	    BufferedWriter writer = new BufferedWriter(file);
        writer.write(fileContent);
        writer.close();

        log.debug("File created in path: {}", absoluteFileName);
    }
}
