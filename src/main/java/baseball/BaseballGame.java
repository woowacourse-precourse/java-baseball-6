package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import validator.Validator;
import constant.Numeric;
import constant.Message;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public int strike = 0, ball = 0;
    Validator validator = new Validator();

    protected void startSystem() {
        sayStart();
        runGames();
    }
    private void runGames(){
        runOneGame();
        if (determineRestart()) {
            runGames();
        }
    }
    private void runOneGame() {
        setBallStrikeZero();
        List<Integer> computer = getRandomThreeNum();
        while (strike != Numeric.NUMBER_OF_INPUT) {
            runOneRound(computer);
        }
        sayEndGame();
    }
    private void runOneRound(List<Integer> computer) {
        setBallStrikeZero();
        List<Integer> user = getThreeNum();
        calculateBallStrike(user, computer);
        sayBallStrike(ball, strike);
    }
    // 게임 시작
    private void sayStart(){
        System.out.println(Message.START_SYSTEM_MESSAGE);
    }
    // strike, ball 0으로 초기화
    private void setBallStrikeZero() {
        ball = 0;
        strike = 0;
    }
    // 1~9 수 중 3개의 중복되지 않은 수 리턴
    private List<Integer> getRandomThreeNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Numeric.NUMBER_OF_INPUT) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
//        System.out.println(computer); // 디버깅
        return computer;
    }
    //  1~9 수 중 중복되지 않은 수 3개 input 받기
    private List<Integer> getThreeNum() throws IllegalArgumentException{
        List<Integer> user = new ArrayList<>();
        System.out.print(Message.REQUIRE_NUMBER_MESSAGE);
        String input = Console.readLine();
        validator.validateStringLength(input);
        for (int i=0; i<Numeric.NUMBER_OF_INPUT; i++) {
            char charValue = input.charAt(i);
            Integer intValue = charValue - '0';
            validator.validateNumberRange(intValue);
            validator.validateDuplicateNumbers(user, intValue);
            user.add(intValue);
        }
        return user;
    }
    // strike, ball 판별
    private void calculateBallStrike(List<Integer>user, List<Integer>computer){
        setBallStrikeZero();
        for (int i=0; i<user.size(); i++) {
            int number = user.get(i);
            determineBallOrStrike(number, i, computer);
        }
    }
    // ball인지 strike인지 판별 (같은 수 찾으면 더이상 볼 필요 없으므로 반복문 탈출)
    private void determineBallOrStrike(Integer number, int i, List<Integer>computer) {
        for (int j = 0; j< Numeric.NUMBER_OF_INPUT; j++) {
            Integer numberInList = computer.get(j);
            if (number.equals(numberInList) && i == j) {
                strike += 1;
                break;
            } else if (number.equals(numberInList) && i != j){
                ball += 1;
                break;
            }
        }
    }
    // strike, ball 출력
    private void sayBallStrike(int ball, int strike){
        // else 사용 X
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        } else if (ball != 0 && strike == 0){
            System.out.printf("%d볼", ball);
        } else if (ball == 0 && strike != 0) {
            System.out.printf("%d스트라이크", strike);
        } else if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크", ball, strike);
        }
        System.out.println();
    }
    // 게임 종료 (3스트라이크 시)
    private void sayEndGame() {
        System.out.printf(Message.END_GAME_MESSAGE);
    }
    // 게임 새로 시작 할 지 정하기
    private Boolean determineRestart() throws IllegalArgumentException{
        System.out.println(Message.ASK_RESTART_MESSAGE);
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } // 입력값이 1, 2가 아닐 때
        throw new IllegalArgumentException();
    }
}
