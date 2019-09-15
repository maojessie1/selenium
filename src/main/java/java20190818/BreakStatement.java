package java20190818;

public class BreakStatement {

    public static void main(String[] args) {
        int i ;
        int sum = 0;
        int score = 0;
        for (i = 1; i <=10 ; i++) {
            score=(int)(Math.random()*100);
            System.out.println(score);
            if (score<60)
                break;
            sum +=score;
            i++;
        }
        if ((sum/10>=80)&&(i==10)){
            System.out.println("通过");
        }else {
            System.out.println("不通过");

        }
    }
}
