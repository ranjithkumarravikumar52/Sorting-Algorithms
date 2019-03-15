package com.sortingalgorithm.dao;

import com.sortingalgorithm.model.formattype.FormatType;
import com.sortingalgorithm.model.pojo.DataAnalysis;

import java.util.List;

public interface DAO {
	boolean saveDataToRepo(List<DataAnalysis> dataAnalysisList, FormatType formatType);
}
