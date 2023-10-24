package baseball.view;

import baseball.dto.GameResultDto;

public class Output {

    public void printGreet() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void printRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public void printResult(GameResultDto result) {
        String message = getBallMessage(result.getBall()) + " " + getStrikeMessage(result.getStrike()).trim();
        if (checkNothing(result))
            message = "낫싱";

        System.out.println(message);
    }

    private boolean checkNothing(GameResultDto result) {
        return (result.getStrike() + result.getBall()) == 0;
    }

    private String getStrikeMessage(int strike) {
        String strikeMessage = "";
        if (0 < strike)
            strikeMessage = strike + "스트라이크";
        return strikeMessage;
    }
    private String getBallMessage(int ball) {
        String ballMessage = "";
        if (0 < ball)
            ballMessage = ball + "볼";
        return ballMessage;
    }

}
