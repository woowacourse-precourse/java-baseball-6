package baseball.model;

public class Number {

    private final int number;

    /**
     * 정수 문자열을 입력받고, 정수로 변환 후 저장한다.
     *
     * @param input
     */
    public Number(String input) {
        validationNumber(input);
        this.number = Integer.parseInt(input);
    }

    /**
     * char 타입의 숫자를 받은 다음에 정수로 변환하여 저장
     *
     * @param num
     */
    public Number(char num) {
        validationNumber(num + ""); // 정수가 맞는지 검증
        this.number = Character.getNumericValue(num); // char -> int 변환 후 저장
    }

    /**
     * 입력한 정수를 반환한다.
     *
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     * 숫자가 맞는지 검증한다.
     *
     * @param input 사용자에게 입력받은 데이터를 받는다.
     * @return 정수일 경우 true, 정수가 아닐 경우 false를 반환한다.
     */
    private static void validationNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
