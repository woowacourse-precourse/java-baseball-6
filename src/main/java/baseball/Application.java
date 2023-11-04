package baseball;

import baseball.enums.GameFlag;
import baseball.enums.Message;
import baseball.enums.OrNot;
import baseball.exception.WrongInputException;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {


    public static void main(String[] args) throws WrongInputException {
        // Game 시작 Setting
        GameFlag flag = GameFlag.START;
        PrintMessage.printlnMessage(Message.START);

        while (flag == GameFlag.START) {

            // 컴퓨터 수 생성
            Set<Integer> targetSet = new HashSet<>();
            while (targetSet.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                targetSet.add(randomNumber);
            }

            GameInputValue gameValue = new GameInputValue(targetSet.stream()
                    .map(String::valueOf)
                    .reduce("", String::concat));

            flag = GameFlag.ING;

            // 맞출 때 까지 반복
            while (flag == GameFlag.ING) {
                PrintMessage.printMessage(Message.INPUT_NUMBER);
                Scanner sc = new Scanner(System.in);
                gameValue.setUserInputValue(sc.nextLine());

                // 입력값 검증
                try {
                    gameValue.checkValidUserInput();
                } catch (WrongInputException exception) {
                    PrintMessage.printlnMessage(exception.getMessage());
                    continue;
                }

                // 사용자 수와 컴퓨터 수 비교
                if (!gameValue.isEqaulsUserAndComputerValue()) {
                    Result result = new Result(gameValue.countSameNumber() - gameValue.countSamePositionAndNumber(), gameValue.countSamePositionAndNumber());
                    if (gameValue.isNothing()) {
                        PrintMessage.printlnMessage(Message.NOTHING);
                    } else {
                        PrintMessage.printlnMessage(Message.makeHintMessage(result));
                    }
                    continue;
                }


                // 리플레이 또는 종료
                PrintMessage.printlnMessage(Message.PLAY_NEXT_GAME_OR_NOT);
                Scanner sc2 = new Scanner(System.in);
                String answer = sc2.nextLine();

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
