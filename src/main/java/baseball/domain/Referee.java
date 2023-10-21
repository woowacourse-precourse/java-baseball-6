package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.view.OutputView.isEnd;

public class Referee {

    int strikeNumber = 0;
    int ballNumber = 0;
    int next = 1;

    public Referee() {
    }

    public void classify(List<BallStatus> BallStatuses) {
        for (BallStatus ballStatus : BallStatuses) {
            if (ballStatus == BallStatus.STRIKE) {
                strikeNumber++;
            }
            if (ballStatus == BallStatus.BALL) {
                ballNumber++;
            }
        }
    }

    public void judge() {
        if (strikeNumber == 3) {
            System.out.println(String.format("%d스트라이크", strikeNumber));
            isEnd();
            return;
        }
        if (ballNumber > 0 && strikeNumber > 0) {
            System.out.println(String.format("%d볼 %d스트라이크", ballNumber, strikeNumber));
            return;
        }
        if (ballNumber == 0 && strikeNumber > 0 && strikeNumber < 3) {
            System.out.println(String.format("%d스트라이크", strikeNumber));
            return;
        }
        if (ballNumber > 0 && strikeNumber == 0) {
            System.out.println(String.format("%d볼", ballNumber));
            return;
        }
        if (ballNumber == 0 && strikeNumber == 0) {
            System.out.println(String.format("낫싱"));
            return;
        } else {
            System.out.println("에러");
        }
    }
    
    private void isEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int next = Integer.parseInt(Console.readLine());
    }

    public int getNext() {
        return next;
    }

    public int getStrikeNumber() {
        return strikeNumber;
    }
}