package baseball.view;

import baseball.model.GameResult;

public class ResultView {

    public void printInit(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printWin(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printBallAndStrikeCounts(GameResult gameResult){
        int balls = gameResult.getBall();
        int strikes = gameResult.getStrike();

        if(balls == 0 && strikes == 0){
            System.out.println("낫싱");
        } else {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
        }

//        private static final Map<String, String> RESULT_MAP = createResultMap();
//
//        public void printResult(int ball, int strike) {
//            String key = ball + "-" + strike;
//            String result = RESULT_MAP.getOrDefault(key, "낫싱");
//            System.out.println(result);
//        }
//
//        private static Map<String, String> createResultMap() {
//            Map<String, String> resultMap = new HashMap<>();
//
//            // 볼만 있는 경우
//            for (int i=1; i<=9; i++) {
//                resultMap.put(i + "-0", i + "볼");
//            }
//
//            // 스트라이크만 있는 경우
//            for (int i=1; i<=3; i++) {
//                resultMap.put("0-" + i ,i + "스트라이크");
//            }
//
//            // 볼과 스트라이크가 모두 있는 경우
//            for (int b=1; b<=9; b++) {
//                for (int s=1; s<=3; s++) {
//                    resultMap.put(b+"-"+s ,b+"볼 "+s+"스트라이크");
//                }
//            }
//
//            return resultMap;
//        }
    }
}
