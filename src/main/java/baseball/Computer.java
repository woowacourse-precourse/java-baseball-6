package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {

    // 컴퓨터 숫자 랜덤 설정
    public ArrayList<Integer> setComputerNumber(ArrayList<Integer> computerNumber) {
        // computerNumber 초기화를 위함
        // computerNumber 내에 원소가 하나라도 있다면 비우기
        if (!computerNumber.isEmpty()) {
            while (!computerNumber.isEmpty()) {
                computerNumber.remove(0);
            }
        }

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }
}
