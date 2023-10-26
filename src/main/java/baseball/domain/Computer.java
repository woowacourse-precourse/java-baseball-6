package baseball.domain;

import static baseball.CONSTANT.GAME_SIZE;

import baseball.dto.GameResultDTO;
import baseball.service.CheckService;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> computerNumber;

    public void createRandomNumber() {
        computerNumber = new ArrayList<>();

        while (computerNumber.size() < GAME_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        System.out.println("computerNumber = " + computerNumber);
    }

    public GameResultDTO compareNumber(List<Integer> userNums) {
        return CheckService.matchNumber(userNums, computerNumber);
    }

}
