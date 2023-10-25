package baseball.controller;

import baseball.model.BaseballGameModel;
import baseball.view.BaseballGameView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BaseballGameController {

    private final BaseballGameModel baseballGameModel;
    private final BaseballGameView baseballGameView;
    private boolean isFirstGame = true;

    public BaseballGameController(BaseballGameModel baseballGameModel, BaseballGameView baseballGameView) {
        this.baseballGameModel = baseballGameModel;
        this.baseballGameView = baseballGameView;
    }

    public void playGame() {
        if (isFirstGame) {
            baseballGameView.displayStartMessage();
            baseballGameModel.generateRandomNumbers();
            isFirstGame = false;
        }

        List<Integer> computerNumbers = baseballGameModel.getComputerNumbers();

        String userInput = baseballGameView.getUserInput();
        List<Integer> processedUserInput = processInput(userInput, 3);

        HashMap<String, Integer> computeResult = computeResult(processedUserInput, computerNumbers);
        baseballGameView.displayResult(computeResult);

        if (computeResult.get("strike") == computerNumbers.size()) {
            handleGameEnd();
        } else {
            playGame();
        }


    }

    public List<Integer> processInput(String userInput, int length_limit) {
        ArrayList<Integer> processedValues = new ArrayList<>();
        HashSet<Integer> integerHashSet = new HashSet<>();

        if (userInput.length() != length_limit) {
            throw new IllegalArgumentException("입력값은 세 자리여야 합니다.");
        }


        for (char c : userInput.toCharArray()) {

            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
            }

            int parseResult = Character.getNumericValue(c);
            if (!integerHashSet.add(parseResult)) {
                throw new IllegalArgumentException("입력값이 서로 다른 숫자여야 합니다.");
            }

            processedValues.add(parseResult);
        }


        return processedValues;
    }

    public HashMap<String, Integer> computeResult(List<Integer> userNumbers, List<Integer> computerNumbers) {
        ArrayList<Integer> copyComputerNumbers = new ArrayList<>();
        HashMap<String, Integer> resultHashMap = new HashMap<String, Integer>();
        int strikes = 0;
        int balls = 0;
        copyComputerNumbers.addAll(computerNumbers);

        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.get(i).equals(copyComputerNumbers.get(i))) {
                strikes++;
                userNumbers.remove(i);
                copyComputerNumbers.remove(i);
                i--;
            }
        }

        for (int i = 0; i < userNumbers.size(); i++) {
            for (int j = 0; j < copyComputerNumbers.size(); j++) {
                if (userNumbers.get(i).equals(copyComputerNumbers.get(j))) {
                    balls++;
                    userNumbers.remove(i);
                    copyComputerNumbers.remove(j);
                    i--;
                    break;
                }
            }
        }
        resultHashMap.put("strike", strikes);
        resultHashMap.put("ball", balls);
        return resultHashMap;
    }

    public void handleGameEnd() {
        List<Integer> restartChoice = processInput(baseballGameView.getUserRestartInput(), 1);

        if (restartChoice.get(0) != 1 && restartChoice.get(0) != 2){
            throw new IllegalArgumentException("입력값은 1 또는 2여야 합니다.");
        }
        else if (restartChoice.get(0) == 1) {
            baseballGameModel.clearComputerNumbers();
            baseballGameModel.generateRandomNumbers();
            playGame();
        }

    }

}
