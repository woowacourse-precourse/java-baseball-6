package baseball.userInterface;

/*
 화면 출력을 담당하는 클래스
 */

public class MessageViewer {
    public void printStartMsg(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputRequestMsg(){
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void printResultMsg(int ballCount, int strikeCount) {
        StringBuilder resultMsg = new StringBuilder();

        if (ballCount == 0 && strikeCount == 0)
            resultMsg.append("낫싱");

        else if (ballCount > 0 && strikeCount > 0)
            resultMsg.append(ballCount).append("볼 ")
                    .append(strikeCount).append("스트라이크");

        else if (ballCount > 0)
            resultMsg.append(ballCount).append("볼");

        else if (strikeCount > 0)
            resultMsg.append(strikeCount).append("스트라이크");

        System.out.println(resultMsg);
    }

    public void printGameEndMsg(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
