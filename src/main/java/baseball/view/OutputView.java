package baseball.view;

import baseball.dto.BaseballGameResultDto;

public class OutputView {
    public void printGreet(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResult(BaseballGameResultDto result) {
        String message = getBallMessage(result.getBall()) + getStrikeMessage(result.getStrike());
        if (checkNothing(result)){
            message = "낫싱";
        }
        System.out.println(message);
    }

    public boolean checkNothing(BaseballGameResultDto result){
        return (result.getStrike() + result.getBall()) == 0;
    }

    private String getStrikeMessage(int strike) {
        String strikeMessage = "";
        if (strike > 0){
            strikeMessage =  strike + "스트라이크";
        }
        return strikeMessage;
    }

    private String getBallMessage(int ball) {
        String ballMessage = "";
        if (ball > 0){
            ballMessage = ball + "볼 ";
        }
        return ballMessage;
    }
}
