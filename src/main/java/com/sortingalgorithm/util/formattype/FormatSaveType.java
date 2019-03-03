package com.sortingalgorithm.util.formattype;

import com.sortingalgorithm.util.dao.DataAnalysis;

import java.io.IOException;

public interface FormatSaveType {
    boolean save(DataAnalysis dao) throws IOException;
}
