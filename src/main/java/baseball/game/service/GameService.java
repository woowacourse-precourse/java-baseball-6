package baseball.game.service;

import baseball.game.participant.Computer;
import baseball.game.participant.Player;
import java.util.List;

/**
 * 사용자가 추측한 답과 컴퓨터가 생성한 정답을 기반으로 힌트를 주는
 * 기능을 제공한다.
 */
public class GameService {

    /**
     * 사용자가 입력한 답이 정답과 얼마나 일치하는지 판단해서 적절한 힌트를 제공한다.
     *
     * @param player   사용자가 입력한 답을 기반으로 생성한 Player 객체
     * @param computer 정답을 가지고 있는 Computer 객체
     * @return 볼의 개수와 스트라이크의 개수를 제시하는 문자열(둘 다 없으면 "낫싱")
     */
    public static String getHint(Player player, Computer computer) {
        List<Integer> listHint = compare(player, computer);

        int ball = listHint.get(0);
        int strike = listHint.get(1);

        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        String ballInfo = (ball != 0 ? ball + "볼" : "");
        String strikeInfo = (strike != 0 ? strike + "스트라이크" : "");

        return ballInfo + (ball != 0 && strike != 0 ? " " : "") + strikeInfo;
    }

    /**
     * 사용자가 입력한 답이 정답과 얼마나 일치하는지 판단한다.
     *
     * @param player   사용자가 입력한 답을 기반으로 생성한 Player 객체
     * @param computer 정답을 가지고 있는 Computer 객체
     * @return 볼 개수(result.get(0)), 스트라이크 개수(result.get(1))가 담긴 List 컬렉션
     */
    private static List<Integer> compare(Player player, Computer computer) {
        List<Integer> proposal = player.getProposal();
        List<Integer> answer = computer.getAnswer();

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(proposal.get(i))) {
                strike++;
            } else if (answer.contains(proposal.get(i))) {
                ball++;
            }
        }

        return List.of(ball, strike);
    }

}
