package baseball.people;

public class Pitcher {

    Pitcher() {
    }

    /*
    Pitcher 객체를 생성하는 정적 팩토리 메서드
     */
    public static Pitcher enter() {
        return new Pitcher();
    }

    /*
    String 객체가 유효한 입력인지 확인하고,
    유효하지 않다면 IllegalArgumentException 예외를 던진다.
    유효하다면 3자리 정수 배열로 바꿔서 반환한다.
     */
    public int[] pitch(String input) {
        if (!isValidInput(input)) {
            throw new IllegalArgumentException();
        }

        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = (input.charAt(i) - '0');
        }
        return numbers;
    }

    /*
    String 객체가 1 또는 2인지에 따라
    재시작과 관련된 boolean 값을 반환한다.
    잘못된 입력이 들어왔다면 IllegalArgumentException 예외를 던진다.
     */
    public boolean restart(String input) {
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    private boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }

        boolean[] duplicationCheck = new boolean[10];
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (c < '1' || c > '9' || duplicationCheck[(c - '0')]) {
                return false;
            }
            duplicationCheck[(c - '0')] = true;
        }

        return true;
    }
}
