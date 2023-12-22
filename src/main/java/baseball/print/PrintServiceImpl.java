package baseball.print;

import static baseball.Constant.*;

public class PrintServiceImpl implements PrintService{
    @Override
    public void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void inputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void gameEndMessage() {
        System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", SIZE));
    }

    @Override
    public void restartMessage() {
        System.out.println(String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", RESTART_FLAG, END_FLAG));
    }

    @Override
    public void resultMessage(int strikeCount, int ballCount) {
        if(strikeCount == 0 && ballCount ==0)
            System.out.print("낫싱");

        if(ballCount > 0)
            System.out.print(String.format("%d볼 ", ballCount));
        if(strikeCount > 0)
            System.out.print(String.format("%d스트라이크 ", strikeCount));

        System.out.println();
    }

}
