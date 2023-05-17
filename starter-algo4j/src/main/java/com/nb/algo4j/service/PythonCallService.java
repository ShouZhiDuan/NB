package com.nb.algo4j.service;


import java.util.Map;

/**
 * @author dev
 */
public interface PythonCallService {


    /**
     * MedicalStatistics#CHI_SQUARE_TEST
     * @param map
     * @return
     */
    Map<String, String> chiSquareTest(Map<String, String> map);

}