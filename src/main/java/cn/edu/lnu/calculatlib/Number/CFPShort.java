package cn.edu.lnu.calculatlib.Number;

import cn.edu.lnu.calculatlib.CFPDivZeroExceptiion;

/**
 * Short类型封装类，提供了Short类型基础的进制转换、运算等操作。<br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPShort implements CFPBaseOperation<CFPShort> , CFPLogicOperation<CFPShort>,
        CFPRadixConversion, Cloneable{

    /**
     * 数据是以标准库Short类型存储，在此基础上提供额外的操作。
     */
    private Short shortNumber;

    /**
     * 构造函数。
     * @param a short型整数。
     */
    public CFPShort(short a){
        shortNumber = a;
    }

    /**
     * 克隆函数。
     * @return 克隆后的对象
     * @throws CloneNotSupportedException 当不支持克隆操作的时候抛出此异常
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        CFPShort a;
        a = (CFPShort) super.clone();
        a.shortNumber = shortNumber;
        return a;
    }

    @Override
    public String toHexString() {
        if(shortNumber >= 0)
            return Integer.toHexString(shortNumber).toUpperCase();
        else{
            StringBuilder stringBuilder = new StringBuilder(Integer.toHexString(shortNumber).toUpperCase());
            return stringBuilder.substring(4);
        }
    }

    @Override
    public String toDecString() {
        return this.shortNumber.toString();
    }

    @Override
    public String toOctString() {
        StringBuilder s1 = new StringBuilder(this.toBinString());
        StringBuilder s2 = new StringBuilder("");
        int n = s1.length() - 3;
        while (n>0){
            s2.insert(0,Byte.parseByte(s1.substring(n,n + 3),2));
            n -= 3;
        }
        s2.insert(0,Byte.parseByte(s1.substring(0,n + 3),2));
        return s2.toString();
    }

    @Override
    public String toBinString() {
        if(shortNumber >= 0)
            return Integer.toBinaryString(shortNumber);
        else{
            StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(shortNumber));
            return stringBuilder.substring(16);
        }
    }

    @Override
    public String toFullBinatyString(){
        StringBuilder stringBuilder = new StringBuilder(this.toBinString());
        int n = 16 - stringBuilder.length();
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
     * 将无符号字符串转换成CFPShort。
     * @param s 要转换的字符串
     * @return 返回转换后的CFPShort类型对象
     */
    public CFPShort parseUnsignedShort(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        if(!(s.length() == 16))
        {
            int n = 16 - stringBuilder.length();
            while (n-- != 0){
                stringBuilder.insert(0,"0");
            }
        }
        this.shortNumber = parseFullUnsignedShort(stringBuilder.toString());
        return this;
    }

    /**
     * 在java1.8之前，没有将无符号的二进制字符串转换成 short 类型的整数的API，
     * 所以在此写了将无符号二进制字符串装换成 short 类型整数的函数，
     * 函数功能同java1.8之后的 Short 类中的public static short parseUnsignedShort(String s,
     * int radix)
     * throws NumberFormatException 当其Radix参数设置为2时的函数。
     *
     * @param string 需要转换的二进制字符串
     * @return 返回一个 short 类型的基础数据类型数据
     */
    private short parseFullUnsignedShort(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        if (stringBuilder.charAt(0) == '1') {
            stringBuilder.setCharAt(0, '-');
            for (int i = 1; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == '1')
                    stringBuilder.setCharAt(i, '0');
                else stringBuilder.setCharAt(i, '1');
            }
            return (short)(Short.parseShort(stringBuilder.toString(), 2) - 1);
        } else return Short.parseShort(stringBuilder.toString(), 2);
    }

    /**
     * 返回一个Short类型的对象。
     * @return short类型的对象
     */
    public Short getShortNumber() {
        return shortNumber;
    }

    /**
     * 设置Long类型对象的值。
     * @param shortNumber Short类型的对象，置此数的值为次数据
     */
    public void setShortNumber(Short shortNumber) {
        this.shortNumber = shortNumber;
    }

    /**
     * 将CFPShort类型转换成CFPRealNumber类型。
     * @return 返回一个CFPRealNumber类型对象
     */
    public CFPRealNumber toCFPRealNumber(){
        return new CFPRealNumber(shortNumber.toString());
    }

    @Override
    public CFPShort add(CFPShort a) {
        this.shortNumber = (short) (this.shortNumber + a.getShortNumber());
        return this;
    }

    @Override
    public CFPShort sub(CFPShort a) {
        this.shortNumber = (short) (this.shortNumber - a.getShortNumber());
        return this;
    }

    @Override
    public CFPShort mul(CFPShort a) {
        this.shortNumber = (short) (this.shortNumber * a.getShortNumber());
        return this;
    }

    @Override
    public CFPShort div(CFPShort a) throws CFPDivZeroExceptiion {
        if (a.getShortNumber() == 0){
            throw new CFPDivZeroExceptiion();
        }
        this.shortNumber = (short) (this.shortNumber / a.getShortNumber());
        return this;
    }

    @Override
    public CFPShort opp() {
        this.shortNumber = (short) -this.shortNumber;
        return this;
    }

    @Override
    public int compareTo(CFPShort a) {
        return this.shortNumber.compareTo(a.getShortNumber());
    }

    @Override
    public CFPShort addABit(int a, int radix) {
        this.shortNumber = (short)(shortNumber*radix + a);
        return this;
    }

    @Override
    public CFPShort deleteABit(int radix) {
        this.shortNumber = (short)(shortNumber / radix);
        return this;
    }

    @Override
    public CFPShort mod(CFPShort a) throws CFPDivZeroExceptiion {
        if (a.getShortNumber() == 0){
            throw new CFPDivZeroExceptiion();
        }
        this.shortNumber = (short) (this.shortNumber % a.getShortNumber());
        return this;
    }

    @Override
    public CFPShort or(CFPShort a) {
        this.shortNumber = (short) (this.shortNumber | a.getShortNumber());
        return this;
    }

    @Override
    public CFPShort xor(CFPShort a) {
        this.shortNumber = (short) (this.shortNumber ^ a.getShortNumber());
        return this;
    }

    @Override
    public CFPShort and(CFPShort a) {
        this.shortNumber = (short) (this.shortNumber & a.getShortNumber());
        return this;
    }

    @Override
    public CFPShort not() {
        this.shortNumber = (short) ~this.shortNumber;
        return this;
    }

    @Override
    public CFPShort lsr(CFPShort a) {
        StringBuilder stringBuilder = new StringBuilder(this.toFullBinatyString());
        for(int i = 0; i < a.getShortNumber(); i++){
            stringBuilder.insert(0, stringBuilder.charAt(15));
            stringBuilder.deleteCharAt(16);
        }
        this.parseUnsignedShort(stringBuilder.toString());
        return this;
    }

    @Override
    public CFPShort lsl(CFPShort a) {
        StringBuilder stringBuilder = new StringBuilder(this.toFullBinatyString());
        for(int i = 0; i < a.getShortNumber(); i++){
            stringBuilder.append(stringBuilder.charAt(0));
            stringBuilder.deleteCharAt(0);
        }
        this.parseUnsignedShort(stringBuilder.toString());
        return this;
    }

    @Override
    public CFPShort sl(CFPShort a) {
        this.shortNumber = (short)(this.shortNumber << a.getShortNumber());
        return this;
    }

    @Override
    public CFPShort sr(CFPShort a) {
        this.shortNumber = (short)(this.shortNumber >> a.getShortNumber());
        return this;
    }


}
