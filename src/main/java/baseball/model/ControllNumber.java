package baseball.model;

public class ControllNumber {

    private static String exitNumber;
    private static int strikeCount;

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
