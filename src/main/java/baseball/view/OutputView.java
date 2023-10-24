package baseball.view;

public class OutputView {
    public static void ballAndStrike(int ball, int strike){
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public static void onlyBall(int ball){
        System.out.println(ball + "볼");
    }

    public static void onlyStrike(int strike){
        System.out.println(strike + "스트라이크");
    }
    public static void nothing(){
        System.out.println("낫싱");
    }
    public static void gameEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
