package cn.edu.lnu.calculatlib.Number;

/**
 * Created by youlingwangzi on 2016/12/2.
 * youlingwangzi
 */
public interface CFPLogicOperation<T> {
    T mod(T a);
    T or(T a);
    T xor(T a);
    T and(T a);
    T not();
    T lsl(T a);
    T lsr(T a);
    T sl(T a);
    T sr(T a);
}
