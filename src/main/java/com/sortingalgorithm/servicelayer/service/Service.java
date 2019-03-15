package com.sortingalgorithm.servicelayer.service;

import com.sortingalgorithm.servicelayer.sortalgorithms.SortAlgorithm;

import java.util.List;

/**
 * Any ServiceImpl should do the following operation
 * Method to call generateArray, sort, calculateMetric, getDAO objects, callDAO layer to save the DAO objects
 */
public interface Service {
	boolean doSimulation(List<SortAlgorithm> sortAlgorithmList, int simulationCount, int dataSize);
}
