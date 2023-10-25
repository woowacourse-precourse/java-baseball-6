package baseball.view;

public class OutputArea {
    public static void GameStartText(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void BallText(int count){
        System.out.print(count + "볼");
    }
    public static void StrikeText(int count){
        System.out.println(count + "스트라이크");
    }

    public static void NoneText(){
        System.out.println("낫싱");
    }

    public static void GameClearText(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}