package com.sortingalgorithm.service.format;

import com.sortingalgorithm.service.model.DataAnalysis;

import java.io.IOException;

public interface FormatType extends FormatSaveType, FormatConvertType {
    @Override
    Object convert(DataAnalysis dao);

    @Override
    boolean save(DataAnalysis dao) throws IOException;
}
