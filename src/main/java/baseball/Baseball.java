package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class Baseball {
    private final List<Integer> numbers = new ArrayList<Integer>();

    Baseball(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void initNumbers() {
        if(!numbers.isEmpty()) {
            numbers.clear();
        }
        while(numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    private List<Integer> inputToInputNumbers(String input) throws IllegalArgumentException {
        if(input.length() != 3) {
            throw new IllegalArgumentException("Error : 3자리의 숫자가 아닌 값 입력");
        }
        List<Integer> inputNumbers = new ArrayList<>();
        for(char number : input.toCharArray()) {
            if(!Character.isDigit(number) || (Character.digit(number, 10) == 0)) {
                throw new IllegalArgumentException("Error : 3자리의 숫자가 아닌 값 입력");
            }
            inputNumbers.add(Character.digit(number, 10));
        }
        return inputNumbers;
    }

    private BaseballResult getBaseballResult(List<Integer> inputNumbers) {
        BaseballResult baseballResult = new BaseballResult();
        for(int i = 0; i < 3; i++) {
            if(this.numbers.contains(inputNumbers.get(i))) {
                if(this.numbers.get(i) == inputNumbers.get(i)) {
                    baseballResult.addStrike();
                } else {
                    baseballResult.addBall();
                }
            }
        }
        return baseballResult;
    }

    public void startBaseball() throws IllegalArgumentException {
        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<Integer> inputNumbers = inputToInputNumbers(input);
            BaseballResult baseballResult = getBaseballResult(inputNumbers);

            System.out.println(baseballResult);
            if(baseballResult.isSuccess()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

}
