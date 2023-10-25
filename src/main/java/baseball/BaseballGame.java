package baseball;

import baseball.model.Score;

import java.util.List;

public class BaseballGame {

    // 시스템 실행 여부
    private boolean isProgress = true;

    final private UserInputManager userInputManager;
    final private RandomNumberGenerator randomNumberGenerator;
    final private ScoreCalculator scoreCalculator;

    public BaseballGame(UserInputManager userInputManager, RandomNumberGenerator randomNumberGenerator, ScoreCalculator scoreCalculator) {
        this.userInputManager = userInputManager;
        this.randomNumberGenerator = randomNumberGenerator;
        this.scoreCalculator = scoreCalculator;
    }

    // 전체 프로세스 실행
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isProgress) {
            List<Integer> randomNumbers = randomNumberGenerator.generate();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> inputNumbers = userInputManager.processNumberInput();
                Score score = scoreCalculator.evaluate(randomNumbers, inputNumbers);

                printScore(score);

                if (score.getStrike() == 3) {
                    break;
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isProgress = userInputManager.processRestartSelectionInput();
        }
    }

    // 점수에 따른 결과 출력
    private void printScore(Score score) {
        String result = "";

        if (score.getStrike() == 0 && score.getBall() == 0) {
            result = "낫싱";
        }
        if (score.getBall() != 0) {
            result += score.getBall() + "볼 ";
        }
        if (score.getStrike() != 0) {
            result += score.getStrike() + "스트라이크 ";
        }

        System.out.println(result);
    }
}
