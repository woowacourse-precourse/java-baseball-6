package baseball.service;

import baseball.domain.GameNumberDTO;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerService {
    /**
     * 난수 저장
     */
    public void comNumber(GameNumberDTO gameNumber) {
        List<Integer> comNumbers = generateRandomNumber();
        gameNumber.setComNum(comNumbers);
    }

    /**
     * 난수 생성
     */
    private List<Integer> generateRandomNumber() {
        List<Integer> comNumber = new ArrayList<>();
        while (comNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNumber.contains(randomNumber)) {
                comNumber.add(randomNumber);
            }
        }
        return comNumber;
    }

}

