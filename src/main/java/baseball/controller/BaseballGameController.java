package baseball.controller;

import baseball.model.BaseballGame;
import baseball.view.BaseballGameView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {
    private BaseballGame game = new BaseballGame(); // BaseballGame 모델을 생성
    private BaseballGameView view = new BaseballGameView(); // 사용자 인터페이스(View)를 생성

    public void runGame() {
        view.displayStartMessage(); // 게임 시작 메시지 출력

        while (true) {
            List<Integer> computer = generateRandomNumbers(); // 무작위 3자리 숫자 생성
            game.setComputer(computer); // 컴퓨터가 선택한 숫자를 모델에 설정
            boolean isGameWon = false;

            while (!isGameWon) {
                List<Integer> userGuess = getUserGuess(); // 사용자로부터 3자리 숫자 입력 받음
                List<Integer> result = game.calculateResult(userGuess); // 입력 숫자와 컴퓨터 숫자 비교하여 결과 계산
                printResult(result); // 게임 결과 출력

                if (result.get(0) == 3) { // 3 스트라이크인 경우, 게임 종료
                    isGameWon = true;
                    view.displayGameWonMessage(); // "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 메시지 출력
                }
            }

            view.displayRestartOrExitMessage(); // 게임 재시작 또는 종료 선택 메시지 출력
            int choice = Integer.parseInt(Console.readLine()); // 사용자의 선택 받음

            if (choice == 2) { // 선택이 2인 경우, 게임 종료
                break;
            }
        }
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9); // 1에서 9 사이의 무작위 숫자 선택
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber); // 중복되지 않는 숫자로 구성된 컴퓨터 숫자 생성
            }
        }
        return computer;
    }

    private List<Integer> getUserGuess() {
        view.displayGuessMessage(); // 사용자로부터 숫자 입력 요청 메시지 출력
        String input = Console.readLine(); // 사용자의 입력 받음

        if (input.length() != 3) {
            view.displayErrorMessage("3자리 숫자를 입력해야 합니다."); // 오류 메시지 출력
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다."); // 예외 처리
        }

        List<Integer> userGuess = new ArrayList<>();
        for (char digit : input.toCharArray()) {
            int number = Character.getNumericValue(digit);
            if (number < 1 || number > 9) {
                view.displayErrorMessage("1에서 9 사이의 숫자만 입력해야 합니다."); // 오류 메시지 출력
                throw new IllegalArgumentException("1에서 9 사이의 숫자만 입력해야 합니다."); // 예외 처리
            }
            userGuess.add(number); // 유효한 입력을 숫자 리스트에 추가
        }
        return userGuess;
    }

    private void printResult(List<Integer> result) {
        int strike = result.get(0);
        int ball = result.get(1);

        if (strike == 0 && ball == 0) {
            view.displayErrorMessage("낫싱"); // "낫싱" 메시지 출력
        } else if (strike == 0) {
            view.displayErrorMessage(ball + "볼"); // 볼 개수 출력
        } else if (ball == 0) {
            view.displayErrorMessage(strike + "스트라이크"); // 스트라이크 개수 출력
        } else {
            view.displayErrorMessage(ball + "볼 " + strike + "스트라이크"); // 볼과 스트라이크 개수 출력
        }
    }
}
