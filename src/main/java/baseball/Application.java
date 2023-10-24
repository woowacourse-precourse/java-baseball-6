package baseball;


import java.util.List;

public class Application {
    private static final Utils utils = new Utils();
    private static final Logic logic = new Logic();

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }

    private static void playGame() {
        List<Integer> computer = utils.generateRandomNumbers();
        boolean isContinue = true;

        while (isContinue) {
            int[] userGuess = logic.getUserGuess();
            int[] result = logic.calculateResult(userGuess, computer);

            utils.displayResult(result);

            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isContinue = logic.askForRestart();
                if(!isContinue) break;
                computer = utils.generateRandomNumbers();
            }
        }
    }
}
