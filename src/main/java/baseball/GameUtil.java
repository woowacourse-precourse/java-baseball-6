package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;

public class GameUtil {
    String answer;
    String userInput;

    public GameUtil() {
        System.out.println(Constants.START_COMMENT);
    }

    public void settingGame() {
        this.answer = makeAnswer();
    }

    private String makeAnswer() {
        ArrayList<Integer> numberList = new ArrayList<>();
        while (numberList.size() < Constants.GAME_NUM_LENGTH){
            int randomValue = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomValue)) numberList.add(randomValue);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < Constants.GAME_NUM_LENGTH; i++) {
            answer.append(numberList.get(i));
        }
        return answer.toString();
    }

    public void receiveUserInput() {
        System.out.print(Constants.RECEIVE_USER_INPUT_COMMENT);
        this.userInput = Console.readLine();

        validateInput(this.userInput);
    }

    private void validateInput(String userInput) {
        if (userInput.length() != Constants.GAME_NUM_LENGTH) {
            throw new IllegalArgumentException();
        }
        else {
            HashMap<Character, Integer> countChar = new HashMap<>();
            for (int i = 0; i < Constants.GAME_NUM_LENGTH; i++) {
                if (countChar.containsKey(userInput.charAt(i)) || userInput.charAt(i) == '0') {
                    throw new IllegalArgumentException();
                } else {
                    countChar.put(userInput.charAt(i), 1);
                }
            }
        }
    }

    public Boolean compareUserInputWithAnswer() {
        Integer ballCount = findBall(this.userInput, this.answer);
        Integer strikeCount = findStrike(this.userInput, this.answer);

        String comment = Constants.NOT_MATCH_COMMENT;

        if (ballCount == 0 && strikeCount > 0) {
            comment = String.format(Constants.STRIKE_COMMENT, strikeCount);
        } else if (ballCount > 0 && strikeCount == 0) {
            comment = String.format(Constants.BALL_COMMENT, ballCount);
        } else if (ballCount > 0 && strikeCount > 0){
            comment = String.format(Constants.BALL_AND_STRIKE_COMMENT, ballCount, strikeCount);
        }

        System.out.println(comment);
        return strikeCount.equals(Constants.GAME_NUM_LENGTH);
    }

    private Integer findBall(String userInput, String answer) {
        int ballCount = 0;

        for (int i = 0; i < Constants.GAME_NUM_LENGTH; i++) {
            if (userInput.charAt(i) != answer.charAt(i) && answer.indexOf(userInput.charAt(i)) != -1) ballCount += 1;
        }

        return ballCount;
    }

    private Integer findStrike(String userInput, String answer) {
        int strikeCount = 0;

        for (int i = 0; i < Constants.GAME_NUM_LENGTH; i++) {
            if (userInput.charAt(i) == answer.charAt(i)) {
                strikeCount += 1;
            }
        }

        return strikeCount;
    }

    public Boolean checkIsContinue() {
        System.out.println(Constants.END_COMMENT);
        System.out.println(Constants.ASK_CONTINUE_COMMENT);

        String userInput = Console.readLine();
        return (userInput.equals(Constants.CONTINUE_INPUT));
    }
}
