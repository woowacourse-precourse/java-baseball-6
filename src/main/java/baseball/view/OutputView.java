package baseball.view;

public class OutputView {
    public final String ballMessage = "볼 ";
    public final String strikeMessage = "스트라이크 ";
    public final String nothingMessage = "낫싱";

    public void printResultMessage(int strike, int ball){
        if(ball != 0){
            System.out.print(ball + ballMessage);
        }
        if(strike != 0){
            System.out.print(strike + strikeMessage);
        }
        if(ball == 0 && strike == 0){
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
