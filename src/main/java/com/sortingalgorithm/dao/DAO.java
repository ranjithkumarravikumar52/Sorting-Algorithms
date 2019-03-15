package com.sortingalgorithm.dao;

import com.sortingalgorithm.model.formattype.FormatType;
import com.sortingalgorithm.model.pojo.DataAnalysis;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DAO {
	boolean saveDataToRepo(List<DataAnalysis> dataAnalysisList, FormatType formatType);
}
