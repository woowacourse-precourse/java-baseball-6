package baseball;

import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    private static final int SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;
    private static final String RESTART_FLAG = "1";

    // 사용자의 숫자입력을 받는 기능
    public String numberInput() {
        String input_number = Console.readLine();

        return input_number;
    }

    // 입력받은 숫자를 형변환하는 기능
    public int[] stringToIntArray(String input) {
        int[] intArray = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            intArray[i] = digit;
        }
        return intArray;
    }

    // 컴퓨터가 임의의 수 3자리를 생성하는 기능
    public List<Integer> randomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 입력받은 숫자의 볼과 스트라이크의 여부를 체킹하는 기능
    public int[] checkStrikeAndBall(int[] input_number, List<Integer> computer_number) {
        int[] strike_ball = {0,0}; // {볼, 스트라이크}

        for (int input_index=0; input_index<SIZE; input_index++) {
            for (int comp_index=0; comp_index<SIZE; comp_index++) {
                checkDetail(input_number, computer_number, strike_ball, input_index, comp_index);
            }
        }
        return strike_ball;
    }

    // 실제로 볼과 스트라이크의 여부를 체킹하는 세부 기능 - 체킹하는 방법의 변화가 있을 때 유지보수에 용이하다.
    private void checkDetail(int[] input_number, List<Integer> computer_number, int[] strike_ball, int input_index, int comp_index) {
        if (input_number[input_index] == computer_number.get(comp_index)) {
            if(input_index == comp_index) {
                strike_ball[STRIKE_INDEX] += 1;
            } else {
                strike_ball[BALL_INDEX] += 1;
            }
        }
    }

    // 사용자 입력값에 대한 예외처리
    public void exceptionUserInput(int[] input_number) {
        if (input_number.length != SIZE) {
            throw new IllegalArgumentException("입력한 숫자의 길이는 " + SIZE + "자리이어야 합니다.");
        }

        if (hasDuplicates(input_number)) {
            throw new IllegalArgumentException("입력한 숫자에 중복된 숫자가 있습니다.");
        }
    }

    // 입력한 값내에 중복된 숫자가 있는지 확인
    public static boolean hasDuplicates(int[] numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            // 만약 이미 Set에 있는 숫자라면 중복이 있다고 판단하고 true를 반환
            if (!uniqueNumbers.add(number)) {
                return true;
            }
        }
        return false; // 중복된 숫자가 없으면 false 반환
    }

    public static void main(String[] args) {
        Application application = new Application();
        View view = new View();

        view.printGameStart();
        List<Integer> computer_number = application.randomNumber();
        while (true) {
            view.printUserInput();
            String str_input_number = application.numberInput();
            int[] int_input_number = application.stringToIntArray(str_input_number);
            application.exceptionUserInput(int_input_number);

            int[] strike_ball = application.checkStrikeAndBall(int_input_number, computer_number);
            view.printStrikeBall(strike_ball);

            if(strike_ball[STRIKE_INDEX] == SIZE) {
                view.printGameRestart();
                String restart_number = application.numberInput();
                if(restart_number.equals(RESTART_FLAG)) {
                    computer_number = application.randomNumber();
                } else {
                    break;
                }
            }
        }
    }
}
