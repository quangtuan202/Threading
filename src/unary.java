import java.util.Random;

public class unary {
    public static void main(String[] args) {
        short w = 14;
        float x = 13;
        double y = 30;
        var z = w * x / y;
        System.out.println(x);

        String[] datetime=generateRandomTime();
        System.out.println(datetime[0]);
        System.out.println(datetime[1]);
    }
    public static String[] generateRandomTime(){
        Random random=new Random();
        int hour = random.nextInt(22)+1;
        int hourEnd=hour+1;
        int minute=random.nextInt(60)+1;
        int second=random.nextInt(60)+1;
        return new String[]{hour+"-"+minute+"-"+second,hourEnd+"-"+minute+"-"+second};

    }

}
