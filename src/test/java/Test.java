import cn.edu.lnu.calculatlib.CFPDataType;
import cn.edu.lnu.calculatlib.CFPDivZeroExceptiion;
import cn.edu.lnu.calculatlib.CFPNumber;
import cn.edu.lnu.calculatlib.Number.*;

public class Test {

    public static void main(String[] args) {
	// write your code here
        
        CFPShort cfpShort1 = new CFPShort((short)32767);
        System.out.println(cfpShort1.toHexString());
        System.out.println(cfpShort1.toDecString());
        System.out.println(cfpShort1.toOctString());
        System.out.println(cfpShort1.toBinString());
        System.out.println(cfpShort1.toFullBinatyString());
        System.out.println(cfpShort1.parseUnsignedShort("1111111111101111").toDecString());

        CFPByte cfpByte1 = new CFPByte((byte)111);
        System.out.println("hex："+cfpByte1.toHexString());
        System.out.println("dec："+cfpByte1.toDecString());
        System.out.println("oct："+cfpByte1.toOctString());
        System.out.println("bin："+cfpByte1.toBinString());
        System.out.println("full："+cfpByte1.toFullBinatyString());
        System.out.println("byte s to byte："+cfpByte1.parseUnsignedByte("11101111").toDecString());

        cfpShort1 = new CFPShort((byte)111);
        System.out.println("hex："+cfpShort1.toHexString());
        System.out.println("dec："+cfpShort1.toDecString());
        System.out.println("oct："+cfpShort1.toOctString());
        System.out.println("bin："+cfpShort1.toBinString());
        System.out.println("full："+cfpShort1.toFullBinatyString());
        System.out.println("short s to byte："+cfpShort1.parseUnsignedShort("1111111111101111").toDecString());

        CFPLong cfpLong1 = new CFPLong(111);
        System.out.println("hex：" +cfpLong1.toHexString());
        System.out.println("dec：" +cfpLong1.toDecString());
        System.out.println("oct：" +cfpLong1.toOctString());
        System.out.println("bin：" +cfpLong1.toBinString());
        System.out.println("full："+cfpLong1.toFullBinatyString());
        System.out.println("long s to byte："+cfpLong1.parseUnsignedLong("1101111").toDecString());

        CFPInteger cfpInteger1 = new CFPInteger(111);
        System.out.println("hex：" +cfpInteger1.toHexString());
        System.out.println("dec：" +cfpInteger1.toDecString());
        System.out.println("oct：" +cfpInteger1.toOctString());
        System.out.println("bin：" +cfpInteger1.toBinString());
        System.out.println("full："+cfpInteger1.toFullBinatyString());
        System.out.println("int s to byte："+cfpInteger1.parseUnsignedInt("11111111111111111111111111101111").toDecString());
        System.out.println("循环右移："+cfpInteger1.lsr(new CFPInteger(1)).toBinString());

        CFPNumber cfpNumbera = new CFPNumber("111").turnToLong();
        CFPNumber cfpNumberb = new CFPNumber(10);

        try {
            System.out.println("number除法："+cfpNumbera.div(cfpNumberb));
        } catch (CFPDivZeroExceptiion cfpDivZeroExceptiion) {
            cfpDivZeroExceptiion.printStackTrace();
        }

        CFPFloat cfpFloat1 = new CFPFloat((float) 12.00342);
        System.out.println("hex：" +cfpFloat1.toHexString());
        System.out.println("dec：" +cfpFloat1.toDecString());
        System.out.println("oct：" +cfpFloat1.toOctString());
        System.out.println("bin：" +cfpFloat1.toBinString());
        System.out.println("full："+cfpFloat1.toFullBinatyString());




        CFPDouble cfpDouble = new CFPDouble(-608798.123000);
        System.out.println("hex："+cfpDouble.toHexString());
        System.out.println("dec："+cfpDouble.toDecString()+"isInteger："+cfpDouble.isIntegerValue());
        System.out.println("oct："+cfpDouble.toOctString());
        System.out.println("bin："+cfpDouble.toBinString());

        CFPRealNumber cfpRealNumber = new CFPRealNumber("-1342.00000");
        System.out.println("hex："+cfpRealNumber.toHexString());
        System.out.println("dec："+cfpRealNumber.toDecString());
        System.out.println("oct："+cfpRealNumber.toOctString());
        System.out.println("bin："+cfpRealNumber.toBinString());
        cfpRealNumber.setInputScale(1);
        cfpRealNumber.setBigDecimalNumber("1342.0");
        System.out.println("hex："+cfpRealNumber.toHexString());
        System.out.println("dec："+cfpRealNumber.toDecString());
        System.out.println("oct："+cfpRealNumber.toOctString());
        System.out.println("bin："+cfpRealNumber.toBinString());
        cfpRealNumber.addABit(1,10);
        System.out.println("hex："+cfpRealNumber.toHexString());
        System.out.println("dec："+cfpRealNumber.toDecString());
        System.out.println("oct："+cfpRealNumber.toOctString());
        System.out.println("bin："+cfpRealNumber.toBinString());
        cfpRealNumber.addABit(4,10);
        System.out.println("hex："+cfpRealNumber.toHexString());
        System.out.println("dec："+cfpRealNumber.toDecString());
        System.out.println("oct："+cfpRealNumber.toOctString());
        System.out.println("bin："+cfpRealNumber.toBinString());

        CFPDataType cfpDataType = CFPDataType.REAL_NUMBER;
        System.out.println(cfpDataType.isIntegersType());

        Float f = (float)0 * 1;
        System.out.println(f.compareTo((float)0));

        CFPNumber a = new CFPNumber("0").turnToFloat();
        CFPNumber tempNum = new CFPNumber("0").turnToFloat();
        tempNum.add(new CFPNumber("1.0").turnToFloat().sub(new CFPNumber("1.0").turnToFloat()));
        try {
            a.div(tempNum);
        } catch (CFPDivZeroExceptiion cfpDivZeroExceptiion) {
            System.out.println(cfpDivZeroExceptiion.toUserString());
        }


        CFPByte along = new CFPByte((byte) 15);
        CFPByte blong = new CFPByte((byte) 17);
        try {
            along = (CFPByte) blong.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        along.setByteNumbger((byte)15);
        System.out.println("a:"+along.toDecString()+"  b:"+blong.toDecString());

        CFPRealNumber a1 = new CFPRealNumber("15");
        CFPRealNumber a2 = new CFPRealNumber("17");
        try {
            a1 = (CFPRealNumber) a2.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        a1.setBigDecimalNumber("15");
        System.out.println("a:"+along.toDecString()+"  b:"+blong.toDecString());

        CFPNumber aNumber = new CFPNumber("15");
        CFPNumber bNumber = new CFPNumber("17");
        try {
            aNumber =(CFPNumber) bNumber.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        aNumber.setNumber("15");
        System.out.println("a:"+aNumber.toDecString()+"  kkkkkkkkb:"+bNumber.toDecString());
    }
}
