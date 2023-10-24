package baseball.service;

import static baseball.common.Constants.END_GAME;
import static baseball.common.Constants.NUMBER_LENGTH;
import static baseball.common.Constants.RESTART;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class SystemService {

    //중복없이 컴퓨터 번호 입력받기: ArrayList로 저장
    public List<Integer> generateComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

    //게임 재시작 여부 확인
    public boolean restart(String userInput) {

        if (userInput.equals(RESTART)) {
            return true;
        } else if (userInput.equals(END_GAME)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
