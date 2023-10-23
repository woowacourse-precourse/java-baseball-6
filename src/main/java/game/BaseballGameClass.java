package game;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGameClass implements Game{
    private Scanner scanner = new Scanner(System.in);
    private List<Integer> RandomAnswerGeneratedInInit;
    @Override
    public void gameInit() {
        List<Integer> RandomAnswerGenerated = new ArrayList<>();
        while(RandomAnswerGenerated.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!RandomAnswerGenerated.contains(randomNumber)){
                RandomAnswerGenerated.add(randomNumber);
            }
        }
        RandomAnswerGeneratedInInit =  RandomAnswerGenerated;
        System.out.println("RandomAnswerGenerated = " + RandomAnswerGenerated);
    }


    @Override
    public void gamePlay(){
        while(true) {
            System.out.printf("숫자를 입력해주세요: ");
            String inputNumber = scanner.nextLine();
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
    public void gameExit() {

    }
}
