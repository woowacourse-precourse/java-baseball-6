package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        GameOnOff gameOnOff = new GameOnOff();

        int gameButton;
        gameButton = gameOnOff.gameStart();
        while (gameButton == 1) {
            // 컴퓨터 랜덤 숫자 선택
            Computer computer = new Computer();
            computer.setComputerNumber();
            List<Integer> computerNumber = computer.getComputerNumber();
            System.out.println(computerNumber);

            String result = "";
            while (!result.equals("3스트라이크")){
                // 플레이어 숫자 입력
                Player player = new Player();
                System.out.println("숫자를 입력해주세요 : ");
                player.setPlayerNumber(Console.readLine());
                List<Integer> playerNumber = player.getPlayerNumber();

                // 숫자 비교
                Result compareResult = new Result();
                String compared = compareResult.compareNumbers(computerNumber, playerNumber);
                System.out.println(compared);

                result = compared;
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            // 게임 지속 여부 입력
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameButton = gameOnOff.gameContinue(Console.readLine());
        }

        System.out.println("게임을 종료합니다.");

    }
}
