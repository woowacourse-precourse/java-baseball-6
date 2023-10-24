package baseball;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.Validation;
import camp.nextstep.edu.missionutils.Console;

public class GameService {

    private static Computer computer;
    private static User user;

    private static Game game;
    public GameService() {
        computer = new Computer();
        user = new User();
        game = new Game();
    }

    public void executeGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String option;
        do {
            playGame();
            option = restartOrExit();
        }while(!option.equals("2"));
    }

    private void playGame() {
        generateRandomNumber();
        do {
            guessRandomNumber();
            printResult();
        } while (!isAnswer());
        endGame();
    }

    private boolean isAnswer() {
        return game.getStrike() == 3;
    }

    private void printResult() {
        game.printCompareResult();
    }

    private void guessRandomNumber() {
        user.inputUserNumber();
        game.compare(computer.getComputerNumbers(), user.getUserNumber());
    }

    private void generateRandomNumber() {
        computer.generateNumber();
    }

    private void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static String restartOrExit(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartNumber = Console.readLine();
        Validation.verifyRestartNumber(restartNumber);
        return restartNumber;
    }

}
