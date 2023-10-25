package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame extends Game {

    private static final String REGEX_THREE_NUMBER = "^[1-9]{3}";

    @Override
    public boolean initGame() {
        printWelcomeMessage();
        return true;
    }

    @Override
    public void playGame() {
        List<Integer> computer = selectComputerNumber();
        List<Integer> player = null;
        do {
            player = inputMyNumber();
        } while (compareNumber(computer, player));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean compareNumber(List<Integer> computer, List<Integer> player) {
        int numStrike = 0;
        int numBall = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                numStrike++;
            }
            if (computer.contains(player.get(i))) {
                numBall++;
            }
        }
        numBall -= numStrike;
        displayStatus(numBall, numStrike);

        return numStrike != 3;
    }

    private void displayStatus(int numBall, int numStrike) {
        if (numBall == 0 && numStrike == 0) {
            System.out.println("낫싱");
        }
        if (numBall != 0 && numStrike == 0) {
            System.out.printf("%d볼", numBall).println();
        }
        if (numBall == 0 && numStrike != 0) {
            System.out.printf("%d스트라이크", numStrike).println();
        }
        if (numBall != 0 && numStrike != 0) {
            System.out.printf("%d볼 %d스트라이크", numBall, numStrike).println();
        }
    }

    private List<Integer> inputMyNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validatePlayerNumber(input);
        return input.chars().boxed().map(Character::getNumericValue).toList();
    }

    private void validatePlayerNumber(String input) {
        ValidateInput.validate(input, REGEX_THREE_NUMBER, "3자리 수를 입력해주세요.");
        ValidateInput.validateDuplicate(input);
    }

    private List<Integer> selectComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private void printWelcomeMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}


