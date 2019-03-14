package com.sortingalgorithm.util.format;

import com.sortingalgorithm.util.dao.DataAnalysis;

import java.io.IOException;

public interface FormatType extends FormatSaveType, FormatConvertType {
    @Override
    Object convert(DataAnalysis dao);

    @Override
    boolean save(DataAnalysis dao) throws IOException;
}
