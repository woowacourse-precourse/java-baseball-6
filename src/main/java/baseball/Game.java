package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int ball, strike;

    public List<Integer> makeRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public void playBall(List<Integer> computer, List<Integer> user){
        for(int i=0;i<3;i++){
            if(computer.get(i) == user.get(i)){
                strike++;
            } else {
                if(computer.contains(user.get(i))){
                    ball++;
                }
            }
        }
    }

    public void printResult(){
        if(ball == 0 && strike == 0){
            System.out.print("낫싱");
        }

        if(ball > 0){
            System.out.print(ball+"볼 ");
        }

        if(strike > 0){
            System.out.print(strike+"스트라이크");
        }

        System.out.println();
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> number = makeRandomNumber();

        while(true){
            ball = 0;
            strike = 0;

            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            List<Integer> inputList = new ArrayList<>();
            for(char i:input.toCharArray()){
                inputList.add(Character.getNumericValue(i));
            }

            playBall(number, inputList);

        }
    }
}
