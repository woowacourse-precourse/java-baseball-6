package baseball.checker;

// 사용자가 입력한 값의 결과를 반환하는 클래스, 볼 카운트는 10, 20, 30으로 스트라이크 카운트는 1, 2, 3으로 구분
public class BaseBallChecker {
    public static int checkGameResult(String userInput, String targetNumber) {
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0; i < 3; i++) {
            char value = userInput.charAt(i);
            if(targetNumber.charAt(i) == value) strikeCount++;
            else if(targetNumber.contains(String.valueOf(value))) ballCount++;
        }

        return 10 * ballCount + strikeCount;
    }
}