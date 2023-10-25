package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {

    private final GameBehavior game;
    private final GenerateComputerNumber generator;

    public Application(GameBehavior game ,GenerateComputerNumber generator) {
        this.game = game;
        this.generator = generator;
    }

    public void run() {
        try {
            boolean isEnd = true;
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("숫자 야구 게임을 시작합니다.");

            while(isEnd) {
                List<Integer> computer = generator.generate();
                boolean isStrike = false;
                System.out.println("computer = " + computer);

                while(!isStrike) {
                    System.out.print("숫자를 입력해주세요 : ");
                    String str = bf.readLine();

                    if(str.length() != 3) {
                        throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
                    }

                    game.ballAndStrikeCount(computer, str);
                    String result = game.getResult();

                    if(result.equals("3스트라이크")) {
                        isStrike = true;
                    }
                }

                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");

                int input = Integer.parseInt(bf.readLine());
                isEnd = input == 1;
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    } // run

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        RandomNumberGenerator generator = new RandomNumberGenerator();
        Application app = new Application(game, generator);

        app.run();
    } // main

} // class
