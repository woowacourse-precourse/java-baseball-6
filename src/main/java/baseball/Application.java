package baseball;

import baseball.enums.GameFlag;
import baseball.enums.Message;
import baseball.enums.OrNot;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Application {


    public static void main(String[] args) {
        GameFlag flag = GameFlag.START;
        PrintMessage.printlnMessage(Message.START);
        while (flag == GameFlag.START) {
            // 랜덤한 값 서로 다른 수 3자리를 생성한다. TODO 함수로 뺄 예정
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            Set<Integer> targetSet = new HashSet<>();
            while (targetSet.size() < 3) {
                int randomNum = random.nextInt(9)+1;
                targetSet.add(randomNum);
            }

            GameInputValue gameValue = new GameInputValue(targetSet.stream()
                    .map(String::valueOf)
                    .reduce("", String::concat));
            flag = GameFlag.ING;

            // 맞출 때 까지 반복
            while (flag == GameFlag.ING){
                PrintMessage.printMessage(Message.INPUT_NUMBER);
                Scanner sc = new Scanner(System.in);
                gameValue.setUserInputValue(sc.nextLine());

                // 사용자 수와 컴퓨터 수 검증하기
                if (!gameValue.isEqaulsUserAndComputerValue()) {
                    // TODO 예외 사항 1. 입력 수가 3자리 이상일때 2. 입력수가 유효하지 않을 때(모두 숫자가 아닐시)

                    Result result = new Result(gameValue.countSameNumber() - gameValue.countSamePositionAndNumber(), gameValue.countSamePositionAndNumber());
                    if (gameValue.isNothing()) {
                        PrintMessage.printlnMessage(Message.NOTHING);
                    }else{
                        PrintMessage.printlnMessage(Message.makeHintMessage(result));
                    }
                    continue;
                }

                PrintMessage.printlnMessage(Message.PLAY_NEXT_GAME_OR_NOT);
                Scanner sc2 = new Scanner(System.in);
                String answer = sc2.nextLine();
                if (answer.equals(OrNot.YES.getProcessCode())) {
                    flag = GameFlag.START;
                    break;
                }
                if (answer.equals(OrNot.NO.getProcessCode())) {
                    flag = GameFlag.END;
                }
            }

        }
    }
}
