package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        String start = "1";
        while(start == "1") {
            Computer computer = new Computer();

            Game game = new Game();
            User user = new User();
            game.answer = computer.getNumber();

            game.play(user);
            start = game.askRestart();
                }
            }
        }

        //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
        
