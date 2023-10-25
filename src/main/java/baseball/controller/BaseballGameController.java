package baseball.controller;

import java.util.ArrayList;

import baseball.view.Hint;
import baseball.view.UserChoice;
import baseball.vo.Baseball;
import camp.nextstep.edu.missionutils.Randoms;

/*
 * 야구게임 기본 기능구현 
 */
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
    
    /*
     * 	유저가 고른 숫자가 룰에 맞는지 검증 
     */
    public void userChoiceInput() {
        userNumber = UserChoice.usersNumbering();
      
        if (isDifferentThreeNumber(userNumber)) {
            throw new IllegalArgumentException("3개의 서로 다른 숫자를 입력해주세요.");
        }
        
        if (userNumber.contains("0")) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }

        for (int i = 0; i < userNumber.length(); i++) {
            String[] splitUserNum = userNumber.split("|");
            if (!splitUserNum.equals("")) {
                b.setUserChoiceNumber(splitUserNum);
            }
        }
    }
    
    /*
     * 	3개의 숫자가 중복되지 않도록 예외발생 기능
     */
    private boolean isDifferentThreeNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            char differentNum = number.charAt(i);
            if (number.lastIndexOf(differentNum) != i) {
                return true; 
            }
        }
        return false;
    }

    public void choiceFail() {
        if (userNumber.length() != 3 || !userNumber.matches("\\d{3}")) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
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
        ArrayList<Character> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            char randomChar = (char) (randomNumber + '0');
            if (!computerNumber.contains(randomChar)) {
                computerNumber.add(randomChar);
            }
        }

        StringBuilder computerNumberStr = new StringBuilder();
        for (char c : computerNumber) {
            computerNumberStr.append(c);
        }

        b.setComputerNumber(computerNumberStr.toString());
    }

}
