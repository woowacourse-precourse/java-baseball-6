package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    static int[] cur, ans;
    static boolean exit = false;
    static Map<Integer, Integer> existMap;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        gameExit : while(true){
            ans = new int[3];
            existMap = new HashMap<>();

            rand : for(int i=0; i<3; i++){
                ans[i] = Randoms.pickNumberInRange(1, 9);
                for(int j=0; j<i; j++) {
                    if (ans[i] == ans[j]) {
                        i--;
                        continue rand;
                    }
                }
                existMap.put(ans[i], i);
            }

            midExit : while(true){
                System.out.println("숫자 야구 게임을 시작합니다.");
                cur = new int[3];
                System.out.print("숫자를 입력해주세요 : ");
                String inp = sc.next();
                if (inp == null || inp.length() != 3 || !isAnotherNum(inp)) {
                    throw new IllegalArgumentException();
                }

                for(int i=0; i<3; i++){
                    cur[i] = Integer.parseInt(String.valueOf(inp.charAt(i)));
                }

                exit = numberValidation();
                if(exit){
                    int val = sc.nextInt();
                    switch (val) {
                        case 1:
                            exit = false;
                            break midExit;
                        case 2:
                            break gameExit;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
    }

    private static boolean isAnotherNum(String input) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<3; i++){
            if(Character.isDigit(input.charAt(i)))
                set.add(input.charAt(i));
        }
        return set.size() == 3;
    }

    public static boolean numberValidation(){
        int ball=0, strike=0;
        boolean allCompl = false;
        boolean[] vis = new boolean[10];
        Arrays.fill(vis, false);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++){
            if(!vis[cur[i]] && existMap.containsKey(cur[i])){
                if(existMap.get(cur[i]) == i) {
                    strike += 1;
                    continue;
                }
                ball+=1;
            }
        }
        if(ball == 0 && strike == 0)
            sb.append("낫싱");
        if(0 < ball)
            sb.append(ball).append("볼 ");
        if(0 < strike)
            sb.append(strike).append("스트라이크 ");
        if(strike == 3){
            sb.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            allCompl = true;
        }
        System.out.println(sb);
        return allCompl;
    }
}
