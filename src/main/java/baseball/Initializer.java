package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Initializer{

    private List<Integer> comNum;
    private List<Integer> userNum;

    public Initializer() {
        this.comNum = new ArrayList<>();
        this.userNum = new ArrayList<>();
    }

    public List<Integer> setCom(){
        //"246", "135", "1", "597", "589", "2"
        comNum.clear();
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

        for(char c : userInStr.toCharArray()){
            if(!Character.isDigit(c)){
                throw new IllegalArgumentException("[프로그램 종료] 잘못된 입력입니다.");
            }
        }

        if(inputSize!=3 ){
            //TODO: 예외처리 (1. 입력길이 3이 아닌 경우 2.숫자가 아닌 것 입력)
            // IllegalArgumentException 예외 발생하면 프로그램 종요하도록
//            throw new IllegalArgumentException("[프로그램 종료] 3자리 수를 입력해주세요.");

        }

        for (int i = 0; i < inputSize; ++i) {
            this.userNum.add(
                    Integer.valueOf(userInStr.charAt(i)-'0')
            );
        }

        return this.userNum;
    }
}
