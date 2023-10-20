# 1주차 프리코스 과제

## 기능 목록

[ ] 컴퓨터로 부터 랜덤 숫자 입력받기

- import camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 메소드를 활용해서 랜덤값 받기.

[ ] 스트라이크, 볼, 낫싱 구분하고 출력하기

    - 스트라이크 조건 : if 위치 && 값 같을 때
    - 볼 조건 : else if 위치는 다르지만 값이 같을 때
    - 낫싱 : else if 위치도 값도 다를 때

[ ] 사용자가 추측한 숫자 입력 받기 & 게임 끝났을 때, 1 OR 2 (재시작 OR 종료) 입력받고 실행하기

- import camp.nextstep.edu.missionutils.Console의 readLine() 메소드를 활용해 입력받음.
- 조건에 맞지 않는 입력일 때 IllegalArgumentException을 Throw한다.
    1) 숫자를 입력하지 않았을 때
    2) 3자리 수를 입력하지 않았을 때
    3) 게임 끝나고 1 혹은 2를 입력하지 않았을 때
    4) 다 다른 숫자가 아닐 때
    5) 빈 문자열을 입력했을 때
       [ ] 잘못된 값 입력 시 IllegalArgumentException 발생 후 애플리케이션 종료

[ ] 각 실행마다 출력해야하는 게임 도움말 출력하기