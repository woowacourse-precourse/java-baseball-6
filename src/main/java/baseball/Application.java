package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        playBaseballGame();
    }

    private static void playBaseballGame() {
        List<Integer> computer = getComputerPicks();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            int balls = 0;
            int strikes = 0;
            System.out.print("숫자를 입력해주세요 : ");

            String input = Console.readLine();
    private static boolean hasDuplicateDigits(String input) {
        return input.chars().distinct().count() < input.length();
    }
    private static List<Integer> getComputerPicks() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
