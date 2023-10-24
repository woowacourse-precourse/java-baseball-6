package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseballGame {

    private static final int STRIKE_IDX = 0;
    private static final int BALL_IDX = 1;
    private static final int NOTHING_IDX = 2;
    private static final int DEFAULT_SIZE = 3;

    private Computer computer;
    private Player player;
    private int restart = 1;

    public boolean isStrike(int playerNum, int idx, List<Integer> computerNums) {
        return computerNums.get(idx) == playerNum;
    }

    public boolean isBall(int playerNum, int idx, List<Integer> computerNums) {
        return computerNums.contains(playerNum) && computerNums.get(idx) != playerNum;
    }


    public boolean isNothing(int playerNum, List<Integer> computerNums) {
        return !computerNums.contains(playerNum);
    }

    public List<Integer> calcResult(List<Integer> computerNums, List<Integer> playerNums) {
        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 0));

        for (int idx = 0; idx < playerNums.size(); idx++) {
            countStrike(computerNums, playerNums, results, idx);
            countBall(computerNums, playerNums, results, idx);
            countNothing(computerNums, playerNums, results, idx);
        }

        return Collections.unmodifiableList(results);
    }

    private void countNothing(List<Integer> computerNums, List<Integer> playerNums, ArrayList<Integer> results, int idx) {
        if(isNothing(playerNums.get(idx), computerNums)) results.set(NOTHING_IDX, results.get(NOTHING_IDX)+1);
    }

    private void countBall(List<Integer> computerNums, List<Integer> playerNums, ArrayList<Integer> results, int idx) {
        if(isBall(playerNums.get(idx), idx, computerNums)) results.set(BALL_IDX, results.get(BALL_IDX)+1);
    }

    private void countStrike(List<Integer> computerNums, List<Integer> playerNums, ArrayList<Integer> results, int idx) {
        if(isStrike(playerNums.get(idx), idx, computerNums)) results.set(STRIKE_IDX, results.get(STRIKE_IDX)+1);
    }

    private void printResult(List<Integer> results) {
        if(results.get(NOTHING_IDX) == DEFAULT_SIZE) {
            System.out.print("낫싱");
            return;
        }

        if(results.get(BALL_IDX) != 0) {
            System.out.print(results.get(BALL_IDX) + "볼");
        }

        if(results.get(BALL_IDX) != 0 && results.get(STRIKE_IDX) != 0){
            System.out.print(" ");
        }

        if(results.get(STRIKE_IDX) != 0){
            System.out.print(results.get(STRIKE_IDX) + "스트라이크");
        }
    }

    public int run() throws IllegalArgumentException, NumberFormatException {
        computer = new Computer(DEFAULT_SIZE);

        boolean correct = false;
        while(!correct) {
            player = new Player(DEFAULT_SIZE);
            List<Integer> results = calcResult(computer.getNums(), player.getPlayerNums());
            printResult(results);
            if(results.get(STRIKE_IDX) == 3) {
                correct = true;
            }
        }
        
        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = Integer.parseInt(Console.readLine());
        } while(restart != 1 && restart != 2);

        return restart;
    }
}
