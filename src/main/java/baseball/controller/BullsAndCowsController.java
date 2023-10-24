package baseball.controller;

import baseball.service.BullsAndCowsService;
import baseball.service.BullsAndCowsServiceImpl;

import java.util.List;

public class BullsAndCowsController {

    private static final BullsAndCowsService bullsAndCowsService = new BullsAndCowsServiceImpl();

    public void BullsAndCowsGame() {

        do {

            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = bullsAndCowsService.createComputerRandomValue();
            while (true) {

                List<Integer> user = bullsAndCowsService.getThreeDigits();

                if (bullsAndCowsService.compareUserGuessWithRandom(computer, user)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

        } while (bullsAndCowsService.isGameRunning());
    }
}
