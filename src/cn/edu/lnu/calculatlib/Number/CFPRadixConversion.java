package cn.edu.lnu.calculatlib.Number;

/**
 * 数据类型转换定义接口。</br>
 * 该接口定义了四个数据类型转换操作。</br>
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public interface CFPRadixConversion {

    /**
     * 将数据转换成十六进制形式。</br>
     * 根据数据类型的不同转换形式有所不同，区别如下：</br>
     * Long、Integer、Short、Byte类型返回其补码的十六进制形式；</br>
     * RealNumber类型返回自然的十六进制形式，eg：-1342.598转换为-53E.9916872B020C49BA5E35……；</br>
     * Double、Float类型返回Double、Float类public static String toHexString(double d)函数结果。
     * @return 转换后的字符串
     */
    String toHexString();

    /**
     * 将数据转换成十进制形式。</br>
     * @return 转换后的字符串
     */
    String toDecString();

    /**
     * 将数据转换成八进制形式。</br>
     * 根据数据类型的不同转换形式有所不同，区别如下：</br>
     * Long、Integer、Short、Byte类型返回其补码的八进制形式；</br>
     * RealNumber类型返回自然的十六进制形式，eg：-1342.598转换为-2476.46213207126010142233……；</br>
     * Double、Float类型返回其IEEE754标准的八进制形式。
     * @return 转换后的字符串
     */
    String toOctString();

    /**
     * 将数据转换成二进制形式。</br>
     * 根据数据类型的不同转换形式有所不同，区别如下：</br>
     * Long、Integer、Short、Byte类型返回其补码的二进制形式；</br>
     * RealNumber类型返回自然的十六进制形式，eg：-1342.598转换为-10100111110.10011001000101101……；</br>
     * Double、Float类型返回Double、Float类public static long doubleToLongBits(double value)、
     *      public static int floatToIntBits(float value)函数结果。
     * @return 转换后的字符串
     */
    String toBinString();

    /**
     * 将数据转换成二进制形式，并按照数据位长将高位填充0。</br>
     * 根据数据类型的不同转换形式有所不同，区别如下：</br>
     * Long、Integer、Short、Byte类型返回其补码的二进制形式，将高位填充0；</br>
     * RealNumber类型返回自然的二进制形式，eg：-1342.598转换为-53E.9916872B020C49BA5E35……；</br>
     * Double、Float类型返回Double、Float类public static long doubleToLongBits(double value)、
     *      public static int floatToIntBits(float value)函数结果。
     * @return 转换后的字符串
     */
    String toFullBinatyString();
}
