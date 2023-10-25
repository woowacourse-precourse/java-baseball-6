package io;

import domain.baseBalls.QuestionBaseBalls;

public class OutputView {
    public static void getBaseBallsResult(QuestionBaseBalls.Result result){
        StringBuilder stringBuilder=new StringBuilder();
        if(result.hasStrike()) stringBuilder.append(String.format("%d 스트라이크 ", result.getStrike()));
        if(result.hasBall()) stringBuilder.append(String.format("%d 볼 ", result.getBall()));
        if(!result.hasStrike()&&!result.hasBall()) stringBuilder.append("낫싱");

        System.out.println(stringBuilder);
    }

    public static void endofOneBaseBallGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}