package baseball.api;

import baseball.api.request.RequestChecker;

import java.util.stream.IntStream;

import static baseball.api.constants.MessageConstants.*;


public class GameStarter {
    private final String result;
    private int length;
    private Count count;
    private GameHelper gameHelper;
    private boolean retryFlag;

    public GameStarter(String result, boolean retryFlag, GameHelper gameHelper) {
        this.result = result;
        this.length = result.length();
        this.retryFlag = retryFlag;
        this.gameHelper = gameHelper;
    }

    public GameHelper run() throws IllegalArgumentException{
        if (!retryFlag){
            System.out.println(START_MESSAGE);
        }
        while (true){
            System.out.print(PLAY_MESSAGE);
            respondToUserGuess();

            if(isResult()){
                System.out.println(COMPLETE_MESSAGE);
                System.out.println(END_MESSAGE);
                return gameHelper;
            }
        }
    }

    private void respondToUserGuess() {
        String input = RequestChecker.gameRequest();

        count = new Count();
        IntStream.range(0, length)
                .forEach(i -> processGuessDigit(input, result, i));
        Computer.hintMessage(count.getStrikeCount(), count.getBallCount());
    }

    private void processGuessDigit(String input, String result, int index){
        char inputChar = input.charAt(index);
        char resultChar = result.charAt(index);

        if(inputChar == resultChar) {
            count.incrementStrikeCount();
        } else {
            boolean contains = result.contains(String.valueOf(inputChar));
            if (contains) {
                count.incrementBallCount();
            }
        }
    }

    private Boolean isResult() {
        return count.getStrikeCount() == length;
    }
}
