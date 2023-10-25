package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class valueHandler {
    // 숫자야구 랜덤 값 생성 함수
    public static List<Integer> createRandomVariable(){
        // 숫자 3개 생성
        List<Integer> computer = new ArrayList<>();

        while(computer.size()< 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    // 숫자가 문자가 아닌지 숫자라도 정해진 양식에서 벗어났는지 체크
    // 만약에 문자라면 -> InputMismatchException -> IllegalArgException
    // 숫자가 양식이 틀리면 -> IllegalArgException
    // 맞으면 숫자 return


    public static int getBallValue(List<Integer> computer, List<Integer> numberList){
        // return할 ball 값
        int ball = 0;

        // 자동생성 자리별 값
        int computer0 = computer.get(0);
        int computer1 = computer.get(1);
        int computer2 = computer.get(2);

        // 유저입력 자리별 값
        int numberList0 = numberList.get(0);
        int numberList1 = numberList.get(1);
        int numberList2 = numberList.get(2);

        if(computer0 == numberList1 || computer0 == numberList2)
            ball++;
        if(computer1 == numberList0 || computer1 == numberList2)
            ball++;
        if(computer2 == numberList1 || computer2 == numberList0)
            ball++;

        return ball;
    }

    // strike 값 가져오기
    public static int getStrikeValue(List<Integer> computer, List<Integer> numberList){
        // return할 strike 값
        int strike = 0;

        // 자동생성 자리별 값
        int computer0 = computer.get(0);
        int computer1 = computer.get(1);
        int computer2 = computer.get(2);

        // 유저입력 자리별 값
        int numberList0 = numberList.get(0);
        int numberList1 = numberList.get(1);
        int numberList2 = numberList.get(2);

        if(computer0 == numberList0)
            strike++;

        if(computer1 == numberList1)
            strike++;

        if(computer2 == numberList2)
            strike++;

        return strike;
    }
}
