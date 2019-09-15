package java20190908001;

public class RandomDemo {
   public int getRandom(int count){
       return (int)Math.round(Math.random()*count);
   }

   private String string = "jfkdslajkslfda";

   public String getRandomString(int length){
       StringBuilder sb = new StringBuilder();
       int len = string.length();
       for (int i = 0; i < length ; i++) {
           sb.append(string.charAt(this.getRandom(len-1)));
       }
       return sb.toString();
   }

    public static void main(String[] args) {
        RandomDemo rd = new RandomDemo();
        for (int i = 0; i < 5 ; i++) {
            System.out.println(rd.getRandomString(3));
        }
    }
}
