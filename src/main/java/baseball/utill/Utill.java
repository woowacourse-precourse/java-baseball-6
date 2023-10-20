package baseball.utill;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Utill {

    /**
     * num1과 num2의 숫자가 같으면 true 반환
     *
     * @param num1
     * @param num2
     * @return
     */
    public static boolean isSameInteger(Integer num1, Integer num2) {
        int isSameInt = Integer.compare(num1, num2);
        if (isSameInt == 0) {
            return true;
        }
        return false;
    }

    /**
     * 두개의 문자열을 비교를 한다. 같다면 false, 다르다면 true 이다.
     *
     * @param resultStr
     * @param gameTerminationConditionStr
     * @return
     */
    public static boolean isNotSameString(String resultStr, String gameTerminationConditionStr) {
        if (resultStr.equals(gameTerminationConditionStr)) {
            return false;
        }
        return true;
    }

    /**
     * 문자열 입력을 받는다.
     *
     * @return
     */
    public static String inputNum() {
        String result = readLine();

        ValidException.isValidLength(result); // 입력 받는 문자열이 3이 아니면 예외처리.

        return result;
    }

    /**
     * 숫자를 입력받는다.
     *
     * @return
     */
    public static int inputIntNum() {
        int resultInt = Integer.parseInt(readLine());
        return resultInt;
    }

}
