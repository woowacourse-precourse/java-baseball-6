package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    /**
     * 숫자 야구 게임의 흐름 전체를 제어
     */
    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            newGame();
        } while (restart());

        System.out.println("숫자 야구 게임을 완전히 종료합니다.");
    }

    private static void newGame() {
        Computer computer = new Computer();
        String hint;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            Validator.validateProposal(input);
            Player player = new Player(input);

            hint = GameService.getHintWith(player, computer);
            System.out.println(hint);
        } while (!hint.equals("3스트라이크"));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    //TODO: private 메서드에 static을 붙이는 게 적절한지 확인
    private static Boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String newOrQuit = Console.readLine();

        Validator.validateNewOrQuit(newOrQuit);
        if (newOrQuit.equals("1")) return true;
        else return false;
    }
}