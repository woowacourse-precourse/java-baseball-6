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
6. `GameManager`가 다양한 게임들을 실행할 수 있도록 `Game`이라는 인터페이스를 도입한다.
    - `GameManager`는 실행하는 게임이 어떤 게임인지 몰라도 된다.
    - 특정 게임의 로직이 변경되어도 `GameManager`가 게임을 실행시키는 것에는 영향을 주지 않기 때문이다.

## 객체 관계

1. `GameManager`
    - `Game`을 실행시키고 입력 값에 따라 반복하거나 종료한다.
2. `Game`,`BaseBall`
    - 값을 입력받고, 정답을 맞출 때까지 한 세트를 반복한다.
    - `RandomNumberCreator` : 게임에 필요한 랜덤 값을 생성한다.
    - `Validator` : `Game`으로 부터 입력받은 값에 대해 유효성 검사를 한다.
    - `Calculator` : 랜덤 값과 입력 값을 비교한다.
    - `Printer` : 비교 값을 화면에 출력한다.