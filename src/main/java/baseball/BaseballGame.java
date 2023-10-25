package baseball;
import camp.nextstep.edu.missionutils.Console;
public class BaseballGame {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            playGame();
        } while (wantsToPlayAgain());

        System.out.println("게임을 종료합니다.");
    }

    private static void playGame() {
        int[] answer = NumberGenerator.getRandomUniqueNumber();
        boolean gameWon = false;

        while (!gameWon) {
            int[] input = InputNumber.getInput();
            String result = Judge.judge(answer, input);
            System.out.println(result);
            if (result.equals("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")) {
                gameWon = true;
            }
        }
    }

    private static boolean wantsToPlayAgain() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: \n");
        String input = Console.readLine();
        return "1".equals(input);
    }
}


