# **구현해야할 기능 목록**
<br/>

#### 변수 선언
    Integer[] orderOfNumbers : 숫자 순서를 담을 배열 
    List<Integer> computerNumbers : 컴퓨터 수를 저장할 List
    String userNumbers : 사용자 수를 저장할 String
    Interger strike : 스트라이크 수를 저장할 Integer
    Integer ball : 볼 수를 저장할 Integer

<br/>

#### 시작
* '숫자 야구 게임을 시작합니다.'을 출력한다.
* 게임 진행여부를 나타내는 GameStatus enum 변수를 선언하고, START(1)로 초기화한다.
  
<br/>

#### 초기화
* orderOfNumbers의 모든 원소를 0으로 초기화한다.
* computerNumbers를 clear()를 통해 초기화한다.
* userNumbers을 빈 문자열로 초기화한다.

<br/>

#### 컴퓨터 수 생성
* camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 이용해 (1 ~ 9)까지의 서로 다른 숫자를 랜덤하게 3개 뽑아 List에 저장한다.
* 그와 동시에 등장순서를 배열에 저장한다.
* 예를 들어 127 이라면 arr[1] = 1, arr[2] = 2, arr[7] = 3 이 들어간다.


<br/>

#### 사용자 수 입력
* '숫자를 입력해주세요 :' 를 출력한다.
* camp.nextstep.edu.missionutils.Console의 readLine()을 이용해 사용자로부터 3자리 숫자를 입력받는다.
* 숫자가 3자리가 아니거나, 숫자 이외의 값을 입력하면 IllegalArgumentException을 발생 시킨 후 애플리케이션을 종료한다.

<br/>

#### 정답 확인
* strike, ball 값을 0으로 초기화한다.
* 사용자가 입력한 수의 왼쪽에서부터 하나 씩 정답 여부를 확인한다.
* 현재 확인하고 있는 숫자를 index로 사용해서 배열에 들어있는 값을 확인한다.
* 배열에 0이 아닌 값이 들어있으면서 순서도 일치한다면 스트라이크, 순서는 일치하지 않는다면 볼로 판단하고 각 변수의 값을 증가시킨다.
* 정답을 모두 맞혔다면 true를 return하고, 그렇지 않다면 false를 return 한다.

<br/>

##### 결과 출력

* 입력 수에 대한 정답 결과를 볼, 스트라이크 개수로 출력한다.
* 한 개도 맞추지 못한 경우엔 '낫싱'을 출력한다.
* 3개의 숫자를 모두 맞힐 경우 '3개의 숫자를 모두 맞히셨습니다! 게임 종료'를 출력하고 게임 재개 여부 확인 단계로 이동한다.
* 3개의 숫자를 모두 맞히지 못한 경우엔 사용자 수 입력 단계로 이동한다.

<br/>

#### 게임 재개 여부 확인

* '게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.' 을 출력한다.
* camp.nextstep.edu.missionutils.Console의 readLine()을 이용해 사용자로부터 숫자를 입력받는다.
* 1을 입력 받았다면 초기화 단계로 이동한다.
* 2를 입력 받았다면 애플리케이션을 종료한다.
* 1, 2를 제외한 문자를 입력받았다면 IllegalArgumentException을 발생 시킨 후 애플리케이션을 종료한다.
