package com.idat.proyect.web.utilities.interfaces;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IPhotoOperations {

    Resource chargingFile(String namePhoto,String pathAbsolute) throws MalformedURLException;

    String copyPhoto(MultipartFile file, String pathAbsolute)  throws IOException;

    boolean removePhoto(String nameFile, String pathAbsolute);

    Path getPath(String namePhoto,String pathAbsolute);

}
