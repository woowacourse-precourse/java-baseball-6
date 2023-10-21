package view;

public class GameView {

    public GameView() {}

    public void printStartMessage() {
        System.out.println(ComputerMessage.START_MESSAGE.message());
    }

    public void printInputNumbersMessage() {
        System.out.print(ComputerMessage.INPUT_NUMBERS_MESSAGE.message());
    }

    public void printEndMessage() {
        String message = String.join(
                "\n",ComputerMessage.END_MESSAGE.message(), ComputerMessage.REGANE_MESSAGE.message());
        System.out.println(message);
    }

    public void printCountMessage(int[] ballStrike) {
        String ball = ballStrike[0] + ComputerMessage.BALL.message();
        String strike = ballStrike[1] + ComputerMessage.STRIKE.message();
        if(ballStrike[0] > 0 && ballStrike[1] > 0) {
            System.out.println(String.join(" ",ball,strike));
        }else if(ballStrike[0] == 0 && ballStrike[1] > 0) {
            System.out.println(strike);
        }else if(ballStrike[0] > 0 && ballStrike[1] == 0) {
            System.out.println(ball);
        }else if(ballStrike[0] == 0 && ballStrike[1] == 0) {
            System.out.println(ComputerMessage.NOTHING.message());
        }
    }

}
