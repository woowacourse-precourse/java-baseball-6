package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameComment{
    private final String startCom = "숫자 야구 게임을 시작합니다.";
    private final String inputCom = "숫자를 입력해주세요 : ";
    private final String restartNum = "1";
    private final String endNum = "2";
    private final String endCom = "게임이 종료되었습니다.";

    private List<Integer> com;
    private Map<String, Integer> ballMap;
    public void start(){
        com = makeComNumber();
        ballMap = new HashMap<>();
        System.out.println(startCom);
        playGame();
    }
    public void playGame(){
        while(true){
            System.out.print(inputCom);
            int[] user = Verification.input();

            ballMap = compareNumber(com,user);

            if (ballMap.get("스트라이크") != null && ballMap.get("스트라이크") == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                endOrRestart();
                break;
            }
        }
    }

    public void endOrRestart(){
        System.out.println("게임을 새로 시작하려면 "+restartNum+", 종료하려면 "+endNum+"를 입력하세요.");
        String in = Console.readLine();
        if(in.equals(restartNum)){
            start();
        }else if(in.equals(endNum)){
            end();
        }else{
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }

    }

    public void end(){
        Console.close();
        System.out.println(endCom);
    }

    public List<Integer> makeComNumber(){
        List<Integer> com = new ArrayList<>();
        while(com.size()<3){
            int ran = Randoms.pickNumberInRange(1,9);
            if(!com.contains(ran)){
                com.add(ran);
            }
        }
        return com;
    }

    public Map<String, Integer> compareNumber(List<Integer> com, int[] user){
        Map<String, Integer> ballMap = new HashMap<>();

        for(int i = 0; i < user.length; i++){
            int u = com.indexOf(user[i]);
            if(u != -1){
                String ball = checkBall(u,i);
                putResult(ballMap,ball);
            }
        }

        return showResult(ballMap);
    }
    public String checkBall(int u, int i){
        if(u == i){
            return "스트라이크";
        }else{
            return "볼";
        }
    }

    public void putResult(Map<String, Integer> ballMap, String ball){
        if(!ballMap.containsKey(ball)){
            ballMap.put(ball,0);
        }
        ballMap.put(ball,ballMap.get(ball)+1);
    }

    public Map<String, Integer> showResult(Map<String, Integer> ballMap){
        if(ballMap.size() != 0){
            StringBuilder sb = new StringBuilder();
            for(String s : ballMap.keySet()){
                sb.append(ballMap.get(s)+s+" ");
            }
            System.out.println(sb.toString());
        }else{
            System.out.println("낫싱");
        }

        return ballMap;
    }
}
