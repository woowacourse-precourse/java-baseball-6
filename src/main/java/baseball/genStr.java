package baseball;

public class genStr {

    // strike ball값 보고 출력 값 생성

    public static String getResult(int strike, int ball){

        String result;

        if(strike == 0){
            if(ball == 0) // 아무것도 못 맞춤
                result = "낫싱";
            else // 볼만
                result = ball + "볼";
        }
        else{
            if(ball == 0) // 스트라이크만
                result = strike + "스트라이크";
            else // 볼 스트라이크
                result = ball + "볼" + " " + strike + "스트라이크";
        }
        return result;
    }
}
