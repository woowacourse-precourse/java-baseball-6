package baseball.errors;

public interface FindError {
    public void matchLength(String str);
    public void verifyNonChar(String str);
    public void duplicatedNumber(String str);
}
