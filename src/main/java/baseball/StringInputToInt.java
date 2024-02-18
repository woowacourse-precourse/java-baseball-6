package baseball;

public class StringInputToInt {
    public static int[] stringInputToInt (String input) {
        // String을 int로..
        int[] result = new int[3];

        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            // 0~9 이외의 잘못된 값이 들어오면 IllegalArgumentException 출력하고 바로 종료
            if (temp < '0' || temp > '9') {
                throw new IllegalArgumentException();
            }
            result[i] = temp - '0';
        }

        return result;
    }
}
