package baseball.history;

import java.util.List;

/**
 * 컴퓨터와 플레이어의 플레이의 진행자 및 심판 역할
 * check point
 * 1. 진행
 * 1-1. 컴퓨터 & 플레이어 입장
 * 1-2. 게임 시작 준비 상태 만들기. -> computer.ready(), player.ready()
 * 1-3. 게임 시작 Host.play()
 * 1-4. 진행 결과 return
 * 1-5. 게임이 끝나면 재시작/종료 return
 */
public class HostV1 {
    // TODO: 플레이들 입장.
    // TODO: 숫자 비교하기
    // TODO: 게임 중지 기능.
    public static void gameStop() {
        return;
    }

    public String play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        ComputerV1 computer = new ComputerV1();
        List<Integer> computerNums = computer.setNums();

        PlayerV1 player = new PlayerV1();
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> playerNums = player.setNums();
//        // 이펙티브 자바에서 while flag 쓰지 말라했던 거 같은데...일단 구현부터,,
//        // TODO : while flag 개선하기,,
//        boolean flag = true;
//        while (gameResult(computerNums, playerNums) != "3스트라이크") {
//            // 중복이 발생한 것 같다. host가 말을 해야하니까,, 이런 문제가 생기네.
//            System.out.print("숫자를 입력해주세요 : ");
//            player.setNums();
//            gameResult(computerNums, playerNums);
//        }
        return gameResult(computerNums, playerNums);
    }

    public static String gameResult(List<Integer> computerNums, List<Integer> playerNums) {
        int strike = 0;
        int ball = 0;
        String printStrike = strike + "스트라이크";
        String printBall = ball + "볼";
        String printNotThing = "낫싱";
        String result = "";


        /**
         * // TODO: computerNums와 playerNums를 비교하는 로직
         * 1. 스트라이크 판독
         * -> 같은 숫자 & 같은 위치
         * 2. 볼 판독
         * -> 같은 숫자 != 다른 위치
         * 3. 낫싱 판독
         * -> 같은 숫자가 존재하지 않음.
         *
         * 스트라이크 , 볼 중복 판별.
         *
         * -> for문 하나로 스트라이크, 볼, 낫싱을 판별 vs 각각 for문으로 판별 -> 낫싱은 for를 하지 않아도 됨 각각이 낫겠다.
         * -> 스트라이크, 볼을 한 번에 묶으면 로직을 각각으로 나눈거보다 파악하기 어려울 수 있음.
         * 스트라이크가 볼보다 더 중요한 정보라고 가정하고 스트라이크인 경우를 먼저 체크하자.
         * -> 나중에 스트라이크, 볼의 기준이 달라질 수 있음.(like 심판마다 기준이 다르듯이?) 각각 구현하는 게 맞는 거 같다.
         */


        // 스트라이크 판독
        // 같은 숫자 같은 자리

        for (int i = 0; i < 3; i++) {
            if(computerNums.get(i) == playerNums.get(i)){
                strike++;
            }
        }

        // 볼 판독
        // 스트라이크인 케이스는 제외해야함.
        // 이성적인 플레이어는 스트라이크를 늘리는 방향으로 진행하겠지.
        // 진행할 수록 볼이 덜 나온다고 가정을 하고 중복처리 역할을 생각해보자. 볼이 하는 거 vs 스트라이크가 처리하는 거
        // 스트라이크가 나오면 볼은 판단할 필요가 없네. but 뭐가 더 나은지 확신이 안 선다.
        // 확률상 같은 숫자가 같은 자리에 나오는 경우보다 아닌 경우가 더 많으니 아닌 경우를 먼저 필터링하자.
        // 뭔가 contains랑 get에서 중복을 제거할 수 있을 거 같음. 알고리즘 속도랑 요소. 같은 자리, 같은 숫자.
        // 숫자가 포함되어 있는 걸 확인하고 -> 같은 자리 확인 vs 첫 번째 숫자를 들고 비교하는 방식.
        // (1)contain을 사용할 거면 같은 위치인지 확인해야함. vs (2)숫자 하나를 들고 같은지 + 같은 위치인지 비교
        // (2) 같은 숫자인 걸 비교할 때 같은 위치인지 계속 물어보는 방법. 모두 물어봐야함.
        // if contain에서 숫자를 포함하지 않는다면 모든 검증을 pass 해도 됨.
        // 게임 처음 시작할 때는 어려우니까 contain이 필요하겠지만 게임을 진행할 수록 contatin의 중요성은 줄어듬.
        // contatin을 덜 쓰는 방식으로 로직을 구현하자.
        // TODO: countain을 따로 뺴서 메서드로 만들어도 될 거 같긴한데.. 일단 나중으로 ,, 미루고 간단한 구현부터 해보자.
        // 예를 들어 123 vs 132
        // get(0) vs get(0) -> strike
        // get(0) vs get(1) if not equals -> ball 이게 맞나,,
        // get, contain말고 비교하는 다른 함수는 없나?
        // get(int index)는 ArrayList에서 O(1)을 가지고 다른 메소드는 O(n)이 걸림.
        // get(int index)를 적극 활용하는 방식이 낫겠네.
        // 이러면 contatin을 하고 index를 비교하면 O(n) + O(1) 이니까 O(N) + O(n)보다 낫다.
        // contain을 사용하면 손해가 있을 수는 있는데 대신 가독성이 좋아지니까 가독성으로 가보자.

        // 다시 조사를 해보니 값과 인덱스를 같이 반환하는 건 없고 따로 한다 해서 이득인게 없다.
        // 그러나 ArrayList에서 get만 O(1)이니까 이걸 적극 하면 최선일 것 같다.
        // 같은 숫자 다른 자리
        for (int i = 0; i < 3; i++) {
            // && 연산으로 if를 하나로 만들 수 있긴한데 큰 차이가 없는 것 같다. 가독성이라도 챙겨보자.
            if (computerNums.contains(playerNums.get(i))){
                if (computerNums.get(i) != playerNums.get(i)) {
                    ball++;
                }
            }
        }
        // 이 부분은 if else로 만들면 return이 효과적으로 될 느낌.
        // TODO: 하다보니까 가독성이 떨어지는 거 같네. 다른 방법도 생각해보자.
        // 아무래도 너무 가독성이 떨어진다.
//        if (strike > 0 || ball > 0) {
//            if (strike > 0 & ball == 0) {
//                result += strike + "스트라이크";
//            } else if () {
//                result += ball + "볼";
//            }                result += strike + "스트라이크 " + ball + "볼";
//        } else {
//            for (int i = 0; i < 3; i++) {
//                if (!computerNums.contains(playerNums.get(i))) {
//                    result += notThing;
//                }
//            }
//        }
        // TODO: 가독성만 생각하다가 구현 못하겠다. 나중으로 미루고 일단 구현부터 하자.
//        if (strike > 0) {
//            result += strike +"스트라이크";
//        }
//
//        if (ball > 0) {
//            result += ball + "볼";
//        }

        if (strike > 0 && ball > 0) {
            result += printStrike + " " + printBall;
        } else if (strike > 0 && ball == 0) {
            result += printStrike;
        } else if (strike == 0 && ball > 0) {
            result += printBall;
        } else {
            result += printNotThing;
        }



//        for (int i = 0; i < 3; i++) {
//                if (!computerNums.contains(playerNums.get(i))) {
//                    result += printNotThing;
//                }
//            }


        return result;
    }
}
