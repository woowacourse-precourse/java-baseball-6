package baseball.View;

public class GameMessage {

    public  static void gameStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void askUserInput(){
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void gameResultMessage(int ballCount, int strikeCount){
        if(ballCount == 0 && strikeCount != 0){
            System.out.println(strikeCount+"스트라이크");
        }
        if(strikeCount == 0 && ballCount != 0){
            System.out.println(ballCount+"볼");
        }
        if(strikeCount == 0 && ballCount == 0){
            System.out.println("낫싱");
        }
        if(strikeCount != 0 && ballCount != 0){
            System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
        }
    }



    public static void gameoverMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static void restartMessage(){
        System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}