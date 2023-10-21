package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseBallGame {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int RANDOM_NUMBER_LENGTH = 3;
    private static final String GAME_RESTART_STATE = "1";
    private static final String GAME_END_STATE = "2";


    public void gameStart() {
        boolean progress = true;

//        printStartMessage();

        while(progress) {
            progress();

//            progress = isRestart();
        }
    }

    private void progress() {
        boolean isCorrect = false;
//        List<Integer> computerNumbers = getRandomNumber();
        List<Integer> playerNumbers;

        while(!isCorrect) {
            playerNumbers = getPlayerNumber();
//            isCorrect = compareNumber(computerNumbers, playerNumbers);
        }

//        printEndMessage();
    }

//    private boolean isRestart() {
//        printRestartQuestionMessage();
//        String inputState = Console.readLine();
//
//        if(inputState.equals(GAME_RESTART_STATE)){
//            return true;
//        }
//
//        if (inputState.equals(GAME_END_STATE)) {
//            return false;
//        }
//
//        throw new IllegalArgumentException();
//    }



//    private boolean compareNumber(List<Integer> computerNumbers, List<Integer> playerNumbers) {
//        int strikeCount = getStrikeCount(computerNumbers, playerNumbers);
//        int ballCount = getBallCount(computerNumbers, playerNumbers);
//
//        printHint(strikeCount, ballCount);
//
//        return strikeCount == RANDOM_NUMBER_LENGTH;
//    }

    private List<Integer> getPlayerNumber() {
        return inputPlayerNumber();
    }

    private List<Integer> inputPlayerNumber() {
        String playerInput = Console.readLine();
        List<Integer> playerNumbers = parseToNumberList(playerInput);

//        validateInput(playerNumbers);

        return playerNumbers;
    }

//    private void validateInput(List<Integer> input) {
//        if(!isUniqueDigits(input) || !isValidLength(input) || !isValidRange(input)) {
//            throw new IllegalArgumentException();
//        }
//    }

    private boolean isValidRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> parseToNumberList(String convertValue) {
//        if(!isNumeric(convertValue)) {
//            throw new IllegalArgumentException();
//        }

        return Arrays.stream(convertValue.split(""))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }





}
