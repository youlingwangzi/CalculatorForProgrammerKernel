package cn.edu.lnu.calculatlib.Number;

import cn.edu.lnu.calculatlib.CFPDivZeroExceptiion;

/**
 * Float类型封装类，提供了Float类型基础的进制转换、运算等操作。</br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPFloat implements CFPRadixConversion, CFPBaseOperation<CFPFloat> {

    /**
     * 数据是以标准库Float类型存储，在此基础上提供额外的操作。
     */
    private Float floatNumber;

    /**
     * 构造函数。
     * @param a float型整数。
     */
    public CFPFloat(float a){
        floatNumber = a;
    }

    @Override
    public String toHexString() {
        return Float.toHexString(floatNumber).toUpperCase();
    }

    @Override
    public String toDecString() {
        return floatNumber.toString();
    }

    @Override
    public String toOctString() {
        return Integer.toOctalString(Float.floatToIntBits(floatNumber));
    }

    @Override
    public String toBinString() {
        return Integer.toBinaryString(Float.floatToIntBits(floatNumber));
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

    /**
     * 返回一个Float类型的对象。
     * @return Float类型的对象
     */
    public Float getFloatNumber() {
        return floatNumber;
    }

    /**
     * 设置Double类型对象的值。
     * @param floatNumber Float类型的对象，置此数的值为次数据
     */
    public void setFloatNumber(Float floatNumber) {
        this.floatNumber = floatNumber;
    }

    /**
     * 将CFPFloat类型转换成CFPRealNumber类型。
     * @return 返回一个CFPRealNumber类型对象
     */
    public CFPRealNumber toCFPRealNumber(){
        return new CFPRealNumber(floatNumber.toString());
    }

    @Override
    public CFPFloat add(CFPFloat a) {
        this.floatNumber += a.getFloatNumber();
        return this;
    }

    @Override
    public CFPFloat sub(CFPFloat a) {
        this.floatNumber -= a.getFloatNumber();
        return this;
    }

    @Override
    public CFPFloat mul(CFPFloat a) {
        this.floatNumber *= a.getFloatNumber();
        return this;
    }

    @Override
    public CFPFloat div(CFPFloat a) throws CFPDivZeroExceptiion {
        if (a.getFloatNumber().compareTo((float)0) == 0){
            throw new CFPDivZeroExceptiion();
        }
        this.floatNumber /= a.getFloatNumber();
        return this;
    }

    @Override
    public CFPFloat opp() {
        this.floatNumber = -this.floatNumber;
        return this;
    }
}
