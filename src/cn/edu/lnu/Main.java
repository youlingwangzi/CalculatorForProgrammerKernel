package cn.edu.lnu;

import cn.edu.lnu.calculatlib.CFPDataType;
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

        CFPRealNumber cfpRealNumber = new CFPRealNumber("1234.5");
        cfpRealNumber.setBigDecimalNumber(new BigDecimal("1342.5"));
        System.out.println("hex："+cfpRealNumber.toHexString());
        System.out.println("dec："+cfpRealNumber.toDecString());
        System.out.println("oct："+cfpRealNumber.toOctString());
        System.out.println("bin："+cfpRealNumber.toBinString());

        CFPDataType cfpDataType = CFPDataType.REAL_NUMBER;
        System.out.println(cfpDataType.isIntegersType());

    }
}
