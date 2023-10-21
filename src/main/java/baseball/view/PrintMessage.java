package baseball.view;

public class PrintMessage {

    public static void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void requestNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printNothing(){
        System.out.println("낫싱");
    }

    public static void printBall(int ballCount){
        System.out.print(ballCount+"볼 ");
    }

    public static void printStrike(int strikeCount){
        System.out.println(strikeCount+"스트라이크");
    }

}
