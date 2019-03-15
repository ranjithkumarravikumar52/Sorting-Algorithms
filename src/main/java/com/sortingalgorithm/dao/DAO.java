package com.sortingalgorithm.dao;

import com.sortingalgorithm.service.model.formattype.FormatType;
import com.sortingalgorithm.service.model.pojo.DataAnalysis;

public interface DAO {
	boolean saveDataToRepo(DataAnalysis dataAnalysis, FormatType formatType);
}
