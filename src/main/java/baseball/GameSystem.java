package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameSystem {
    private static final int MAX_STRIKE_COUNT = 3;
    private static final String RESTART_NUMBER = "1";
    private static final String END_NUMBER = "2";
    
    private Number number;
    private CalculateService calculateService;
    private String computerNumber;
    private String userInput;
    private String userNumber;
    private int strikeCount;
    private int ballCount;
    private String resultMessage;
    private boolean end = false;
    
    public GameSystem() {
        setUpGame();
    }
    
    public void startGame() {
        System.out.println(MessageType.START.getMessage());
        
        while (!end) {
            System.out.print(MessageType.INSERT_NUMBER.getMessage());
            updateUserNumber();
            
            updateBallAndStrikeCounts();
            updateResultMessage();
            System.out.println(resultMessage);
            
            if (isAllStrike()) {
                System.out.println(MessageType.END.getMessage());
                System.out.println(MessageType.ASK_RESTART.getMessage());
                readyRestartOrEnd();
            }
        }
    }
    
    // 숫자 야구 게임 초기 설정 메서드
    private void setUpGame() {
        number = new Number();
        calculateService = new CalculateService();
        updateComputerNumber();
    }
    
    // 컴퓨터의 숫자를 업데이트하는 메서드
    private void updateComputerNumber() {
        computerNumber = number.setComputersNumber();
    }
    
    // 사용자의 숫자를 업데이트하는 메서드
    private void updateUserNumber() {
        userInput = getUserInput();
        userNumber = number.setUserNumber(userInput);
    }
    
    // 사용자의 입력을 받는 메서드
    private String getUserInput() {
        return Console.readLine();
    }
    
    // 볼과 스트라이크 개수를 업데이트하는 메서드
    private void updateBallAndStrikeCounts() {
        ballCount = calculateService.getBallCount(computerNumber, userNumber);
        strikeCount = calculateService.getStrikeCount(computerNumber, userNumber);
    }
    
    // 볼과 스트라이크 개수에 따른 결과 메시지를 업데이트하는 메서드
    private void updateResultMessage() {
        resultMessage = calculateService.getResultMessage(ballCount, strikeCount);
    }
    
    // 정답(3스트라이크)인지 판별하는 메서드
    private boolean isAllStrike() {
        return strikeCount == MAX_STRIKE_COUNT;
    }

    // 재시작, 종료 여부의 사용자 입력을 검증하는 메서드
    private String verifyUserInput(String userInput) {
        if (!userInput.equals(RESTART_NUMBER) && !userInput.equals(END_NUMBER)) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }
    
    // 사용자의 입력에 따른 재시작 혹은 종료를 위한 준비 메서드
    private void readyRestartOrEnd() {
        userInput = verifyUserInput(getUserInput());
        if (userInput.equals(RESTART_NUMBER)) {
            updateComputerNumber();
        } else if (userInput.equals(END_NUMBER)) {
            end = true;
        }
    }
}
