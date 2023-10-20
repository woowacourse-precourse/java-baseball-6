package baseball;


import baseball.ver3.ComputerV3;
import baseball.ver3.GameEntities;
import baseball.ver3.GameManager;
import baseball.ver3.PlayerV3;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            // 게임 엔터티 생성
            GameEntities entities = GameEntities.createEntities();
            ComputerV3 computer = entities.getComputer();
            PlayerV3 player = entities.getPlayer();

            // 컴퓨터의 숫자 설정
            List<Integer> computerNums = GameManager.ready(computer);

            // 게임 결과 초기화
            String gameResult = "";

            // 3스트라이크가 아닐 때까지 반복
            while (!"3스트라이크".equals(gameResult)) {
                // 플레이어의 숫자 설정
                List<Integer> playerNums = GameManager.ready(player);

                // 게임 결과 계산
                gameResult = GameManager.playAndResult(computerNums, playerNums);
                System.out.println(gameResult);
            }

            // 3스트라이크일 경우, 게임을 계속할지 물어봄
            String playOrNot = GameManager.playOrNot();
            if ("2".equals(playOrNot)) {
                break; // 사용자가 2를 선택하여 게임 종료
            }
        }

    }

}
