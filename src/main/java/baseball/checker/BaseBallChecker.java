package baseball.checker;

// 사용자가 입력한 값의 결과를 반환하는 클래스, 볼 카운트는 10, 20, 30으로 스트라이크 카운트는 1, 2, 3으로 구분
public class BaseBallChecker {
    private final static int LENGTH_LIMIT = 3;

    public int checkGameResult(String userInput, String targetNumber) {
        Result result = new Result();

        for(int i = 0; i < LENGTH_LIMIT; i++) {
            char value = userInput.charAt(i);
            result.addCount(value, targetNumber, i);
        }

        return result.getResult();
    }

    private static class Result {
        private int ballCount;
        private int strikeCount;

        public Result() {
            this.ballCount = 0;
            this.strikeCount = 0;
        }

        public void addCount(char inputValue, String targetNumber, int index) {
            if(targetNumber.charAt(index) == inputValue) {
                strikeCount++;
                return;
            }
            if(targetNumber.contains(String.valueOf(inputValue))) ballCount++;
        }

        public int getResult() {
            return 10 * ballCount + strikeCount;
        }
    }
}