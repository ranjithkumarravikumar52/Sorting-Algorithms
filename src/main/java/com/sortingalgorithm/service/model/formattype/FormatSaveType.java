package com.sortingalgorithm.service.model.formattype;

import com.sortingalgorithm.service.model.pojo.DataAnalysis;

import java.io.IOException;

public interface FormatSaveType {
    boolean save(DataAnalysis dao) throws IOException;
}
