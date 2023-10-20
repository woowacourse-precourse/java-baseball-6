package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final List<Integer> computerNumbers = new ArrayList<>();
    private static final List<Integer> userNumbers = new ArrayList<>();
    public static void main(String[] args) {
        // 게임 시작 메시지 출력
        System.out.println(GAME_START_MESSAGE);

        // 랜덤 숫자 생성
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        // 사용자 숫자 입력
        System.out.print(USER_INPUT_MESSAGE);
        String userInput = Console.readLine();

        // 사용자 숫자 검증
        // 정규식을 사용한 검증
        if (!userInput.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        // 사용자 숫자(문자열)를 List<Integer> 타입으로 변경
        for (char c : userInput.toCharArray()) {
            int number = Character.getNumericValue(c);
            userNumbers.add(number);
        }

        // 사용자 숫자 입력에 따른 결과 계산
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            Integer currentUserNumber = userNumbers.get(i);
            Integer currentComputerNumber = computerNumbers.get(i);
            if (currentUserNumber.equals(currentComputerNumber)) {
                strike++;
            } else if (computerNumbers.contains(currentUserNumber)) {
                ball++;
            }
        }

        if (strike == 0) {
            if (ball == 0) {
                System.out.println(NOTHING_MESSAGE);
            } else {
                System.out.println(ball + BALL_MESSAGE);
            }
        } else {
            if (ball == 0) {
                System.out.println(strike + STRIKE_MESSAGE);
            } else {
                System.out.println(ball + BALL_MESSAGE);
                System.out.print(" ");
                System.out.print(strike + STRIKE_MESSAGE);
            }
        }
    }
}
