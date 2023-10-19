package baseball;

public class BaseballGameView {

    public BaseballGameView() {}

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputGuideMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printEndMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRestartMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
