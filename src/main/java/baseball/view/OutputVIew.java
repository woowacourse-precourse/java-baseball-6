package baseball.view;
//모든 결과 출력
public class OutputVIew {
    public static void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void printBallMessage(){
        System.out.println("볼");
    }
    public static void printStrikeMessage(){
        System.out.println("스트라이크");
    }
    public static void printNothingMessage(){
        System.out.println("낫싱");
    }
    public static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
