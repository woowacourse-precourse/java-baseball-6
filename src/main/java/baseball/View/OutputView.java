package baseball.View;

public class OutputView {
    public static String startMessage = "숫자 야구 게임을 시작합니다.";
    public static String inputMessage = "숫자를 입력해주세요 : ";
    public static String ballMessage = "볼";
    public static String strikeMessage = "스트라이크";
    public static String nashingMesaage = "낫싱";
    public static String CurrentendMessage = "3개의 숫자를 모두 맞추셨습니다! 게임 종료";

    public static String endMessage = "게임 종료";

    public static String RetryMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public static void printStart(){
        System.out.println(startMessage);
    }

    public static void printCurrentEnd(){
        System.out.println(CurrentendMessage);
    }

    public static void printEnd(){
        System.out.println(endMessage);
    }
    public static void printInput(){
        System.out.print(inputMessage);
    }

    public static void printBall(int ballCount){
        if(ballCount != 0){
            System.out.print(ballCount + ballMessage);
        }
    }

    public static void printStrike(int strikeCount){
        if(strikeCount != 0) {
            System.out.print(strikeCount + strikeMessage);
        }
    }

    public static void printNashing(){
        System.out.print(nashingMesaage);
    }

    public static void printRetry(){
        System.out.println(RetryMessage);
    }
}
