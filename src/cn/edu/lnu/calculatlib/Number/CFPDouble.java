package cn.edu.lnu.calculatlib.Number;

/**
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPDouble implements CFPBaseOperation<CFPDouble>,CFPRadixConversion {
    private Double doubleNumber;

    public CFPDouble(double a){
        doubleNumber = a;
    }

    @Override
    public String toHexString() {
        return Double.toHexString(doubleNumber).toUpperCase();
    }

    @Override
    public String toDecString() {
        return doubleNumber.toString();
    }

    @Override
    public String toOctString() {
        return Long.toOctalString(Double.doubleToLongBits(doubleNumber));
    }

    @Override
    public String toBinString() {
        return Long.toBinaryString(Double.doubleToLongBits(doubleNumber));
    }

    @Override
    public String toFullBinatyString() {
        StringBuilder stringBuilder = new StringBuilder(this.toBinString());
        int n = 64 - stringBuilder.length();
        while (n-- != 0){
            stringBuilder.insert(0,"0");
        }
        return stringBuilder.toString();
    }

    public Double getDoubleNumber() {
        return doubleNumber;
    }

    public void setDoubleNumber(Double doubleNumber) {
        this.doubleNumber = doubleNumber;
    }

    public CFPRealNumber toCFPRealNumber(){
        return new CFPRealNumber(doubleNumber.toString());
    }

    @Override
    public CFPDouble add(CFPDouble a) {
        this.doubleNumber += a.getDoubleNumber();
        return this;
    }

    @Override
    public CFPDouble sub(CFPDouble a) {
        this.doubleNumber -= a.getDoubleNumber();
        return this;
    }

    @Override
    public CFPDouble mul(CFPDouble a) {
        this.doubleNumber *= a.getDoubleNumber();
        return this;
    }

    @Override
    public CFPDouble div(CFPDouble a) {
        this.doubleNumber /= a.getDoubleNumber();
        return this;
    }

    @Override
    public CFPDouble opp() {
        this.doubleNumber = -this.doubleNumber;
        return this;
    }
}
