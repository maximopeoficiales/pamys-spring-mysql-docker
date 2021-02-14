package com.idat.proyect.web.utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import com.idat.proyect.web.security.Console;
import com.idat.proyect.web.utilities.interfaces.IPhotoOperations;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoOperations implements IPhotoOperations {
    Console console = new Console(PhotoOperations.class);

    @Override
    public Resource chargingFile(String namePhoto, String pathAbsolute) throws MalformedURLException {
        Path rutaArchivo = this.getPath(namePhoto, pathAbsolute);
        // muestra la ruta en consola
        console.log(rutaArchivo.toString());
        Resource recurso = new UrlResource(rutaArchivo.toUri());
        if (!recurso.exists() && !recurso.isReadable()) {
            new MalformedURLException("El recurso no existe");
        }
        return recurso;
    }

    @Override
    public String copyPhoto(MultipartFile file, String pathAbsolute) throws IOException {
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename().replace(" ", "");
        Path filePath = Paths.get(pathAbsolute).resolve(fileName).toAbsolutePath();
        console.log(fileName);
        console.log(filePath.toString());
        Files.copy(file.getInputStream(), filePath);
        return fileName;
    }

    @Override
    public boolean removePhoto(String nameFile, String pathAbsolute) {
        if (nameFile != null && nameFile.length() > 0) {
            Path rutaFotoAnterior = Paths.get(pathAbsolute).resolve(nameFile).toAbsolutePath();
            File archivoAnterior = rutaFotoAnterior.toFile();
            if (archivoAnterior.exists() && archivoAnterior.canRead()) {
                archivoAnterior.delete();
                return true;
            }
        }
        return false;
    }

    @Override
    public Path getPath(String namePhoto, String pathAbsolute) {
        return Paths.get(pathAbsolute).resolve(namePhoto).toAbsolutePath();
    }

}
