package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final List<Integer> computerNumber = new ArrayList<>();
    public static void main(String[] args) {
        // 게임 시작 메시지 출력
        System.out.println(GAME_START_MESSAGE);

        // 랜덤 숫자 생성
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }
}
