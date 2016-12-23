package cn.edu.lnu.calculatlib.Number;

import cn.edu.lnu.calculatlib.CFPDivZeroExceptiion;

/**
 * Long类型封装类，提供了long类型基础的进制转换、运算等操作。</br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPLong implements CFPBaseOperation<CFPLong>, CFPLogicOperation<CFPLong>, CFPRadixConversion, Cloneable{

    /**
     * 数据是以标准库Long类型存储，在此基础上提供额外的操作。
     */
    private Long longNumber;

    /**
     * 构造函数。
     * @param a long型整数。
     */
    public CFPLong(long a) {
        longNumber = a;
    }

    /**
     * 克隆函数。
     * @return 克隆后的对象
     * @throws CloneNotSupportedException 当不支持克隆操作的时候抛出此异常
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        CFPLong a;
        a = (CFPLong) super.clone();
        a.longNumber = longNumber;
        return a;
    }

    @Override
    public String toHexString(){
        return Long.toHexString(longNumber).toUpperCase();
    }

    @Override
    public String toDecString(){
        return longNumber.toString();
    }

    @Override
    public String toOctString(){
        return Long.toOctalString(longNumber);
    }

    @Override
    public String toBinString(){
        return Long.toBinaryString(longNumber);
    }

    @Override
    public String toFullBinatyString(){
        StringBuilder stringBuilder = new StringBuilder(Long.toBinaryString(longNumber));
        int n = 64 - stringBuilder.length();
        while (n-- != 0){
            stringBuilder.insert(0,"0");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return this.toDecString();
    }

    /**
     * 返回一个Long类型的对象。
     * @return Long类型的对象
     */
    public Long getLongNumber() {
        return longNumber;
    }

    /**
     * 设置Long类型对象的值。
     * @param longNumber Long类型的对象，置此数的值为次数据
     */
    public void setLongNumber(Long longNumber) {
        this.longNumber = longNumber;
    }

    /**
     * 将无符号字符串转换成CFPLong。
     * @param s 要转换的字符串
     * @return 返回转换后的CFPLong类型对象
     */
    public CFPLong parseUnsignedLong(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        if(!(s.length() == 64))
        {
            int n = 64 - stringBuilder.length();
            while (n-- != 0){
                stringBuilder.insert(0,"0");
            }
        }
        this.longNumber = parseFullUnsignedLong(stringBuilder.toString());
        return this;
    }

    /**
     * 在java1.8之前，没有将无符号的二进制字符串转换成long类型的整数的API，
     * 所以在此写了将无符号二进制字符串装换成long类型整数的函数，
     * 函数功能同java1.8之后的Long类中的public static long parseUnsignedLong(String s,
     * int radix)
     * throws NumberFormatException 当其Radix参数设置为2时的函数。
     *
     * @param string 需要转换的二进制字符串
     * @return 返回一个long类型的基础数据类型数据
     */
    private long parseFullUnsignedLong(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        if (stringBuilder.charAt(0) == '1') {
            stringBuilder.setCharAt(0, '-');
            for (int i = 1; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == '1')
                    stringBuilder.setCharAt(i, '0');
                else stringBuilder.setCharAt(i, '1');
            }
            return Long.parseLong(stringBuilder.toString(), 2) - 1;
        } else return Long.parseLong(stringBuilder.toString(), 2);
    }

    /**
     * 将CFPLong类型转换成CFPRealNumber类型。
     * @return 返回一个CFPRealNumber类型对象
     */
    public CFPRealNumber toCFPRealNumber(){
        return new CFPRealNumber(longNumber.toString());
    }

    @Override
    public CFPLong add(CFPLong a) {
        this.longNumber += a.getLongNumber();
        return this;
    }

    @Override
    public CFPLong sub(CFPLong a) {
        this.longNumber -= a.getLongNumber();
        return this;
    }

    @Override
    public CFPLong mul(CFPLong a) {
        this.longNumber *= a.getLongNumber();
        return this;
    }

    @Override
    public CFPLong div(CFPLong a) throws CFPDivZeroExceptiion {
        if(a.getLongNumber() == 0)
            throw new CFPDivZeroExceptiion();
        this.longNumber /=a.getLongNumber();
        return this;
    }

    @Override
    public CFPLong opp() {
        this.longNumber = -this.longNumber;
        return this;
    }

    @Override
    public int compareTo(CFPLong a) {
        return this.longNumber.compareTo(a.getLongNumber());
    }

    @Override
    public CFPLong addABit(int a, int radix) {
        this.longNumber = longNumber*10 + a;
        return this;
    }

    @Override
    public CFPLong mod(CFPLong a) throws CFPDivZeroExceptiion {
        if(a.getLongNumber() == 0)
            throw new CFPDivZeroExceptiion();
        this.longNumber %= a.getLongNumber();
        return this;
    }

    @Override
    public CFPLong or(CFPLong a) {
        this.longNumber |= a.getLongNumber();
        return this;
    }

    @Override
    public CFPLong xor(CFPLong a) {
        this.longNumber ^= a.getLongNumber();
        return this;
    }

    @Override
    public CFPLong and(CFPLong a) {
        this.longNumber &= a.getLongNumber();
        return this;
    }

    @Override
    public CFPLong not() {
        this.longNumber = ~this.longNumber;
        return this;
    }

    @Override
    public CFPLong lsr(CFPLong a) {
        this.longNumber =
                this.longNumber >>> a.getLongNumber() | this.longNumber << (64 - a.getLongNumber());
        return this;
    }

    @Override
    public CFPLong lsl(CFPLong a) {
        this.longNumber =
                this.longNumber << a.getLongNumber() | this.longNumber >>> (64 - a.getLongNumber());
        return this;
    }

    @Override
    public CFPLong sl(CFPLong a) {
        this.longNumber = this.longNumber << a.getLongNumber();
        return this;
    }

    @Override
    public CFPLong sr(CFPLong a) {
        this.longNumber = this.longNumber >> a.getLongNumber();
        return this;
    }
}
