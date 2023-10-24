package baseball;

import java.util.ArrayList;
import java.util.List;

public class CustomView {
    private static final String GAME_START_MESSAGE = "게임을 시작합니다.";
    private static final String GAME_INPUT_MESSAGE = "숫자를 입력해주세요: ";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_END_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    public List<Integer> strToList(String player){
        String[] playerInput = player.split("");
        List<Integer> list = new ArrayList<>();
        for(String s : playerInput){
            list.add(Integer.parseInt(s));
        }
        return list;
    }
    public static void printStart(){
        System.out.println(GAME_START_MESSAGE);
        System.out.print(GAME_INPUT_MESSAGE);
    }
    public static void printResult(){
        System.out.println(GAME_END_MESSAGE);
        System.out.println(GAME_END_INPUT_MESSAGE);
    }
    public static void printNumber(){
        System.out.print(GAME_INPUT_MESSAGE);
    }
}
