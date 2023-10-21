숫자 야구 게임 만들기!

1. 랜덤으로 서로다른 숫자 3개를 생성한다.(camp.nextstep.edu.missionutils의 Randoms함수를 이용)
2. 사용자의 입력을 받는다(camp.nextstep.edu.missionutils의 Console함수 이용, 입력값은 서로다른 숫자 3개)
3. 해당 입력이 잘못된 입력일 경우 IllegalArgumentException을 발생시킨 후 종료한다.
4. 랜덤생성 숫자와 사용자 숫자를 비교해 strike와 ball의 수에 따라 다른 출력값을 반환한다.
5. 만일 3스트라이크로 맞췄을 경우 해당 게임을 종료하고 다시 게임할지 종료할지 여부를 입력받는다.
6. 입력값이 1이면 새게임, 2라면 종료한다.
7. 1과 2 둘다 아닐경우 이번에도 IllegalArgumentException을 발생시키고 종료한다.

[추가적 구현]
1. 캡슐화 해보기
2. 주석을 달기
3. 긴 함수를 여러개의 작은 함수로 쪼개보기 (리팩토링 경험해보기)