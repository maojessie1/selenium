package java20190925;

import org.testng.annotations.Test;

public class ExpectedException {
    //�쳣���ԣ��������������Ϊĳһ���쳣��ʱ��

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("����һ��ʧ�ܵ��쳣����");
    }

    //�쳣���ԣ��ɹ���
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("�����ҵ��쳣����");
        throw new RuntimeException();
    }
}
