package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static void createComputerNum(List<Integer> computerNum){
        while(computerNum.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNum.contains(randomNumber)){
                computerNum.add(randomNumber);
            }
        }
    }
    static String receiveUserNum(){
        String userNum;

        System.out.print("숫자를 입력해주세요 : ");
        userNum = Console.readLine();
        return userNum;
    }
    static String referee(List<Integer> computerNum, String userNum){
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < 3; i++){
            if(computerNum.get(i) == userNum.charAt(i)-'0'){
                strike++;
            } else{
                ball++;
            }
        }
        return String.format("%d볼 %d스트라이크",ball,strike);
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNum = new ArrayList<>();
        String userNum, result;

        createComputerNum(computerNum);
        userNum = receiveUserNum();
        result = referee(computerNum, userNum);

        System.out.println(result);
    }
}
