package cn.edu.lnu.calculatlib.Number;

import cn.edu.lnu.calculatlib.CFPDivZeroExceptiion;

/**
 * Double类型封装类，提供了Double类型基础的进制转换、运算等操作。</br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPDouble implements CFPBaseOperation<CFPDouble>,CFPRadixConversion,Cloneable {

    /**
     * 数据是以标准库Double类型存储，在此基础上提供额外的操作。
     */
    private Double doubleNumber;

    /**
     * 构造函数。
     * @param a double型整数。
     */
    public CFPDouble(double a){
        doubleNumber = a;
    }

    /**
     * 克隆函数。
     * @return 克隆后的对象
     * @throws CloneNotSupportedException 当不支持克隆操作的时候抛出此异常
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        CFPDouble a;
        a = (CFPDouble) super.clone();
        a.doubleNumber = doubleNumber;
        return a;
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

    @Override
    public String toString() {
        return this.toDecString();
    }

    /**
     * 返回一个Double类型的对象。
     * @return Double类型的对象
     */
    public Double getDoubleNumber() {
        return doubleNumber;
    }

    /**
     * 设置Double类型对象的值。
     * @param doubleNumber Double类型的对象，置此数的值为次数据
     */
    public void setDoubleNumber(Double doubleNumber) {
        this.doubleNumber = doubleNumber;
    }

    /**
     * 将CFPDouble类型转换成CFPRealNumber类型。
     * @return 返回一个CFPRealNumber类型对象
     */
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
    public CFPDouble div(CFPDouble a) throws CFPDivZeroExceptiion {
        if(a.getDoubleNumber().compareTo((double)0) == 0){
            throw new CFPDivZeroExceptiion();
        }
        this.doubleNumber /= a.getDoubleNumber();
        return this;
    }

    @Override
    public CFPDouble opp() {
        this.doubleNumber = -this.doubleNumber;
        return this;
    }

    @Override
    public int compareTo(CFPDouble a) {
        return this.doubleNumber.compareTo(a.getDoubleNumber());
    }
}
