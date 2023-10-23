package baseball;

public class CalculateService {
    private static final int NUMBER_LENGTH = 3;
    
    private int ballCount;
    private int strikeCount;
    
    public int getBallCount(String computerNumber, String userNumber) {
        calculateBallCount(computerNumber, userNumber);
        return ballCount;
    }
    
    public int getStrikeCount(String computerNumber, String userNumber) {
        calculateStrikeCount(computerNumber, userNumber);
        return strikeCount;
    }
    
    // 볼의 개수를 계산하는 메서드
    private void calculateBallCount(String computerNumber, String userNumber) {
        int count = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            for (int j = 0; j < NUMBER_LENGTH; j++) {
                if (i != j && computerNumber.charAt(i) == userNumber.charAt(j)) {
                    count++;
                }
            }
        }
        ballCount = count;
    }
    
    // 스트라이크의 개수를 계산하는 메서드
    private void calculateStrikeCount(String computerNumber, String userNumber) {
        int count = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumber.charAt(i) == userNumber.charAt(i)) {
                count++;
            }
        }
        strikeCount = count;
    }
}
