package baseball.view;

public class Output {

    public static void message(){
        System.out.println("낫싱");
    }
    public static void message(int ball, int strike){
        if (strike == 0){
            if (ball > 0) System.out.println(ball + "볼");
        }
        else{
            if (ball == 0) System.out.println(strike + "스트라이크");
            else System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
