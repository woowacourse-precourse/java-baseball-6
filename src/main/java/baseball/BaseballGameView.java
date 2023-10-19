package baseball;

public class BaseballGameView {

    public BaseballGameView() {}

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputGuideMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public String printBallCount(BallCount ballCount){
        int strike = ballCount.getStrike();
        int ball = ballCount.getBall();
        String resultMessage;

        if(strike > 0 && ball > 0){
            resultMessage = String.format("%d볼 %d스트라이크", ball, strike);
            System.out.println(resultMessage);
            return resultMessage;
        }

        if(strike == 0 && ball > 0){
            resultMessage = String.format("%d볼", ball);
            System.out.println(resultMessage);
            return resultMessage;
        }

        if(strike > 0 && ball == 0){
            resultMessage = String.format("%d스트라이크", strike);
            System.out.println(resultMessage);
            return resultMessage;
        }

        resultMessage = "낫싱";
        System.out.println(resultMessage);
        return resultMessage;
    }
}
