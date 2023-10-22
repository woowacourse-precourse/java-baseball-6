package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            int[] answerNum = new int[3];

            generateAnswer(answerNum);

            System.out.println("숫자 야구 게임을 시작합니다.");
        }catch(IllegalArgumentException e){
            // 그냥 프로그램 종료
        }finally{
            Console.close();
        }

    }

    private static void generateAnswer(int[] answerNum) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < 3) {
            uniqueNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        int idx = 0;
        for (Integer num : uniqueNumbers) {
            answerNum[idx++] = num;
        }
    }
}
