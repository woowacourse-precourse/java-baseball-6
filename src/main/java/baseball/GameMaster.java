package baseball;

import java.util.List;

public class GameMaster {
    private int strikeCount = 0;
    private int ballCount = 0;
    private boolean replay = false;
    private boolean answer = true;

    public GameMaster() {
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public boolean isReplay() {
        return replay;
    }

    public void setReplay(boolean replay) {
        this.replay = replay;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public void countStrikeAndBall(List computerRandomNumber, List userPickNumber) {
        for (int i = 0; i < computerRandomNumber.size(); i++) {
            if (computerRandomNumber.get(i)==userPickNumber.get(i)) {
                strikeCount++;
            }
            for (int j = 0; j < userPickNumber.size(); j++) {
                if (computerRandomNumber.get(i)==userPickNumber.get(j) && i!=j) {
                    ballCount++;
                }
            }
        }
    }

    public StringBuffer generateHint(int ballCount, int strikeCount) {
        StringBuffer hint = new StringBuffer();
        if (ballCount > 0) {
            hint.append(ballCount).append("볼");
        }
        if (ballCount > 0 && strikeCount > 0) {
            hint.append(" ");
        }
        if (strikeCount > 0) {
            hint.append(strikeCount).append("스트라이크");
        }
        if (ballCount==0 && strikeCount==0) {
            hint.append("낫싱");
        }
        return hint;
    }

    public void replayIntExceptionCheck(String replayInt) {
        if (!(replayInt.equals("1") || replayInt.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2만 입력해야합니다.");
        }
    }

    public void replayIntResultCheck(String replayInt) {
        if (replayInt.equals("1")) {
            this.replay = true;
        }
        if (replayInt.equals("2")) {
            this.answer = false;
            System.out.println("게임 종료");
        }
    }
}

