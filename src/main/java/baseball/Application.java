package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static final String NOTHING_KR = "낫싱";
    static final String BALL_KR = "볼";
    static final String STRIKE_KR = "스트라이크";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean play = true;
        while(play){
            int answer = generateAnswer();
            int[] answerArr = inputToArray(answer);

            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                String inputStr = "";
                inputStr = Console.readLine();
                checkInput(inputStr);


                int input = Integer.parseInt(inputStr);
                int[] inputArr = inputToArray(input);
                Result result = checkGuess(answerArr, inputArr);
                String output = buildOutput(result);

                System.out.println(output);
                if(isOver(result)){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String playOnStr = Console.readLine();
            if(!(playOnStr.equals("1") || playOnStr.equals("2"))){
                throw new IllegalArgumentException();
            }

            int playOn = Integer.parseInt(playOnStr);
            if(endGame(playOn)){
                System.out.print("게임 종료");
                play = false;
            }
        }
    }

    public static Result checkGuess(int[] target, int[] guess){
        int numOfBalls = checkBalls(target, guess);
        int numOfStrikes = checkStrikes(target, guess);

        return new Result(numOfBalls, numOfStrikes);
    }

    public static String buildOutput(Result result) {
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

    public static int checkBalls(int[] target, int[] guess){
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

    public static int checkStrikes(int[] target, int[] guess){
        int result = 0;

        for(int i = 0; i < 3; i++){
            if(target[i] == guess[i]){
                result++;
            }
        }

        return result;
    }

    public static int[] inputToArray(int number){
        int hundred = number/100;
        int ten = number/10%10;
        int one = number%10;

        int[] result = {hundred, ten, one};

        return result;
    }

    public static boolean isOver(Result result){
        return result.getStrike() == 3;
    }

    public static boolean endGame(int playOn){
        return playOn == 2;
    }

    public static void checkInput(String input) {
        if(input.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    public static int generateAnswer(){
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

    public static class Result{
        int ball;
        int strike;

        public Result(int ball, int strike){
            this.ball = ball;
            this.strike = strike;
        }

        public int getBall() {
            return ball;
        }

        public int getStrike() {
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
