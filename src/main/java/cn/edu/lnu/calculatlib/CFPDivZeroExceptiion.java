package cn.edu.lnu.calculatlib;

/**
 * 除数为零时抛出此异常。<br>
 * Created by youlingwangzi on 2016/12/6.
 * @author youlingwangzi
 */
public class CFPDivZeroExceptiion extends Exception {

    /**
     * use serialVersionUID
     */
    private static final long serialVersionUID = -6786277232691025892L;

    /**
     * 返回“对不起，除数不能为零。”的错误信息字符串。
     * 
     * @return “对不起，除数不能为零。”的错误信息字符串
     */
    public String toUserString(){
        return "对不起，除数不能为零。";
    }
}
