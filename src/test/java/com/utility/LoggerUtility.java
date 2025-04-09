package com.utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private LoggerUtility() {

    }

    public static Logger getLogger(Class<?> clazz){
        Logger Logger=null;
        if (Logger == null) {
            Logger = LogManager.getLogger(clazz);
        }
        return Logger;
    }
}
