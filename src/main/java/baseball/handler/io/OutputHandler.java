package baseball.handler.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputHandler {

    private OutputHandler(){
    }
    public static void startGame() {
        System.out.println("숫자 야구게임을 시작합니다.");
    }
    public static String correctAnswer() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
    public static void porvideHint(Map<String, Integer> hint){

        int ball = hint.get("ball");
        int strike = hint.get("strike");

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if(ball>0){
            System.out.println(ball + "볼");
        }
        if(strike > 0) {
            System.out.println(strike + "스트라이크");
        }

        System.out.println();
    }

}
