package cn.edu.lnu.calculatlib.Number;

import cn.edu.lnu.calculatlib.CFPDivZeroExceptiion;
import cn.edu.lnu.calculatlib.CFPNonsupportedOperation;

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
     * @throws CFPDivZeroExceptiion 当除数为0时抛出此异常
     * @throws CFPNonsupportedOperation 当不支持该操作的数据类型调用该操作时抛出此异常
     * @return this%a的值
     */
    T mod(T a) throws CFPDivZeroExceptiion, CFPNonsupportedOperation;

    /**
     * 或运算，置this的值为this|a，并返回this|a的值。
     * @param a 要进行或运算的值
     * @throws CFPNonsupportedOperation 当不支持该操作的数据类型调用该操作时抛出此异常
     * @return this|a的值
     */
    T or(T a) throws CFPNonsupportedOperation;

    /**
     * 异或运算，置this的值为this^a，并返回this^a的值。
     * @param a 要进行异或运算的值
     * @throws CFPNonsupportedOperation 当不支持该操作的数据类型调用该操作时抛出此异常
     * @return this^a的值
     */
    T xor(T a) throws CFPNonsupportedOperation;

    /**
     * 与运算，置this的值为this&a，并返回this&a的值。
     * @param a 要进行与运算的值
     * @throws CFPNonsupportedOperation 当不支持该操作的数据类型调用该操作时抛出此异常
     * @return this&a的值
     */
    T and(T a) throws CFPNonsupportedOperation;

    /**
     * 非运算，置this的值为~this，并返回~this的值。
     * @throws CFPNonsupportedOperation 当不支持该操作的数据类型调用该操作时抛出此异常
     * @return ~this的值
     */
    T not() throws CFPNonsupportedOperation;

    /**
     * 循环左移运算，置this的值为this循环左移a位的值，并返回。
     * @param a 要进行循环移位运算的值
     * @throws CFPNonsupportedOperation 当不支持该操作的数据类型调用该操作时抛出此异常
     * @return this循环左移a位的值
     */
    T lsl(T a) throws CFPNonsupportedOperation;

    /**
     * 循环右移运算，置this的值为this循环右移a位的值，并返回。
     * @param a 要进行循环移位运算的值
     * @throws CFPNonsupportedOperation 当不支持该操作的数据类型调用该操作时抛出此异常
     * @return this循环右移a位的值
     */
    T lsr(T a) throws CFPNonsupportedOperation;

    /**
     * 左移运算，置this的值为this左移a位的值，并返回。
     * @param a 要进行移位运算的值
     * @throws CFPNonsupportedOperation 当不支持该操作的数据类型调用该操作时抛出此异常
     * @return this左移a位的值
     */
    T sl(T a) throws CFPNonsupportedOperation;

    /**
     * 右移运算，置this的值为this右移a位的值，并返回。
     * @param a 要进行移位运算的值
     * @throws CFPNonsupportedOperation 当不支持该操作的数据类型调用该操作时抛出此异常
     * @return this右移a位的值
     */
    T sr(T a) throws CFPNonsupportedOperation;
}
