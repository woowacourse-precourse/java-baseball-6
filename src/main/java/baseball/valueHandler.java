package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class valueHandler {

    public static int endValueCheck(){
        // 콘솔에서 읽는 값.
        String sfns = readLine();

        int fns;

        try{
            fns = Integer.parseInt(sfns);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }

        if(fns == 1)
            return 0;
        else if (fns == 2)
            return 1;
        else
            throw new IllegalArgumentException("입력 범위를 넘어선 값입니다.");
    }

    // 숫자값 List<Integer>로 변환
    public static List<Integer> createUserVariable(int number){
        List<Integer> numberList = new ArrayList<>();

        numberList.add(number/100);
        numberList.add((number%100)/10);
        numberList.add(number%10);

        return numberList;
    }

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
