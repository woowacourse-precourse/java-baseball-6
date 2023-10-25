package baseball.controller;

import baseball.model.Admin;
import baseball.model.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class BaseballGame {
    private Integer ball;
    private Integer strike;
    private final Player player;
    private Admin admin;

    public BaseballGame(Player player) {
        this.player = player;
    }

    public void init() {
        this.ball = 0;
        this.strike = 0;
        this.admin = new Admin();
    }

    public void run() {
        // 1. 초기화
        init();
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 2. 실행
        while(strike < 3) {
            ball = strike = 0;
            // 1. 플레이어 숫자 제시
            playerInput();

            // 2. admin과 player의 숫자 비교
            countStrikeBall(admin.getAnswer(), player.getAnswer());

            // 3. 문구 출력
            print();

        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");


    }

    private void print() {
        if(this.ball == 0 && this.strike == 0)
            System.out.println("낫싱");
        else if (this.strike == 0) {
            System.out.println(this.ball + "볼");
        } else if (this.ball == 0) {
            System.out.println(this.strike + "스트라이크");
        }
        else {
            System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
        }
    }

    public void playerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String in = Console.readLine();
        player.setAnswer(in);
    }

    public void countStrikeBall(List<Integer> a, List<Integer> p) {
        for (int i = 0; i<3; i++) {
            if(a.get(i) == p.get(i)) this.strike++;
            else {
                if (a.contains(p.get(i))) this.ball++;
            }
        }
    }
}
