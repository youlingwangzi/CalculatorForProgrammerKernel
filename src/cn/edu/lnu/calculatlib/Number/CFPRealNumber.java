package cn.edu.lnu.calculatlib.Number;

import cn.edu.lnu.calculatlib.CFPDivZeroExceptiion;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 实数类型封装类，提供了实数类型基础的进制转换、运算等操作。</br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPRealNumber implements CFPBaseOperation<CFPRealNumber>, CFPRadixConversion, Cloneable{

    /**
     * 数据是以标准库BigDecimal类型存储，在此基础上提供额外的操作。
     */
    private BigDecimal bigDecimalNumber;

    /**
     * 二进制形式小数求解精度。
     */
    private long binatyScale = 20;

    /**
     * 八进制形式小数求解精度。
     */
    private long octScale = 20;

    /**
     * 十六进制形式小数求解精度。
     */
    private long hexScale = 20;

    /**
     * 精度设置
     */
    private int inputScale = 0;

    /**
     * 构造函数。
     * @param s 要转换的字符串
     */
    public CFPRealNumber(String s){
        bigDecimalNumber = new BigDecimal(s);
    }

    /**
     * 克隆函数。
     * @return 克隆后的对象
     * @throws CloneNotSupportedException 当不支持克隆操作的时候抛出此异常
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        CFPRealNumber a;
        a = (CFPRealNumber)super.clone();
        a.bigDecimalNumber = new BigDecimal(bigDecimalNumber.toString());
        return a;
    }

    /**
     * 获取数值精度。
     *
     * @return 精度值
     */
    public int getInputScale() {
        return this.inputScale;
    }

    /**
     * 设置数值精度。
     * @param scale 要设置的数值精度
     */
    public void setInputScale(int scale) {
        this.inputScale = scale;
        if (scale == 0)
            this.bigDecimalNumber = this.bigDecimalNumber.setScale(0, BigDecimal.ROUND_DOWN);
        else
            this.bigDecimalNumber = this.bigDecimalNumber.setScale(scale - 1, BigDecimal.ROUND_DOWN);
    }

    /**
     * 数值精度加。
     * @param scale 要增加的数值精度
     */
    public void addScale(int scale) {
        bigDecimalNumber.setScale(bigDecimalNumber.scale() + scale);
    }

    /**
     * 设置二进制小数精度。
     * @param binatyScale 要设置的精度scale
     */
    public void setBinatyScale(long binatyScale) {
        this.binatyScale = binatyScale;
    }

    /**
     * 设置十六进制小数精度。
     * @param hexScale 要设置的精度
     */
    public void setHexScale(long hexScale) {
        this.hexScale = hexScale;
    }

    /**
     * 设置八进制小数精度。
     * @param octScale 要设置的精度
     */
    public void setOctScale(long octScale) {
        this.octScale = octScale;
    }

    @Override
    public String toHexString() {
        BigInteger integerPart = bigDecimalNumber.toBigInteger();
        BigDecimal decimalPart = bigDecimalNumber.subtract(new BigDecimal(integerPart));

        StringBuilder s1 = new StringBuilder(this.integerPartToBinaryString());
        StringBuilder s2 = new StringBuilder("");
        int n = s1.length() - 4;
        while (n>0){
            s2.insert(0,toHexNumber(Byte.parseByte(s1.substring(n,n + 4),2)));
            n -= 4;
        }
        s2.insert(0,toHexNumber(Byte.parseByte(s1.substring(0,n + 4),2)));


        int j = 0;

        if(decimalPart.equals(BigDecimal.ZERO)){
            if(bigDecimalNumber.compareTo(BigDecimal.ZERO) == -1)
                s2.insert(0, "-");
            if(getInputScale() == 1){
                s2.append('.');
            }
            return s2.toString();
        }

        decimalPart = decimalPart.abs(); //取绝对值

        s2.append('.');
        do{
            int i;
            i = decimalPart.multiply(new BigDecimal("16")).intValue();
            decimalPart = decimalPart.multiply(new BigDecimal("16")).subtract(new BigDecimal(Integer.toString(i)));
            s2.append(toHexNumber((byte) i));
        }while (++j < hexScale);

        for(j = s2.length()-1; j>=0; j--) {
            if (s2.charAt(j) == '0')
                s2.deleteCharAt(j);
            else {
                if (s2.charAt(j) == '.')
                    s2.deleteCharAt(j);
                break;
            }
        }

        if(bigDecimalNumber.compareTo(BigDecimal.ZERO) == -1)
            s2.insert(0, "-");

        if(getInputScale() == 1){
            s2.append('.');
        }
        return s2.toString();
    }

    /**
     * 将数字转换成十六进制字符。供 toHexString()函数调用。
     * @param a 要转换的数
     * @return 返回转换后的字符
     */
    private char toHexNumber(byte a){
        switch (a){
            case 0: return '0';
            case 1: return '1';
            case 2: return '2';
            case 3: return '3';
            case 4: return '4';
            case 5: return '5';
            case 6: return '6';
            case 7: return '7';
            case 8: return '8';
            case 9: return '9';
            case 10: return 'A';
            case 11: return 'B';
            case 12: return 'C';
            case 13: return 'D';
            case 14: return 'E';
            case 15: return 'F';
        }
        return 0;
    }

    @Override
    public String toDecString() {
        if (getInputScale() == 1)
            return bigDecimalNumber.toString() + ".";
        else
            return bigDecimalNumber.toString();
    }

    @Override
    public String toOctString() {
        BigInteger integerPart = bigDecimalNumber.toBigInteger();
        BigDecimal decimalPart = bigDecimalNumber.subtract(new BigDecimal(integerPart));

        StringBuilder s1 = new StringBuilder(this.integerPartToBinaryString());
        StringBuilder s2 = new StringBuilder("");
        int n = s1.length() - 3;
        while (n>0){
            s2.insert(0,Byte.parseByte(s1.substring(n,n + 3),2));
            n -= 3;
        }
        s2.insert(0,Byte.parseByte(s1.substring(0,n + 3),2));


        int j = 0;

        if(decimalPart.equals(BigDecimal.ZERO)){
            if(bigDecimalNumber.compareTo(BigDecimal.ZERO) == -1)
                s2.insert(0, "-");
            if(getInputScale() == 1){
                s2.append('.');
            }
            return s2.toString();
        }

        decimalPart = decimalPart.abs(); //取绝对值

        s2.append('.');
        do{
            int i;
            i = decimalPart.multiply(new BigDecimal("8")).intValue();
            decimalPart = decimalPart.multiply(new BigDecimal("8")).subtract(new BigDecimal(Integer.toString(i)));
            s2.append(i);
        }while (++j < octScale);

        for(j = s2.length()-1; j>=0; j--) {
            if (s2.charAt(j) == '0')
                s2.deleteCharAt(j);
            else {
                if (s2.charAt(j) == '.')
                    s2.deleteCharAt(j);
                break;
            }
        }

        if(bigDecimalNumber.compareTo(BigDecimal.ZERO) == -1)
            s2.insert(0, "-");

        if(getInputScale() == 1){
            s2.append('.');
        }
        return s2.toString();
    }

    @Override
    public String toBinString() {
        StringBuilder s = new StringBuilder("");
        s.append(this.integerPartToBinaryString());
        s.append(this.decimalPartToBinaryString());

        if(bigDecimalNumber.compareTo(BigDecimal.ZERO) == -1)
            s.insert(0, "-");
        if(getInputScale() == 1){
            s.append('.');
        }
        return s.toString();
    }

    @Override
    public String toFullBinatyString() {
        return this.toBinString();
    }

    @Override
    public String toString() {
        return this.toDecString();
    }

    /**
     * 将实数小数部分转换成二进制。如果没有小数部分，则返回空字符串。
     * @return 转换后的字符串
     */
    private String decimalPartToBinaryString(){
        BigInteger integerPart = bigDecimalNumber.toBigInteger();
        BigDecimal decimalPart = bigDecimalNumber.subtract(new BigDecimal(integerPart));
        StringBuilder s = new StringBuilder("");
        int j = 0;

        if(decimalPart.equals(BigDecimal.ZERO))
            return s.toString();

        decimalPart = decimalPart.abs(); //取绝对值
        s.append('.');
        do{
            int i;
            i = decimalPart.multiply(new BigDecimal("2")).intValue();
            decimalPart = decimalPart.multiply(new BigDecimal("2")).subtract(new BigDecimal(Integer.toString(i)));
            s.append(i);
        }while (++j < binatyScale);

        for(j = s.length()-1; j>=0; j--){
            if(s.charAt(j) == '0')
                s.deleteCharAt(j);
            else{
                if(s.charAt(j) == '.')
                    s.deleteCharAt(j);
                break;
            }
        }

        return s.toString();
    }

    /**
     * 判断当前数值是否为整数
     * @return 是则true，不是则false
     */
    public boolean isIntegerValue(){
        return this.getBigDecimalNumber().compareTo(new BigDecimal(this.getBigDecimalNumber().toBigInteger())) == 0;
    }

    /**
     * 将实数整数部分转换成二进制。
     * @return 转换后的字符串
     */
    private String integerPartToBinaryString(){
        BigInteger integerPart = bigDecimalNumber.toBigInteger();
        StringBuilder s = new StringBuilder("");
        do{
            int i;
            i = integerPart.mod(new BigInteger("2")).intValue();
            integerPart = integerPart.divide(new BigInteger("2"));
            s.insert(0,i);
        }while (!integerPart.equals(BigInteger.ZERO));
        return s.toString();
    }

    /**
     * 返回一个BigDeclmal类型的对象。
     * @return BigDeclmal类型的对象
     */
    public BigDecimal getBigDecimalNumber() {
        return bigDecimalNumber;
    }
    /**
     * 设置BigDecimal类型对象的值。
     * @param bigDecimalNumber 要设置的数据的字符串形式
     */
    public void setBigDecimalNumber(String bigDecimalNumber) {
        this.bigDecimalNumber = new BigDecimal(bigDecimalNumber);
        this.setInputScale(this.bigDecimalNumber.scale());
    }

    @Override
    public CFPRealNumber add(CFPRealNumber a) {
        this.bigDecimalNumber = this.bigDecimalNumber.add(a.getBigDecimalNumber());
        return this;
    }

    @Override
    public CFPRealNumber sub(CFPRealNumber a) {
        this.bigDecimalNumber = this.bigDecimalNumber.subtract(a.getBigDecimalNumber());
        return this;
    }

    @Override
    public CFPRealNumber mul(CFPRealNumber a) {
        this.bigDecimalNumber = this.bigDecimalNumber.multiply(a.getBigDecimalNumber());
        return this;
    }

    @Override
    public CFPRealNumber div(CFPRealNumber a) throws CFPDivZeroExceptiion {
        if(a.getBigDecimalNumber().compareTo(BigDecimal.ZERO) == 0){
            throw new CFPDivZeroExceptiion();
        }
        this.bigDecimalNumber = this.bigDecimalNumber.divide(a.getBigDecimalNumber());
        return this;
    }

    @Override
    public CFPRealNumber opp() {
        this.bigDecimalNumber = this.bigDecimalNumber.multiply(new BigDecimal("-1"));
        return this;
    }

    @Override
    public int compareTo(CFPRealNumber a) {
        return this.bigDecimalNumber.compareTo(a.getBigDecimalNumber());
    }

    @Override
    public CFPRealNumber addABit(int a, int radix) {
        if (this.getInputScale() == 0){
            this.mul(new CFPRealNumber(Integer.toString(radix))).add(new CFPRealNumber(Integer.toString(a)));
        }else {
            BigDecimal b = BigDecimal.valueOf(radix).pow(this.getInputScale());
            BigDecimal c = BigDecimal.valueOf(a).divide(b);
            this.add(new CFPRealNumber(c.toString()));
            this.setInputScale(this.getInputScale() + 1);
        }
        return this;
    }

    @Override
    public CFPRealNumber deleteABit(int radix) {
        if (this.getInputScale() == 0){
            try {
                this.div(new CFPRealNumber(Integer.toString(radix)));
                this.setInputScale(0);
            } catch (CFPDivZeroExceptiion cfpDivZeroExceptiion) {
                cfpDivZeroExceptiion.printStackTrace();
            }
        }else {
            this.setInputScale(this.getInputScale() - 1);
        }
        return this;
    }

    /**
     * 将数据转换成CFPLong类型。
     * @return 返回CFPLong类型对象
     */
    public CFPLong toCFPLong(){
        return new CFPLong(bigDecimalNumber.longValue());
    }

    /**
     * 将数据转换成CFPInteger类型。
     * @return 返回CFPInteger类型对象
     */
    public CFPInteger toCFPIteger(){
        return new CFPInteger(bigDecimalNumber.intValue());
    }

    /**
     * 将数据转换成CFPShort类型。
     * @return 返回CFPShort类型对象
     */
    public CFPShort toCFPShort(){
        return new CFPShort(bigDecimalNumber.shortValue());
    }

    /**
     * 将数据转换成CFPByte类型。
     * @return 返回CFPByte类型对象
     */
    public CFPByte toCFPByte(){
        return new CFPByte(bigDecimalNumber.byteValue());
    }

    /**
     * 将数据转换成CFPDouble类型。
     * @return 返回CFPDouble类型对象
     */
    public CFPDouble toCFPDouble(){
        CFPDouble cfpDouble =  new CFPDouble(bigDecimalNumber.doubleValue());
        cfpDouble.setInputScale(getInputScale());
        return cfpDouble;
    }

    /**
     * 将数据转换成CFPFloat类型。
     * @return 返回CFPFloat类型对象
     */
    public CFPFloat toCFPFloat(){
        CFPFloat cfpFloat = new CFPFloat(bigDecimalNumber.floatValue());
        cfpFloat.setInputScale(getInputScale());
        return cfpFloat;
    }

}
