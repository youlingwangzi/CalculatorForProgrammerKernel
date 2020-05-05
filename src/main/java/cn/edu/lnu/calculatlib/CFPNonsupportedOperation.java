package cn.edu.lnu.calculatlib;

/**
 * 当所选择的数据类型调用了不支持的操作时抛出此异常。<br>
 * Created by youlingwangzi on 2016/12/6.
 * @author youlingwangzi
 */
public class CFPNonsupportedOperation extends Exception {
    /**
     * 存储具体错误信息
     */
    private String info;

    /**
     * 构造函数
     * @param s 具体错误信息
     */
    CFPNonsupportedOperation(String s){
        info = s;
    }

    /**
     * 返回的不支持的操作的具体错误信息字符串。
     * @return 具体错误信息字符串
     */
    public String toUserMes(){
        return info;
    }
}
