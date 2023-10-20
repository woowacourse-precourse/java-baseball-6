package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
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

        // 사용자 숫자 입력
        System.out.print(USER_INPUT_MESSAGE);
        String userNumber = Console.readLine();

        // 사용자 숫자 검증
        // 정규식을 사용한 검증
        if (!userNumber.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
