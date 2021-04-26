package com.amazon.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class FileReader {

    public static final String LATIN = "\\p{Alpha}+";
    public static final String ENCODING = "utf-8";
    private static final Logger log = Logger.getLogger(FileReader.class.getName());

    private FileReader() {
        throw new AssertionError();
    }

    public static String readJson() {
        return null;
    }

    public static String readFile(final String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);//NOSONAR
        } catch (IOException ex) {
            log.info("I catch the error" + ex);
        }
        return res;
    }
}
