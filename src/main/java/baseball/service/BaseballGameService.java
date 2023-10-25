package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.Computer;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGameService {
    private static final String EXIT_NUMBER = "2";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void start(){
        System.out.println(START_MESSAGE);
        List<Integer> numbers = Computer.generateRandomThreeValue();
        User user = new User();
        BaseballGame baseballGame = new BaseballGame(numbers, user);
        playGame(baseballGame);
    }

    public void playGame(BaseballGame baseballGame){
        User user = baseballGame.getUser();
        List<Integer> targetNumbers = baseballGame.getTargetNumber();

        while(true){
            System.out.print(INPUT_MESSAGE);
            String input = Console.readLine();

            checkInputValidation(input);

            makeUserNumbers(input, user);

            if(compareTwoNumbers(targetNumbers, user.getNumbers())){
                finish();
                String endInput = User.input();
                if(isEndBaseballGame(endInput)){
                    break;
                }

                targetNumbers.clear();
                targetNumbers = Computer.generateRandomThreeValue();
            }

            user.getNumbers().clear();
        }
    }

    private boolean isEndBaseballGame(String endInput) {
        return endInput.equals(EXIT_NUMBER);
    }

    private static void makeUserNumbers(String input, User user) {
        for(int i = 0; i< input.length(); i++){
            int num = input.charAt(i) - '0';
            user.addNumber(num);
        }
    }

    private static void checkInputValidation(String input) {
        if(input.isEmpty() || input.length() > 3){
            throw new IllegalArgumentException();
        }
    }

    public boolean compareTwoNumbers(List<Integer> targetNumbers, List<Integer> userNumbers){
        int strike = 0;
        int ball = 0;
        boolean isNothing = false;

        for(int i=0; i<targetNumbers.size(); i++){
            for(int j=0; j<userNumbers.size(); j++){
                if(isStrike(targetNumbers, userNumbers, i, j)){
                    strike++;
                    break;
                } else if(isBall(targetNumbers, userNumbers, i, j)){
                    ball++;
                    break;
                }
            }
        }

        if(isNothing(strike, ball)){
            isNothing = true;
        }
        printResult(isNothing, strike, ball);

        return strike == 3;
    }

    private static boolean isNothing(int strike, int ball) {
        return strike + ball == 0;
    }

    private static boolean isBall(List<Integer> targetNumbers, List<Integer> userNumbers, int i, int j) {
        return targetNumbers.get(i).equals(userNumbers.get(j)) && i != j;
    }

    private static boolean isStrike(List<Integer> targetNumbers, List<Integer> userNumbers, int i, int j) {
        return targetNumbers.get(i).equals(userNumbers.get(j)) && i == j;
    }

    public void printResult(boolean isNothing, int strike, int ball){
        if(isNothing){
            System.out.println("낫싱");
            return ;
        }

        if(ball > 0){
            System.out.print(ball + "볼 ");
        }
        if(strike > 0){
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    public void finish(){
        System.out.println(END_MESSAGE);
        System.out.println(RESTART_MESSAGE);
    }

}
