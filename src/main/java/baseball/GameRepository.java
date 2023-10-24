package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

/**
 * 게임 데이터(사용자, 컴퓨터 수)를 초기화, 값을 비교해 처리하는 클래스
 * @description Getter / Setter 사용을 지양하는 방향으로 구현(내부 필드는 클래스 내부에서 연산 및 처리)
 */
public class GameRepository {
    private ArrayList<Integer> computer; // 컴퓨터의 세자리 수를 저장하는 필드
    private ArrayList<Integer> user; // 사용자의 세자리 수를 저장하는 필드

    /**
     * 컴퓨터의 세자리 수를 설정하는 메소드
     */
    public void setComputer() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            // 중복되지 않은 1-9로 구성되어 있는 세자리 수 computer로 add
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    /**
     * 사용자의 세자리 수를 설정하는 메소드, 규칙 부적합 시 예외 발생
     * @throws IllegalArgumentException 사용자 입력 값 유효하지 않을 시 예외 발생
     */
    public void setUser() throws IllegalArgumentException {
        user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String score = Console.readLine();
        System.out.println("com : " + computer);
        // 사용자 입력 값 규칙 적합 여부 검증 1 (1-9까지의 세자리 수로 구성 여부)
        if (!(score.length() == 3 && score.matches("[1-9][1-9][1-9]"))) {
            throw new IllegalArgumentException();
        }
        // 사용자 입력 값 규칙 적합 여부 검증 (중복여부 확인)
        // 적합할 시 user 로 세자리 수 add
        for (char c : score.toCharArray()) {
            if (user.contains(Character.getNumericValue(c))) {
                throw new IllegalArgumentException();
            }
            user.add(Character.getNumericValue(c));
        }
    }

    /**
     * 사용자와 컴퓨터의 세자리 수를 비교하는 메소드
     * @return 볼, 스트라이크 개수를 리턴
     */
    public int[] setScore() {
        int ball = 0;
        int strike = 0;
        for (int computerIndex = 0; computerIndex < computer.size(); computerIndex++) {
            for (int userIndex = 0; userIndex < user.size(); userIndex++) {
                if (computer.get(computerIndex).equals(user.get(userIndex))) {
                    if (computerIndex == userIndex) {
                        strike++;
                    }
                    if (computerIndex != userIndex) {
                        ball++;
                    }
                }
            }
        }
        return new int[]{ball, strike};
    }

    /**
     * 사용자와 컴퓨터의 세자리 수 비교 결과를 출력하는 메소드
     * @return 게임 종료 여부(사용자와 컴퓨터 세자리 수 일치 여부) 리턴
     */
    public boolean printScore() {
        int ball = setScore()[0];
        int strike = setScore()[1];

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }

        if (strike == 3) {
            return true;
        }
        return false;
    }
}
