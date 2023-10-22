package baseball.view;

public class OutputView {

    public final String gameStartMessage = "숫자 야구 게임을 시작합니다.";

    public final String matchAllNumberMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public final String ballMessage = "볼 ";

    public final String strikeMessage = "스트라이크 ";

    public final String nothingMessage = "낫싱";

    public void printGameStartMessage(){
        System.out.println(gameStartMessage);
    }
    public void printMatchAllNumberMessage(){
        System.out.println(matchAllNumberMessage);
    }

    public void printResultMessage(int strike, int ball){
        if(ball != 0){
            System.out.print(ball + ballMessage);
        }
        if(strike != 0){
            System.out.print(strike + strikeMessage);
        }
        if(ball == 0 && strike == 0){
            System.out.print(nothingMessage);
        }
        System.out.println();
    }
}
