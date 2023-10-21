package baseball.console;

import baseball.domain.BaseBall;
import baseball.repository.BaseBallRepository;
import baseball.service.BaseBallService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBallGame {

    public BaseBallRepository baseBallRepository;
    public BaseBallService baseBallService;

    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void playGame() throws IOException {

        baseBallRepository = new BaseBallRepository();
        baseBallService = new BaseBallService();

        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseBall computer = new BaseBall();
        BaseBall player = new BaseBall(new ArrayList<>());
        List<Integer> computerBallNumbers = computer.getInputBallNumber();

        while(true) {
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> input = Arrays.stream(br.readLine().split("")).
                    map(Integer::parseInt).toList();

            baseBallRepository.save(player, input);
            if(check(input, computerBallNumbers) {
                break;
            }
            숫자를 입력해주세요 :145
            1 볼
            숫자를 입력해주세요 :671
            2 볼
            숫자를 입력해주세요 :216
            1 스트라이크
            숫자를 입력해주세요 :713
            3 스트라이크
            3 개의 숫자를 모두 맞히셨습니다 !게임 종료
            게임을 새로 시작하려면 1, 종료하려면 2 를 입력하세요.
            1
        }
    }
}
