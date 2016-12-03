package cn.edu.lnu.calculatlib;

import cn.edu.lnu.calculatlib.Number.*;

/**
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPNumber implements CFPBaseOperation<CFPNumber>, CFPLogicOperation<CFPNumber>, CFPRadixConversion{
    private CFPLong longNumber = new CFPLong(0);
    private CFPInteger integerNumBer = new CFPInteger(0);
    private CFPShort shortNumber = new CFPShort((short) 0);
    private CFPByte byteNumber = new CFPByte((byte)0);
    private CFPRealNumber realNumber = new CFPRealNumber("0");
    private CFPDouble doubleNumber = new CFPDouble(0);
    private CFPFloat floatNumber = new CFPFloat(0);



    @Override
    public CFPNumber mod(CFPNumber a) {
        return null;
    }

    @Override
    public CFPNumber or(CFPNumber a) {
        return null;
    }

    @Override
    public CFPNumber xor(CFPNumber a) {
        return null;
    }

    @Override
    public CFPNumber and(CFPNumber a) {
        return null;
    }

    @Override
    public CFPNumber not() {
        return null;
    }

    @Override
    public CFPNumber lsl(CFPNumber a) {
        return null;
    }

    @Override
    public CFPNumber lsr(CFPNumber a) {
        return null;
    }

    @Override
    public CFPNumber sl(CFPNumber a) {
        return null;
    }

    @Override
    public CFPNumber sr(CFPNumber a) {
        return null;
    }

    @Override
    public CFPNumber add(CFPNumber a) {
        return null;
    }

    @Override
    public CFPNumber sub(CFPNumber a) {
        return null;
    }

    @Override
    public CFPNumber mul(CFPNumber a) {
        return null;
    }

    @Override
    public CFPNumber div(CFPNumber a) {
        return null;
    }

    @Override
    public CFPNumber opp() {
        return null;
    }

    @Override
    public String toHexString() {
        return null;
    }

    @Override
    public String toDecString() {
        return null;
    }

    @Override
    public String toOctString() {
        return null;
    }

    @Override
    public String toBinString() {
        return null;
    }

    @Override
    public String toFullBinatyString() {
        return null;
    }
}
