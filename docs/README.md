<h2> Application 클래스에는 main메서드를 넣어서 실행이 되게 만드는 클래스로 이용 할 것이다. </h2>

<br>1) main메서드

- 프로그램을 실행하는 메서드 (숫자 야구 게임을 실행)

<h2> StartGame 클래스에는 게임에 대한 전반적인 내용들을 다양한 메서드를 통해서 구현 할 것이다.</h2>

<br>1) start 메서드 <br>

- 게임이 시작되고 종료까지의 순서들을 처리하는 메서드

<br>2) randomNumber 메서드 <br>

- 컴퓨터가 랜덤으로 숫자 3개를 고르는 메서드
- 숫자들을 골라서 ArrayList의 baseball 값 안에 넣어준다.

<br>3) inputUserNumber 메서드

- 유저가 숫자 야구 게임에서 컴퓨터가 고른 값들을 맞출 때까지 숫자를 입력해야하는 메서드

<br>4) gameResult 메서드

- 유저가 입력한 3개의 숫자에 대해 컴퓨터가 고른 값과 같은지 판단하는 메서드
- 3개의 스트라이크를 성공했을 시에 CORRECT_ANSWER로 리턴
- 그 외에는 WRONG_ANSWER로 리턴
  <br>5) printResult 메서드
- gameResult에서 strike 개수와 ball의 개수를 가지고 결과값을 출력하는 메서드

<h2> ExceptionHandling 클래스에는 예외처리에 대한 메서드를 구성하여 예외처리가 발생 시에 처리되는 값들을 구현 할 것이다. </h2>

<br>1) checkNumber 메서드

- 유저가 입력할 값에 대한 범위를 체크한다
- 만약 범위에 해당되지 않는다면 IllegalArgumentException 예외처리를 날린다.

<br>2) checkDuplication 메서드

- 유저가 입력한 값에 대해 중복된 숫자가 없는지 체크한다.
- 만약 중복된 값이 발생한다면 IllegalArgumentException 예외처리를 날린다.

<br>3) checkNumberSize 메서드

- 유저가 입력한 숫자들의 개수가 3개인지 체크한다.
- 만약 유저의 입력 갯수가 3개가 아니라면 IllegalArgumentException 예외처리를 날린다.

<br>4) restartOrEnd 메서드

- 유저가 게임을 다시 시작할 것인지, 종료할 것인지에 대한 값을 입력 받는지 체크한다.
- 만약 두 경우가 아니라면 IllegalArgumentException 예외처리를 날린다.

<h2> FixedValue 클래스에는 상수들로만 구성된 클래스로 이용 할 것이다. </h2>

