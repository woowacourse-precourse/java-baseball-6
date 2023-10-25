package baseball;

public class Msg {
    final String STARTING_Msg = "숫자 야구 게임을 시작합니다.";
    final String INPUT_Msg ="숫자를 입력해주세요 : ";
    final String ENDING_Msg ="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final String REGAME_Msg ="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final String STRIKE = "스트라이크";
    final String BALL = "볼";
    final String NOTHIG = "낫싱";

    //메시지를 출력하는 메소드
    void printMsg(String Msg){
        System.out.println(Msg);
    }
    //스트라이크나 볼 증 하나만 있을 때 메시지를 출력하는 메소드
    void printOneCase(int number, String Msg){
        System.out.println(number+Msg);
    }
    //스트라이크와 볼이 모두 있을 때 메시지를 출력하는 메소드
    void printTwoCase(int balls, int strikes){
        System.out.println(balls+BALL+" "+strikes+STRIKE);
    }

}
