package baseball;

import baseball.game.GameRunner;
import baseball.player.Computer;
import baseball.player.Person;
import baseball.util.generator.NsRandomGenerator;
import baseball.util.generator.RandomGenerator;

/**
 * 애플리케이션의 시작점입니다. 필요한 객체를 생성하고 게임을 실행합니다.
 */
public class Application {
    public static void main(String[] args) {
        // 랜덤 숫자 생성 객체 생성
        RandomGenerator randomGenerator = new NsRandomGenerator();

        // 플레이어 객체 생성
        Person person = new Person();

        // 컴퓨터 객체 생성, 랜덤 번호 생성 객체 주입
        Computer computer = new Computer(randomGenerator);

        // 게임 실행 객체 생성 및 게임 실행
        GameRunner gameRunner = new GameRunner(person, computer);
        gameRunner.playGame();
    }
}
