package baseball;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public void outputGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void outputGameScore(final int strikeCnt, final int ballCnt) {
        String messageBall = "";
        String messageStrike = "";

        if (ballCnt > 0) {
            messageBall = String.valueOf(ballCnt) + "볼 ";
        }
        if (strikeCnt > 0) {
            messageStrike = String.valueOf(strikeCnt) + "스트라이크";
        }
        if (ballCnt + strikeCnt > 0) {
            System.out.println(messageBall + messageStrike);
            return;
        }
        if (ballCnt + strikeCnt == 0) {
            System.out.println("낫싱");
            return;
        }
    }

    public String inputPlayerAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String inputPlayerRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}

