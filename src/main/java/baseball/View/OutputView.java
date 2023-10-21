package baseball.View;

public class OutputView {
    public static void printStartGame(){
        System.out.println("숫자 야구를 시작합니다.");
    }

    public static void printStrikeBall(){
        System.out.println("볼 ");
    }

    public static void printBall(){
        System.out.println("볼");
    }

    public static void printStrike(){
        System.out.println("스트라이크");
    }

    public static void printNothing(){
        System.out.println("낫싱");
    }

    public static void printCount(int count){
        System.out.println(count);
    }

    public static void printSetGameMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
