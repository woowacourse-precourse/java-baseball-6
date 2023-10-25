package baseball.game;

import baseball.game.participant.Computer;
import baseball.game.participant.Player;
import baseball.game.service.GameService;
import baseball.game.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 숫자 야구 게임의 진행을 위한 기능을 제공한다.
 */
public class BaseballGame {

    /**
     * 숫자 야구 게임의 흐름 전체를 제어한다.
     * <p>새로운 게임을 시작하고, 재시작/종료를 결정하고, 완전 종료 시 자원을 반납한다.
     */
    public static void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            startNewGame();
        } while (restart());

        cleanUpResource();
    }

    /**
     * 하나의 새로운 게임을 진행한다.
     * <p>(컴퓨터가 정답을 생성하고, 사용자가 그 정답을 맞힐 때까지)
     */
    private static void startNewGame() {
        Computer computer = Computer.create();
        String hint;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            Validator.validateProposal(input);
            Player player = Player.create(input);

            hint = GameService.getHint(player, computer);
            System.out.println(hint);
        } while (!hint.equals("3스트라이크"));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 새로운 게임을 시작할지 여부를 결정한다
     *
     * @return 사용자가 입력한 값이 "1"이면 true, "2"면 false
     */
    private static Boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String newOrQuit = Console.readLine();

        Validator.validateNewOrQuit(newOrQuit);
        if (newOrQuit.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Scanner의 인스턴스를 사용하는 동안 가지고 있던 OS 자원을 반납한다.
     * <p>참고 자료:
     * <a href="https://stackoverflow.com/questions/24573084/why-we-should-i-close-a-java-util-scanner-variable">
     *         Why we should I close a java.util.Scanner variable?</a>.
     */
    private static void cleanUpResource() {
        Console.close();
    }
}