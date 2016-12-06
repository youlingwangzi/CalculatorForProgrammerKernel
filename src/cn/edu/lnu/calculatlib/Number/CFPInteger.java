package cn.edu.lnu.calculatlib.Number;

import cn.edu.lnu.calculatlib.CFPDivZeroExceptiion;

/**
 * Integer类型封装类，提供了long类型基础的进制转换、运算等操作。</br>
 * Created by youlingwangzi on 2016/12/2.
 * @author yuanxiaokun
 */
public class CFPInteger implements CFPBaseOperation <CFPInteger>, CFPLogicOperation<CFPInteger>, CFPRadixConversion {

    /**
     * 数据是以标准库Integer类型存储，在此基础上提供额外的操作。
     */
    private Integer integerNumber;

    /**
     * 构造函数。
     * @param a int型整数。
     */
    public CFPInteger(int a){
        integerNumber = a;
    }

    @Override
    public String toHexString(){
        return Integer.toHexString(integerNumber);
    }

    @Override
    public String toDecString(){
        return integerNumber.toString();
    }

    @Override
    public String toOctString(){
        return Integer.toOctalString(integerNumber);
    }

    @Override
    public String toBinString(){
        return Integer.toBinaryString(integerNumber);
    }

    @Override
    public String toFullBinatyString(){
        StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(integerNumber));
        int n = 32 - stringBuilder.length();
        while (n-- != 0){
            stringBuilder.insert(0,"0");
        }
        return stringBuilder.toString();
    }

    /**
     * 将无符号字符串转换成CFPInteger。
     * @param s 要转换的字符串
     * @param radix 字符串采用的进制
     * @return 返回转换后的CFPInteger类型对象
     */
    public CFPInteger parseUnsignedInt(String s, int radix){
        this.integerNumber = Integer.parseUnsignedInt(s, radix);
        return this;
    }

    /**
     * 返回一个Integer类型的对象。
     * @return Integer类型的对象
     */
    public Integer getIntegerNumber() {
        return integerNumber;
    }

    /**
     * 设置Integer类型对象的值。
     * @param integerNumber Integer类型的对象，置此数的值为次数据
     */
    public void setIntegerNumber(Integer integerNumber) {
        this.integerNumber = integerNumber;
    }

    /**
     * 将CFPInteger类型转换成CFPRealNumber类型。
     * @return 返回一个CFPRealNumber类型对象
     */
    public CFPRealNumber toCFPRealNumber(){
        return new CFPRealNumber(integerNumber.toString());
    }

    @Override
    public CFPInteger add(CFPInteger a) {
        this.integerNumber += a.getIntegerNumber();
        return this;
    }

    @Override
    public CFPInteger sub(CFPInteger a) {
        this.integerNumber -= a.getIntegerNumber();
        return this;
    }

    @Override
    public CFPInteger mul(CFPInteger a) {
        this.integerNumber *= a.getIntegerNumber();
        return this;
    }

    @Override
    public CFPInteger div(CFPInteger a) throws CFPDivZeroExceptiion {
        if (a.getIntegerNumber() == 0){
            throw new CFPDivZeroExceptiion();
        }
        this.integerNumber /= a.getIntegerNumber();
        return this;
    }

    @Override
    public CFPInteger opp() {
        this.integerNumber = -this.integerNumber;
        return this;
    }

    @Override
    public int compareTo(CFPInteger a) {
        return this.integerNumber.compareTo(a.getIntegerNumber());
    }

    @Override
    public CFPInteger mod(CFPInteger a) throws CFPDivZeroExceptiion {
        if (a.getIntegerNumber() == 0){
            throw new CFPDivZeroExceptiion();
        }
        this.integerNumber %= a.integerNumber;
        return this;
    }

    @Override
    public CFPInteger or(CFPInteger a) {
        this.integerNumber |= a.integerNumber;
        return this;
    }

    @Override
    public CFPInteger xor(CFPInteger a) {
        this.integerNumber ^= a.integerNumber;
        return this;
    }

    @Override
    public CFPInteger and(CFPInteger a) {
        this.integerNumber &= a.integerNumber;
        return this;
    }

    @Override
    public CFPInteger not() {
        this.integerNumber = ~this.integerNumber;
        return this;
    }

    @Override
    public CFPInteger lsl(CFPInteger a) {
        this.integerNumber =
                this.integerNumber >>> a.getIntegerNumber() | this.integerNumber << (32 - a.getIntegerNumber());
        return this;
    }

    @Override
    public CFPInteger lsr(CFPInteger a) {
        this.integerNumber =
                this.integerNumber << a.getIntegerNumber() | this.integerNumber >>> (32 - a.getIntegerNumber());
        return this;
    }

    @Override
    public CFPInteger sl(CFPInteger a) {
        this.integerNumber = this.integerNumber << a.integerNumber;
        return this;
    }

    @Override
    public CFPInteger sr(CFPInteger a) {
        this.integerNumber = this.integerNumber >> a.integerNumber;
        return this;
    }
}
