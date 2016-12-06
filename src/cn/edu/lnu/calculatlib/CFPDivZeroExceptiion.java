package cn.edu.lnu.calculatlib;

/**
 * 除数为零时抛出此异常
 * Created by youlingwangzi on 2016/12/6.
 * @author youlingwangzi
 */
public class CFPDivZeroExceptiion extends Exception {
    public String toUserString(){
        return "对不起，除数不能为零。";
    }
}
