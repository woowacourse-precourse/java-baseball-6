package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {

    private List<Integer> player; //플레이어 숫자

    public Player() {
        player = new ArrayList<>();
    }

    public List<Integer> getPlayer() {
        return player;
    }

    public void init(){
        player.clear();
    }

    //숫자 입력 및 변환
    public void inputNum() {
        int Num = Integer.parseInt(Console.readLine());

        if((int)( Math.log10(Num)+1 ) != 3){
            throw new IllegalArgumentException();
        }

        Stack<Integer> stack = new Stack<>();

        while(Num > 0) {
            stack.add(Num % 10);
            Num /= 10;
        }

        while(stack.size() > 0){
            player.add(stack.pop());
        }
    }

    public int inputRun(){
         int Num = Integer.parseInt(Console.readLine());
         if(Num > 2 && Num < 1){
             throw new IllegalArgumentException();
         }
         return Num;
    }
}
