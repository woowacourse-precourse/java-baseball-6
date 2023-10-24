package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> getRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }

        return randomNumberList;
    }

    public static void main(String[] args) {
        // TODO1: 게임시작 메세지 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // TODO2: 랜덤 숫자 설정
        List<Integer> computer = getRandomNumber();

    }
}
