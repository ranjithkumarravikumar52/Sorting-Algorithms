package com.sortingalgorithm.service.format;

import com.sortingalgorithm.service.model.DataAnalysis;

import java.io.IOException;

public interface FormatSaveType {
    boolean save(DataAnalysis dao) throws IOException;
}
