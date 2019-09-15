package java20190818;

public class WhileLoopStatement {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        int score = 60;
        while ((i <= 10) && (score >= 60)) {
            score = (int) (Math.random() * 100);
            System.out.println(score+",");
            sum += score;
            i++;
        }
        System.out.println();
        if ((i == 10) && (sum / 10) >= 80) {
            System.out.println("tongguo");
        }else {
            System.out.println("butongguo");
        }
    }
}
