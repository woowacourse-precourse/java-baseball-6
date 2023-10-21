package baseball;

public class PrintResult {
    public static String print(int[] strike_ball){
        StringBuilder sb = new StringBuilder();

        if (strike_ball[1]>0){
            sb.append(strike_ball[1]);
            sb.append("볼");
            sb.append(" ");
        }
        if (strike_ball[0]>0){
            sb.append(strike_ball[0]);
            sb.append("스트라이크");
        }
        if (sb.isEmpty()){
            sb.append("낫싱");
        }

        return sb.toString();
    }
}