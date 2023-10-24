package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {
    private Computer computer;
    private User user;
    Game(){
        this.computer = new Computer();
        this.user = new User();
    }

    public void startGame(){ //숫자 야구 게임을 시작하는 메소드
        this.computer.setNumbers(); //컴퓨터의 숫자 정하기
        while(true){ //종료 조건 : 3스트라이크
            System.out.print("숫자를 입력해주세요 : ");
            this.user.setGuessNumber(); //플레이어의 숫자 입력 받기
            int[] strikeAndBall = this.checkNumber(); //strikeAndBall[0]: 스트라이크, strikeAndBall[1]: 볼
            if(strikeAndBall[0]==3){ //3스트라이크: 반복문 종료 조건
                //종료 멘트 출력
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            else if(strikeAndBall[0]+strikeAndBall[1]!=0){ //스트라이크와 볼이 둘다 0이 아닌 경우
                if(strikeAndBall[1]!=0){//볼이 0이 아닐 때 개수 출력
                    System.out.printf("%d볼 ", strikeAndBall[1]);
                }
                if(strikeAndBall[0]!=0){//스트라이크가 0이 아닐 시 개수 출력
                    System.out.printf("%d스트라이크",strikeAndBall[0]);
                }
                System.out.println(); //줄바꿈
            } else{ //둘 다 0인 경우
                System.out.println("낫싱");
            }
            this.user.clearGuessNumber(); //사용자가 새로운 숫자를 입력할 때마다 기존에 저장되어 있던 숫자 초기화
        }
    }

    public boolean isRestart(){ //게임 재시작 여부
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String s = Console.readLine();
        int selection = Integer.parseInt(s); //게임 재시작 여부를 저장
        if(selection==1){ //재시작하면 true
            return true;
        }
        else if(selection==2){ //종료를 선택하면 false return;
            return false;
        }
        throw new IllegalArgumentException(); //만약 사용자가 1,2가 아닌 값을 입력했을 시 IllegalArgumentException 에러 발생

    }
    private int[] checkNumber(){ //컴퓨터의 숫자와 플레이어가 입력한 숫자를 비교하여 스트라이크와 볼의 개수를 리턴하는 메소드
         int [] strikeAndBall = {0,0}; // 0번째 인덱스: 스트라이크, 1번째 인덱스: 볼

        ArrayList<Integer> comp = this.computer.getNumbers(); //컴퓨터의 숫자
        ArrayList<Integer> player = this.user.getNumbers(); //유저가 입력한 숫자

        for(int i=0;i<comp.size();i++){
            for(int j=0;j<player.size();j++){
                if(comp.get(i).equals(player.get(j))){
                    if(i==j){ //컴퓨터와 유저의 숫자가 서로 같고 위치도 같다면 스트라이크
                        strikeAndBall[0]++;
                    } else{ //값만 서로 같으면 볼
                        strikeAndBall[1]++;
                    }
                }
            }
        }
        return strikeAndBall;
    }

}
