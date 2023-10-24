package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    public static void start(){
        Boolean again = true;

        while (again) {
            List<Integer> computerNum = Computer.generate();
            String result = "";

            while (!result.equals("3스트라이크")){
                List<Integer> playerNum = Player.enter();
                result = Refree.count(computerNum, playerNum);
                System.out.println(result);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String againPlayer = Console.readLine();

            if(againPlayer.equals("1")) {
                again = true;
            } else if(againPlayer.equals("2")) {
                again = false;
            } else {
                throw new IllegalArgumentException("재시작은 1,2로 입력하셔야 합니다.");
            }
        }
    }
}
