# 구현할 기능 목록

# baseball

### Application

숫자 야구 게임의 **프론트 역할**을 합니다.

사용자의 숫자를 입력 받을 수 있고, 게임의 결과를 출력합니다.

# service

### BallService(인터페이스)

1. `generateRandomNumber()`

   랜덤 숫자를 생성하는 메서드

2. `isValidation(String ballCount)`

   사용자가 입력한 값의 유효성을 검사하는 메서드

3. `startGame(String ballCount)`

   유효성 검사가 완료된 **ballCount**를 랜덤 숫자와 비교하면서 **ball**과 **strike**를 계산해주는 메서드

4. `printBallCount(int ball, int strike)`

   **ball**과 **strike**로 나온 값을 바탕으로 게임 결과 값을 출력하는 메서드

### BallServiceImpl(인터페이스 구현한 클래스)

1. `BallServiceImpl()`

   생성자이다. 싱글톤 패턴으로 작성하였기 때문에 한번만 호출된다.

   `generareRandomNumber()` 를 호출해 처음에 랜덤 숫자를 생성해 준다.

2. `getInstance()`

   싱글톤 패턴으로 만든 **service** 객체를 return 하는 메서드

나머지는 **BallService** 인터페이스의 메서드를 구현

# test

1. `중복_숫자_테스트()`

   사용자 입력값인 “171” 을 넣어 IllegalArgumentException 을 발생시키는지 테스트 하는 코드

2. `문자_테스트()`

   사용자 입력값인 “ekf” 를 넣어 숫자가 아닌 문자를 넣었을 때

   IllegalArgumentException 을 발생시키는지 테스트 하는 코드
