package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private final NumberManagement computer;

    BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = new NumberManagement();
    }

    private void close() {
        computer.close();
    }

    public void run() {
        computer.clear();
        computer.makeNumbers(0);
        while(true) {
            int[] inputNumbers = getNumber();
            if(answerCheck(inputNumbers)) {
                break;
            }
        }
        if(regame()) { run(); }
        close();
    }

    private int[] getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        varlidateInput(input);
        int[] numbers = new int[3];
        char[] inputArr = input.toCharArray();
        for(int i = 0; i < 3; i++) {
            numbers[i] = inputArr[i] - '0';
        }
        return numbers;
    }

    private boolean answerCheck(int[] numbers) {
        boolean flag = computer.numberCheck(numbers);
        if(flag) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return flag;
    }

    private boolean regame() {
        System.out.println("게임을 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return input.equals("1");
    }

    private void varlidateInput(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException("the input range is 3");
        }

        char[] inputArr = input.toCharArray();
        boolean[] numberFlag = new boolean[10];
        for(char val : inputArr) {
            int number = val - '0';
            if(number < 1 || number > 9) {
                throw new IllegalArgumentException("only numbers between 1 and 9 can be input");
            }
            if(numberFlag[number]) {
                throw new IllegalArgumentException("Numbers cannot be duplicated");
            }
            numberFlag[number] = true;
        }
        System.out.println("유효성 체크 완료!");
    }

}
