package baseball.domain.player;

import baseball.domain.game.BaseballGameResult;
import baseball.domain.game.ContinueAnswer;
import baseball.domain.judgement.GameState;
import baseball.domain.judgement.Judgement;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer implements BaseballPlayer, Judgement {
        private String generateNumber(int limitLength) {
                StringBuilder sb = new StringBuilder();
                List<Integer> pickNumber = new ArrayList<>();

                while (sb.length() < limitLength) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!pickNumber.contains(randomNumber)) {
                                pickNumber.add(randomNumber);
                                sb.append(randomNumber);
                        }
                }

                return sb.toString();
        }

        @Override
        public String submitThreeNumber(int limitLength) {
                return generateNumber(limitLength);
        }

        @Override
        public ContinueAnswer responseContinuePlay() {
                return ContinueAnswer.YES;
        }

        @Override
        public GameState judgementGameState(String num1, String num2) {
                int strike = countStrike(num1, num2);
                int ball = countBall(num1, num2);
                StringBuilder sb = new StringBuilder(); // todo more think about it

                if (strike == 3) {
                        sb.append(3);
                        sb.append(BaseballGameResult.STRIKE);
                        System.out.println(sb);
                        return GameState.FINISH;
                }

                if (strike == 0 && ball == 0) {
                        System.out.println(BaseballGameResult.NOTING);
                        return GameState.PROGRESS;
                }

                if (ball != 0) {
                        sb.append(ball);
                        sb.append(BaseballGameResult.BALL);
                }

                if (ball != 0 && strike != 0) {
                        sb.append(" ");
                }

                if (strike != 0) {
                        sb.append(strike);
                        sb.append(BaseballGameResult.STRIKE);
                }

                System.out.println(sb);
                return GameState.PROGRESS;
        }

        private int countStrike(String num1, String num2) {
                int strikePoint = 0;

                for (int i = 0; i < num1.length(); i++) {
                        if (num1.charAt(i) == num2.charAt(i)) {
                                strikePoint += 1;
                        }
                }

                return strikePoint;
        }

        private int countBall(String num1, String num2) {
                int ball = 0;

                for (int i = 0; i < num1.length(); i++) {
                        int numIdx = num2.indexOf(num1.charAt(i));
                        if (numIdx != -1 && numIdx != i) {
                                ball += 1;
                        }
                }

                return ball;
        }
}
