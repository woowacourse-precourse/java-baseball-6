package baseball.game;

import baseball.game.participant.Computer;
import baseball.game.participant.Player;
import baseball.game.service.GameService;
import baseball.game.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    /**
     * 숫자 야구 게임의 흐름 전체를 제어한다.
     */
    public static void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            newGame();
        } while (restart());

        System.out.println("숫자 야구 게임을 완전히 종료합니다.");
        cleanUpResource();
    }

    /**
     * 하나의 새로운 게임을 진행한다.
     * (컴퓨터가 정답을 생성하고, 사용자가 그 정답을 맞힐 때까지)
     */
    private static void newGame() {
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
     * @return 사용자가 입력한 값이 "1"이면 true, "2"면 false
     */
    private static Boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String newOrQuit = Console.readLine();

        Validator.validateNewOrQuit(newOrQuit);
        if (newOrQuit.equals("1")) return true;
        else return false;
    }

    /**
     * Scanner의 인스턴스를 사용하는 동안 가지고 있던 자원을 반납한다.
     */
    private static void cleanUpResource() {
        Console.close();
    }
}