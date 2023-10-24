package baseball.view;
public class OutputView {
    public void displayMessage(String message){
        System.out.println(message);
    }
    public void nolineDisplayMessage(String message){
        System.out.print(message);
    }
    public void displayScore(int ballCount, int strikeCount){
        System.out.printf("%d볼 %d스트라이크\n",ballCount,strikeCount);
    }
    public void displayBallScore(int ballCount){
        System.out.printf("%d볼\n",ballCount);
    }
    public void displayStrikeScore(int strikeCount){
        System.out.printf("%d스트라이크\n",strikeCount);
    }



}
