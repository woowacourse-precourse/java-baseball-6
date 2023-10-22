package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class GameService {

    public static String getHintWith(Player player, Computer computer) {
        List<Integer> listHint = compare(player, computer);

        int ball = listHint.get(0);
        int strike = listHint.get(1);

        if (ball == 0 && strike == 0) {
            return "낫싱";
        } else {
            String ballInfo = ball != 0 ? (ball + "볼") : "";
            String strikeInfo = strike != 0 ? (strike + "스트라이크") : "";
            String info = (ball != 0 && strike != 0) ? (ballInfo + " " + strikeInfo) : (ballInfo + strikeInfo);
            return info;
        }
    }

    /**
     * 플레이어가 입력한 답이 정답과 얼마나 일치하는지 결과를 반환
     * @param computer 정답
     * @return 볼 개수(result.get(0)), 스트라이크 개수(result.get(1))를
     *         List에 담아서 반환
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
