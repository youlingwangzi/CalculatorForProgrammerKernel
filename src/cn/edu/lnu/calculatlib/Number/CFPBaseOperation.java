package cn.edu.lnu.calculatlib.Number;

import cn.edu.lnu.calculatlib.CFPDivZeroExceptiion;

/**
 * 基础运算定义接口。</br>
 * 该接口定义了五种基础算数运算。
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public interface CFPBaseOperation <T> {
    /**
     * 加法操作，置this的值为this+a，并返回this+a的值。
     * @param a 加数
     * @return this+a的和
     */
    T add(T a);

    /**
     * 减法操作，置this的值为this-a，并返回this-a的值。
     * @param a 减数
     * @return this-a的差
     */
    T sub(T a);

    /**
     * 乘法操作，置this的值为this*a，并返回this*a的值。
     * @param a 乘数
     * @return this*a的积
     */
    T mul(T a);

    /**
     * 除法操作，置this的值为this/a，并返回this/a的值。
     * @param a 被除数
     * @throws CFPDivZeroExceptiion 当除数为0时抛出此异常
     * @return this/a的商
     */
    T div(T a) throws CFPDivZeroExceptiion;

    /**
     * 取相反数操作，置this的值为-this，并返回-this的值。
     * @return -this的值
     */
    T opp();

    /**
     * 数据大小比较函数。判断 this 与 a 的大小关系。
     * @param a 需要比较的数
     * @return 返回-1表示this小于a，返回0表示this等于a，返回1表示this大于a。
     */
    int compareTo(T a);
}
