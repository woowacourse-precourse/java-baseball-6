package baseball.view;

public class OutputView {


    public OutputView(String [] result){
        if(!result[0].equals("0")&&result[1].equals("0")) printOnlyBallCountMessage(result[0]);
        if(!result[1].equals("0")&&result[0].equals("0")) printOnlyStrikeCountMessage(result[1]);
        if(!result[0].equals("0")&&!result[1].equals("0")) printBallAndStrikeCountMessage(result[0],result[1]);
        if(result[0].equals("0")&&result[1].equals("0"))printNothingMessage();
    }


    public static void printGameInitMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printOnlyBallCountMessage(String ball){
        System.out.println(ball+"볼 ");
    }

    public static void printOnlyStrikeCountMessage(String strike){
        System.out.println(strike+"스트라이크");
    }

    public static void printBallAndStrikeCountMessage(String ball,String strike){
        System.out.println(ball+"볼 "+strike+"스트라이크");
    }



    public static void printNothingMessage(){
        System.out.println("낫싱");
    }

    public static void printAnswerMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestartGameMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }




}
