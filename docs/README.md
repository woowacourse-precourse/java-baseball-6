## 기능 구현 목록
1. 랜덤으로 값 생성하는 객체
    - `Randoms.pickNumberInRange()` 사용
2. 세 자리의 수를 입력 받는다.
    - `Console.readLine()` 사용
3. 랜덤 값과 입력 값을 비교한 결과 값을 출력한다.
    - domain에 해당하는 `BaseBall` 객체 생성
    - 입력 값과 랜덤 값을 계산하는 `BaseballCalculator` 객체 생성
    - `BaseBall`은 결과 값 계산을 `BaseballCalculator`에게 위임한다.
    - 결과 값을 출력하는 `Printer` 객체 생성
4. 3 스트라이크일 경우, 게임 종료한다.
5. 1을 입력하면 재시작, 2를 입력하면 프로그램을 종료한다.
