package com.nb.algo4j.service.impl;

import com.nb.algo4j.service.PythonCallService;
import jep.Interpreter;
import jep.SharedInterpreter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


/**
 * @author dev
 */

@Slf4j
public class PythonCallServiceImpl implements PythonCallService {

    @Override
    public Map<String, String> chiSquareTest(Map<String, String> map) {
        //String fileName = "./python/hetero-lr-boston.py";
        String fileName = map.get("fileName");
        String pythonCode = "";
        try {
            byte[] encodedBytes = Files.readAllBytes(Paths.get(fileName));
            pythonCode = new String(encodedBytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("Failed to read file: " + e.getMessage());
        }

        try (Interpreter interp = new SharedInterpreter()) {
            // Call Python
            interp.exec(pythonCode);

            HashMap<String, String> metrics = (HashMap<String, String>) interp.getValue("metrics");
            HashMap<String, String> model = (HashMap<String, String>) interp.getValue("model");

            log.info("metrics=" + metrics);
            log.info("model=" + model);
        }
        return null;
    }


}