package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {

    private InputValidator validator;
    private List<Integer> randomNumbers;

    public GameService() {
        this.validator = new InputValidator();
        this.randomNumbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public String validateInput(String userInput) {
        validator.validate(userInput);
        return generateResultMessage(userInput);
    }

    private String generateResultMessage(String userInput) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < userInput.length(); i++) {
            if (isStrike(userInput, i)) {
                strikeCount++;
            } else if (isBall(userInput, i)) {
                ballCount++;
            }
        }

        return getResultMessage(ballCount, strikeCount);
    }

    private boolean isStrike(String userInput, int index) {
        return Character.getNumericValue(userInput.charAt(index)) == randomNumbers.get(index);
    }

    private boolean isBall(String userInput, int index) {
        if (index >= randomNumbers.size()) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        int number = Character.getNumericValue(userInput.charAt(index));

        return randomNumbers.contains(number) && !isStrike(userInput, index);
    }
    private String getResultMessage(int ballCount, int strikeCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        StringBuilder resultMessageBuilder = new StringBuilder();

        if(ballCount > 0){
            resultMessageBuilder.append(ballCount).append("볼 ");
        }

        if(strikeCount > 0){
            resultMessageBuilder.append(strikeCount).append("스트라이크");
        }

        // remove the trailing space at the end of the message
        return resultMessageBuilder.toString().trim();
    }
}