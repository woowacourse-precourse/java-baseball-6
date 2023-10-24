package baseball;

public class ContinueNumber {

    public String getContinueNumber(String readLine) {
        checkContinueNumber(readLine);
        return readLine;
    }

    private void checkContinueNumber(String word) throws IllegalArgumentException {
        if (!word.equals("1") && !word.equals("2")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    //    private method 테스트를 위한 function
    public void testCheckContinueNumber(String word) throws IllegalArgumentException {
        checkContinueNumber(word);
    }
}
