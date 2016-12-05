package cn.edu.lnu.calculatlib.Number;

/**
 * Long类型封装类，提供了long类型基础的进制转换、运算等操作。</br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPLong implements CFPBaseOperation<CFPLong>, CFPLogicOperation<CFPLong>, CFPRadixConversion{

    /**
     * 数据是以标准库Long类型存储，在此基础上提供额外的操作。
     */
    private Long longNumber;

    /**
     * 构造函数。
     * @param a long型整数。
     */
    public CFPLong(long a) {
        longNumber = a;
    }

    @Override
    public String toHexString(){
        return Long.toHexString(longNumber);
    }

    @Override
    public String toDecString(){
        return longNumber.toString();
    }

    @Override
    public String toOctString(){
        return Long.toOctalString(longNumber);
    }

    @Override
    public String toBinString(){
        return Long.toBinaryString(longNumber);
    }

    @Override
    public String toFullBinatyString(){
        StringBuilder stringBuilder = new StringBuilder(Long.toBinaryString(longNumber));
        int n = 64 - stringBuilder.length();
        while (n-- != 0){
            stringBuilder.insert(0,"0");
        }
        return stringBuilder.toString();
    }

    /**
     * 返回一个Long类型的对象。
     * @return Long类型的对象
     */
    public Long getLongNumber() {
        return longNumber;
    }

    /**
     * 设置Long类型对象的值。
     * @param longNumber Long类型的对象，置此数的值为次数据
     */
    public void setLongNumber(Long longNumber) {
        this.longNumber = longNumber;
    }

    /**
     * 将无符号字符串转换成CFPLong。
     * @param s 要转换的字符串
     * @param radix 字符串采用的进制
     * @return 返回转换后的CFPLong类型对象
     */
    public CFPLong parseUnsignedLong(String s, int radix){
        this.longNumber = Long.parseUnsignedLong(s, radix);
        return this;
    }

    /**
     * 将CFPLong类型转换成CFPRealNumber类型。
     * @return 返回一个CFPRealNumber类型对象
     */
    public CFPRealNumber toCFPRealNumber(){
        return new CFPRealNumber(longNumber.toString());
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
