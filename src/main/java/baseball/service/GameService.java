package baseball.service;

import baseball.validation.InputValueValidation;
import baseball.view.GameMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameService {

    private int size;
    private int[] baseNumber;
//    private List<Integer> inputValueList = new ArrayList<Integer>(List.of(0,0,0));
    private int inputNumber;
    private int ballCount;
    private int strikeCount;

    InputValueValidation validation = new InputValueValidation();

    public void setGame(int startInclusive, int endInclusive, int count){
        this.size = count;
        baseNumber = new int[count];
//        List<Integer> arr = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
        int r1 = Randoms.pickNumberInRange(startInclusive, endInclusive);
        baseNumber[0] = r1;
        int r2 = Randoms.pickNumberInRange(startInclusive, endInclusive);
        while(r1 == r2){
            r2 = Randoms.pickNumberInRange(startInclusive, endInclusive);
        }
        baseNumber[1] = r2;
        int r3 = Randoms.pickNumberInRange(startInclusive, endInclusive);
        while(r1 == r3 || r2 == r3){
            r3 = Randoms.pickNumberInRange(startInclusive, endInclusive);
        }
        baseNumber[2] = r3;

        System.out.println("정답 : "+r1+" "+r2+" "+r3);
    }

    public void playGame(){
        inputRequirement(); //view에게 '숫자를 입력해주세요' 출력 부탁
        inputValueValid(); // input 받아서 검증까지
        calculateBallStrike(); // ball & strike 계산
        resultPrint(); // 위 ball & strike 내용 바탕으로 계산
        retryPlay(); // 3스트라이크 여부 판단
    }

    public void inputRequirement(){
        GameMessage.inputRequirementMessage();
    }

    public void inputValueValid(){
        String input = Console.readLine();
        inputNumber = validation.valid(input, size);
        ballCount = 0;
        strikeCount = 0;
    }

//    public void inputToList(int num){
//        inputValueList.set(0, num/100);
//        inputValueList.set(1, (num/10)%10);
//        inputValueList.set(2, num%10);
//    }

    public void calculateBallStrike(){
//        updateBallStrike(0,1,2);
//        updateBallStrike(1,2,0);
//        updateBallStrike(2,0,1);
        int first = inputNumber/100;
        int second = (inputNumber/10)%10;
        int third = inputNumber%10;
        if(baseNumber[0] == first){
            strikeCount++;
        } else if (baseNumber[0] == second || baseNumber[0] == third) {
            ballCount++;
        }
        if(baseNumber[1] == second){
            strikeCount++;
        } else if (baseNumber[1] == first || baseNumber[1] == third) {
            ballCount++;
        }
        if(baseNumber[2] == third){
            strikeCount++;
        } else if (baseNumber[2] == second || baseNumber[2] == first) {
            ballCount++;
        }
    }

//    public void updateBallStrike(int i, int j, int k){
//        if(Objects.equals(baseNumber.get(i), inputValueList.get(i))){
//            strikeCount++;
//        } else if(Objects.equals(baseNumber.get(i), inputValueList.get(j))
//                || Objects.equals(baseNumber.get(i), inputValueList.get(k))){
//            ballCount++;
//        }
//    }

    public void resultPrint(){
        GameMessage.resultMessage(ballCount, strikeCount);
    }

    public void retryPlay(){
        if(strikeCount != 3){
            playGame();
        }
    }
}
