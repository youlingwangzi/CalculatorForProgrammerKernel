package cn.edu.lnu.calculatlib.Number;

/**
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public class CFPByte implements CFPBaseOperation<CFPByte>, CFPLogicOperation<CFPByte>,CFPRadixConversion {
    private Byte byteNumbger;

    public CFPByte(byte a){
        byteNumbger = a;
    }

    @Override
    public String toHexString() {
        if(byteNumbger >= 0)
            return Integer.toHexString(byteNumbger);
        else{
            StringBuilder stringBuilder = new StringBuilder(Integer.toHexString(byteNumbger));
            return stringBuilder.substring(6);
        }
    }

    @Override
    public String toDecString() {
        return this.byteNumbger.toString();
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
        if(byteNumbger >= 0)
            return Integer.toBinaryString(byteNumbger);
        else{
            StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(byteNumbger));
            return stringBuilder.substring(24);
        }
    }

    @Override
    public String toFullBinatyString() {
        StringBuilder stringBuilder = new StringBuilder(this.toBinString());
        int n = 8 - stringBuilder.length();
        while (n-- != 0){
            stringBuilder.insert(0,"0");
        }
        return stringBuilder.toString();
    }

    public CFPByte parseUnsignedByte(String s, int radix){
        if (s.charAt(0) == '1' && s.length() == 8){
            StringBuilder stringBuilder = new StringBuilder(this.toBinString());
            int n = 32 - stringBuilder.length();
            while (n-- != 0){
                stringBuilder.insert(0,"1");
            }
        }
        this.byteNumbger = (byte)Integer.parseUnsignedInt(s, radix);
        return this;
    }

    public Byte getByteNumbger() {
        return byteNumbger;
    }

    public void setByteNumbger(Byte byteNumbger) {
        this.byteNumbger = byteNumbger;
    }

    public CFPRealNumber toCFPRealNumber(){
        return new CFPRealNumber();
    }

    @Override
    public CFPByte add(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger + a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte sub(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger - a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte mul(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger * a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte div(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger / a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte opp() {
        this.byteNumbger = (byte) -this.byteNumbger;
        return this;
    }

    @Override
    public CFPByte mod(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger % a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte or(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger | a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte xor(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger ^ a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte and(CFPByte a) {
        this.byteNumbger = (byte) (this.byteNumbger & a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte not() {
        this.byteNumbger = (byte) ~this.byteNumbger;
        return this;
    }

    @Override
    public CFPByte lsl(CFPByte a) {
        this.byteNumbger =
                (byte)(this.byteNumbger >>> a.getByteNumbger() | this.byteNumbger << (8 - a.getByteNumbger()));
        return this;
    }

    @Override
    public CFPByte lsr(CFPByte a) {
        this.byteNumbger =
                (byte)(this.byteNumbger << a.getByteNumbger() | this.byteNumbger >>> (8 - a.getByteNumbger()));
        return this;
    }

    @Override
    public CFPByte sl(CFPByte a) {
        this.byteNumbger = (byte)(this.byteNumbger << a.getByteNumbger());
        return this;
    }

    @Override
    public CFPByte sr(CFPByte a) {
        this.byteNumbger = (byte)(this.byteNumbger >> a.getByteNumbger());
        return this;
    }

}
