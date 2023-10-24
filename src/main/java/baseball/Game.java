package baseball;

import java.util.List;

public class Game {
    public void startGame() {
        Rule rule = new Rule(100, 999, 3, 1, 2);

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isPlaying = true;
        while (isPlaying) {
            playGame(rule);
            isPlaying = askToPlayAgain(rule);
        }
        System.out.println("게임 종료");
    }

    /**
     * 사용자에게 게임을 다시 시작할 것인지 물어봅니다.
     *
     * @return 사용자가 게임을 다시 시작하려면 true, 종료하려면 false
     */
    private boolean askToPlayAgain(Rule rule) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userChoice = InputHandler.getUserGameChoiceInput(rule);
        return userChoice == 1;
    }

    /**
     * 숫자 야구 게임을 진행합니다. Rule 객체를 통해 NumberGenerator 객체를 생성하고, NumberGenerator 객체가 랜덤한 숫자를 생성합니다. 사용자로부터 입력을 받아 Referee
     * 객체를 통해 결과를 계산하고, DisplayManager 객체를 통해 결과를 출력합니다. 사용자가 3 스트라이크를 달성할 때까지 반복합니다.
     *
     * @param rule 숫자 야구 게임의 규칙을 담고 있는 Rule 객체
     */
    private void playGame(Rule rule) {
        NumberGenerator numberGenerator = new NumberGenerator(rule);
        List<Integer> randomNumbers = numberGenerator.generateRandomNumbers();
        Referee referee = new Referee(rule);
        while (true) {
            int userNumber = InputHandler.getUserGameNumberInput(rule);

            int[] result = referee.compareNumbers(randomNumbers, userNumber);
            DisplayManager.printResult(result);
            if (result[0] == rule.getNumberOfDigits()) {
                break;
            }
        }
    }

}
