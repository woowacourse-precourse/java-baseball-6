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

* `InputView`
    * [x] : 서로 다른 세자리수를 입력한다.
        * [x] : 테스트 코드 작성을 위한 대역 생성(DoubleConsoleService)과 서비스 추상화(ConsoleService)
    * [x] : 재시작/종료를 위해 1과 2를 입력받는다.

* `InputValidator`
    * [x] : 1 ~ 9 사이의 서로 다른 세자리수인지 검증한다.
    * [x] : 재시작/종료를 위해서는 1과 2만 입력받을 수 있다.

* `BaseBallGameService`
    * [x] : Application 에게 정답 공의 숫자를 생성하라는 메시지를 받으면 게임을 시작해 정답 공의 숫자들을 가져온다.
    * [x] : Application 에게 게임 결과를 알려달라는 메시지를 받으면 게임 결과를 가져온다.

* `Application`
    * [x] : 야구 게임을 실행한다. (모든 테스트 성공!)
        * [x] : Console 작동을 위한 ConsoleService 구현체인 DefaultConsoleService 생성
        * [x] : Randoms 작동을 위한 RandomService 구현체인 DefaultRandomService 생성

* `BasBallGameController`
    * [x] : Application은 2개의 책임을 가지고 있다. -> 3스트라이크가 나올때까지 게임을 하는 책임을 Controller가 가져가자!

* `OutputView`
    * [x] : 게임 시작 멘트를 출력한다.
    * [x] : 게임 종료 멘트를 출력한다.
    * [x] : 게임 결과를 출력한다.

* `FrontController`
    * [x] : FrontController에서만 BaseBallController를 호출하도록 만들어 BaseBallController의 View 의존성 제거
    * [x] : FrontController만 InputView와 OutputView에게 메시지를 보낼 수 있다.