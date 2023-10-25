package baseball;

public class NumberComparison {
    public static int[] compareNumbers(int computerNumber, int userNumber) {
        String computerNumStr = String.valueOf(computerNumber);
        String userNumStr = String.valueOf(userNumber);
        int[] result = new int[2]; // [strikes, balls]

        for (int i = 0; i < 3; i++) {
            if (computerNumStr.charAt(i) == userNumStr.charAt(i)) {
                result[0]++; // 스트라이크
            } else if (computerNumStr.contains(String.valueOf(userNumStr.charAt(i)))) {
                result[1]++; // 볼
            }
        }

        return result;
    }
}
