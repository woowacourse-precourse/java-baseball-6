package baseball.controller;

import baseball.domain.GameNumber;
import baseball.domain.GuessResult;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseBallController {

    static GameNumber pickComputerNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return new GameNumber(computerNumbers);
    }

    static GuessResult createGuessResult(GameNumber computer, GameNumber user) {
        int ballCount = 0;
        int strikeCount = 0;
        List<Integer> userNumbers = user.numbers();
        List<Integer> computerNumbers = computer.numbers();

        for (int i = 0; i < 3; i++) {
            int userNumber = userNumbers.get(i);
            int computerNumber = computerNumbers.get(i);

            if (userNumber == computerNumber) {
                strikeCount++;
                continue;
            }

            if (computerNumbers.contains(userNumber)) {
                ballCount++;
            }
        }

        return new GuessResult(ballCount, strikeCount);
    }

    static void printGuessResult(GuessResult guessResult) {
        StringBuilder sb = new StringBuilder();
        if (guessResult.hasBall()) {
            sb.append(guessResult.ballCount()).append("볼 ");
        }
        if (guessResult.hasStrike()) {
            sb.append(guessResult.strikeCount()).append("스트라이크");
        }
        if (sb.isEmpty()) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
    }

    static void play() {
        GameNumber computer = pickComputerNumber();
        boolean isGameProceed = true;
        while (isGameProceed) {
            GameNumber user = InputView.readUserNumber();
            GuessResult guessResult = createGuessResult(computer, user);
            printGuessResult(guessResult);
            if (guessResult.isAllStrike()) {
                isGameProceed = false;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean shouldPlay = true;
        while (shouldPlay) {
            play();
            shouldPlay = InputView.readShouldReplay();
        }
    }

}
