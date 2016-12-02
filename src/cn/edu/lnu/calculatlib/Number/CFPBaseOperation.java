package cn.edu.lnu.calculatlib.Number;

/**
 * Created by youlingwangzi on 2016/12/2.
 * @author youlingwangzi
 */
public interface CFPBaseOperation <T> {
    T add(T a);
    T sub(T a);
    T mul(T a);
    T div(T a);
    T opp();
}
