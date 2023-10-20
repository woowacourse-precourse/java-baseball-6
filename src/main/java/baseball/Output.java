package baseball;

public class Output {
    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printStrikeBallMessage(int strike,int ball) {
        System.out.println(chooseStrikeBallMessage(strike, ball));
    }

    private String chooseStrikeBallMessage(int strike, int ball) {
        if(strike==0 & ball==0) {
            return "낫싱";
        }
        if(strike==3) {
            return strike + "스트라이크\n" + strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        return (ball + "볼 " + strike +"스트라이크");
    }

    public void printSelectRestartMessage() {
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n",1,2);
    }
}
