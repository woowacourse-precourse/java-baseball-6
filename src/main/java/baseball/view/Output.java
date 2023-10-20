package baseball.view;

import baseball.model.BallCount;

import java.util.List;

public class Output {

    public static void Start_Message() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void Input_Message() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void Output_Message(List<Integer> answerList, String UserInput) {
        int ball = BallCount.Ball(answerList, UserInput);
        int strike = BallCount.Strike(answerList, UserInput);
        String output = "";
        if (ball == 0 && strike == 0) {
            output += "낫싱";
        }
        if (ball != 0) {
            output += Integer.toString(ball) + "볼 ";
        }
        if (strike != 0) {
            output += Integer.toString(strike) + "스트라이크";
        }
        System.out.println(output);
    }

    public static void Output_Message_end() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
