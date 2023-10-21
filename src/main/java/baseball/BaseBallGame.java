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



    private boolean compareNumber(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = getStrikeCount(computerNumbers, playerNumbers);
        int ballCount = getBallCount(computerNumbers, playerNumbers);

        printHint(strikeCount, ballCount);

        return strikeCount == RANDOM_NUMBER_LENGTH;
    }

    private void printHint(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();

        if(ballCount > 0) {
            sb.append(ballCount).append("볼");
            sb.append(" ");
        }

        if(strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }

        if(ballCount == 0 && strikeCount == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }

    private int getBallCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ballCount = 0;

        for(int i = 0; i < RANDOM_NUMBER_LENGTH; i++) {
            int playerNumber = playerNumbers.get(i);

            if (!computerNumbers.get(i).equals(playerNumber) && computerNumbers.contains(playerNumber)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private int getStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = 0;

        for(int i = 0; i < RANDOM_NUMBER_LENGTH; i++) {
            if(computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private List<Integer> getPlayerNumber() {
        return inputPlayerNumber();
    }

    private List<Integer> inputPlayerNumber() {
        String playerInput = Console.readLine();
        List<Integer> playerNumbers = parseToNumberList(playerInput);

        validateInput(playerNumbers);

        return playerNumbers;
    }

    private void validateInput(List<Integer> input) {
        if(!isUniqueDigits(input) || !isValidLength(input) || !isValidRange(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> parseToNumberList(String convertValue) {
        if(!isNumeric(convertValue)) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(convertValue.split(""))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }



    private boolean isNumeric(String input) {
        for(char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean isUniqueDigits(List<Integer> numbers) {
        Set<Integer> deduplicatedNumbers = new HashSet<>(numbers);

        return deduplicatedNumbers.size() == numbers.size();
    }

    private boolean isValidLength(List<Integer> numbers) {
        return numbers.size() == RANDOM_NUMBER_LENGTH;
    }
}
