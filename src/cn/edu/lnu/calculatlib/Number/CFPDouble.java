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
        return null;
    }

    @Override
    public CFPDouble add(CFPDouble a) {
        return null;
    }

    @Override
    public CFPDouble sub(CFPDouble a) {
        return null;
    }

    @Override
    public CFPDouble mul(CFPDouble a) {
        return null;
    }

    @Override
    public CFPDouble div(CFPDouble a) {
        return null;
    }

    @Override
    public CFPDouble opp() {
        return null;
    }
}
