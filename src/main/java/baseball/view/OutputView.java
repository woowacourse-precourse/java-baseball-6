package baseball.view;

public class OutputView {
    private static final int default_number = 0;

    public static void gameStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void gameOverMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printBallAndStrike(int ball, int strike){
        if(ball>0 && strike>0){
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public static void printOnlyBall(int ball, int strike){
        if(ball>0 && strike==default_number){
            System.out.println(ball + "볼");
        }
    }

    public static void printOnlyStrike(int ball, int strike){
        if(ball==default_number && strike>0){
            System.out.println(strike + "스트라이크");
        }
    }
    
    public static void printNothing(int ball, int strike){
        if(ball==default_number && strike==default_number){
            System.out.println("낫싱");
        }
    }

}
