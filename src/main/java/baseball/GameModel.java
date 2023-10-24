package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GameModel {

    private static GameModel gameModel = new GameModel();

    private GameModel() {
    }

    public static GameModel getInstance() {
        return gameModel;
    }

    //정답 여부 반환
    public boolean completeSame(List<Integer> res) {
        if (res.get(1) == 3) {
            return true;
        }
        return false;
    }

    //사용자와 컴퓨터 숫자 비교
    public List<Integer> compareNums(List<Integer> computer, List<Integer> user) {
        int ball = 0;
        int strike = 0;
        List<Integer> match = computer.stream()
                .filter(c -> user.stream().anyMatch(Predicate.isEqual(c)))
                .collect(Collectors.toList());

        if (match.size() > 0) {
            ball = match.size();
            for (int i = 0; i < 3; i++) {
                if (computer.get(i) == user.get(i)) {
                    strike++;
                    ball--;
                }
            }
        }

        List<Integer> count = new ArrayList<>(); //[ball, strike]
        count.add(ball);
        count.add(strike);
        return count;
    }

    //컴퓨터 숫자 생성
    public List<Integer> generateComputerNums() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //컴퓨터 숫자 출력
        for (Integer i : computer) {
            System.out.print(i + " ");
        }
        System.out.println();

        return computer;
    }

}
