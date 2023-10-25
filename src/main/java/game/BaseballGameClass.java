package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class BaseballGameClass implements Game{
    private List<Integer> RandomAnswerGeneratedInInit;

    public List<Integer> RandomNumberGenerator(){
        List<Integer> randomNumberGenerated = new ArrayList<>();
        while(randomNumberGenerated.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!randomNumberGenerated.contains(randomNumber)){
                randomNumberGenerated.add(randomNumber);
            }
        }
        return randomNumberGenerated;
    }
    @Override
    public void gameInit() {
        RandomAnswerGeneratedInInit = RandomNumberGenerator();
        System.out.println("RandomAnswerGeneratedInInit = " + RandomAnswerGeneratedInInit);
    }


    @Override
    public void gamePlay(){
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        while(true) {
            System.out.printf("숫자를 입력해주세요: ");
            String inputNumber = Console.readLine();

            exceptionHandler.NumberSizeExceed(inputNumber);
            exceptionHandler.UnexpectedValue(inputNumber);
            exceptionHandler.DuplicatedValue(inputNumber);

            CountManager countManager = new CountManager();
            countManager.CalculateCount(inputNumber, RandomAnswerGeneratedInInit);
            String ballstrikeString = countManager.BallStrikeStringManager();
            System.out.println(ballstrikeString);
            if(countManager.gameRestartChecker()){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }

    @Override
    public Integer gameExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputNumber = Console.readLine();
        if(inputNumber.charAt(0) == '2') {
            return 2;
        }
        return 1;
    }
}
