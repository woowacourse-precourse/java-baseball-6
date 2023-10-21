package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.List;

public class Guess {
    public static List<Integer> guess = new ArrayList<>();

    public static void GuessInput() {
        // 질문 출력
        System.out.println(Text.inputText);
        // 인풋 받기 및 숫자의 List로 저장
        char[] str = Console.readLine().toCharArray();
        for (char c : str){
            if (!guess.contains((int) c)){
                guess.add((int) c);
            }
        }
    }
}
