package java20190818;

public class ForLoopStatement {
    public static void main(String[] args) {
        int i,j;
        for (i = 1;  i<=10 ; i++) {
            for (j=1;j<=i;j++){
                System.out.print(i+"x"+j+" ="+i*j+"  ");
                System.out.println();
            }

        }
    }
}
