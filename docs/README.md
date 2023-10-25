# 미션 - 숫자 야구

## 구현 할 기능 목록

1. 랜덤의 3자리의 수 생성하는 기능

   - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`사용
   - 1부터 9까지 서로 다른 수로 이루어진 3자리의 수

2. 게임 플레이어가 생각하는 3개의 숫자를 입력 받는 기능

   - `camp.nextstep.edu.missionutils.Console`의 `readLine()`사용
   - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생

3. 입력받은 수와 생성한 랜덤 수를 비교하는 기능

   - 같은 수가 같은 자리에 있으면 '스트라이크' return
   - 같은 수가 다른 자리에 있으면 '볼' return
   - 같은 수가 전혀 없으면 '낫싱' return

4. 게임 플레이어가 '3스트라이크'를 달성하여 게임이 종료되면 게임 재시작 여부를 입력받는 기능
   - 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수
