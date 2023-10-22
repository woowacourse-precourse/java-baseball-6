package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.List;

public class Game {
    public void playGame() {
        System.out.println(Constans.START_GAME);
        while(true) {
            int[] answerNums = creRandomNums();
            String result = "";

            while (!result.equals(String.format(Constans.STRIKE, Constans.MAX_NUMBER)) || result.equals("")) {
                int[] nums = inputNums();
                result = outputResult(nums, answerNums);
                System.out.println(result);
            }
            System.out.println(Constans.END_GAME);
            System.out.println(Constans.ASK_RESTART);
            String reStart = Console.readLine();
            if (reStart.equals("1")) {
                continue;
            } else if (reStart.equals("2")) {
                break;
            } else {
                Exceptions.IllegalArgumentException(Constans.REQUEST_1_OR_2);
            }
        }
    }

    public int[] inputNums() {
        System.out.print(Constans.REQUEST_NUMS);
        String userAnswer = Console.readLine();
        inputNumsTest(userAnswer);
        String[] userAnswerNums = userAnswer.split("");
        int[] nums = new int[Constans.MAX_NUMBER];
        for(int i = 0; i < Constans.MAX_NUMBER; i++){
            nums[i] = Integer.parseInt(userAnswerNums[i]);
        }
        return nums;
    }

    public void inputNumsTest(String userAnswer){
        String[] spiltAnswer = userAnswer.split("");
        Set<String> uniqueDigits = new HashSet<>();
        for(int i = 0; i < spiltAnswer.length; i++){
            uniqueDigits.add(spiltAnswer[i]);
        }
        if(!userAnswer.matches("^\\d{"+Constans.MAX_NUMBER+"}$")){
            Exceptions.IllegalArgumentException(Constans.REQUEST_ONLY_3_NUMS);
        }
        if(uniqueDigits.size() != Constans.MAX_NUMBER){
            Exceptions.IllegalArgumentException(Constans.REQUEST_OTHER_3_NUMS);
        }

    }

    //userNum -- 사용자, answerNums -- 자동 생성숫자
    public String outputResult(int[] userNums, int[] answerNums){
        int ballCount = 0;
        int strikeCount = 0;
        String result = null;

        for(int i = 0; i < Constans.MAX_NUMBER; i++){
            for(int j = 0; j < Constans.MAX_NUMBER; j++) {
                if(j==i && userNums[i]==answerNums[j]){
                    strikeCount++;
                }else if(userNums[i]==answerNums[j]){
                    ballCount++;
                }
            }
        }

        if(ballCount == 0 && strikeCount == 0){
            result = Constans.NOT_THING;
        }else if(ballCount == 0){
            result = String.format(Constans.STRIKE, strikeCount);
        }else if(strikeCount == 0){
            result = String.format(Constans.BALL, ballCount);
        }else{
            result = String.format(Constans.BALL_STRIKE,ballCount, strikeCount);
        }

        return result;
    }

    public int[] creRandomNums(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Constans.MAX_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(Constans.RANDOM_MIN_RANGE, Constans.RANDOM_MAX_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int[] randomNums = new int[Constans.MAX_NUMBER];
        for(int i = 0; i < Constans.MAX_NUMBER ; i++){
            randomNums[i] = computer.get(i);
        }
        return randomNums;
    }
}
