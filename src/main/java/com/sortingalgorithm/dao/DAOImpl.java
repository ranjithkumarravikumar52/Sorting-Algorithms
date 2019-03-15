package com.sortingalgorithm.dao;

import com.sortingalgorithm.model.formattype.FormatType;
import com.sortingalgorithm.model.pojo.DataAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DAOImpl implements DAO{

    private static final Logger log = LoggerFactory.getLogger(DAOImpl.class);

    @Override
    public boolean saveDataToRepo(List<DataAnalysis> dataAnalysisList, FormatType formatType){


        try {
           for(DataAnalysis dataAnalysis: dataAnalysisList){
               formatType.save(dataAnalysis);
           }
           return true;
       }catch (Exception e){
           log.error(e.getMessage());
           e.printStackTrace();
           return false;
       }
    }
}
