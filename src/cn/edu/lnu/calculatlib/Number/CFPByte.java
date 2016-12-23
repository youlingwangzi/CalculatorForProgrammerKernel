package cn.edu.lnu.calculatlib.Number;

import cn.edu.lnu.calculatlib.CFPDivZeroExceptiion;

/**
 * Byte类型封装类，提供了Byte类型基础的进制转换、运算等操作。</br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPByte implements CFPBaseOperation<CFPByte>, CFPLogicOperation<CFPByte>,CFPRadixConversion, Cloneable {

    /**
     * 数据是以标准库Byte类型存储，在此基础上提供额外的操作。
     */
    private Byte byteNumbger;

    /**
     * 构造函数。
     * @param a byte型整数。
     */
    public CFPByte(byte a){
        byteNumbger = a;
    }

    /**
     * 克隆函数。
     * @return 克隆后的对象
     * @throws CloneNotSupportedException 当不支持克隆操作的时候抛出此异常
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        CFPByte a;
        a = (CFPByte) super.clone();
        a.byteNumbger = byteNumbger;
        return a;
    }

    @Override
    public String toHexString() {
        if(byteNumbger >= 0)
            return Integer.toHexString(byteNumbger).toUpperCase();
        else{
            StringBuilder stringBuilder = new StringBuilder(Integer.toHexString(byteNumbger).toUpperCase());
            return stringBuilder.substring(6);
        }
    }

    @Override
    public String toDecString() {
        return this.byteNumbger.toString();
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
        if(byteNumbger >= 0)
            return Integer.toBinaryString(byteNumbger);
        else{
            StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(byteNumbger));
            return stringBuilder.substring(24);
        }
    }

    @Override
    public String toFullBinatyString() {
        StringBuilder stringBuilder = new StringBuilder(this.toBinString());
        int n = 8 - stringBuilder.length();
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
     * 将无符号字符串转换成CFPByte。
     * @param s 要转换的字符串
     * @return 返回转换后的CFPByte类型对象
     */
    public CFPByte parseUnsignedByte(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        if(!(s.length() == 8))
        {
            int n = 8 - stringBuilder.length();
            while (n-- != 0){
                stringBuilder.insert(0,"0");
            }
        }
        this.byteNumbger = parseFullUnsignedByte(stringBuilder.toString());
        return this;
    }

    /**
     * 在java1.8之前，没有将无符号的二进制字符串转换成 byte 类型的整数的API，
     * 所以在此写了将无符号二进制字符串装换成 byte 类型整数的函数，
     * 函数功能同java1.8之后的 Byte 类中的public static byte parseUnsignedByte(String s,
     * int radix)
     * throws NumberFormatException 当其Radix参数设置为2时的函数。
     *
     * @param string 需要转换的二进制字符串
     * @return 返回一个 byte 类型的基础数据类型数据
     */
    private byte parseFullUnsignedByte(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        if (stringBuilder.charAt(0) == '1') {
            stringBuilder.setCharAt(0, '-');
            for (int i = 1; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == '1')
                    stringBuilder.setCharAt(i, '0');
                else stringBuilder.setCharAt(i, '1');
            }
            return (byte) (Byte.parseByte(stringBuilder.toString(), 2) - 1);
        } else return Byte.parseByte(stringBuilder.toString(), 2);
    }

    /**
     * 返回一个Byte类型的对象。
     * @return Byte类型的对象
     */
    public Byte getByteNumbger() {
        return byteNumbger;
    }

    /**
     * 设置Byte类型对象的值。
     * @param byteNumbger Byte类型的对象，置此数的值为次数据
     */
    public void setByteNumbger(Byte byteNumbger) {
        this.byteNumbger = byteNumbger;
    }

    /**
     * 将CFPByte类型转换成CFPRealNumber类型。
     * @return 返回一个CFPRealNumber类型对象
     */
    public CFPRealNumber toCFPRealNumber(){
        return new CFPRealNumber(byteNumbger.toString());
    }

    @Override
    public CFPByte add(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger + a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte sub(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger - a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte mul(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger * a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte div(CFPByte a) throws CFPDivZeroExceptiion {
        if (a.getByteNumbger() == 0){
            throw new CFPDivZeroExceptiion();
        }
        this.byteNumbger = (byte) (this.byteNumbger / a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte opp() {
        this.byteNumbger = (byte) -this.byteNumbger;
        return this;
    }

    @Override
    public int compareTo(CFPByte a) {
        return this.byteNumbger.compareTo(a.getByteNumbger());
    }

    @Override
    public CFPByte addABit(int a, int radix) {
        this.byteNumbger = (byte)(byteNumbger*10 + a);
        return this;
    }

    @Override
    public CFPByte deleteABit(int radix) {
        this.byteNumbger =  (byte)(byteNumbger / radix);
        return this;
    }

    @Override
    public CFPByte mod(CFPByte a) throws CFPDivZeroExceptiion {
        if (a.getByteNumbger() == 0){
            throw new CFPDivZeroExceptiion();
        }
        this.byteNumbger = (byte) (this.byteNumbger % a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte or(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger | a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte xor(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger ^ a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte and(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger & a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte not() {
        this.byteNumbger = (byte) ~this.byteNumbger;
        return this;
    }

    @Override
    public CFPByte lsr(CFPByte a) {
        this.byteNumbger =
                (byte)(this.byteNumbger >>> a.getByteNumbger() | this.byteNumbger << (8 - a.getByteNumbger()));
        return this;
    }

    @Override
    public CFPByte lsl(CFPByte a) {
        this.byteNumbger =
                (byte)(this.byteNumbger << a.getByteNumbger() | this.byteNumbger >>> (8 - a.getByteNumbger()));
        return this;
    }

    @Override
    public CFPByte sl(CFPByte a) {
        this.byteNumbger = (byte)(this.byteNumbger << a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte sr(CFPByte a) {
        this.byteNumbger = (byte)(this.byteNumbger >> a.getByteNumbger());
        return this;
    }

}
