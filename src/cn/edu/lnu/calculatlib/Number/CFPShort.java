package cn.edu.lnu.calculatlib.Number;

/**
 * Created by youlignwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPShort implements CFPBaseOperation<CFPShort> , CFPLogicOperation<CFPShort>, CFPRadixConversion{
    private Short shortNumber;

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

    public Short getShortNumber() {
        return shortNumber;
    }

    public void setShortNumber(Short shortNumber) {
        this.shortNumber = shortNumber;
    }

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
