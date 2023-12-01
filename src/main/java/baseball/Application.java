package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        String start = "1";

        while(start.equals("1")){
            Computer computer = new Computer();

            Game game = new Game();
            User user = new User();
            game.answer = computer.getNumber();

            game.play(user);
            start = game.askRestart();
            System.out.println(start);
                }
            }
        }

