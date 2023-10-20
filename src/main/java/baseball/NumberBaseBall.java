package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class NumberBaseBall {
    RandomNumberGenerator randomNumberGenerator;
    NumberChecker numberChecker;
    InputValidator inputValidator;
    List<Integer> computer;
    public void init(){
        randomNumberGenerator = new RandomNumberGenerator();
        numberChecker = new NumberChecker();
        inputValidator = new InputValidator();
        computer = randomNumberGenerator.generateRandomNumber();
    }

    public void run(){
        boolean keepGoing = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (keepGoing){
            System.out.println("숫자를 입력해주세요 : ");
            System.out.println(computer.get(0) + " " + computer.get(1) + " " + computer.get(2));
            List<Integer> user = inputValidator.validateUserAnswer(Console.readLine());
            System.out.println(user.get(0) + " " + user.get(1) + " " + user.get(2));
            StringBuilder checkResult = numberChecker.checkNumber(user, computer);
            System.out.println(checkResult);
            if(checkResult.toString().equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int restart = inputValidator.validateRestartInput(Console.readLine());

                if (restart == 1)
                    computer = randomNumberGenerator.generateRandomNumber();
                else if (restart == 2)
                    keepGoing = false;

            }
        }
    }
}
