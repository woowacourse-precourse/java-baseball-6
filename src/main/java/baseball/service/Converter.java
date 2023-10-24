package baseball.service;

/**
 * 숫자 문자열의 정보를 담을 수 있는 배열로 변환하는 클래스
 */
public class Converter {
    private static final int NUMBER_SIZE = 3;
    private static final int ARRAY_SIZE = 10;

    /**
     * 숫자 문자열의 정보를 담는 배열을 반환
     * <p>
     * 배열의 index 1~9는 뽑힐 숫자의 목록. 배열의 값은 뽑힌 숫자의 자리. 0:사용 되지 않음 1:백의 자리 2:십의 자리 3:일의 자리
     *
     * @param num 숫자 문자열
     * @return 변환된 배열
     */
    public static int[] convert(String num) {
        int[] arr = new int[ARRAY_SIZE];
        for (int i = 0; i < NUMBER_SIZE; i++) {
            arr[num.charAt(i) - '0'] = i + 1;
        }
        return arr;
    }

    /**
     * 숫자 문자열에 중복된 숫자가 있는지 판별할 때 사용하는 배열을 반환
     * <p>
     * 배열의 index 1~9는 뽑힐 숫자의 목록. 배열의 값은 뽑힌 숫자의 횟수.
     *
     * @param num 숫자 문자열
     * @return 변환된 배열
     */
    public static int[] convertForDuplicate(String num) {
        int[] arr = new int[ARRAY_SIZE];
        for (int i = 0; i < NUMBER_SIZE; i++) {
            arr[num.charAt(i) - '0']++;
        }
        return arr;
    }
}
