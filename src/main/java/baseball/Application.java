package baseball;

import camp.nextstep.edu.missionutils.Console;
import exceptions.TerminateApplicationException;

public class Application {

    private static GameRule rule = new GameRule(3, 1, 9);
    private static String NEW_GAME = "1";
    private static String EXIT = "2";

    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("야구 게임을 시작합니다.");
        while (true) {
            try {
                GameRound round = new GameRound(rule);
                round.playUntilCorrect();
                askForNextGame();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            } catch (TerminateApplicationException e) {
                System.out.println("게임 종료");
                break;
            }
        }
    }

    private static void askForNextGame() throws TerminateApplicationException {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String selectedOption = Console.readLine();
            if (selectedOption.equals(EXIT)) {
                throw new TerminateApplicationException();
            } else if (selectedOption.equals(NEW_GAME)) {
                break;
            }
        }
    }
}
