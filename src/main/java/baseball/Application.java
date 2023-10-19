package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        String inputString = readLine();

        List<Integer> inputNumber = new ArrayList<>();
        if(inputString.length() != 3){
            throw new IllegalArgumentException();
        }
        for(int i=0;i<3;i++){
            try{
                int number = Integer.parseInt(inputString.substring(i,i+1));
                if(inputNumber.contains(number)){
                    throw new IllegalArgumentException();
                }
                inputNumber.add(number);
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }
        }

    }
}
