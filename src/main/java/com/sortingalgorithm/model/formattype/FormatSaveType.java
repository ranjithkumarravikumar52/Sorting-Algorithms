package com.sortingalgorithm.model.formattype;

import com.sortingalgorithm.model.pojo.DataAnalysis;

import java.io.IOException;

public interface FormatSaveType {
    boolean save(DataAnalysis dao) throws IOException;
}
