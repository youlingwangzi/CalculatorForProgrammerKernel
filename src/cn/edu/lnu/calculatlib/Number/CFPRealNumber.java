package cn.edu.lnu.calculatlib.Number;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPRealNumber implements CFPBaseOperation<CFPRealNumber>, CFPRadixConversion{
    private BigDecimal bigDecimalNumber;
    private long binatyScale = 20;
    private long octScale = 20;
    private long hexScale = 20;

    public CFPRealNumber(){
        bigDecimalNumber = new BigDecimal("1");
    }

    public void setBinatyScale(long binatyScale) {
        this.binatyScale = binatyScale;
    }

    public void setHexScale(long hexScale) {
        this.hexScale = hexScale;
    }

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

        if(decimalPart.equals(BigDecimal.ZERO))
            return s2.toString();

        s2.append('.');
        do{
            int i = 0;
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

        return s2.toString();
    }

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

        if(decimalPart.equals(BigDecimal.ZERO))
            return s2.toString();

        s2.append('.');
        do{
            int i = 0;
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

        return s2.toString();
    }

    @Override
    public String toBinString() {
        StringBuilder s = new StringBuilder("");
        s.append(this.integerPartToBinaryString());
        s.append(this.decimalPartToBinaryString());
        return s.toString();
    }

    private String decimalPartToBinaryString(){
        BigInteger integerPart = bigDecimalNumber.toBigInteger();
        BigDecimal decimalPart = bigDecimalNumber.subtract(new BigDecimal(integerPart));
        StringBuilder s = new StringBuilder("");
        int j = 0;

        if(decimalPart.equals(BigDecimal.ZERO))
            return s.toString();

        s.append('.');
        do{
            int i = 0;
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

    private String integerPartToBinaryString(){
        BigInteger integerPart = bigDecimalNumber.toBigInteger();
        StringBuilder s = new StringBuilder("");
        do{
            int i = 0;
            i = integerPart.mod(new BigInteger("2")).intValue();
            integerPart = integerPart.divide(new BigInteger("2"));
            s.insert(0,i);
        }while (!integerPart.equals(BigInteger.ZERO));
        return s.toString();
    }

    @Override
    public String toFullBinatyString() {
        return null;
    }

    public BigDecimal getBigDecimalNumber() {
        return bigDecimalNumber;
    }

    public void setBigDecimalNumber(BigDecimal bigDecimalNumber) {
        this.bigDecimalNumber = bigDecimalNumber;
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
    public CFPRealNumber div(CFPRealNumber a) {
        this.bigDecimalNumber = this.bigDecimalNumber.divide(a.getBigDecimalNumber());
        return this;
    }

    @Override
    public CFPRealNumber opp() {
        this.bigDecimalNumber = this.bigDecimalNumber.multiply(new BigDecimal("-1"));
        return this;
    }

    public CFPLong toCFPLong(){
        CFPLong cfpLong = new CFPLong(bigDecimalNumber.longValue());
        return cfpLong;
    }

    public CFPInteger toCFPIteger(){
        CFPInteger cfpInteger = new CFPInteger(bigDecimalNumber.intValue());
        return cfpInteger;
    }

    public CFPShort toCFPShort(){
        CFPShort cfpShort = new CFPShort(bigDecimalNumber.shortValue());
        return cfpShort;
    }

    public CFPByte toCFPByte(){
        CFPByte cfpByte = new CFPByte(bigDecimalNumber.byteValue());
        return cfpByte;
    }

    public CFPDouble toCFPDouble(){
        CFPDouble cfpDouble = new CFPDouble(bigDecimalNumber.doubleValue());
        return cfpDouble;
    }

    public CFPFloat toCFPFloat(){
        CFPFloat cfpFloat = new CFPFloat(bigDecimalNumber.floatValue());
        return cfpFloat;
    }

}
