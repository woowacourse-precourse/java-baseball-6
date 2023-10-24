package error;

/*
 * 클래스 이름 : ErrorConstant
 *
 * 버전 정보 : Java 17
 *
 * 최종 수정날짜 : 2023-10-22
 *
 * 작성자 : 문재경
 */
public class ErrorConstant {

    // 게임 시작 input number
    public static String INPUT_LENGTH_ERROR = "{input number} :input의 길이가 이상합니다."; // 길이 에러
    public static String NOT_NUMBER = "{input number} : 숫자가 아닌 문자가 포함되어 있습니다."; // 숫자가 아닌 값 에러
    public static String SAME_NUMBER = "{input number} : 숫자가 서로 다르지 않습니다."; // 서로 다르지 않은 숫자 에러
    public static int INPUT_CORRECT_LENGTH = 3; // 올바른 길이

    // 게임 종료 후 exit number

    public static String EXIT_LENGTH_ERROR = "{exit number} : 값의 길이가 이상합니다."; // 길이 에러
    public static String INCORRECT_NUMBER = "{exit number} : 제대로 된 값이 아닙니다."; // 올바르지 않은 숫자 에러
    public static int EXIT_CORRECT_LENGTH = 1; // 올바른 길이
}
