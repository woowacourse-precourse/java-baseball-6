package baseball;

public class CheckException {
    //들어온 데이터 String을 사용해서 오류를 확인한다.
    public void checkException_input(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        // 지금은 데이터가 3개 밖에 없어서 이렇게 할 수 있지만 일반적인 공식은 없는가?
        // [수정 필요]
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(
                2)) {
            throw new IllegalArgumentException();
        }
    }

    //숫자 1이면 재시작, 2이면 종료 그 외에는 오류를 발생시킨다.
    public void checkException_Exit(int num) {
        if (num != 1 && num != 2) {
            throw new IllegalArgumentException();
        }
    }
}
