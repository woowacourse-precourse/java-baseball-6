package controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : controller
 * fileName       : RandomController
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-19        qkrtn_ulqpbq2       최초 생성
 */
public class RandomController {

    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            randomNumbers.add(generateRandomNumber(randomNumbers));
        }

        return randomNumbers;
    }

    private int generateRandomNumber(List<Integer> randomNumbers) {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!randomNumbers.contains(randomNumber)){
                return randomNumber;
            }
        }
    }
}
