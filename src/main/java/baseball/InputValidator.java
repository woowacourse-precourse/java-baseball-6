package baseball;

public class InputValidator {
    private static final int BALL_COUNT = 3; // 유저가 생성할 공(숫자)의 개수
    private static final int MIN_BALL_NUM = 1; // 공(숫자)가 가질 수 있는 가장 작은 수
    private static final int MAX_BALL_NUM = 9; // 공(숫자)가 가질 수 있는 가장 큰 수

    // 사용자의 입력이 올바르면 true, 그렇지 않으면 false 반환
    public static boolean validateInput(String input){
        if(input == null || input.length() != BALL_COUNT){
            return false;
        }
        for (char ch : input.toCharArray()){
            int number = Character.getNumericValue(ch); // char -> int 변환
            if (number < MIN_BALL_NUM || number > MAX_BALL_NUM){
                return false;
            }
        }
        return true;
    }

    // 다시 시작할지 여부에 대한 사용자의 입력이 형식에 맞나 검증 ( 맞으면 true )
    public static boolean validateAgain(String input){
        return "1".equals(input) || "2".equals(input);
    }


}