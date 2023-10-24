package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        RandomNumber randomNumbers = new RandomNumber();
        List<Integer> cpuInput = randomNumbers.getRandomNumbers();
        System.out.println("컴퓨터 숫자:" + cpuInput);
        System.out.print("숫자를 입력해주세요 : ");
        UserNumber userNumber = new UserNumber(readLine());
        String userInput = userNumber.getUserNumber();

        // BaseballGame 인스턴스 생성
        BaseballGame game = new BaseballGame();
        game.play(cpuInput, userInput);
    }
}
