package baseball.game;

import baseball.domain.BaseBall;
import baseball.domain.BaseBallMount;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private MountResult mountResult;
    private BaseBallMount computerMount;
    private BaseBallMount playerMount;

    private void setPlayerMount(List<BaseBall> baseBalls) {
        this.playerMount = new BaseBallMount(baseBalls);
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 초기화
        initializeComputerMount();

        do {
            // 숫자 입력 및 컴퓨터 야구공 초기화
            initializeMountResult();

            List<BaseBall> inputBaseBalls = resolveBaseBallsFromInput();
            setPlayerMount(inputBaseBalls);

            // 게임 결과 처리
            String result = mountResult.referee(computerMount, playerMount);
            System.out.println(result);
        } while (mountResult.isNotAllStrike());
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void initializeMountResult() {
        this.mountResult = new MountResult();
    }

    private void initializeComputerMount() {
        List<BaseBall> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.stream().map(BaseBall::getValue).toList().contains(randomNumber)) {
                computer.add(new BaseBall(randomNumber));
            }
        }
        this.computerMount = new BaseBallMount(computer);
    }

    private List<BaseBall> resolveBaseBallsFromInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        try {
            if (input.length() != 3) {
                throw new IllegalArgumentException("세자리 수를 입력해주세요");
            }

            List<BaseBall> baseBalls = new ArrayList<>();
            for (String number : input.split("")) {
                int value = Integer.parseInt(number);
                BaseBall baseBall = new BaseBall(value);
                baseBalls.add(baseBall);
            }
            return baseBalls;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }


}
