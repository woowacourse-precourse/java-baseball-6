package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Processor {
    
    private Processor() {}
    
    public static void doGame(AnswerBox answerBox, List<Integer> numGenerated) {
        while (!answerBox.getMessage().equals("3스트라이크")) { // 사용자에게서 맞출때까지 계속해서 입력 받음
            System.out.print("숫자를 입력해 주세요: ");
           
            String input = Console.readLine();
            // 입력받은 String 의 input 을 List<Integer>형태로 변환
            List<Integer> numGet;
            
            try {
                numGet = Arrays.stream(input.split(""))
                        .map(Integer::parseInt)
                        .toList();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid Input: Not a number", e);
            }
            
            Set<Integer> compare = new HashSet<>(numGet);
            //입력 받은 수의 유효성 검사
            if(numGet.size() != 3 || compare.size() != 3) {
                throw new IllegalArgumentException("Invalid Input: Duplicate number");
            }
            
            Processor.compareNum(numGet, numGenerated, answerBox);
            
            System.out.println(answerBox.getMessage());
        }
    }
    
    private static void compareNum(List<Integer> numGet, List<Integer> numGenerated, AnswerBox answerBox) {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < numGenerated.size(); i++) {
            Integer a = numGenerated.get(i);
            if (a.equals(numGet.get(i))) {
                strike += 1;
            } else if (numGet.contains(a)) {
                ball += 1;
            }
        }

        answerBox.setScore(strike, ball);
        answerBox.updateMessage();
    }
    
}
