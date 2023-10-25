package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedHashSet;

public class Game {
    private final LinkedHashSet<Integer> correctNumbers;
    private LinkedHashSet<Integer> playerAnswer;
    int strikes, balls;
    boolean endOfGame = false;
    public Game() {
        this.correctNumbers = Computer.generatedNumbers(); // 게임 생성 시에 정답 숫자열을 생성
    }
    //-- 비즈니스 로직 --//
    public void inputPlayerAnswer() {
        Computer.printPlayerInputRequest();
        char[] answer = Console.readLine()
                .replaceAll(" ", "")
                .toCharArray();
        playerAnswer = validatePlayerAnswer(answer);
    }
    public boolean inputRestart() {
        Computer.printRestart();

        String restartInput = Console.readLine();

        if (restartInput.equals("1")) {
            return true;
        }
        if (restartInput.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("[ERROR] :: 1, 혹은 2를 입력 하여야 합니다");
    }
    public void calculateScore() {
        if (playerAnswer.equals(correctNumbers)) {
            endOfGame = true;
            return;
        }

        strikes = 0;
        balls = 0;
        int[] corrects = correctNumbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        int[] player = playerAnswer.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = 0; i < corrects.length; i++) {
            for (int j = 0; j < player.length; j++) {
                if (i == j && corrects[i] == player[j]) {
                    strikes++;
                    break;
                }
                if (i != j && corrects[i] == player[j]) {
                    balls++;
                    break;
                }
            }
        }
    }
    private static LinkedHashSet<Integer> validatePlayerAnswer(char[] list) {
        return validateIsUnique(validateIsDigit(list));
    }
    private static LinkedHashSet<Integer> validateIsUnique(LinkedHashSet<Integer> hashSet) {
        if (hashSet.size() != 3) {
            throw new IllegalArgumentException("[ERROR] :: 숫자 3개를 입력해 주세요.");
        }
        return hashSet;
    }
    private static LinkedHashSet<Integer> validateIsDigit(char[] list) {
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        for (char c : list) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] :: 입력이 숫자가 아닙니다.");
            }
            hashSet.add(Integer.parseInt(String.valueOf(c)));
        }
        return hashSet;
    }
    public void play() {
        while (!endOfGame) {
            inputPlayerAnswer();
            calculateScore();
            if (!endOfGame) {
                Computer.printStrikesAndBalls(this);
            }
        }
    }

}
