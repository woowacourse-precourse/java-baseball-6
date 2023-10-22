package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Game {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public void game() throws IOException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            int[] answerNums = creRandomNums();

            //정답보기
            for(int i = 0; i < answerNums.length; i++){
                System.out.print(answerNums[i] + " ");
            }
            System.out.println();

            String result = "";

            while (!result.equals("0볼 3스트라이크") || result.equals("")) {
                int[] nums = inputNums();
                result = resultOutput(nums, answerNums);
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String reStart = reader.readLine();
            if (reStart.equals("1")) {
                result = null;
                continue;
            } else if (reStart.equals("2")) {
                break;
            } else {
                Exceptions.IllegalArgumentException();
            }
        }
    }

    public int[] inputNums() throws IOException {
        System.out.print("숫자를 입력해주세요 : ");
        String userAnswer = reader.readLine();
        inputNumsTest(userAnswer);
        String[] userAnswerNums = userAnswer.split("");
        int[] nums = new int[3];
        for(int i = 0; i < 3; i++){
            nums[i] = Integer.parseInt(userAnswerNums[i]);
        }
        return nums;
    }
    public void inputNumsTest(String userAnswer){
        if(userAnswer.matches("^\\d{3}$")){
            return;
        }else{
            Exceptions.IllegalArgumentException();
        }
    }

    //userNum -- 사용자, answer -- 자동 생성숫자
    public String resultOutput(int[] userNum, int[] answerNums){
        int ball = 0;
        int striker = 0;
        String result = null;

        for(int i = 0; i <3; i++){
            for(int j = 0; j < 3; j++) {
                if(j == i) {
                    if (userNum[i] == answerNums[j]) {
                        striker++;
                    }else{
                        ball++;
                    }
                }
            }
        }

        result = String.format("%d볼 %d스트라이크",ball, striker);
        return result;
    }

    public int[] creRandomNums(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int[] randomNums = new int[3];
        for(int i = 0; i < 3 ; i++){
            randomNums[i] = computer.get(i);
        }
        return randomNums;
    }
}
