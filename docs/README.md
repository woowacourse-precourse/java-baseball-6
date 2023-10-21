# 숫자 야구 - 6기
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
<br>
## 목표
1. MVC 패턴을 최대한 적용하여 잘게 나눈 단위의 기능들을 구현한다.<br>
   -> View와 Model은 독립적이다 !
2. 가장 주된 우선순위는 성공적으로 동작하는 것이다.
3. 모든 것이 구현된 이후 리팩토링을 진행한다.
4. code, commit convention을 잘 지켰는지 상시 검토한다.
5. 모든 작업은 협업이라는 가정하에 진행한다.
6. 상수, 문자열 변수들은 따로 관리한다.
   <br>
## 구조
#### Controller : BaseBallGame<br>
-> Player, Refree, Computer 생성 (Model)<br>
-> Player의 동작을 컨트롤 (입력)<br>
-> Refree의 동작을 컨트롤 (IsStrike, IsBall, Exception 처리 등)<br>
-> Computer 동작을 컨트롤 (Random 숫자 생성)<br>
#### View : GameResult <br>
-> Model에게 정보를 받은 Controller로 부터 게임 진행 상황을 전달 받음<br>
-> 인터페이스가 되어서 출력을 담당<br>
#### Model : Player <br>
-> 입력<br>
#### Model : Refree <br>
-> Player의 입력에 대해서 판단을 함<br>
-> 게임 종료를 판단<br>
-> 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 지 판단<br>
-> 잘못된 값을 입력할 경우 IllegalArgumentException 처리<br>
#### Model : Computer <br>
-> Random한 세 자리 숫자를 생성함<br>
<br>
## Flow
1. BaseBallGame을 컨트롤 하는 객체가 생성된다.
2. Controller로 게임을 시작한다.
3. 게임이 시작되면 Controller에 의해 Computer는 숫자를 생각한다.
4. Player는 숫자를 입력한다.
5. Refree는 판단한다.
6. 4-5를 반복하고 Refree는 게임 종료를 판단한다.
7. 게임 종료 후에 Player의 의사에 따라 Refree는 게임을 재시작할지 완전히 종료할지 판단한다.
   <br>
## 기능
1. 스트라이크를 판단하는 기능(Refree) [o]
2. 볼을 판단하는 기능(Refree) [o]
3. 낫싱을 판단하는 기능(Refree) [o]
4. 컴퓨터가 숫자를 랜덤으로 생각하는 기능(Computer) [o]
5. 게임을 종료할 지 판단하는 기능(Refree) [o]
6. 게임을 다시 시작하는 기능 [o]
7. 게임을 완전히 종료하는 기능 [o]
8. 잘못된 입력을 판단하여 예외를 발생하는 기능 [o]<br>
   -> 숫자가 아닌 입력을 포함한 경우<br>
   -> 세자리의 숫자가 아닌 경우  <br>
   -> '1', '2'가 아닌 입력인 경우<br>

   