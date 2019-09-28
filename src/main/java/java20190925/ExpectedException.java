package java20190925;

import org.testng.annotations.Test;

public class ExpectedException {
    //异常测试，在我们期望结果为某一个异常的时候

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    //异常测试，成功。
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException();
    }
}
