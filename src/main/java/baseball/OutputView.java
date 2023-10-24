package baseball;

import java.util.List;

class Message{
    public static final String Start = "숫자 야구 게임을 시작합니다.";
    public static final String GetInput = "숫자를 입력해주세요 : ";
    public static final String Ball = "볼";
    public static final String Strike = "스트라이크";
    public static final String Nothing = "낫싱";
    public static final String Match = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String Restart = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
}

public class OutputView {

    public static void printStart(){
        System.out.println(Message.Start);
    }

    public static void printInput(){
        System.out.println(Message.GetInput);
    }

    public static void printResult(List<Integer> ballCount){
        int ball = ballCount.get(0);
        int strike = ballCount.get(1);
        if (ball == 0 && strike == 0){
            System.out.println(Message.Nothing);
            return;
        }
        System.out.println(ball + Message.Ball + " " + strike + Message.Strike);
    }

    public static void printRestart(){
        System.out.println(Message.Match);
        System.out.println(Message.Restart);
    }

}
