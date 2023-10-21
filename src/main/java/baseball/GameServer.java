package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameServer {

    private final Computer computer = new Computer();
    private Result score;

    public void run() {
        System.out.println(OutputMessage.START.message);
        while (true) {

            playGame();

            if (score.isThreeStrike()) {
                Command command = askRetry();
                if(!command.retry) break;
                computer.prepareGameRetry();
            }
        }
    }

    private void playGame() {
        System.out.print(OutputMessage.INPUT_NUMBER.message);
        Digits input = new Digits(Console.readLine());
        score = computer.calculateScore(input);
        System.out.println(score.getResultInKorean());
    }

    private Command askRetry() {
        System.out.println(OutputMessage.GAME_CLEAR.message);
        System.out.println(OutputMessage.RETRY_OR_END.message);
        return Command.getCommand(Console.readLine());
    }
}
