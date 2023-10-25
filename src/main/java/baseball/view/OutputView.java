package baseball.view;

public class OutputView {

    private static final String startMessage = "숫자 야구 게임을 시작합니다.";
    private static final String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void gameStart(){
        System.out.println(startMessage);
    }
    public void gameEnd(){
        System.out.println(endMessage);
    }
    public static void ballStrikeMessage(int n){
        System.out.print(n+"볼 ");
    }
    public static void ballMessage(int n){
        System.out.println(n+"볼");
    }
    public static void strikeMessage(int n){
        System.out.println(n+"스트라이크");
    }
    public static void nothingMessage(){
        System.out.println("낫싱");
    }
}
