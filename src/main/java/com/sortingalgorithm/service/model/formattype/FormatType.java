package com.sortingalgorithm.service.model.formattype;

import com.sortingalgorithm.service.model.pojo.DataAnalysis;

import java.io.IOException;

public interface FormatType extends FormatSaveType, FormatConvertType {
    @Override
    Object convert(DataAnalysis dao);

    @Override
    boolean save(DataAnalysis dao) throws IOException;
}
