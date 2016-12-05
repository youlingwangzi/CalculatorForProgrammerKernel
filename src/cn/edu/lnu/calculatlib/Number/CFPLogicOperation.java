package cn.edu.lnu.calculatlib.Number;

/**
 * 逻辑运算定义接口。</br>
 * 该接口定义了九种逻辑运算。</br>
 * Created by youlingwangzi on 2016/12/2.
 * youlingwangzi
 */
public interface CFPLogicOperation<T> {

    /**
     * 取模运算，置this的值为this%a，并返回this%a的值。
     * @param a 要取模的值
     * @return this%a的值
     */
    T mod(T a);

    /**
     * 或运算，置this的值为this|a，并返回this|a的值。
     * @param a 要进行或运算的值
     * @return this|a的值
     */
    T or(T a);

    /**
     * 异或运算，置this的值为this^a，并返回this^a的值。
     * @param a 要进行异或运算的值
     * @return this^a的值
     */
    T xor(T a);

    /**
     * 与运算，置this的值为this&a，并返回this&a的值。
     * @param a 要进行与运算的值
     * @return this&a的值
     */
    T and(T a);

    /**
     * 非运算，置this的值为~this，并返回~this的值。
     * @return ~this的值
     */
    T not();

    /**
     * 循环左移运算，置this的值为this循环左移a位的值，并返回。
     * @param a 要进行循环移位运算的值
     * @return this循环左移a位的值
     */
    T lsl(T a);

    /**
     * 循环右移运算，置this的值为this循环右移a位的值，并返回。
     * @param a 要进行循环移位运算的值
     * @return this循环右移a位的值
     */
    T lsr(T a);

    /**
     * 左移运算，置this的值为this左移a位的值，并返回。
     * @param a 要进行移位运算的值
     * @return this左移a位的值
     */
    T sl(T a);

    /**
     * 右移运算，置this的值为this右移a位的值，并返回。
     * @param a 要进行移位运算的值
     * @return this右移a位的值
     */
    T sr(T a);
}
