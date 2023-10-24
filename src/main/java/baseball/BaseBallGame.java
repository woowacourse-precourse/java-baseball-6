package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private final static int GAME_START = 1;
    private final static int GAME_EXIT = 2;

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNumbers = generateComputerNumbers();
            playGame(computerNumbers);

            if (!replayGame()) {
                break;
            }
        }

        System.out.println("게임을 종료합니다. 다음에 다시 도전해주세요!");
    }
    /**
    서로 다른 3개의 숫자를 생성하는 매서드입니다.

    1. 숫자를 담을 용도로 ArrayList computer를 생성합니다.
    2. while문을 통해 computer의 크기가 3보다 작은 동안(즉 computer의 크기가 3이 될 때까지) 다음을 반복합니다.
        2-1. 1부터 9사이의 난수를 생성하여 randomNumber에 저장
        2-2. computer에 randomNumber가 포함되어 있찌 않다면 해당 값을 computer에 추가
    3. while문이 종료되면 서로 다른 3개의 숫자가 담긴 computer 리스트를 반환합니다.
     */
    private List<Integer> generateComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    /**
    사용자로부터 입력받은 숫자를 리스트로 변환하는 매서드입니다.

    1. Console.readLine을 통해 사용자로부터 입력을 받고, 이를 input 변수에 저장합니다.
    2. validateUserInput 매서드를 활용하여 사용자의 입력이 유효한지 검증합니다.
    3. 숫자를 담을 용도로 userNumber를 생성합니다.
    4. input의 각 자릿수를 숫자로 변환하여 userNumber에 저장합니다.
       - 이때, char를 int로 변환하기 위해 '0'을 뺀 값을 사용합니다.
    5. 변환된 숫자가 담긴 userNumber 리스트를 반환합니다.

     */
    private List<Integer> getUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateUserInput(input);
        List<Integer> userNumbers = new ArrayList<>();
        for (char digit : input.toCharArray()) {
            userNumbers.add(digit - '0');
        }
        return userNumbers;
    }

    /**
    사용자 입력이 유효한지 검증하는 매서드입니다.
    입력값이 3자리 인지, 숫자 외의 문자가 포함되어 있는지, 서로 다른 숫자가 맞는지를 검증합니다.
    입력이 유효하지 않은 경우 IllegalArgumentExeption을 발생시킵니다.
     */
    private void validateUserInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
        }

        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);

            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException("숫자 이외의 문자가 포함되어 있습니다.");
            }

            if (input.indexOf(digit) != i) {
                throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
            }
        }
    }
    /**
    게임을 진행하는 매서드입니다.

    @param computerNumbers 컴퓨터가 선택한 숫자 리스트
    @return                게임의 결과를 나타내는 Result 객체

    만약 게임이 종료되지 않았다면 사용자에게 다시 입력을 받아 결과를 계산해야합니다.
     */
    private void playGame(List<Integer> computerNumbers) {
        do {
            List<Integer> userNumbers = getUserNumbers();
            Result result = calculateResult(computerNumbers, userNumbers);
            printResult(result);

            if (result.isGameOver()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            System.out.println("게임을 계속하려면 1, 종료하려면 2를 입력하세요.");
        } while (Console.readLine().charAt(0) == '1');
    }
    /**
     * 게임 재시작 여부를 확인하는 메서드입니다.
     *
     * @return 게임을 재시작할 경우 true, 종료할 경우 false
     */
    private boolean replayGame() {
        String input;
        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();
        } while (invalidInput(input));

        return input.equals("1");
    }

    /**
     * 입력값이 유효한지 확인하는 메서드입니다.
     *
     * @param input 사용자 입력값
     * @return 유효하지 않은 경우 true, 유효한 경우 false
     */
    private boolean invalidInput(String input) {
        return !input.equals("1") && !input.equals("2");
    }

    /**
    사용자가 입력한 숫자와 컴퓨터가 선택한 숫자를 비교하여 결과를 계산하는 매서드입니다.

    스트라이크와 볼의 개수를 초기화한 후, 각 조건에 따라 스트라이크와 볼의 개수를 카운팅합니다.
    * 같은 위치에 같은 숫자인 경우 스트라이크
    * 다른 위치에 같은 숫자인 경우 볼

    최종적으로 결과를 담은 Result 객체를 반환합니다.
    여기서 Result 클래스를 사용하게 되는데, 해당 게임의 결과를 저장합니다.
     */
    private Result calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int userNumber = userNumbers.get(i);
            int computerNumber = computerNumbers.get(i);

            if (userNumber == computerNumber) {
                strikes++;
            } else if (computerNumbers.contains(userNumber)) {
                balls++;
            }
        }

        return new Result(strikes, balls);
    }

    /**
    게임의 결과를 출력하는 매서드입니다.

    각각 스트라이크, 볼, 낫싱이 있을 경우 출력하게 되며, 결과 출력이 끝났다면 개행하여 다음 줄로 이동시킵니다.
    */
    private void printResult(Result result) {
        if (result.getStrikes() > 0) {
            System.out.print(result.getStrikes() + "스트라이크 ");
        }

        if (result.getBalls() > 0) {
            System.out.print(result.getBalls() + "볼");
        }

        if (result.getStrikes() == 0 && result.getBalls() == 0) {
            System.out.print("낫싱");
        }

        System.out.println();
    }
}

