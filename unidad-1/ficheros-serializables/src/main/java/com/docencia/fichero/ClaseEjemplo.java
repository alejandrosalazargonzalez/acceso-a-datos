package com.docencia.fichero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClaseEjemplo {

    private static final Logger logger = LoggerFactory.getLogger(ClaseEjemplo.class);

    public ClaseEjemplo(){
        String variable = "soy variable";
        String otra = "soy otra variable";
        logger.info("soy un mensaje {}, y soy otra variable {}",variable,otra);
        Exception exception = new Exception("Sucedio un error");
        logger.error("el mensaje que quiero {}, más excepcion ", variable,exception);
    }
}
