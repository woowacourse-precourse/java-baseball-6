package baseball;

import baseball.enums.GameFlag;
import baseball.enums.GameProgressMessage;
import baseball.enums.OrNot;
import baseball.exception.WrongInputException;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NumberBaseBallGameLauncher {

    public void startGame() {
        init();
    }

    private void init() {
        // Game 시작 Setting
        GameFlag flag = GameFlag.START;
        PrintMessage.printlnMessage(GameProgressMessage.START);

        while (flag == GameFlag.START) {

            // 컴퓨터 수 생성
            Set<Integer> targetSet = new HashSet<>();
            while (targetSet.size() < 3) {
                targetSet.add(pickNumberInRange(1, 9));
            }

            GameInputValue gameValue = new GameInputValue(targetSet.stream()
                    .map(String::valueOf)
                    .reduce("", String::concat));

            flag = GameFlag.ING;

            // 맞출 때 까지 반복
            while (flag == GameFlag.ING) {
                PrintMessage.printMessage(GameProgressMessage.INPUT_NUMBER);
                gameValue.setUserInputValue(readLine());

                // 입력값 검증
                try {
                    gameValue.checkValidUserInput();
                } catch (WrongInputException exception) {
                    PrintMessage.printlnMessage(exception.getMessage());
                    continue;
                }

                // 사용자 수와 컴퓨터 수 비교
                Result result = new Result(gameValue.countSameNumber() - gameValue.countSamePositionAndNumber(), gameValue.countSamePositionAndNumber());
                if (gameValue.isNothing()) {
                    PrintMessage.printlnMessage(GameProgressMessage.NOTHING);
                } else {
                    PrintMessage.printlnMessage(GameProgressMessage.makeHintMessage(result));
                }

                // 리플레이 또는 종료
                if(gameValue.isEqaulsUserAndComputerValue()){
                    PrintMessage.printlnMessage(GameProgressMessage.PLAY_NEXT_GAME_OR_NOT);
                    String answer = readLine();

                    if (answer.equals(OrNot.YES.getProcessCode())) {
                        flag = GameFlag.START;
                    }
                    if (answer.equals(OrNot.NO.getProcessCode())) {
                        flag = GameFlag.END;
                    }
                }
            }

        }

    }

}
