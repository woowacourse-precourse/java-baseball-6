package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> goal;
    Integer GOAL_SIZE = 3;

    public void init(){
        goal = new ArrayList<>();
        while (goal.size() < GOAL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!goal.contains(randomNumber)) {
                goal.add(randomNumber);
            }
        }
        //System.out.println(goal);
    }
    public void play() {
        while(true){
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> ansList = new ArrayList<>();
            String ans = Console.readLine();
            if(ans.length() != GOAL_SIZE) throw new IllegalArgumentException();
            boolean[] chk = new boolean[10];
            for(int i=0;i<GOAL_SIZE;i++){
                char c = ans.charAt(i);
                if(!isNumber(c)) throw new IllegalArgumentException();
                int x = c-'0';
                if(chk[x]) throw new IllegalArgumentException();
                chk[x]=true;
                ansList.add(x);
            }
            if(answer(ansList)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
    public boolean answer(List<Integer> ans){
        int strike=0;
        int ball=0;
        for(int i=0;i<GOAL_SIZE;i++){
            int a = ans.get(i);
            int b = goal.get(i);
            if(a==b){
                strike++;
                continue;
            }
            if(goal.contains(a)){
                ball++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(ball>0) sb.append(ball).append("볼 ");
        if(strike>0) sb.append(strike).append("스트라이크");
        System.out.println(sb.isEmpty()?"낫싱":sb);
        return strike == 3;
    }
    public boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
}
