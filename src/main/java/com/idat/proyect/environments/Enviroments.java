package com.idat.proyect.environments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Enviroments {

    @Value("${myConfig.pathOriginsCors}")
    public String pathOriginsCors;

    @Value("${myConfig.pathVouchers}")
    public String nameDirectoryVouchersPhotos;

    @Value("${myConfig.pathImagesClients}")
    public String nameDirectoryClientPhotos;

    @Value("${myConfig.pathProducts}")
    public String nameDirectoryProductsPhotos;

    @Value("${myConfig.pathProductsThumbnail}")
    public String nameDirectoryProductsThumbnailPhotos;
}
