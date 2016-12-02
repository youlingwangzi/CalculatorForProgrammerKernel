package cn.edu.lnu.calculatlib.Number;

/**
 * @author yuanxiaokun
 * Created by yuanx on 2016/10/12.
 */
public class CFPInteger implements CFPBaseOperation <CFPInteger>,CFPLogicOperation<CFPInteger> {
    private Integer integerNumber;

    public CFPInteger(int a){
        integerNumber = a;
    }

    public String toHexString(){
        return Integer.toHexString(integerNumber);
    }

    public String toDecString(){
        return integerNumber.toString();
    }

    public String toOctString(){
        return Integer.toOctalString(integerNumber);
    }

    public String toBinString(){
        return Integer.toBinaryString(integerNumber);
    }

    public String toFullBinatyString(){
        StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(integerNumber));
        int n = 32 - stringBuilder.length();
        while (n-- != 0){
            stringBuilder.insert(0,"0");
        }
        return stringBuilder.toString();
    }

    public CFPInteger parseUnsignedInt(String s, int radix){
        this.integerNumber = Integer.parseUnsignedInt(s, radix);
        return this;
    }

    public CFPRealNumber toCFPRealNumber(){
        return new CFPRealNumber();
    }

    public Integer getIntegerNumber() {
        return integerNumber;
    }

    public void setIntegerNumber(Integer integerNumber) {
        this.integerNumber = integerNumber;
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
    public CFPInteger div(CFPInteger a) {
        this.integerNumber /= a.getIntegerNumber();
        return null;
    }

    @Override
    public CFPInteger opp() {
        this.integerNumber = -this.integerNumber;
        return this;
    }

    @Override
    public CFPInteger mod(CFPInteger a) {
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
