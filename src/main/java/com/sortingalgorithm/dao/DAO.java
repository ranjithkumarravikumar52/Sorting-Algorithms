package com.sortingalgorithm.dao;

import com.sortingalgorithm.service.format.FormatType;
import com.sortingalgorithm.service.model.DataAnalysis;

public interface DAO {
	boolean saveDataToRepo(DataAnalysis dataAnalysis, FormatType formatType);
}
