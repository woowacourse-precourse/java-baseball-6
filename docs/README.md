* ## 🛠 기능 구현 목록

* `RandomNumberGenerator`: 서로 다른 3개의 수의 임의의 숫자를 만든다.
    * [x] 서로 다른 3개의 숫자를 만든다.
        * [x] Randoms 를 알기 위해 학습 테스트 생성
        * [x] 테스트 코드 작성을 위한 대역 생성(DoubleRandomService)과 서비스 추상화(RandomService)
        * [x] 서로 다른 3자리 !!! -> 중복 확인 필요

* `GameReferee` : 시도한 공과 정답 공을 비교해 결과를 알려준다.
    * [x] 시도한 공을 받아 게임 결과를 알려준다.

* `Score` : 점수 (ex. THREE_STRIKE)
    * [x] : 볼 갯수와 스트라이크 갯수로 Score을 만든다.

* `Ball` : 볼 안에 있는 숫자를 관리한다.
    * [x] : 볼에 있는 숫자와 다른 볼에 있는 숫자를 비교한다.

* `InputDevice`
    * [x] : 서로 다른 세자리수를 입력한다.
        * [x] : 테스트 코드 작성을 위한 대역 생성(DoubleConsoleService)과 서비스 추상화(ConsoleService)
    * [x] : 재시작/종료를 위해 1과 2를 입력받는다.

* `InputValidator`
    * [x] : 1 ~ 9 사이의 서로 다른 세자리수인지 검증한다.
    * [x] : 재시작/종료를 위해서는 1과 2만 입력받을 수 있다.
  