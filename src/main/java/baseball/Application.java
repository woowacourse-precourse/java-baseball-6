package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // Game Start
        Game game = new Game();
        game.generateRandomNumber();

        Player player = new Player();

        while (true) {
            System.out.print("숫자를 입력하여 주세요 : ");

            // playerNumber 입력받고 검증
            player.setNumber(Console.readLine());

            // playerNumber와 answer를 비교 후 결과 출력
            if (game.checkNumber(player.getNumber())) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                // 게임 종료 시, 게임 진행 여부 확인
                if (game.restart(Console.readLine())) {
                    break;
                } else {
                    game.generateRandomNumber();
                }
            }
        }
    }
}
