package cn.edu.lnu.calculatlib.Number;

/**
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPFloat implements CFPRadixConversion, CFPBaseOperation<CFPFloat> {

    private Float floatNumber;

    public CFPFloat(float a){
        floatNumber = a;
    }

    @Override
    public String toHexString() {
        return Float.toHexString(floatNumber).toUpperCase();
    }

    @Override
    public String toDecString() {
        return floatNumber.toString();
    }

    @Override
    public String toOctString() {
        return Integer.toOctalString(Float.floatToIntBits(floatNumber));
    }

    @Override
    public String toBinString() {
        return Integer.toBinaryString(Float.floatToIntBits(floatNumber));
    }

    @Override
    public String toFullBinatyString() {
        StringBuilder stringBuilder = new StringBuilder(this.toBinString());
        int n = 32 - stringBuilder.length();
        while (n-- != 0){
            stringBuilder.insert(0,"0");
        }
        return stringBuilder.toString();
    }

    public Float getFloatNumber() {
        return floatNumber;
    }

    public void setFloatNumber(Float floatNumber) {
        this.floatNumber = floatNumber;
    }

    public CFPRealNumber toCFPRealNumber(){
        return new CFPRealNumber(floatNumber.toString());
    }

    @Override
    public CFPFloat add(CFPFloat a) {
        this.floatNumber += a.getFloatNumber();
        return this;
    }

    @Override
    public CFPFloat sub(CFPFloat a) {
        this.floatNumber -= a.getFloatNumber();
        return this;
    }

    @Override
    public CFPFloat mul(CFPFloat a) {
        this.floatNumber *= a.getFloatNumber();
        return this;
    }

    @Override
    public CFPFloat div(CFPFloat a) {
        this.floatNumber /= a.getFloatNumber();
        return this;
    }

    @Override
    public CFPFloat opp() {
        this.floatNumber = -this.floatNumber;
        return this;
    }
}
