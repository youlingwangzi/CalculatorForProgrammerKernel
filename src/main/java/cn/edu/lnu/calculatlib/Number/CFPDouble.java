package cn.edu.lnu.calculatlib.Number;

/**
 * Double类型封装类，提供了Double类型基础的进制转换、运算等操作。</br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPDouble extends CFPRealNumber {
    /**
     * 构造函数。
     *
     * @param s 要转换的字符串
     */
    public CFPDouble(String s) {
        super(s);
    }

    /**
     * 构造函数。
     *
     * @param a 要转化的数
     */
    public CFPDouble(double a) {
        super(Double.valueOf(a).toString());
    }

    @Override
    public String toHexString() {
        return Double.toHexString(this.getBigDecimalNumber().doubleValue()).toUpperCase();
    }

    @Override
    public String toOctString() {
        return Long.toOctalString(Double.doubleToLongBits(this.getBigDecimalNumber().doubleValue()));
    }

    @Override
    public String toBinString() {
        return Long.toBinaryString(Double.doubleToLongBits(this.getBigDecimalNumber().doubleValue()));
    }

    @Override
    public String toFullBinatyString() {
        StringBuilder stringBuilder = new StringBuilder(this.toBinString());
        int n = 64 - stringBuilder.length();
        while (n-- != 0){
            stringBuilder.insert(0,"0");
        }
        return stringBuilder.toString();
    }

    public CFPRealNumber toCFPRealNumber(){
        CFPRealNumber cfpRealNumber = new CFPRealNumber(this.getBigDecimalNumber().toString());
        cfpRealNumber.setInputScale(getInputScale());
        return cfpRealNumber;
    }
}
