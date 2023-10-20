package baseball.view;

public class OutputView {
    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void printRoundResultMessage(int strike, int ball) {
        if(strike!=0 && ball!=0){
            System.out.println(ball+"볼" +strike+"스트라이크");
        }
        if(strike!=0 && ball==0){
            System.out.println(strike+"스트라이크");
        }
        if(strike==0 && ball!=0){
            System.out.println(ball+"볼");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }

    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
