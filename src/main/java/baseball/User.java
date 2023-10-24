package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> user;

    public User() {
        this.user = new ArrayList<>();
    }

    // 문자열 형식의 입력값을 정수 배열에 저장
    public void setUser(String input) {
        checkIfValidInputNumber(input);   // 문자열에 대한 유효성검사 실시
        String[] tokens = input.split("");
        for (String str : tokens) {
            addNumberToArray(Integer.parseInt(str));
        }
    }

    // 숫자로만 이루어진 문자열을 대상으로 하는 유효성 검사
    // 입력값은 Play 클래스의 checkIfInputHasChar()에서의 유효성 검사를 통과한 문자열
    private void checkIfValidInputNumber(String input) {
        checkInputLength(input);    // 문자열 길이 검사
        checkIfInputHasZero(input);   // 0 포함 여부 검사
    }

    // 입력된 문자열의 길이가 3인지 검사
    private void checkInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("Invalid input length.");
        }
    }

    // 입력된 문자열에 0이 포함되었는지 검사
    // 이 유효성검사는 3자리 숫자인 입력값을 대상으로 수행
    // 따라서 이 검사를 통과하는 문자열은 1~9 사이 숫자로만 구성된 3자리 수
    private void checkIfInputHasZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("This input includes zero.");
        }
    }

    // 입력값을 배열에 저장할 때 서로 중복된 숫자가 있으면 IllegalArgumentException 발생 후 종료
    // 중복된 숫자가 없다면 그대로 배열에 저장
    private void addNumberToArray(int num) {
        if (user.contains(num)) {
            throw new IllegalArgumentException("This is already contained: " + num);
        }
        user.add(num);
    }

    // 사용자가 선택한 숫자가 저장된 배열 비우기
    public void clearUser() {
        user.clear();
    }

    // 사용자의 숫자를 불러옴(Rules.countBallsAndStrikes() 전용)
    public List<Integer> getUser() {
        return user;
    }
}
