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
    }


    @Override
    public void gamePlay() throws IllegalArgumentException{
        while(true) {
            System.out.printf("숫자를 입력해주세요: ");
            String inputNumber = Console.readLine();

            if(inputNumber.length() != 3) {
                throw new IllegalArgumentException();
            }
            for(int i=0; i<inputNumber.length(); i++){
                if(inputNumber.charAt(i) < '1' || inputNumber.charAt(i) >'9'){
                    throw new IllegalArgumentException();
                }
            }

            Integer ballCount = 0, strikeCount = 0;
            for (int i = 0; i < inputNumber.length(); i++) {
                if (inputNumber.charAt(i) == RandomAnswerGeneratedInInit.get(i)+'0') {
                    strikeCount += 1;
                    continue;
                }
                if (RandomAnswerGeneratedInInit.contains(inputNumber.charAt(i)-'0')) {
                    ballCount += 1;
                }
            }
            if(ballCount == 0 && strikeCount == 0){
                System.out.println("낫싱");
                continue;
            }
            if(ballCount != 0){
                System.out.printf(ballCount.toString()+"볼 ");
            }
            if(strikeCount != 0){
                System.out.printf(strikeCount.toString()+"스트라이크");
            }
            System.out.println();
            if(strikeCount == 3){
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
