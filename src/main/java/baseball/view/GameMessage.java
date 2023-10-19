package baseball.view;

public class GameMessage {

    public static void inputRequirementMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void resultMessage(int ball, int strike){
        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
        } else if(ball == 0 && strike > 0 && strike <= 3){
            System.out.println(strike+"스트라이크");
        } else if(strike == 0 && ball > 0 && ball <= 3){
            System.out.println(ball+"볼");
        } else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

}
