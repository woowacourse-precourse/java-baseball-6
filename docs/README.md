<h1>1주차 프리코스</h1>
<h2>📄 구현 기능 목록</h2>
<h3>1~9사이의 숫자중 3개를 뽑아 3자리 수를 정한다.</h3>

1.3자리 수를 입력받는다. 단, 유효성 검사를 실시한다
<li>받은 값이 3자리가 아닌 경우 예외 출력</li>
<li>받은 값이 숫자가 아닌 경우 예외 출력</li>
<li>받은 값에 중복된 숫자가 있을 시 예외 출력</li>

2.입력값에 따라 값을 구분한다.
<li>자리와 숫자 둘다 맞춘 경우 => 스트라이크</li>
<li>숫자는 같지만 자리가 다른 경우 => 볼</li>
<li>자리와 숫자 모두 틀린 경우 => 낫싱</li>

3.게임의 승패 유무를 판단한다.
<li>3스트라이크인 경우, 게임이 종료된다.</li>
<li>3스트라이크가 아니면 다음 라운드로 자동 진행된다.</li>

4.게임 종료가 되면, 다시 게임을 진행할지 완전히 프로그램을 종료할 지를 출력한다.
<li>1 입력 시 게임 재시작</li>
<li>2 입력 시 프로그램 종료</li>

<h3>MVC 구조</h3>
<h4>baseball</h4>
<ui>controller
<li>BaseballGame (Model과 View를 결정하여 전달)</li>
</ui>
<ui>model
<li>ComputerNumber (게임을 위한 숫자 랜덤 생성)</li>
<li>PlayerNumber (사용자 숫자 생성)</li>
<li>RetryNumber (재시작 생성)</li>
</ui>
<ui>util
<li>NumberComapare (비교 후 볼, 스트라이크 카운트 저장)</li>
<li>Validator (사용자 입력과 랜덤 생성 숫자 비교를 위한 검증자 생성)</li>
</ui>
<ui>view
<li>InputView  (사용자 입력 클래스)</li>
<li>OputView (출력 클래스)</li>
</ui>