package baseball;

public class OutputView {

    public void printStartBaseBallGameMessage(){
        System.out.println(ProgressMessage.START_BASEBALL_GAME);
    }

    public void printInputExpectedNumberMessage(){
        System.out.println(ProgressMessage.INPUT_EXPECTED_NUMBER);
    }

    public void printStatusBallAndStrike(String message){
        System.out.println(message);
    }
}
