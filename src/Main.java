import cn.edu.lnu.calculatlib.CFPDataType;
import cn.edu.lnu.calculatlib.CFPDivZeroExceptiion;
import cn.edu.lnu.calculatlib.CFPNumber;
import cn.edu.lnu.calculatlib.Number.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        CFPShort cfpShort1 = new CFPShort((short)32767);
        System.out.println(cfpShort1.toHexString());
        System.out.println(cfpShort1.toDecString());
        System.out.println(cfpShort1.toOctString());
        System.out.println(cfpShort1.toBinString());
        System.out.println(cfpShort1.toFullBinatyString());
        System.out.println(cfpShort1.parseUnsignedShort("1111111111101111",2).toDecString());*/

/*        CFPByte cfpShort1 = new CFPByte((byte)111);
        System.out.println("hex："+cfpShort1.toHexString());
        System.out.println("dec："+cfpShort1.toDecString());
        System.out.println("oct："+cfpShort1.toOctString());
        System.out.println("bin："+cfpShort1.toBinString());
        System.out.println("full："+cfpShort1.toFullBinatyString());
        System.out.println("s to byte："+cfpShort1.parseUnsignedByte("1101111",2).toDecString());

        CFPDouble cfpDouble = new CFPDouble(-608798.123);
        System.out.println("hex："+cfpDouble.toHexString());
        System.out.println("dec："+cfpDouble.toDecString());
        System.out.println("oct："+cfpDouble.toOctString());
        System.out.println("bin："+cfpDouble.toBinString());*/

 /*       CFPRealNumber cfpRealNumber = new CFPRealNumber("-1342");
        System.out.println("hex："+cfpRealNumber.toHexString());
        System.out.println("dec："+cfpRealNumber.toDecString());
        System.out.println("oct："+cfpRealNumber.toOctString());
        System.out.println("bin："+cfpRealNumber.toBinString());
        cfpRealNumber.setBigDecimalNumber("-1342.598");
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
        */

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

        CFPDataType cfpDataType = CFPDataType.BYTE;
        CFPDataType cfpDataType1 = CFPDataType.DOUBLE;
        cfpDataType = cfpDataType1;
        cfpDataType = CFPDataType.BYTE;
        System.out.println("a:"+cfpDataType+"  b:"+cfpDataType1);

        CFPNumber aNumber = new CFPNumber("15");
        CFPNumber bNumber = new CFPNumber("17");
        try {
            aNumber =(CFPNumber) bNumber.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        aNumber.setNumber("15");
        System.out.println("a:"+aNumber.toDecString()+"  b:"+bNumber.toDecString());


    }
}
