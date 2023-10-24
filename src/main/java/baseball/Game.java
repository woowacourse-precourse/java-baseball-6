package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public void run() {
        do {
            play();
        } while (inputRegame());
    }

    private void play() {
        int strike = 0;
        List<Integer> rivalNumber;
        List<Integer> myGuessNumber;

        printStartMessage();
        rivalNumber = makeRivalNumber();
        System.out.println(rivalNumber);

        while (strike != 3) {
            myGuessNumber = inputMyGuess();
            System.out.println(myGuessNumber);
            strike = 3;
        }

        printFinishMessage();
    }

    private void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printFinishMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private List makeRivalNumber() {
        List<Integer> rivalNumber = new ArrayList<>();

        while (rivalNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!rivalNumber.contains(randomNumber)) {
                rivalNumber.add(randomNumber);
            }
        }
        return rivalNumber;
    }

    private List inputMyGuess() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        return toArrayList(input);
    }

    private List toArrayList(String input) {
        List<Integer> myGuessNumber = new ArrayList<>();

        for (String number : input.split("")) {
            myGuessNumber.add(Integer.parseInt(number));
        }
        return myGuessNumber;
    }

    private boolean inputRegame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        }
        return false;
    }
}
