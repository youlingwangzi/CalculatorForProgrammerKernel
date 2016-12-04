package cn.edu.lnu.calculatlib;

/**
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public enum CFPDataType {
    LONG,INTEGER,SHORT,BYTE,REAL_NUMBER,DOUBLE,FLOAT;

    public boolean isIntegersType(){
        return ordinal() < 4;
    }

    public boolean isDecimalType(){
        return ordinal() > 4;
    }

    public boolean isRealNumber(){
        return ordinal() == 4;
    }
}
