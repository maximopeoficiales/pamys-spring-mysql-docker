package com.idat.proyect.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Console {

    public Logger logger;

    public Console(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);

    }

    public void log(String value) {
        // encripta password
        this.logger.info(value);
    }

}
