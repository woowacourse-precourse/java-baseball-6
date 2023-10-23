package baseball.controller;

import baseball.vo.Baseball;
import baseball.view.Hint;
import baseball.view.UserChoice;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGameController {
    private Baseball b;
    private String userNumber;

    public BaseballGameController() {
        b = new Baseball();
    }

    public void start() {
        do {
            computerNumbering();
            Hint.startMessage();

            while (true) {
                userChoiceInput();
                choiceFail();

                int strikes = strikeJudge();
                int balls = ballJudge();
                b.setStrike(strikes);
                b.setBall(balls);

                hintMessage();

                if (strikes == 3) {
                    Hint.endMessage();
                    break;
                }
            }
        } while (restart());
    }

    public void userChoiceInput() {
        userNumber = UserChoice.usersNumbering();
    }

    public void choiceFail() {
        if (userNumber.length() != 3 || !userNumber.matches("\\d{3}")) {
            throw new IllegalArgumentException("입력을 잘못하셨습니다. 3자리 숫자를 입력해주세요");
        }
    }

    public int strikeJudge() {
        String computerNumber = b.getComputerNumber();
        
        int strikeScore = 0;
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) == computerNumber.charAt(i)) {
                strikeScore++;
            }
        }
        return strikeScore;
    }

    public int ballJudge() {
        String computerNumber = b.getComputerNumber();
        
        int ballScore = 0;
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) != computerNumber.charAt(i) && computerNumber.contains(String.valueOf(userNumber.charAt(i)))) {
                ballScore++;
            }
        }
        return ballScore;
    }

    public void hintMessage() {
    	if (b.getBall() > 0) {
    		Hint.ball(b);
    	}
    	
        if (b.getStrike() > 0) {
            Hint.strike(b);
        }
        
        if (b.getBall() == 0 && b.getStrike() == 0) {
            Hint.nothing();
        }
    }

    public boolean restart() {
        String choice = UserChoice.gameStartEnd();
        
        if ("2".equals(choice)) {
        	Hint.gameOverMessage();
            return false;
        }
        
        if (!"1".equals(choice)) {
            throw new IllegalArgumentException("1 또는 2만 선택해주세요.");
        }
        return true;
    }

    public void computerNumbering() {
        StringBuilder computerNumberStr = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            computerNumberStr.append(randomNumber);
        }
        b.setComputerNumber(computerNumberStr.toString());
    }

}
