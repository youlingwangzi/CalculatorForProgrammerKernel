package cn.edu.lnu.calculatlib;

/**
 * 数据类型枚举类。定义了支持的所有数据类型。</br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public enum CFPDataType {
    /**
     * 长整型
     */
    LONG,

    /**
     * 整型
     */
    INTEGER,

    /**
     * 短整型
     */
    SHORT,

    /**
     * 字节
     */
    BYTE,

    /**
     * 实数
     */
    REAL_NUMBER,

    /**
     * 双精度浮点型
     */
    DOUBLE,

    /**
     * 浮点型
     */
    FLOAT;

    /**
     * 判定当前是否是整型。</br>
     * 包括Long、Integer、Short、Byte四种。
     * @return 返回bool结果
     */
    public boolean isIntegersType(){
        return ordinal() < 4;
    }

    /**
     * 判定当前是否是浮点型。</br>
     * 包括Double、Float两种。
     * @return 返回bool结果
     */
    public boolean isDecimalType(){
        return ordinal() > 4;
    }

    /**
     * 判定当前是否是实数。</br>
     * 包括RealNumber一种。
     * @return 返回bool结果
     */
    public boolean isRealNumber(){
        return ordinal() == 4;
    }
}
