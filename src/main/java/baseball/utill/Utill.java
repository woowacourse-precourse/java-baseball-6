package baseball.utill;

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
}
