package cn.edu.lnu.calculatlib.Number;

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
     * @return this/a的商
     */
    T div(T a);

    /**
     * 取相反数操作，置this的值为-this，并返回-this的值。
     * @return -this的值
     */
    T opp();
}
