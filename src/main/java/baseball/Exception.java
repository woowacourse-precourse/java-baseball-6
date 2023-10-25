package baseball;

public class Exception {
    public static final String USER_NUM_REG_EX = "([1-9])(?!\\1)([1-9])(?!\\1|\\2)([1-9])";
    public static final String END_OR_NOT = "[12]";

    public void guessNumberException(String st) {
        if (!st.matches(USER_NUM_REG_EX)) {
            throw new IllegalArgumentException(OutputMessage.USER_NUM_REG_EX);
        }
    }

    public void endNumberException(String st) {
        if (!st.matches(END_OR_NOT)) {
            throw new IllegalArgumentException(OutputMessage.END_OR_NOT);
        }
    }
}
