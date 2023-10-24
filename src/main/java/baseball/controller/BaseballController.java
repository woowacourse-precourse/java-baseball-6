package baseball.controller;

import baseball.model.BaseballModel;
import baseball.view.BaseballView;

public class BaseballController {

    private BaseballModel model;
    private BaseballView view;

    public BaseballController() {
        model = new BaseballModel();
        view = new BaseballView();
    }

    //게임 시작
    public void playGame() {
        view.displayGameStartMessage();

        boolean shouldRestart = true;

        while (shouldRestart) {

            int[] guess = view.getUserGuess();
            int[] targetNumber = model.getTargetNumber();

            try {
                if (!isValidInput(guess)) {
                    throw new IllegalArgumentException("서로 다른 수를 입력해야 합니다.");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                break;
            }

            int[] result = calculateResult(targetNumber, guess);
            view.displayResult(result[0], result[1]);

            if (result[1] == 3) {
                view.displayGameWon();
                int choice = view.getRestartChoice();
                if (choice == 2) {
                    shouldRestart = false; // 게임 종료
                } else if (choice == 1) {
                    shouldRestart = true; // 게임 재시작
                    model = new BaseballModel(); // 게임 재시작 시에 새로운 난수 생성
                }
            }
        }
    }

    // 유저 입력이 서로 다른 숫자인지 확인
    private boolean isValidInput(int[] guess) {
        for (int i = 0; i < guess.length; i++) {
            for (int j = i + 1; j < guess.length; j++) {
                if (guess[i] == guess[j]) {
                    return false; // 중복된 숫자가 있다면 유효하지 않음
                }
            }
        }

        return true;
    }

    // ball, strikes 계산 로직
    private int[] calculateResult(int[] targetNumber, int[] guess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < targetNumber.length; i++) {
            for (int j = 0; j < guess.length; j++) {
                if (targetNumber[i] == guess[j]) {
                    if (i == j) {
                        strikes++; // 같은 숫자가 같은 위치에 있으면 스트라이크
                    } else if (i != j){
                        balls++; // 같은 숫자가 다른 위치에 있으면 볼
                    } else return new int[] { balls, strikes }; //낫싱
                }
            }
        }

        return new int[] { balls, strikes };
    }

}

