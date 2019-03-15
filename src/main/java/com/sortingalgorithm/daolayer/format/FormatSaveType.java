package com.sortingalgorithm.daolayer.format;

import com.sortingalgorithm.daolayer.model.DataAnalysis;

import java.io.IOException;

public interface FormatSaveType {
    boolean save(DataAnalysis dao) throws IOException;
}
