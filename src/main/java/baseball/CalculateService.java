package baseball;

import static baseball.NumberService.NUMBER_LENGTH;

public class CalculateService {
    private int ballCount;
    private int strikeCount;
    private String resultMessage;
    
    public int getBallCount(String computerNumber, String userNumber) {
        calculateBallCount(computerNumber, userNumber);
        return ballCount;
    }
    
    public int getStrikeCount(String computerNumber, String userNumber) {
        calculateStrikeCount(computerNumber, userNumber);
        return strikeCount;
    }
    
    public String getResultMessage(int ballCount, int strikeCount) {
        calculateResultMessage(ballCount, strikeCount);
        return resultMessage;
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
    
    // 볼과 스트라이크의 개수에 따라 결과 메시지를 계산하는 메서드
    private void calculateResultMessage(int ballCount, int strikeCount) {
        StringBuilder result = new StringBuilder();
        
        if (ballCount == 0 && strikeCount == 0) {
            result.append(MessageType.NOTHING.getMessage());
        }
        
        if (ballCount > 0) {
            result.append(ballCount).append(MessageType.BALL.getMessage()).append(" ");
        }
        
        if (strikeCount > 0) {
            result.append(strikeCount).append(MessageType.STRIKE.getMessage());
        }
        
        resultMessage = String.valueOf(result);
    }
}
