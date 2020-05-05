package cn.edu.lnu.calculatlib.Number;


/**
 * Float类型封装类，提供了Float类型基础的进制转换、运算等操作。<br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPFloat extends CFPRealNumber{

    /**
     * 构造函数。
     *
     * @param s 要转换的字符串
     */
    public CFPFloat(String s) {
        super(s);
    }

    /**
     * 构造函数。
     *
     * @param a 要转换的字符串
     */
    public CFPFloat(float a) {
        super(Float.valueOf(a).toString());
    }

    @Override
    public String toHexString() {
        return Float.toHexString(this.getBigDecimalNumber().floatValue()).toUpperCase();
    }

    @Override
    public String toOctString() {
        return Integer.toOctalString(Float.floatToIntBits(this.getBigDecimalNumber().floatValue()));
    }

    @Override
    public String toBinString() {
        return Integer.toBinaryString(Float.floatToIntBits(this.getBigDecimalNumber().floatValue()));
    }

    @Override
    public String toFullBinatyString() {
        StringBuilder stringBuilder = new StringBuilder(this.toBinString());
        int n = 32 - stringBuilder.length();
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
