package com.sortingalgorithm.dao;

import com.sortingalgorithm.service.format.FormatType;
import com.sortingalgorithm.service.model.DataAnalysis;

public class DAOImpl implements DAO{

    private DataAnalysis dao;
    private FormatType formatType;

    public DAOImpl(DataAnalysis dao, FormatType formatType) {
        this.dao = dao;
        this.formatType = formatType;
    }

    @Override
    public boolean saveDataToRepo(DataAnalysis dao, FormatType formatType){
       try {
           formatType.save(dao);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }
}
