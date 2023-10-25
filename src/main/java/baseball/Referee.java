package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;

public class Referee {
    private static List<Integer> computer = new ArrayList<>();
    private int[] score = new int[3];

    public List<Integer> randomNumber() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public int[] judgment(Player player) {
        List<Integer> playerNumber = player.getPlayerNumber();
        HashSet<Integer> playerNumberSet = new HashSet<>(playerNumber);
        HashSet<Integer> computerSet = new HashSet<>(computer);
        HashSet<Integer> intersection = new HashSet<>(playerNumberSet);
        score = new int[3];

        intersection.retainAll(computerSet); // 교집합 생성
        Iterator<Integer> iterator = intersection.iterator();

        switch (intersection.size()) {
            case 0:
                score[2] = 3;
                break;
            case 1:
                score[2] = 2;
                while (iterator.hasNext()) {
                    Integer setNumber = iterator.next();
                    if (playerNumber.indexOf(setNumber) == computer.indexOf(setNumber)) {
                        score[0]++;
                    } else {
                        score[1]++;
                    }
                }
                break;
            case 2:
                score[2] = 1;
                while (iterator.hasNext()) {
                    Integer setNumber = iterator.next();
                    if (playerNumber.indexOf(setNumber) == computer.indexOf(setNumber)) {
                        score[0]++;
                    } else {
                        score[1]++;
                    }
                }
                break;
            case 3:
                score[2] = 0;
                while (iterator.hasNext()) {
                    Integer setNumber = iterator.next();
                    if (playerNumber.indexOf(setNumber) == computer.indexOf(setNumber)) {
                        score[0]++;
                    } else {
                        score[1]++;
                    }
                }
                break;
        }
        return score;
    }

    public void judgmentPrint() {
        if (score[2] == 3) {
            System.out.println("낫싱");
        } else if ((score[0] > 0) && (score[1] > 0)) {
            System.out.println(score[1] + "볼 " + score[0] + "스트라이크");
        } else if ((score[0] > 0) && (score[1] == 0)) {
            System.out.println(score[0] + "스트라이크");
        } else if ((score[0] == 0) && (score[1] > 0)) {
            System.out.println(score[1] + "볼");
        } else if (score[0] == 3) {
            System.out.println(score[0] + "스트라이크");

        }
    }

    public int judgmentStop() {
        if (score[0] == 3) {
            return 1;
        } else {
            return 0;
        }
    }
}
