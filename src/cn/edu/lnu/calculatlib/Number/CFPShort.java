package cn.edu.lnu.calculatlib.Number;

/**
 * Short类型封装类，提供了Short类型基础的进制转换、运算等操作。</br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPShort implements CFPBaseOperation<CFPShort> , CFPLogicOperation<CFPShort>, CFPRadixConversion{

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

    @Override
    public String toHexString() {
        if(shortNumber >= 0)
            return Integer.toHexString(shortNumber);
        else{
            StringBuilder stringBuilder = new StringBuilder(Integer.toHexString(shortNumber));
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

    public String toFullBinatyString(){
        StringBuilder stringBuilder = new StringBuilder(this.toBinString());
        int n = 16 - stringBuilder.length();
        while (n-- != 0){
            stringBuilder.insert(0,"0");
        }
        return stringBuilder.toString();
    }

    /**
     * 将无符号字符串转换成CFPShort。
     * @param s 要转换的字符串
     * @param radix 字符串采用的进制
     * @return 返回转换后的CFPShort类型对象
     */
    public CFPShort parseUnsignedShort(String s, int radix){
        if (s.charAt(0) == '1' && s.length() == 16){
            StringBuilder stringBuilder = new StringBuilder(this.toBinString());
            int n = 32 - stringBuilder.length();
            while (n-- != 0){
                stringBuilder.insert(0,"1");
            }
        }
        this.shortNumber = (short)Integer.parseUnsignedInt(s, radix);
        return this;
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
    public CFPShort div(CFPShort a) {
        this.shortNumber = (short) (this.shortNumber / a.getShortNumber());
        return this;
    }

    @Override
    public CFPShort opp() {
        this.shortNumber = (short) -this.shortNumber;
        return this;
    }

    @Override
    public CFPShort mod(CFPShort a) {
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
    public CFPShort lsl(CFPShort a) {
        this.shortNumber =
                (short)(this.shortNumber >>> a.getShortNumber() | this.shortNumber << (16 - a.getShortNumber()));
        return this;
    }

    @Override
    public CFPShort lsr(CFPShort a) {
        this.shortNumber =
                (short)(this.shortNumber << a.getShortNumber() | this.shortNumber >>> (16 - a.getShortNumber()));
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
