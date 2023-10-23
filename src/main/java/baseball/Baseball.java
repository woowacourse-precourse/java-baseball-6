package baseball;

import camp.nextstep.edu.missionutils.*;

public class Baseball {
    private String computerNumber;

    /**
     * 숫자 야구 진행 함수
     * 입력: 없음
     * 출력: 없음
     */
    void gameManager() {}

    /**
     * 입력 값 검증 함수
     * 입력: userNumber(사용자의 입력 값)
     * 출력: boolean(입력 값이 유효 범위 내에 존재하는 값일 경우 true 반환)
     */
    boolean isValid(String userNumber) {
        // 사용자가 입력한 값이 3자리 문자인지 확인
        return true;
    }

    /**
     * 입력 값과 컴퓨터 값 비교 함수
     * 입력: userNumber(사용자의 입력 값)
     *      result(결과 배열, 0, 1번째 인덱스는 각각 스트라이크 개수, 볼 개수)
     * 출력: boolean(3 스트라이크일 경우 true 반환)
     */
    boolean checkNumber(String userNumber, int result[]) {
        result[0] = countStrike(userNumber);
        // 볼의 개수를 셀 때, 스트라이크도 볼로 카운트하므로 스트라이크 개수 제외
        result[1] = countBall(userNumber) - result[0];
        if (result[1] > 0) {
            System.out.print(result[1] + "볼");
            if (result[0] > 0)
                System.out.print(" " + result[0] + "스트라이크");
            System.out.println();
        } else if (result[0] > 0) {
            if (result[0] > 0)
                System.out.println(result[0] + "스트라이크");
        } else {
            System.out.println("낫싱");
        }

        if (result[0] == 3)
            return true;
        else
            return false;
    }

    /**
     * 스트라이크 개수 확인 함수
     * 입력: userNumber(사용자의 입력 값)
     * 출력: int(스트라이크 개수)
     */
    int countStrike(String userNumber) {
        int result = 0;
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) == computerNumber.charAt(i))
                result++;
        }

        return result;
    }

    /**
     * 볼 개수 확인 함수
     * 입력: userNumber(사용자의 입력 값)
     * 출력: int(볼 개수)
     */
    int countBall(String userNumber) {
        int result = 0;
        for(int i = 0 ; i < userNumber.length() ; i++) {
            if (computerNumber.contains(userNumber.charAt(i) + ""))
                result++;
        }

        return result;
    }
}
