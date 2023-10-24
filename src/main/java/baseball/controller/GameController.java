package baseball.controller;

import baseball.model.NumberFormat;
import baseball.model.RoundResult;
import baseball.service.GameService;

public class GameController {

    private NumberFormat computerNumber;
    private NumberFormat userNumber;
    public static void printInitMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printEndMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public boolean checkIfRoundEnd(){
        RoundResult result = GameService.compareNumberFormat(computerNumber, userNumber);
        printResultMessage(result);
        return result.isRoundEnd();
    }
    public void printResultMessage(RoundResult result){
        int strikeCount = result.strikeCount();
        int ballCount = result.ballCount();
        if (strikeCount > 0 && ballCount > 0)
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        else if (ballCount > 0)
            System.out.println(ballCount + "볼");
        else if (strikeCount > 0)
            System.out.println(strikeCount + "스트라이크");
        else System.out.println("낫싱");
    }

    public void setComputerNumber(NumberFormat computerNumber) {
        this.computerNumber = computerNumber;
    }

    public void setUserNumber(NumberFormat userNumber) {
        this.userNumber = userNumber;
    }
}
