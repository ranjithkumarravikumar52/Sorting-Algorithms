package com.sortingalgorithm.dao;

import com.sortingalgorithm.model.formattype.FormatType;
import com.sortingalgorithm.model.pojo.DataAnalysis;

public interface DAO {
	boolean saveDataToRepo(DataAnalysis dataAnalysis, FormatType formatType);
}
