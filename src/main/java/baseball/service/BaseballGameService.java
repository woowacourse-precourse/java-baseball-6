package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.Computer;
import baseball.domain.User;

import java.util.List;

public class BaseballGameService {

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> numbers = Computer.generateRandomThreeValue();
        User user = new User();
        BaseballGame baseballGame = new BaseballGame(numbers, user);
        playGame(baseballGame);


    }

    public void playGame(BaseballGame baseballGame){
        User user = baseballGame.getUser();
        List<Integer> targetNumbers = baseballGame.getTargetNumber();

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String input = User.input();

            if(input.isEmpty() || input.length() > 3){
                throw new IllegalArgumentException();
            }

            for(int i=0; i<input.length(); i++){
                int num = input.charAt(i) - '0';
                user.addNumber(num);
            }

            if(compareTwoNumbers(targetNumbers, user.getNumbers())){
                finish();
                String endInput = User.input();
                if(endInput.equals("2")){
                    break;
                }
                targetNumbers = baseballGame.getTargetNumber();
            }

            user.getNumbers().clear();
        }


    }

    public boolean compareTwoNumbers(List<Integer> targetNumbers, List<Integer> userNumbers){
        int strike = 0;
        int ball = 0;
        boolean isNothing = false;

        for(int i=0; i<targetNumbers.size(); i++){
            for(int j=0; j<userNumbers.size(); j++){
                if(targetNumbers.get(i) == userNumbers.get(j) && i == j){
                    strike++;
                    break;
                } else if(targetNumbers.get(i) == userNumbers.get(j) && i != j){
                    ball++;
                    break;
                }
            }
        }

        if(strike + ball == 0){
            isNothing = true;
        }
        printResult(isNothing, strike, ball);

        if(strike == 3){
            return true;
        }

        return false;


    }

    public void printResult(boolean isNothing, int strike, int ball){
        if(isNothing){
            System.out.println("낫싱");
            return ;
        }

        if(strike > 0){
            System.out.print(strike + " 스트라이크 ");
        }
        if(ball > 0){
            System.out.print(ball + " 볼");
        }
        System.out.println();
    }

    public void finish(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
