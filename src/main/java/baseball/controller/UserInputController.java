package baseball.controller;

import baseball.constants.Constants;
import baseball.model.UserNumber;
import baseball.view.StartView;
import baseball.view.EndView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputController {
    private List<List<Integer>> duplicatedNum = new ArrayList<>();
    private StartView startView = new StartView();
    private EndView endView = new EndView();

    public UserNumber getUserInputNumber() {
        while (true) {
            System.out.print(Constants.USER_INPUT_MESSAGE);
            String userInput = Console.readLine();
            if (isValidInput(userInput)) {
                List<Integer> userNumber = changeUserInputNumber(userInput);
                if (!containsNumber(duplicatedNum, userNumber)) {
                    duplicatedNum.add(userNumber);
                    return new UserNumber(userNumber);
                }
            } else {
                throw new IllegalArgumentException(Constants.ERROR_MESSAGE);
            }
        }
    }

    private boolean isValidInput(String input) {
        return input.matches("^[1-9]\\d{2}$");
    }

    private boolean containsNumber(List<List<Integer>> numbersList, List<Integer> target) {
        for (List<Integer> numbers : numbersList) {
            if (numbers.equals(target)) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> changeUserInputNumber(String userInputNumber) {
        List<Integer> inputNumber = new ArrayList<>();
        for (int i = 0; i < userInputNumber.length(); i++) {
            char currentChar = userInputNumber.charAt(i);
            int changeType = Integer.parseInt(String.valueOf(currentChar));
            inputNumber.add(changeType);
        }
        return inputNumber;
    }

    public boolean getRestartInput() {
        endView.displayRestartMessage();
        while (true) {
            try {
                int restartInput = Integer.parseInt(Console.readLine());
                if (restartInput == Constants.RESTART_GAME_NUMBER) {
                    return true;
                } else if (restartInput == Constants.END_GAME_NUMBER) {
                    System.out.println("게임 종료");
                    return false;
                } else {
                    System.out.println(Constants.RETRY_MESSAGE);
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요.");
            }
        }
    }

    public int getExitInput() {
        return 0;
    }

    public void resetDuplicateNumber() {
        this.duplicatedNum = new ArrayList<>();
        return;
    }
}
