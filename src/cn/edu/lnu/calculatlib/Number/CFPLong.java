package cn.edu.lnu.calculatlib.Number;

/**
 * Created by youlingwangzi on 2016/10/2.
 * @author youlingwangzi
 */
public class CFPLong implements CFPBaseOperation<CFPLong>,CFPLogicOperation<CFPLong>{
    private Long longNumber;

    public CFPLong(long a) {
        longNumber = a;
    }

    public String toHexString(){
        return Long.toHexString(longNumber);
    }

    public String toDecString(){
        return longNumber.toString();
    }

    public String toOctString(){
        return Long.toOctalString(longNumber);
    }

    public String toBinString(){
        return Long.toBinaryString(longNumber);
    }

    public Long getLongNumber() {
        return longNumber;
    }

    public void setLongNumber(Long longNumber) {
        this.longNumber = longNumber;
    }

    public String toFullBinatyString(){
        StringBuilder stringBuilder = new StringBuilder(Long.toBinaryString(longNumber));
        int n = 64 - stringBuilder.length();
        while (n-- != 0){
            stringBuilder.insert(0,"0");
        }
        return stringBuilder.toString();
    }

    public CFPLong parseUnsignedInt(String s, int radix){
        this.longNumber = Long.parseUnsignedLong(s, radix);
        return this;
    }

    public CFPRealNumber toCFPRealNumber(){
        return new CFPRealNumber();
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
    public CFPLong div(CFPLong a) {
        this.longNumber /=a.getLongNumber();
        return this;
    }

    @Override
    public CFPLong opp() {
        this.longNumber = -this.longNumber;
        return this;
    }

    @Override
    public CFPLong mod(CFPLong a) {
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
    public CFPLong lsl(CFPLong a) {
        this.longNumber =
                this.longNumber >>> a.getLongNumber() | this.longNumber << (64 - a.getLongNumber());
        return this;
    }

    @Override
    public CFPLong lsr(CFPLong a) {
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