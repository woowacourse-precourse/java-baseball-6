package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballFunction {
    
    final static int gameSize = 3;
    
    /**
     * gameSize와 같은 size의 (1~9)의 수를 생성. List<Integer>로 반환
     * 
     * @return gameSize의 size를 가진 List<Integer>
     */
    public static List<Integer> generateNumbers() {
        List<Integer> computer = new ArrayList<Integer>();
        while (computer.size() < gameSize) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    
    /**
     * 수를 입력받는메서드. 인자로 받은 int 자리수의 수를 입력받지 않으면 예외 발생. 0~9이외 입력받으면 예외 발생.
     * 게임중에는 1~9를, 게임종료시에는 1~2를 받아야 하지만 게임종료시에는 1과 2만 입력한다는 요구사항이 있어 따로 만들어두지는 않았음.
     * 
     * @param inputSize
     * @return 입력받은 수가 한자리씩 들어있는 List<Integer>
     * @throws IllegalArgumentException
     */
    public static List<Integer> getUserInput(int inputSize) throws IllegalArgumentException {
        List<Integer> userInput = new ArrayList<Integer>();
        String input = Console.readLine();
        if (input.length() != inputSize) {
            throw new IllegalArgumentException("입력한 것의 길이가 길거나 짧습니다.");
        }
        for (int i = 0; i < inputSize; i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("입력한 것이 수가 아닙니다.");
            } else if (input.charAt(i) == '0') {                
                throw new IllegalArgumentException("1 ~ 9의 수를 입력해야 합니다.");
            } else if (userInput.contains(Character.getNumericValue(input.charAt(i)))) {                
                throw new IllegalArgumentException("중복되지 않은 수를 입력해야 합니다.");
            } else {                
                userInput.add(Character.getNumericValue(input.charAt(i)));
            } 
        }
        return userInput;
    }
    
    /**
     * 스트라이크와 볼 수를 계산해 출력하고 맞추기를 반복할지(true) 그만둘지(false)를 return
     * 
     * @param computer의 숫자 List<Integer>
     * @param userInput의 숫자 List<Integer>
     * @return strike == gameSize면 그만두기(false) 아니라면 반복(true)
     */
    public static boolean calculateResult(List<Integer> computer, List<Integer> userInput) {
        boolean repeat = true;
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                if (userInput.get(i) == computer.get(j)) {
                    if (i == j) {
                       strikes ++; 
                    } else {
                        balls ++;
                    }
                }
            }
        }
        
        if (strikes == gameSize) {
            repeat = false;
        }
        if (strikes == 0 && balls == 0) {
            System.out.print("낫싱");
        }
        if (balls != 0) {
            System.out.print(balls + "볼 ");
        }
        if (strikes != 0) {
            System.out.print(strikes + "스트라이크");
        }
        System.out.println();
        
        return repeat;
    }
     
}
