## ✏️ 구현할 기능 사항

### 1. 난수 생성
- 컴퓨터가 생성할 서로다른 3개의 난수를 만든다.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.

### 2. 사용자 입력
- 입력에 대한 유효성을 판단하고 예외처리에 주의한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

### 3. 게임 규칙 적용
- 사용자가 입력한 입력 값을 주어진 규칙을 적용하여 판단하고 판단한 결과를 출력한다.

### 4. 재실행 및 종료
- 사용자의 입력에 따라 프로그램을 재시작 또는 종료한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.