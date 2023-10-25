package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
/*  -> (1) 상대방의 수 만들기: generateComputerNumber() OK,
    -> (2) 사용자의 입력을 받는 기능: inputUserNumber() OK,
        2-1) 스트라이크인지 확인하는 기능 isStrike(), OK
        2-2) 볼인지 확인하는 기능 isBall(), OK
        2-3) 결과를 출력하는 기능 outputResult()
    -> (3) 게임을 시작하고 종료하는 기능 startEndGame(),
        3-1) 종료 후 재시작 여부를 확인하는 기능 isRestart() OK
    -> (4) 사용자의 입력이 숫자인지 확인하는 기능 isDigit() OK,
        4-1) 사용자의 입력이 3자리 숫자인지 확인하는 기능 isThree() OK,
        4-2) 사용자가 입력한 숫자 중 동일한 숫자가 없는지 확인하는 기능
             isDupilcate() OK */
public class Digit {
    private final int end = 3;
    private int ball = 0;
    private int strike = 0;
    private int reStart = 0;
    private int ballPlusStrike = 0;
    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getReStart() {
        return reStart;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setReStart(int reStart) {
        this.reStart = reStart;
    }
    public int getBallPlusStrike() {

        return this.ballPlusStrike;
    }

    public void setBallPlusStrike(int ballPlusStrike) {
        this.ballPlusStrike = ballPlusStrike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
    private List<Integer> computerNumber = new ArrayList<>();
    private List<Integer> userNumber = new ArrayList<>();
    public Digit() {}
    public List<Integer> getComputerNumber() {
        return this.computerNumber;
    }
    public void generateComputerNumber() {
        this.computerNumber = new ArrayList<>();
        while (this.computerNumber.size() < end) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.computerNumber.contains(randomNumber)) {
                this.computerNumber.add(randomNumber);
            }
        }
    }
    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void inputUserNumber(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }
    public int isStrike() {
        int strike=0;
        Object[] forStrikeComputer = computerNumber.toArray();
        Object[] forStrikeUser = userNumber.toArray();
        for (int i=0; i<3; i++) {
            if (forStrikeUser[i].equals(forStrikeComputer[i])) {
               strike++;
            }
        }
        return this.strike = strike;
    }
    public int isBall() {
        int ball = 0;
        for(Integer i : userNumber) {
            if (computerNumber.contains(i)) {
                ball++;
            }
        }
        return this.ball = ball;
    }
    public String outputResult() {
        String resultString = "";
        ballPlusStrike = getBall()+getStrike();
        setBall(ballPlusStrike-strike);
        setStrike(ballPlusStrike-ball);

        if (getBall() == 0 && getStrike() == 0) {
            return "낫싱";
        }
        if (getBall() != 0) {
           resultString += getBall() + "볼 ";
        }
        if (getStrike() != 0) {
            resultString += getStrike() + "스트라이크 ";
        }
        if (getStrike() == 3) {
            resultString += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        return resultString;
    }
}
