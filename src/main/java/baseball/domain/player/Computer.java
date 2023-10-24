package baseball.domain.player;

import baseball.domain.game.BaseballGameResult;
import baseball.domain.game.RetryAnswer;
import baseball.domain.judgement.BaseballJudgement;
import baseball.domain.judgement.GameState;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자 야구 게임에 참여하는 플레이어의 역할을 수행하는 컴퓨터 대한 개념 객체를 나타내는 클래스입니다.
 */
public class Computer implements BaseballPlayer, BaseballJudgement {
        /**
         * 컴퓨터가 생성한 숫자열을 문자열 타입으로 반환합니다.
         *
         * @param limitLength 숫자열의 제한 길이
         * @return 컴퓨터가 생성한 숫자열
         */
        @Override
        public String provideLimitedNumber(int limitLength) {
                return generateNumber(limitLength);
        }

        /**
         * 컴퓨터가 제한 길이에 맞는 숫자열을 생성합니다.
         *
         * @param limitLength
         * @return 생성한 숫자열
         */
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

        /**
         * 컴퓨터는 오직 YES의 응답만을 반환합니다.
         *
         * @return YES
         */
        @Override
        public RetryAnswer responseRetryPlay() {
                return RetryAnswer.YES;
        }

        /**
         * 입력 받은 두 숫자열을 기반으로 게임의 결과를 반환합니다.
         * 컴퓨터가 심판의 역할을 수행합니다.
         *
         * @param num1 플레이어 1번의 숫자로 구성된 문자열
         * @param num2 플레이어 2번의 숫자로 구성된 문자열
         * @return 3 STRIKE의 경우 FINISH, 그 외의 경우에는 PROGRESS
         */
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

        /**
         * 두 플레이어의 숫자열을 기반으로 스트라이크 수를 계산합니다.
         *
         * @param num1 플레이어 1번의 숫자로 구성된 문자열
         * @param num2 플레이어 2번의 숫자로 구성된 문자열
         * @return 스트라이크 카운트
         */
        private int countStrike(String num1, String num2) {
                int strikePoint = 0;

                for (int i = 0; i < num1.length(); i++) {
                        if (num1.charAt(i) == num2.charAt(i)) {
                                strikePoint += 1;
                        }
                }

                return strikePoint;
        }

        /**
         * 두 플레이어의 숫자열을 기반으로 볼 수를 계산합니다.
         *
         * @param num1 플레이어 1번의 숫자로 구성된 문자열
         * @param num2 플레이어 2번의 숫자로 구성된 문자열
         * @return 볼 카운트
         */
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
