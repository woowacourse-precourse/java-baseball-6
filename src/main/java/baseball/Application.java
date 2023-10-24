package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static final String NOTHING_KR = "낫싱";
    static final String BALL_KR = "볼";
    static final String STRIKE_KR = "스트라이크";
    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    static final String ANSWER_FOUND_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String GAME_OVER_MESSAGE = "게임 종료";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(START_MESSAGE);

        boolean play = true;
        while(play){
            int answer = generateAnswer();
            int[] answerArr = inputToArray(answer);

            playGame(answerArr);
            play = restartGame();

        }
    }

    private static void playGame(int[] answerArr) {
        while(true){
            System.out.print(INPUT_MESSAGE);
            String inputStr = Console.readLine();
            checkInput(inputStr);

            int input = Integer.parseInt(inputStr);
            int[] inputArr = inputToArray(input);
            Result result = checkGuess(answerArr, inputArr);
            String output = buildOutput(result);

            System.out.println(output);
            if(isOver(result)){
                System.out.println(ANSWER_FOUND_MESSAGE);
                return;
            }
        }
    }

    private static boolean restartGame() {
        System.out.println(RESTART_MESSAGE);
        String playOnStr = Console.readLine();
        if(!(playOnStr.equals("1") || playOnStr.equals("2"))){
            throw new IllegalArgumentException();
        }

        int playOn = Integer.parseInt(playOnStr);
        if(endGame(playOn)){
            System.out.print(GAME_OVER_MESSAGE);
            return false;
        }

        return true;
    }

    private static Result checkGuess(int[] target, int[] guess){
        int numOfBalls = checkBalls(target, guess);
        int numOfStrikes = checkStrikes(target, guess);

        return new Result(numOfBalls, numOfStrikes);
    }

    private static String buildOutput(Result result) {
        StringBuilder output = new StringBuilder();

        int numOfBalls = result.getBall();
        int numOfStrikes = result.getStrike();

        if(numOfBalls == 0 && numOfStrikes == 0){
            output.append(NOTHING_KR);
        }else if(numOfBalls == 0){
            output.append(numOfStrikes).append(STRIKE_KR);
        }else if(numOfStrikes == 0){
            output.append(numOfBalls).append(BALL_KR);
        }else{
            output.append(numOfBalls).append(BALL_KR).append(" ").append(numOfStrikes).append(STRIKE_KR);
        }

        return output.toString();
    }

    private static int checkBalls(int[] target, int[] guess){
        int result = 0;

        for(int i = 0; i < 3; i++){
            int currentNumber = guess[i];
            int nextIdx = (i + 1) % 3;
            int prevIdx = (i + 2) % 3;
            if(target[nextIdx] == currentNumber || target[prevIdx] == currentNumber){
                result++;
            }
        }

        return result;
    }

    private static int checkStrikes(int[] target, int[] guess){
        int result = 0;

        for(int i = 0; i < 3; i++){
            if(target[i] == guess[i]){
                result++;
            }
        }

        return result;
    }

    private static int[] inputToArray(int number){
        int hundred = number/100;
        int ten = number/10%10;
        int one = number%10;

        int[] result = {hundred, ten, one};

        return result;
    }

    private static boolean isOver(Result result){
        return result.getStrike() == 3;
    }

    private static boolean endGame(int playOn){
        return playOn == 2;
    }

    private static void checkInput(String input) {
        if(input.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    private static int generateAnswer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        int result = 100 * computer.get(0) + 10 * computer.get(1) + computer.get(2);
        return result;
    }

    private static class Result{
        int ball;
        int strike;

        private Result(int ball, int strike){
            this.ball = ball;
            this.strike = strike;
        }

        private int getBall() {
            return ball;
        }

        private int getStrike() {
            return strike;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "ball=" + ball +
                    ", strike=" + strike +
                    '}';
        }
    }
}
