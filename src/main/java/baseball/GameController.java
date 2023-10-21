package baseball;

public class GameController {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String ANSWER_RESULT = "3스트라이크";
    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_TO_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void setGame() {
        Player player = new Player();
        System.out.println(GAME_START);
        do {
            startGame(player);
        } while (player.conformGameRestart());
    }

    private void startGame(Player player) {
        boolean isAnswerCorrect = false;
        Computer computer = new Computer();
        computer.generateAnswerAsChars();

        while (!isAnswerCorrect) {
            isAnswerCorrect = runGameTurn(player, computer);
        }
        System.out.println(GAME_OVER);
        System.out.println(ASK_TO_CONTINUE);
    }

    private boolean runGameTurn(Player player, Computer computer) {
        System.out.println(INPUT_NUMBER);
        String playerInput = player.inputNumbers();
        String resultString = computer.generateResult(playerInput);
        System.out.println(resultString);
        if (resultString.equals(ANSWER_RESULT)) {
            return true;
        }
        return false;
    }
}
