package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> computer;
    private List<Integer> answer;
    Integer SIZE = 3;
    public void init(){
     computer = new ArrayList<>();
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }

    public void start(){
        while(true){
            System.out.println("숫자를 입력해 주세요 : ");
            answer = new ArrayList<>();
            String anw = Console.readLine();
            if (anw.length() != SIZE){
                throw new IllegalArgumentException();
            }
            if (answer.contains(Integer.parseInt(anw))) {
                throw new IllegalArgumentException();
            }
            if(check(answer)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }

    }
    public boolean check (List<Integer> answer){
        int strike = 0;
        int ball = 0;
        for ( int i = 0; i< SIZE; i++){
            int my_num = answer.get(i);
            int com_num = computer.get(i);
            if(my_num == com_num){
                strike++;
            } else if (computer.contains(my_num)) {
                ball++;
            }
        }
        StringBuilder result = new StringBuilder();
        if(ball>0) result.append(ball).append("볼 ");
        if(strike>0) result.append(strike).append("스트라이크");
        System.out.println(result.isEmpty()?"낫싱":result);
        return strike == 3;
    }
    public boolean isNumber(char c){
        return c >= '0' && c <='9';
    }




}
