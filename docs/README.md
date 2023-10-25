## 기능 목록

1. 컴퓨터의 랜덤 숫자를 지정한다.
   - Computer 클래스에서 중복되지 않은 1에서 9까지의 숫자로 이루어진 리스트를 받아온다.
   - `camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 사용하여 구현.
   - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
2. 사용자에게 숫자를 입력받는다.
   - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
   - 예외 처리
      - 사용자가 정확히 3개의 문자를 입력했는지 예외처리
      - 사용자가 1부터 9까지의 숫자만 입력했는지 예외처리
      - 사용자가 숫자가 아닌 문자나 공백을 입력하지 않았는지 예외처리

     → 만약 잘못된 값을 입력한다면 애플리케이션 종료 (`IllegalArgumentException`)

3. 사용자의 숫자와 컴퓨터의 숫자를 바탕으로 실행 결과를 확인한다.
   - 비교된 결과는 `Result` 클래스의 Ball, Strike에 저장되어 관리한다.
   - Ball, Strike가 모두 0인 경우 → “낫싱”
   - Ball이 0개가 아닌 경우 → “n볼”
   - Strike가 0개가 아닌 경우 → “n스트라이크”
   - 결과값은 String형식으로 출력 요구 조건에 맞게 받아올 수 있다.
4. 2~3까지 반복하다가 스트라이크가 3회 등장하면 게임을 종료하는 메시지를 출력한다.
   1. 게임을 다시 시작할 것이냐고 사용자에게 묻는다. `reStart()`
      1. 사용자가 1을 입력한 경우 → 재시작 (1~4번까지 다시 진행)
      2. 사용자가 2를 입력한 경우 → 게임 종료
      3. 사용자가 다른 숫자를 입력한 경우 → 애플리케이션 종료 (`IllegalArgumentException`)