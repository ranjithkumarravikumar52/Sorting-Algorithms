package com.sortingalgorithm.model.formattype;

import com.sortingalgorithm.model.pojo.DataAnalysis;

import java.io.IOException;

/**
 * FormatType is the type of data we want to store it in a repo
 * This is could be excel, json or a POJO
 */
public interface FormatType extends FormatSaveType, FormatConvertType {
    @Override
    Object convert(DataAnalysis dao);

    @Override
    boolean save(DataAnalysis dao) throws IOException;
}
