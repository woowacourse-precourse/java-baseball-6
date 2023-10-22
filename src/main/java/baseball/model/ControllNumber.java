package baseball.model;

public class ControllNumber {

    private static String exitNumber = "1";
    private static int strikeCount = 0;

    public static String getExitNumber() {
        return exitNumber;
    }

    public static void setExitNumber(String exitNumber) {
        ControllNumber.exitNumber = exitNumber;
    }

    public static int getStrikeCount() {
        return strikeCount;
    }

    public static void setStrikeCount(int strikeCount) {
        ControllNumber.strikeCount = strikeCount;
    }
}
