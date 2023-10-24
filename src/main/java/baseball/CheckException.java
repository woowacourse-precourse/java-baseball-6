package baseball;

public class CheckException {
    //들어온 데이터 String을 사용해서 오류를 확인한다.
    public void checkException_input(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 이중 반복문 사용으로 그나마 해결
        // 더 좋은 방법은 없는가? 람다식?
        char[] inputCharArray = input.toCharArray();
        for (int i = 0; i < inputCharArray.length; i++) {
            for (int j = i + 1; j < inputCharArray.length; j++) {
                if (inputCharArray[i] == inputCharArray[j]) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    //숫자 1이면 재시작, 2이면 종료 그 외에는 오류를 발생시킨다.
    public void checkException_Exit(int num) {
        if (num != 1 && num != 2) {
            throw new IllegalArgumentException();
        }
    }
}
