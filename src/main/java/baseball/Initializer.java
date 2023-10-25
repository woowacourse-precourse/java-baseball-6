package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Initializer {

    private List<Integer> comNum=new ArrayList<>();
    private List<Integer> userNum=new ArrayList<>();
    public List<Integer> setCom(){

        while(comNum.size()<3){
            this.comNum.add(Randoms.pickNumberInRange(1,9));
        }

        return this.comNum;
    }
    public List<Integer> setUser(){
        userNum.clear();

        System.out.print("숫자를 입력해주세요 : ");

        String userInStr =Console.readLine();
        int inputSize = userInStr.length();

        if(inputSize>3 || inputSize==1 || inputSize==2 ){
            //TODO: 예외처리
            throw new IllegalArgumentException("[프로그램 종료] 잘못된 입력입니다.");
        }

        for (int i = 0; i < inputSize; ++i) {
            this.userNum.add(
                    Integer.valueOf(userInStr.charAt(i)-'0')
            );
        }

        return this.userNum;
    }
}
