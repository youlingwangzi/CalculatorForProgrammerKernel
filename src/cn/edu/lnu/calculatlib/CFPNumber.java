package cn.edu.lnu.calculatlib;

import cn.edu.lnu.calculatlib.Number.*;

/**
 * 主数据类，可自由切换数据的数据类型，并提供不同的操作。</br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPNumber implements CFPBaseOperation<CFPNumber>, CFPLogicOperation<CFPNumber>, CFPRadixConversion, Cloneable{

    /**
     * Long类型内部存储结构。
     */
    private CFPLong longNumber = new CFPLong(0);
    /**
     * Integer类型内部存储结构。
     */
    private CFPInteger integerNumBer = new CFPInteger(0);
    /**
     * Short类型内部存储结构。
     */
    private CFPShort shortNumber = new CFPShort((short) 0);
    /**
     * Byte类型内部存储结构。
     */
    private CFPByte byteNumber = new CFPByte((byte)0);
    /**
     * RealNumber类型内部存储结构。
     */
    private CFPRealNumber realNumber = new CFPRealNumber("0");
    /**
     * Double类型内部存储结构。
     */
    private CFPDouble doubleNumber = new CFPDouble(0);
    /**
     * Float类型内部存储结构。
     */
    private CFPFloat floatNumber = new CFPFloat(0);

    /**
     * 存储当前的数据类型。默认为Long类型。
     */
    private CFPDataType dataType = CFPDataType.REAL_NUMBER;

    /**
     * 构造函数，构造Integer型数据。
     * @param a 要设置的值
     */
    public CFPNumber(int a){
        integerNumBer.setIntegerNumber(a);
        dataType = CFPDataType.INTEGER;
    }

    /**
     * 构造函数，构造Integer型数据。
     * @param a 要设置的值
     */
    public CFPNumber(float a){
        floatNumber.setFloatNumber(a);
        dataType = CFPDataType.FLOAT;
    }

    /**
     * 构造函数，构造RealNumber型数据。
     * @param s 要设置的值
     */
    public CFPNumber(String s){
        realNumber.setBigDecimalNumber(s);
    }

    /**
     * 构造函数，按照传入的参数构造数据类型。
     * @param s 要设置的值
     * @param dataType 要设置的数据类型
     */
    public CFPNumber(String s, CFPDataType dataType){
        realNumber.setBigDecimalNumber(s);
        this.setDataType(dataType);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        CFPNumber a;
        a = (CFPNumber) super.clone();
        a.dataType = dataType;
        switch (dataType){
            case LONG: a.longNumber =(CFPLong) longNumber.clone();
                break;
            case INTEGER: a.integerNumBer =(CFPInteger) integerNumBer.clone();
                break;
            case SHORT: a.shortNumber =(CFPShort) shortNumber.clone();
                break;
            case BYTE: a.byteNumber =(CFPByte) byteNumber.clone();
                break;
            case REAL_NUMBER: a.realNumber =(CFPRealNumber) realNumber.clone();
                break;
            case DOUBLE: a.doubleNumber =(CFPDouble) doubleNumber.clone();
                break;
            case FLOAT: a.floatNumber =(CFPFloat) floatNumber.clone();
                break;
        }

        return a;
    }


    /**
     * 根据当前数据类型设置当前数据。会自动根据数据类型进行数据转换。
     * @param s 要设置的数值的十进制字符串
     * @return 返回设置后的 CFPNumber 对象
     */
    public CFPNumber setNumber(String s){
        CFPDataType dataType1 = this.dataType;
        this.turnToRealNumber();
        realNumber.setBigDecimalNumber(s);
        return this.setDataType(dataType1);
    }

    /**
     * 返回当前对象的数据类型。
     * @return 当前对象的数据类型
     */
    public CFPDataType getDataType() {
        return dataType;
    }

    /**
     * 返回 CFPInteger 类型的对象。
     * @return CFPInteger 类型对象
     */
    private CFPInteger getIntegerNumBer() {
        return integerNumBer;
    }

    /**
     * 返回 CFPLong 类型的对象。
     * @return CFPLong 类型对象
     */
    private CFPLong getLongNumber() {
        return longNumber;
    }

    /**
     * 返回 CFPByte 类型的对象。
     * @return CFPByte 类型对象
     */
    private CFPByte getByteNumber() {
        return byteNumber;
    }

    /**
     * 返回 CFPShort 类型的对象。
     * @return CFPShort 类型对象
     */
    private CFPShort getShortNumber() {
        return shortNumber;
    }

    /**
     * 返回 CFPRealNumber 类型的对象。
     * @return CFPRealNumber 类型对象
     */
    private CFPRealNumber getRealNumber() {
        return realNumber;
    }

    /**
     * 返回 CFPDouble 类型的对象。
     * @return CFPDouble 类型对象
     */
    private CFPDouble getDoubleNumber() {
        return doubleNumber;
    }

    /**
     * 返回 CFPFloat 类型的对象。
     * @return CFPFloat 类型对象
     */
    private CFPFloat getFloatNumber() {
        return floatNumber;
    }

    @Override
    public String toHexString() {
        String s;
        switch (dataType){
            case LONG:        s = longNumber.toHexString(); break;
            case INTEGER:  s = integerNumBer.toHexString(); break;
            case SHORT:      s = shortNumber.toHexString(); break;
            case BYTE:        s = byteNumber.toHexString(); break;
            case REAL_NUMBER: s = realNumber.toHexString(); break;
            case DOUBLE:    s = doubleNumber.toHexString(); break;
            case FLOAT:      s = floatNumber.toHexString(); break;
            default:         s="";
        }
        return s;
    }

    @Override
    public String toDecString() {
        String s;
        switch (dataType){
            case LONG:        s = longNumber.toDecString(); break;
            case INTEGER:  s = integerNumBer.toDecString(); break;
            case SHORT:      s = shortNumber.toDecString(); break;
            case BYTE:        s = byteNumber.toDecString(); break;
            case REAL_NUMBER: s = realNumber.toDecString(); break;
            case DOUBLE:    s = doubleNumber.toDecString(); break;
            case FLOAT:      s = floatNumber.toDecString(); break;
            default:         s="";
        }
        return s;
    }

    @Override
    public String toOctString() {
        String s;
        switch (dataType){
            case LONG:        s = longNumber.toOctString(); break;
            case INTEGER:  s = integerNumBer.toOctString(); break;
            case SHORT:      s = shortNumber.toOctString(); break;
            case BYTE:        s = byteNumber.toOctString(); break;
            case REAL_NUMBER: s = realNumber.toOctString(); break;
            case DOUBLE:    s = doubleNumber.toOctString(); break;
            case FLOAT:      s = floatNumber.toOctString(); break;
            default:         s="";
        }
        return s;
    }

    @Override
    public String toBinString() {
        String s;
        switch (dataType){
            case LONG:        s = longNumber.toBinString(); break;
            case INTEGER:  s = integerNumBer.toBinString(); break;
            case SHORT:      s = shortNumber.toBinString(); break;
            case BYTE:        s = byteNumber.toBinString(); break;
            case REAL_NUMBER: s = realNumber.toBinString(); break;
            case DOUBLE:    s = doubleNumber.toBinString(); break;
            case FLOAT:      s = floatNumber.toBinString(); break;
            default:         s="";
        }
        return s;
    }

    @Override
    public String toFullBinatyString() {
        String s;
        switch (dataType){
            case LONG:        s = longNumber.toFullBinatyString(); break;
            case INTEGER:  s = integerNumBer.toFullBinatyString(); break;
            case SHORT:      s = shortNumber.toFullBinatyString(); break;
            case BYTE:        s = byteNumber.toFullBinatyString(); break;
            case REAL_NUMBER: s = realNumber.toFullBinatyString(); break;
            case DOUBLE:    s = doubleNumber.toFullBinatyString(); break;
            case FLOAT:      s = floatNumber.toFullBinatyString(); break;
            default:         s="";
        }
        return s;
    }

    @Override
    public String toString() {
        return this.toDecString();
    }

    /**
     * 将无符号二进制字符串转换成 CFPNumber ，仅对整形数据有效。
     * @param s 要转换的字符串
     * @return 返回 CFPNumber 对象
     */
    public CFPNumber parseUnsignedBinary(String s){
        switch (dataType){
            case LONG:        longNumber.parseUnsignedLong(s); break;
            case INTEGER:  integerNumBer.parseUnsignedInt(s); break;
            case SHORT:      shortNumber.parseUnsignedShort(s); break;
            case BYTE:        byteNumber.parseUnsignedByte(s); break;
        }
        return this;
    }

    @Override
    public CFPNumber mod(CFPNumber a) throws CFPDivZeroExceptiion , CFPNonsupportedOperation{
        if (!this.dataType.isIntegersType()){
            throw new CFPNonsupportedOperation(this.dataType.toString() + "不能执行 mod 操作。");
        }
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        switch (dataType){
            case LONG:        longNumber.mod(a.getLongNumber()); break;
            case INTEGER:  integerNumBer.mod(a.getIntegerNumBer()); break;
            case SHORT:      shortNumber.mod(a.getShortNumber()); break;
            case BYTE:        byteNumber.mod(a.getByteNumber()); break;
        }
        return this;
    }

    @Override
    public CFPNumber or(CFPNumber a) throws CFPNonsupportedOperation {
        if (!this.dataType.isIntegersType()){
            throw new CFPNonsupportedOperation(this.dataType.toString() + "不能执行 or 操作。");
        }
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        switch (dataType){
            case LONG:        longNumber.or(a.getLongNumber()); break;
            case INTEGER:  integerNumBer.or(a.getIntegerNumBer()); break;
            case SHORT:      shortNumber.or(a.getShortNumber()); break;
            case BYTE:        byteNumber.or(a.getByteNumber()); break;
        }
        return this;
    }

    @Override
    public CFPNumber xor(CFPNumber a) throws CFPNonsupportedOperation {
        if (!this.dataType.isIntegersType()){
            throw new CFPNonsupportedOperation(this.dataType.toString() + "不能执行 xor 操作。");
        }
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        switch (dataType){
            case LONG:        longNumber.xor(a.getLongNumber()); break;
            case INTEGER:  integerNumBer.xor(a.getIntegerNumBer()); break;
            case SHORT:      shortNumber.xor(a.getShortNumber()); break;
            case BYTE:        byteNumber.xor(a.getByteNumber()); break;
        }
        return this;
    }

    @Override
    public CFPNumber and(CFPNumber a) throws CFPNonsupportedOperation {
        if (!this.dataType.isIntegersType()){
            throw new CFPNonsupportedOperation(this.dataType.toString() + "不能执行 and 操作。");
        }
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        switch (dataType){
            case LONG:        longNumber.and(a.getLongNumber()); break;
            case INTEGER:  integerNumBer.and(a.getIntegerNumBer()); break;
            case SHORT:      shortNumber.and(a.getShortNumber()); break;
            case BYTE:        byteNumber.and(a.getByteNumber()); break;
        }
        return this;
    }

    @Override
    public CFPNumber not() throws CFPNonsupportedOperation {
        if (!this.dataType.isIntegersType()){
            throw new CFPNonsupportedOperation(this.dataType.toString() + "不能执行 not 操作。");
        }
        switch (dataType){
            case LONG:        longNumber.not(); break;
            case INTEGER:  integerNumBer.not(); break;
            case SHORT:      shortNumber.not(); break;
            case BYTE:        byteNumber.not(); break;
        }
        return this;
    }

    @Override
    public CFPNumber lsl(CFPNumber a) throws CFPNonsupportedOperation {
        if (!this.dataType.isIntegersType()){
            throw new CFPNonsupportedOperation(this.dataType.toString() + "不能执行 lsl 操作。");
        }
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        switch (dataType){
            case LONG:        longNumber.lsl(a.getLongNumber()); break;
            case INTEGER:  integerNumBer.lsl(a.getIntegerNumBer()); break;
            case SHORT:      shortNumber.lsl(a.getShortNumber()); break;
            case BYTE:        byteNumber.lsl(a.getByteNumber()); break;
        }
        return this;
    }

    @Override
    public CFPNumber lsr(CFPNumber a) throws CFPNonsupportedOperation {
        if (!this.dataType.isIntegersType()){
            throw new CFPNonsupportedOperation(this.dataType.toString() + "不能执行 lsr 操作。");
        }
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        switch (dataType){
            case LONG:        longNumber.lsr(a.getLongNumber()); break;
            case INTEGER:  integerNumBer.lsr(a.getIntegerNumBer()); break;
            case SHORT:      shortNumber.lsr(a.getShortNumber()); break;
            case BYTE:         byteNumber.lsr(a.getByteNumber()); break;
        }
        return this;
    }

    @Override
    public CFPNumber sl(CFPNumber a) throws CFPNonsupportedOperation {
        if (!this.dataType.isIntegersType()){
            throw new CFPNonsupportedOperation(this.dataType.toString() + "不能执行 sl 操作。");
        }
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        switch (dataType){
            case LONG:        longNumber.sl(a.getLongNumber()); break;
            case INTEGER:  integerNumBer.sl(a.getIntegerNumBer()); break;
            case SHORT:      shortNumber.sl(a.getShortNumber()); break;
            case BYTE:        byteNumber.sl(a.getByteNumber()); break;
        }
        return this;
    }

    @Override
    public CFPNumber sr(CFPNumber a) throws CFPNonsupportedOperation {
        if (!this.dataType.isIntegersType()){
            throw new CFPNonsupportedOperation(this.dataType.toString() + "不能执行 sr 操作。");
        }
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        switch (dataType){
            case LONG:        longNumber.sr(a.getLongNumber()); break;
            case INTEGER:  integerNumBer.sr(a.getIntegerNumBer()); break;
            case SHORT:      shortNumber.sr(a.getShortNumber()); break;
            case BYTE:        byteNumber.sr(a.getByteNumber()); break;
        }
        return this;
    }

    @Override
    public CFPNumber add(CFPNumber a) {
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        switch (dataType){
            case LONG:        longNumber.add(a.getLongNumber()); break;
            case INTEGER:  integerNumBer.add(a.getIntegerNumBer()); break;
            case SHORT:      shortNumber.add(a.getShortNumber()); break;
            case BYTE:        byteNumber.add(a.getByteNumber()); break;
            case REAL_NUMBER: realNumber.add(a.getRealNumber()); break;
            case DOUBLE:    doubleNumber.add(a.getDoubleNumber()); break;
            case FLOAT:      floatNumber.add(a.getFloatNumber()); break;
        }
        return this;
    }

    @Override
    public CFPNumber sub(CFPNumber a) {
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        switch (dataType){
            case LONG:        longNumber.sub(a.getLongNumber()); break;
            case INTEGER:  integerNumBer.sub(a.getIntegerNumBer()); break;
            case SHORT:      shortNumber.sub(a.getShortNumber()); break;
            case BYTE:        byteNumber.sub(a.getByteNumber()); break;
            case REAL_NUMBER: realNumber.sub(a.getRealNumber()); break;
            case DOUBLE:    doubleNumber.sub(a.getDoubleNumber()); break;
            case FLOAT:      floatNumber.sub(a.getFloatNumber()); break;
        }
        return this;
    }

    @Override
    public CFPNumber mul(CFPNumber a) {
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        switch (dataType){
            case LONG:        longNumber.mul(a.getLongNumber()); break;
            case INTEGER:  integerNumBer.mul(a.getIntegerNumBer()); break;
            case SHORT:      shortNumber.mul(a.getShortNumber()); break;
            case BYTE:        byteNumber.mul(a.getByteNumber()); break;
            case REAL_NUMBER: realNumber.mul(a.getRealNumber()); break;
            case DOUBLE:    doubleNumber.mul(a.getDoubleNumber()); break;
            case FLOAT:      floatNumber.mul(a.getFloatNumber()); break;
        }
        return this;
    }

    @Override
    public CFPNumber div(CFPNumber a) throws CFPDivZeroExceptiion {
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        try {
            switch (dataType){
                case LONG:        longNumber.div(a.getLongNumber()); break;
                case INTEGER:  integerNumBer.div(a.getIntegerNumBer()); break;
                case SHORT:      shortNumber.div(a.getShortNumber()); break;
                case BYTE:        byteNumber.div(a.getByteNumber()); break;
                case REAL_NUMBER: realNumber.div(a.getRealNumber()); break;
                case DOUBLE:    doubleNumber.div(a.getDoubleNumber()); break;
                case FLOAT:      floatNumber.div(a.getFloatNumber()); break;
            }
        }catch (CFPDivZeroExceptiion e){
            throw e;
        }
        return this;
    }

    @Override
    public CFPNumber opp() {
        switch (dataType){
            case LONG:        longNumber.opp(); break;
            case INTEGER:  integerNumBer.opp(); break;
            case SHORT:      shortNumber.opp(); break;
            case BYTE:        byteNumber.opp(); break;
            case REAL_NUMBER: realNumber.opp(); break;
            case DOUBLE:    doubleNumber.opp(); break;
            case FLOAT:      floatNumber.opp(); break;
        }
        return this;
    }

    @Override
    public int compareTo(CFPNumber a) {
        if (!a.getDataType().equals(this.dataType)){
            a.setDataType(this.dataType);
        }
        int result = 0;
        switch (dataType){
            case LONG:        result = longNumber.compareTo(a.getLongNumber()); break;
            case INTEGER:  result = integerNumBer.compareTo(a.getIntegerNumBer()); break;
            case SHORT:      result = shortNumber.compareTo(a.getShortNumber()); break;
            case BYTE:        result = byteNumber.compareTo(a.getByteNumber()); break;
            case REAL_NUMBER: result = realNumber.compareTo(a.getRealNumber()); break;
            case DOUBLE:    result = doubleNumber.compareTo(a.getDoubleNumber()); break;
            case FLOAT:      result = floatNumber.compareTo(a.getFloatNumber()); break;
        }
        return result;
    }

    /**
     * 按照传入的参数切换数据类型。
     * @param dataType 要切换的数据类型
     * @return 返回转换后的 CFPNumber 对象
     */
    public CFPNumber setDataType(CFPDataType dataType){
        switch (dataType){
            case LONG: this.turnToLong();break;
            case INTEGER: this.turnToInteger();break;
            case SHORT: this.turnToShort();break;
            case BYTE: this.turnToByte();break;
            case REAL_NUMBER: this.turnToRealNumber();break;
            case DOUBLE: this.turnToDouble();break;
            case FLOAT:  this.turnToFloat();break;
        }
        return this;
    }

    /**
     * 切换数据类型置 Long 类型。
     *
     * @return 转换后的 CFPNumber 对象
     */
    public CFPNumber turnToLong(){
        turnToRealNumber();
        longNumber = realNumber.toCFPLong();
        dataType = CFPDataType.LONG;
        return this;
    }

    /**
     * 切换数据类型置 Integer 类型。
     *
     * @return 转换后的 CFPNumber 对象
     */
    public CFPNumber turnToInteger(){
        turnToRealNumber();
        integerNumBer = realNumber.toCFPIteger();
        dataType = CFPDataType.INTEGER;
        return this;
    }

    /**
     * 切换数据类型置 Short 类型。
     *
     * @return 转换后的 CFPNumber 对象
     */
    public CFPNumber turnToShort(){
        turnToRealNumber();
        shortNumber = realNumber.toCFPShort();
        dataType = CFPDataType.SHORT;
        return this;
    }

    /**
     * 切换数据类型置 Byte 类型。
     *
     * @return 转换后的 CFPNumber 对象
     */
    public CFPNumber turnToByte(){
        turnToRealNumber();
        byteNumber = realNumber.toCFPByte();
        dataType = CFPDataType.BYTE;
        return this;
    }

    /**
     * 切换数据类型置 RealNumber 类型。
     *
     * @return 转换后的 CFPNumber 对象
     */
    public CFPNumber turnToRealNumber(){
        switch (dataType){
            case LONG:          realNumber = longNumber.toCFPRealNumber();break;
            case INTEGER:       realNumber = integerNumBer.toCFPRealNumber();break;
            case SHORT:         realNumber = shortNumber.toCFPRealNumber();break;
            case BYTE:          realNumber = byteNumber.toCFPRealNumber();break;
            case DOUBLE:        realNumber = doubleNumber.toCFPRealNumber();break;
            case FLOAT:         realNumber = floatNumber.toCFPRealNumber();break;
        }
        dataType = CFPDataType.REAL_NUMBER;
        return this;
    }

    /**
     * 切换数据类型置 Double 类型。
     *
     * @return 转换后的 CFPNumber 对象
     */
    public CFPNumber turnToDouble(){
        turnToRealNumber();
        doubleNumber = realNumber.toCFPDouble();
        dataType = CFPDataType.DOUBLE;
        return this;
    }

    /**
     * 切换数据类型置 Float 类型。
     *
     * @return 转换后的 CFPNumber 对象
     */
    public CFPNumber turnToFloat(){
        turnToRealNumber();
        floatNumber = realNumber.toCFPFloat();
        dataType = CFPDataType.FLOAT;
        return this;
    }
}
