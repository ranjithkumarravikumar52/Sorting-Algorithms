package util.datapersistence;

import util.dao.DataAnalysis;
import util.formattype.FormatType;

public class DataPersistence {

    private DataAnalysis dao;
    private FormatType formatType;

    public DataPersistence(DataAnalysis dao, FormatType formatType) {
        this.dao = dao;
        this.formatType = formatType;
    }

    public boolean saveData(){
       try {
           formatType.save(dao);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }
}
