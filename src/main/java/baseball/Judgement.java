package baseball;

import baseball.enums.GameProgressMessage;

public class Judgement {

    public void judge(GameInputValue gameValue) {
        // 사용자 수와 컴퓨터 수 비교 => 판정하는 클래스가 해야할 일
        Result result = new Result(gameValue.countSameNumber() - gameValue.countSamePositionAndNumber(), gameValue.countSamePositionAndNumber());
        if (gameValue.isNothing()) {
            PrintMessage.printlnMessage(GameProgressMessage.NOTHING);
        } else {
            PrintMessage.printlnMessage(GameProgressMessage.makeHintMessage(result));
        }
    }

}
