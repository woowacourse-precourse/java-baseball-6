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
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String PLAYER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_END_MESSAGE = RANDOM_NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 " + GAME_RESTART_STATE +
            ", 종료하려면 " + GAME_END_STATE + "를 입력하세요.";

    public void gameStart() {
        boolean progress = true;

        printStartMessage();

        while(progress) {
            progress();

            progress = isRestart();
        }
    }

    private void progress() {
        boolean isCorrect = false;
        List<Integer> computerNumbers = getRandomNumber();
        List<Integer> playerNumbers;

        while(!isCorrect) {
            playerNumbers = getPlayerNumber();
            isCorrect = compareNumber(computerNumbers, playerNumbers);
        }

        printEndMessage();
    }

    private boolean isRestart() {
        printRestartQuestionMessage();
        String inputState = Console.readLine();

        if(inputState.equals(GAME_RESTART_STATE)){
            return true;
        }

        if (inputState.equals(GAME_END_STATE)) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    private void printRestartQuestionMessage() {
        System.out.println(GAME_RESTART_MESSAGE);
    }

    private void printEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

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
        printPlayerInputMessage();
        return inputPlayerNumber();
    }

    private List<Integer> inputPlayerNumber() {
        String playerInput = Console.readLine();
        List<Integer> playerNumbers = parseToNumberList(playerInput);

        validateInput(playerNumbers);

        return playerNumbers;
    }

    private void validateInput(List<Integer> input) {
        if(!isUniqueDigits(input) || !isValidLength(input)) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> parseToNumberList(String convertValue) {
        if(!isNumeric(convertValue)) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(convertValue.split(""))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }

    private void printPlayerInputMessage() {
        System.out.print(PLAYER_INPUT_MESSAGE);
    }

    private void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    private List<Integer> getRandomNumber() {
        Set<Integer> computerNumber = new HashSet<>();

        while(computerNumber.size() < RANDOM_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            computerNumber.add(randomNumber);
        }

        return computerNumber.stream().toList();
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
