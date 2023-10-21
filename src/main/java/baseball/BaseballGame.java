package baseball;

import baseball.validator.NewOrQuitValidator;
import baseball.validator.PlayerProposalValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.IntStream;

public class BaseballGame {

    /**
     * 숫자 야구 게임의 흐름 전체를 제어
     */
    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            newGame();
        } while (restart());

        System.out.println("숫자 야구 게임을 완전히 종료합니다.");
    }

    private static void newGame() {
        Computer computer = initAnswer();
        List<Integer> result;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            PlayerProposalValidator.execute(input);
            Player player = new Player(input);

            result = compare(player, computer);
            System.out.println(getHintWith(result));
        } while (result.get(1) != 3);
    }

    //TODO: private 메서드에 static을 붙이는 게 적절한지 확인
    private static Boolean restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String newOrQuit = Console.readLine();

        NewOrQuitValidator.execute(newOrQuit);
        if (newOrQuit.equals("1")) return true;
        else return false;
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

        int strike = (int) IntStream.range(0, 3)
                .filter(i -> answer.get(i).equals(proposal.get(i)))
                .count();
        int ball = (int) IntStream.range(0, 3)
                .filter(i -> !answer.get(i).equals(proposal.get(i)) && answer.contains(proposal.get(i)))
                .count();

        return List.of(ball, strike);
    }

    private static String getHintWith(List<Integer> result) {
        int ball = result.get(0);
        int strike = result.get(1);

        if (ball == 0 && strike == 0) {
            return "낫싱";
        } else {
            String ballInfo = ball != 0 ? (ball + "볼") : "";
            String strikeInfo = strike != 0 ? (strike + "스트라이크") : "";
            String info = (ball != 0 && strike != 0) ? (ballInfo + " " + strikeInfo) : (ballInfo + strikeInfo);
            return info;
        }
    }

    private static Computer initAnswer() {
        return new Computer();
    }
}