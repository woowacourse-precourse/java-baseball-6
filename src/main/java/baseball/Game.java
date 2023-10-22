package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * 게임. 답과 실행메서드(play())를 가지고 있다.
 */
public class Game {

    private String computerNum; // 컴퓨터가 선택한 숫자(답)

    /**
     * 게임 시작에 필요한 정보 세팅
     */
    private void init() {
        makeComputerNum(); // 컴퓨터의 숫자 결정
    }

    /**
     * 게임 실행
     */
    public void play() throws IllegalArgumentException {
        init();

        System.out.println("숫자 야구 게임을 시작합니다.");

        // 사용자의 값 입력
        System.out.print("숫자를 입력해주세요 : ");
        String userNum = Console.readLine();

        // 사용자가 입력한 값에 대한 검증
        if (!isValidUserNum(userNum)) {
            throw new IllegalArgumentException(String.format("유효하지 않은 입력값 = %s", userNum));
        }

    }

    /**
     * 사용자가 입력한 값에 대한 검증
     * @param userNum 사용자가 입력한 값
     * @return 사용자가 입력한 값이 유효한 경우 true, 그렇지 않은 경우 false
     */
    private boolean isValidUserNum(String userNum) {
        //입력이 양수가 아닌 경우 or 입력한 숫자가 3자리가 아닌 경우 or 입력한 숫자에 중복이 존재하는 경우
        return isPositiveNumber(userNum)
                && userNum.length() == GameDetail.NUM_COUNT
                && !hasDuplicateNum(userNum);
    }

    /**
     * String이 양수인지 검증
     * @param input 검증대상 String
     * @return 양수인 경우 true, 그렇지 않은 경우 false
     */
    private boolean isPositiveNumber(String input) {
        int num = 0;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return num > 0;
    }

    /**
     * 사용자가 입력한 값에 중복이 존재하는지 검증
     * @param userNum 사용자가 입력한 값
     * @return 중복이 존재하는 경우 true, 그렇지 않은 경우 false
     */
    private boolean hasDuplicateNum(String userNum) {
        for (int i = 0; i < userNum.length(); i++) {
            if (userNum.lastIndexOf(userNum.charAt(i)) != i) {
                return true;
            }
        }
        return false;
    }

    /**
     * 컴퓨터의 숫자 결정(답 결정)
     */
    private void makeComputerNum() {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < GameDetail.NUM_COUNT) {
            String randomNum = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (sb.indexOf(randomNum) == -1) {
                sb.append(randomNum);
            }
        }
        computerNum = sb.toString();
    }

}
