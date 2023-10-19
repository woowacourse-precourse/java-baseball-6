package baseball.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(int ballCnt, int strikeCnt) {

        // 하나도 없는 경우
        if (ballCnt == 0 && strikeCnt == 0)
            System.out.println("낫싱");

        // 볼, 스트라이크가 모두 하나 이상인 경우
        else if (ballCnt > 0 && strikeCnt > 0)
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");

        // 볼만 있는 경우
        else if (ballCnt > 0 && strikeCnt == 0)
            System.out.println(ballCnt + "볼");

        // 스트라이크만 있는 경우
        else if (ballCnt == 0 && strikeCnt > 0) {
            System.out.println(strikeCnt + "스트라이크");

            // 스트라이크가 3인 경우 (숫자를 맞춘 경우)
            if (strikeCnt == 3)
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

}
