package com.sortingalgorithm.daolayer.format;

import com.sortingalgorithm.daolayer.dao.DataAnalysis;

import java.io.IOException;

public interface FormatType extends FormatSaveType, FormatConvertType {
    @Override
    Object convert(DataAnalysis dao);

    @Override
    boolean save(DataAnalysis dao) throws IOException;
}
