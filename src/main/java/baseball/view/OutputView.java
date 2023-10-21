package baseball.view;

public class OutputView {
    public static void printResult(int[] result){
        int strikes = result[0];
        int balls = result[1];

        String ballResult = printBalls(balls);
        String strikeResult = printStrikes(strikes);

        if(ballResult.isEmpty() && strikeResult.isEmpty()) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(ballResult + strikeResult);
    }

    private static String printBalls(int balls){
        if(balls >= 1) return balls + "볼 ";
        return "";
    }

    private static String printStrikes(int strikes){
        if(strikes >= 1) return strikes + "스트라이크";
        return "";
    }

}
