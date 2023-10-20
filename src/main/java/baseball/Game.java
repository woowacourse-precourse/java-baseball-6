package baseball;

import baseball.handler.UserInputHandler;

public class Game {

    private final UserInputHandler userInputHandler = new UserInputHandler();
    private boolean isCorrect = false;

    public void play() {
        String computerNumber = "425";
        while (!isCorrect) {
            String userInputNumber = userInputHandler.askUserInputNumber();
            isCorrect = getCorrect(userInputNumber, computerNumber);
        }
    }

    public boolean checkRestart() {
        return userInputHandler.askRestart();
    }

    private boolean getCorrect(String userInput, String computerNumber) {
        if (userInput.equals(computerNumber)) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        // TODO: 게임 결과 계산
        return false;
    }
}
