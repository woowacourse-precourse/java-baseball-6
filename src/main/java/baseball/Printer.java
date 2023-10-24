package baseball;

public class Printer {

    // 외부에서 메서드를 바로 사용하는 클래스이므로 외부에서 사용할 메서드를 스태틱으로 선언한다.
    // 외부에서 메서드를 하나만 사용하므로 생성자없이 메서드에서 인자를 바로 받는다.
    public static void printResult(int balls, int strikes) {
        StringBuilder result = new StringBuilder();

        // 볼이 있을 경우
        printBalls(balls, result);

        // 스트라이크가 있을 경우
        printStrikes(strikes, result);

        // 아무 것도 없을 경우
        printNothing(result);

        System.out.println(result.toString());
    }

    private static void printBalls(int balls, StringBuilder result) {
        if (balls > 0) {
            result.append(balls).append("볼");
        }
    }

    private static void printStrikes(int strikes, StringBuilder result) {
        if (strikes > 0) {
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(strikes).append("스트라이크");
        }
    }

    private static void printNothing(StringBuilder result) {
        if (result.isEmpty()) {
            result.append("낫싱");
        }
    }

}
