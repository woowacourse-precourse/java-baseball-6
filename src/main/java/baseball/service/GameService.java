package baseball.service;

import baseball.domain.GameResultDTO;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    List<Integer> computerNumber = new ArrayList<>();

    public void setComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        this.computerNumber = computerNumber;
    }

    public GameResultDTO GameResult(List<Integer> playerNumber) {
        int idx=0, strike=0, ball=0;

        for(int i : playerNumber) {
            if(computerNumber.contains(i)) {
                if(computerNumber.indexOf(i) == idx) {
                    strike++;
                }
                else {
                    ball++;
                }
            }
            idx++;
        }

        GameResultDTO gameResultDTO = new GameResultDTO(ball, strike);

        return gameResultDTO;
    }
}