1. player
- computer number와 비교하기 위한 세자리 숫자 player number를 입력할 수 있다
- 게임 한 판이 끝났을 시 해당 게임을 종료할지 재시작할지 선택한다
  <br>

2.  computer
-  랜덤으로 세자리 숫자 computer number를 만든다. 이때, 각 자리의 숫자는 달라야한다
   <br>

3. baseball game
- 게임 시작 문구를 출력한다
- player number와 computer number의 자리 별 숫자 동일 여부를 비교하여 해당 결과를 출력한다
    - 만일 입력된 player number가  3자리 수가 아니거나, 서로 같은 숫자가 존재할 시, 잘못된 숫자 입력이라 판단하여 예외 처리를 한다.
    - 만일 player number에 숫자중 computer number에 포함된 숫자가 없을 시 "낫싱" 출력
    - 자리가 다르고 숫자는 같은게 포함되었을 시 "n볼" 출력
    - 자리가 같고 숫자도 같은 경우 "n스트라이크" 출력
    - 볼과 스트라이크가 모두 존재하면 볼을 먼저 출력한다
    - 만일 세자리 숫자 모두 같을 시 "3스트라이크" 출력 후, 해당 판의 게임을 끝낸다.
