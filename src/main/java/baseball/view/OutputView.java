package baseball.view;

public class OutputView {

    public static void printGameInitMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printOnlyBallCountMessage(String ball){
        System.out.println(ball+"볼");

    }

    public static void printOnlyStrikeCountMessage(String strike){
        System.out.println(strike+"스트라이크");
    }


    public static void printBallAndStrikeCountMessage(String ball,String strike){
        System.out.println(ball+"볼"+" " + strike+"스트라이크");
    }

    public static void printNothingMessage(){
        System.out.println("낫싱");
    }




}
