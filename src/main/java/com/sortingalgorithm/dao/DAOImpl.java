package com.sortingalgorithm.dao;

import com.sortingalgorithm.model.formattype.FormatType;
import com.sortingalgorithm.model.pojo.DataAnalysis;

public class DAOImpl implements DAO{

    private DataAnalysis dao;
    private FormatType formatType;

    public DAOImpl(DataAnalysis dataAnalysis, FormatType formatType) {
        this.dao = dataAnalysis;
        this.formatType = formatType;
    }

    @Override
    public boolean saveDataToRepo(DataAnalysis dataAnalysis, FormatType formatType){
       try {
           formatType.save(dataAnalysis);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }
}
