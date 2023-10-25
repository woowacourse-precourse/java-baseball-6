package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * 숫자야구 게임
 */
public class BaseballGame {
    UserInputCheck userInputCheck = new UserInputCheck(); // 사용자 입력 유효성 확인 및 Exception 처리
    Computer computer = new Computer(); // 컴퓨터

    /**
     * 숫자야구 게임 진행
     */
    public void playGame(){
        // 게임 시작
        int end = Constant.RESTART_OPTION; // 게임 재시작 or 종료
        System.out.println(Constant.START_GAME_MESSAGE);

        while (end != Constant.END_OPTION){
            // 컴퓨터 숫자 생성
            List<Integer> computerNumbers = computer.generateNumbers();

            Hint hint = new Hint(0, 0); // 힌트

            // 정답을 맞출 때까지 반복
            while (hint.getStrikeCount()!=Constant.GENERATE_NUM_SIZE) {
                // 사용자 입력 - 숫자
                List<Integer> inputNumbers = checkNumbers();

                // 힌트 생성 및 출력
                hint = computer.compareNumbers(computerNumbers, inputNumbers);
                printHint(hint);
            }
            // 게임 종료
            System.out.println(Constant.END_GAME_MESSAGE);
            // 사용자 입력 - 게임 재시작 or 종료
            end = checkRestart();
        }
    }

    /**
     * 사용자 숫자 입력 및 유효성 확인
     */
    public List<Integer> checkNumbers(){
        // 사용자 입력 - 숫자
        System.out.print(Constant.INPUT_NUMBER_MESSAGE);
        String input = Console.readLine();

        // 유효성 확인 및 Exception 처리
        userInputCheck.validNumbers(input);

        List<Integer> inputNumbers = new ArrayList<>();
        for (int i=0; i<Constant.GENERATE_NUM_SIZE; i++){
            inputNumbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        return inputNumbers;
    }

    /**
     * 사용자 게임 재시작 or 종료 입력 및 유효성 확인
     */
    public int checkRestart(){
        // 사용자 입력 - 게임 재시작 or 종료
        System.out.println(Constant.RESTART_GAME_MESSAGE);
        String input = Console.readLine();

        // 유효성 확인 및 Exception 처리
        userInputCheck.validRestart(input);

        return Integer.parseInt(input);
    }

    /**
     * 힌트 출력
     */
    public void printHint(Hint hint){
        if (hint.getBallCount() == 0 && hint.getStrikeCount() == 0){
            System.out.println(Constant.NOTHING_STR);
        } else if (hint.getBallCount() == 0){
            System.out.println(hint.getStrikeCount()+Constant.STRIKE_STR);
        } else if (hint.getStrikeCount() == 0){
            System.out.println(hint.getBallCount()+Constant.BALL_STR);
        } else {
            System.out.println(hint.getBallCount()+Constant.BALL_STR+" "+hint.getStrikeCount()+Constant.STRIKE_STR);
        }
    }
}
