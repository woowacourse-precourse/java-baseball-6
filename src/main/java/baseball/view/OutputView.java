package baseball.view;

public class OutputView {
    public static void printGameStart(){
        System.out.println("야구 게임을 시작 합니다.");
    }
    public static void printStrikeMessage(){
        System.out.println("스트라이크");
    }
    public static void printBallMessage(){
        System.out.println("볼");
    }
    public static void printNothingMessage(){
        System.out.println("낫싱");
    }

    public static void printCount(int count){
        System.out.println(count);
    }
    public static void printGamesetMessage(){
        System.out.println("3개의 숫자를 모두 맞혔습니다. 게임종료!");
    }
}
