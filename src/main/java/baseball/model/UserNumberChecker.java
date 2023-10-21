package baseball.model;

// 사용자가 입력한 숫자 체크
public class UserNumberChecker {

    private String userNumber; // 사용자가 입력한 값 배열

    public String getUserNumber() {
        return userNumber;
    } // private 접근 제어하는 userNumber의 값을 변경하지 않고 다른 패키지 혹은 클래스에서 갖고 오기 위한 getter

    public UserNumberChecker(String userNumber) {
        isLengthCorrect(userNumber);
        isSingleDigit(userNumber);
        isDuplicatedNumber(userNumber);

        this.userNumber = userNumber;
    }

    public static void isLengthCorrect(String userNumber) throws IllegalArgumentException {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("에러! 총 세 번 입력해야 합니다.)");
        }
    } // user의 입력이 총 세 번 이뤄졌는지 확인하는 메소드(최우선)

    public static void isSingleDigit(String userNumber) throws IllegalArgumentException {
        for (char digit : userNumber.toCharArray()) {
            if (!Character.isDigit(digit) || digit == '0') {
                throw new IllegalArgumentException("에러! 1부터 9까지의 숫자만 입력할 수 있습니다.");
            }
        }
    } // user의 입력값이 각각 한 자리 자연수인지 확인하는 메소드

    public static void isDuplicatedNumber(String userNumber) throws IllegalArgumentException {
        char[] charArray = userNumber.toCharArray();
        int[] intArray = new int[charArray.length];

        int index = 0; // index = 2가 될 때까지 반복문 적용

        while (index < 3) {
            boolean isDuplicate = false; // 중복 여부 변수

            for (int i = 0; i < index; i++) {
                if (intArray[i] == intArray[index]) {
                    isDuplicate = true;
                    break; // 중복된 숫자를 찾으면 반복문 종료
                }
            }

            if (isDuplicate) {
                throw new IllegalArgumentException("에러! 중복된 숫자를 입력할 수 없습니다.");
            }
            index++;
        }

    } // user의 입력값 요소들 중에서 중복된 자연수가 있는지 확인하는 메소드
}
