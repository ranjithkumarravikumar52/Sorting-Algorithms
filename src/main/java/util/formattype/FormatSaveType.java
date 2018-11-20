package util.formattype;

import util.dao.DataAnalysis;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FormatSaveType {
    boolean save(DataAnalysis dao) throws IOException;
}
