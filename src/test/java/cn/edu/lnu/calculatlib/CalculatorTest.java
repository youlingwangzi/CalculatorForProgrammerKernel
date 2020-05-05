package cn.edu.lnu.calculatlib;

import cn.edu.lnu.calculatlib.Number.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("Test CFPSHort Class")
    void shortTest() {
        CFPShort cfpShort = new CFPShort((short)32767);
        assertEquals("7FFF", cfpShort.toHexString(), "Short to HEX");
        assertEquals("32767", cfpShort.toDecString(), "Short to DEC");
        assertEquals("77777", cfpShort.toOctString(), "Short to OCT");
        assertEquals("111111111111111", cfpShort.toBinString(), "Short to BIN");
        assertEquals("0111111111111111", cfpShort.toFullBinatyString(), "Short to full BIN");
        assertEquals("-17", cfpShort.parseUnsignedShort("1111111111101111").toDecString(), "Bin to unShort");
    }

    @Test
    @DisplayName("Test CFPByte Class")
    void byteTest() {
        CFPByte cfpByte = new CFPByte((byte)111);
        assertEquals("6F", cfpByte.toHexString(), "Byte to HEX");
        assertEquals("111", cfpByte.toDecString(), "Byte to DEC");
        assertEquals("157", cfpByte.toOctString(), "Byte to OCT");
        assertEquals("1101111", cfpByte.toBinString(), "Byte to BIN");
        assertEquals("01101111", cfpByte.toFullBinatyString(), "Byte to full BIN");
        assertEquals("-17", cfpByte.parseUnsignedByte("11101111").toDecString(), "Bin to Byte");
    }

    @Test
    @DisplayName("Test CFPLong Class")
    void longTest() {
        CFPLong cfpLong = new CFPLong(111);
        assertEquals("6F", cfpLong.toHexString(), "Long to HEX");
        assertEquals("111", cfpLong.toDecString(), "Long to DEC");
        assertEquals("157", cfpLong.toOctString(), "Long to OCT");
        assertEquals("1101111", cfpLong.toBinString(), "Long to BIN");
        assertEquals("0000000000000000000000000000000000000000000000000000000001101111", cfpLong.toFullBinatyString(), "Long to full BIN");
        assertEquals("111", cfpLong.parseUnsignedLong("1101111").toDecString(), "Bin to Long");
    }

    @Test
    @DisplayName("Test CFPInteger Class")
    void integerTest(){
        CFPInteger cfpInteger1 = new CFPInteger(111);
        assertEquals("6F", cfpInteger1.toHexString(), "Integer to HEX");
        assertEquals("111", cfpInteger1.toDecString(), "Integer to DEC");
        assertEquals("157", cfpInteger1.toOctString(), "Integer to OCT");
        assertEquals("1101111", cfpInteger1.toBinString(), "Integer to BIN");
        assertEquals("00000000000000000000000001101111", cfpInteger1.toFullBinatyString(), "Integer to full BIN");
        assertEquals("-17", cfpInteger1.parseUnsignedInt("11111111111111111111111111101111").toDecString(), "Bin to Integer");
        assertEquals("11111111111111111111111111110111", cfpInteger1.lsr(new CFPInteger(1)).toBinString(), "Integer 循环右移");

    }
}
