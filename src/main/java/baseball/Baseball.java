package baseball;

import java.util.List;

public class Baseball {
    private int computerNumber;
    private List<Character> domain;

    /**
     * 입력 값 유효 범위 설정 함수
     */
    public void setDomain(List<Character> domain) {
        this.domain = domain;
    }

    /**
     * 숫자 야구 진행 함수
     * 입력: 없음
     * 출력: 없음
     */
    void gameManager() {}

    /**
     * 입력 값 검증 함수
     * 입력: userNumber(사용자의 입력 값)
     *      domain(입력 값 유효 범위)
     * 출력: boolean(입력 값이 유효 범위 내에 존재하는 값일 경우 true 반환)
     */
    boolean isValid(String userNumber) {
        // 사용자의 입력값 자리수마다 확인하여 하나라도 domain에 없는 값일 경우 false 반환
        for(int i = 0 ; i < userNumber.length() ; i++) {
            if (!domain.contains((Character)userNumber.charAt(i)))
                return false;
        }

        return true;
    }

    /**
     * 입력 값과 컴퓨터 값 비교 함수
     * 입력: userNumber(사용자의 입력 값)
     *      result(결과 배열, 0, 1번째 인덱스는 각각 스트라이크 개수, 볼 개수)
     * 출력: boolean(3 스트라이크일 경우 true 반환)
     */
    boolean checkNumber(int userNumber, int result[]) {return true;}

    /**
     * 스트라이크 개수 확인 함수
     * 입력: userNumber(사용자의 입력 값)
     * 출력: int(스트라이크 개수)
     */
    int countStrike(int userNumber) {return 0;}

    /**
     * 볼 개수 확인 함수
     * 입력: userNumber(사용자의 입력 값)
     * 출력: int(볼 개수)
     */
    int countBall(int userNumber) {return 0;}
}
