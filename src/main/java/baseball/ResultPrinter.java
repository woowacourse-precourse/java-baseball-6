package baseball;

public class ResultPrinter {
    public static void printResult(int strike, int ball) {
        String strikeResult = (strike == 0) ? "" : strike + "스트라이크";
        String ballResult = (ball == 0) ? "" : ball + "볼";
        String nothingResult = (strike == 0 && ball == 0) ? "낫싱" : "";
        System.out.println(ballResult + " " + strikeResult + nothingResult);
    }
}

