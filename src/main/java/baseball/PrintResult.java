package baseball;

public class PrintResult {
    // 사용자 입력 수에 대한 결과 출력
    public static void print(int[] strike_ball){
        StringBuilder sb = new StringBuilder();

        if (strike_ball[1]>0){
            sb.append(strike_ball[1]);
            sb.append("볼 ");
        }
        if (strike_ball[0]>0){
            sb.append(strike_ball[0]);
            sb.append("스트라이크");
        }
        if (sb.isEmpty()){
            sb.append("낫싱");
        }

        System.out.println(sb);
    }
}