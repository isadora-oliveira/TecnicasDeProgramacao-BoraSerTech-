package com.letscode.linx838.flightsInformation.entity;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {

    public List<String> readLines(String filePath ){
        Path path = Paths.get(filePath);

        try{
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        }catch(IOException exeption){
           return null;
        }
    }

    public void writeLines(String filePath, List<String> fileContent){
        Path path = Paths.get(filePath);

        fileContent.stream().collect(Collectors.joining(";"));

        try{
            Files.write(path, fileContent, StandardCharsets.UTF_8);
        }catch(IOException exception){ }
    }

    public void createFile(String filePath){
        Path path = Path.of(filePath);
        try{
            Files.createFile(path);
        }catch(IOException exception){  }
    }

    public void deleteFile(String filePath){
        Path path = Path.of(filePath);
        try{
            Files.deleteIfExists(path);
        }catch(NoSuchFileException exception){

        }catch(IOException exception){
            System.out.println();
        }
    }

    public void createDirectory(String filePath){
        Path path = Path.of(filePath);

        try{
            Files.createDirectories(path);
        }catch(IOException exception){ }
    }

    public void deleteDirectory(String filePath){
        try{
            Files.delete(Path.of(filePath));
        }catch(IOException exception){}

    }


}
