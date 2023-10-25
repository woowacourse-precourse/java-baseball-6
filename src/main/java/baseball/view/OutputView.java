package baseball.view;

public class OutputView {

    public static void printStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void printBall(int ball){
        System.out.print(ball + "볼 ");
    }

    public static void printStrike(int strike){
        System.out.print(strike + "스트라이크");
    }

    public static void printNothing(){
        System.out.print("낫싱");
    }

    public static void printThreeStrike(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printNewLine(){
        System.out.println();
    }

}
