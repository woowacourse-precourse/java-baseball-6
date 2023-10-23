package baseball.controller;

import baseball.model.NumberFormat;
import baseball.service.GameService;
import java.util.List;

public class GameController {

    public static void printInitMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public boolean checkGameResult(){
        List<Integer> result = GameService.compareNumberFormat(computerNumber, userNumber);
        printResultMessage(result.get(0), result.get(1));
        return (result.get(0) == 3) ? true : false;
    }
    public void printResultMessage(int strikeCount, int ballCount){
        if (strikeCount > 0 && ballCount > 0)
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        else if (ballCount > 0)
            System.out.println(ballCount + "볼");
        else if (strikeCount > 0)
            System.out.println(strikeCount + "스트라이크");
        else System.out.println("낫싱");
    }
}
