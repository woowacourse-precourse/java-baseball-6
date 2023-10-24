package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static List<Integer> getRandom(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> getInputNumber(int rangeStart,int rangeEnd, int size){
        String input = Console.readLine();
        List<Integer> number = new ArrayList<>();
        for(int idx=0;idx<input.length();idx++){
            number.add(Character.getNumericValue(input.charAt(idx)));
        }
        validNumber(number,rangeStart,rangeEnd,size);
        return number;
    }

    public static void validNumber(List<Integer> number,int range_start,int range_end,int size){
        HashSet<Integer> set = new HashSet<>();
        if(!(number.size()==size)){
            throw new IllegalArgumentException("length is different from expected");
        }
        for (int idx=0;idx<size;idx++) {
            int num=number.get(idx);
            if (!(range_start<=num && num <= range_end)) {
                throw new IllegalArgumentException("value not in range.");
            }
            if (set.contains(num)){
                throw new IllegalArgumentException("duplicate number.");
            }
            else{
                set.add(num);
            }
        }
    }

    public static BaseballScore getScore(List<Integer> answer,List<Integer> number){
        int strike=0;
        int ball=0;
        for(int idx=0;idx<3;idx++){
            if (answer.get(idx)==number.get(idx)){
                strike++;
            }
            else if(answer.contains(number.get(idx))){
                ball++;
            }
        }
        return new BaseballScore(strike,ball);
    }

    public static boolean getResult(BaseballScore score){
        List<String> instructions = new ArrayList<>();
        if(score.get_ball()!=0){
            instructions.add(score.get_ball()+"볼");
        }
        if(score.get_strike()!=0){
            instructions.add(score.get_strike()+"스트라이크");
        }
        if(instructions.size()==0){
            System.out.println("낫싱");
        }
        else{
            System.out.println(instructions.stream().collect(Collectors.joining(" ")));
        }
        if (score.get_strike()==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }

    public static int getFlag(){
        List<Integer> flag = getInputNumber(1,2,1);
        return flag.get(0);

    }
    public static void playGame(){
        int repeat=1;
        while (repeat==1){
            boolean gameEnd=false;
            List<Integer> answer=getRandom();
            while (!(gameEnd)){
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> number=getInputNumber(1,9,3);
                BaseballScore score = getScore(answer,number);
                gameEnd=getResult(score);
            }

            repeat=getFlag();
        }
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }
}
