## 필요한 기능
### (1) 초기설정
- 세자리 숫자를 생성/입력받고 저장해서 관리할 클래스`shootBall`을 구현한다.
- shoot ball 내부에 10 크기의 1차원 정수형 변수를 저장하는 배열 `numbers`을 구현한다.
- `numbers` 배열은 전부 0으로 초기화한다.
- 세자리 수가 주어질 때 숫자의 자릿수에 따라 배열에 저장한다.
##### 예시
    세 자리 수가 456 인 경우:{0,0,0,0,1,2,3,0,0,0}

    세 자리 수가 723 인 경우: {0,0,2,3,0,0,0,1,0,0}

    세 자리 수가 185 인 경우: {0,1,0,0,0,3,0,0,2,0}
- 게임시작 문구를 출력해준다.


    숫자 야구 게임을 시작합니다.
### (2) 랜덤으로 서로 다른 3자리의 수를 생성하는 기능 `randomNumGenerator()`
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
#### 사용 예시
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
    computer.add(randomNumber);
    }
    }
- 생성된 수를 (1)의 조건에 맞게 `random_num`에 저장한다.
.
### (3) 사용자가 입력하는 수를 입력받는 기능 `inputNumGenerator()`
- scanner를 사용하여 입력받는다.


    숫자를 입력해주세요 : 123
- 입력받은 수를 (1)의 조건에 맞게 `input_num`에 저장한다..
- 
### (3.1) 배열에 저장한 수를 지우는 기능 `clearArr()`
- 게임을 새로 시작하거나, 입력을 다시 받을 때, 배열에 있는 기존의 수를 다 지워줘야 한다.
  - (2), (3)번 기능 내부에서 사용할 예정이다.


### (4) 사용자에게 입력받은 수가 잘못됐을 때 인식하는 기능 `validNumInspect()`
- 다음과 같은 조건에서 `IllegalArgumentException`를 발생시키는 기능을 구현한다. 


  1. 중복된 수가 있을 시.
  2. 3자리수보다 적거나 많이 입력했을 시.
  3. 숫자가 아닌 문자를 입력했을 시.

### (5) 사용자가 입력한 수와 컴퓨터의 수를 대조해주는 기능 `baseballReferee()`
-정수형 변수 `strike`와 `ball`에 strike와 ball 여부를 저장한다.
- 반복문으로 `random_ball`과 `input_ball`의 같은 인덱스에 있는 값들로 and 연산을 수행한다.
  - and 연산을 수행했을 때의 값이 0이라면
    - 다음 인덱스로 넘어간다.
  - and 연산을 수행했을 때의 값이 0이 아니라면
    - random_ball`과 `input_ball`의 값을 대조한다.
      - 같다면 `strike`에 1을 더해준다.
      - 다르다면 `ball`에1을 더해준다.
- `strike`와 `ball`의 값을 바탕으로 볼, 스트라이크 여부를 출력해주고, 게임 승리 여부를 boolean으로 출력해준다.


    숫자를 입력해주세요 : 123
    1볼 1스트라이크
    숫자를 입력해주세요 : 145
    1볼
    숫자를 입력해주세요 : 671
    2볼
- 두 변수의 값이 0이라면 낫싱을 출력해준다.
    낫싱
- 위와 같이 3스트라이크가 아닐 때는 
  - false 를 리턴
  - `input_num`의 값을 모두 0으로 초기화 
  - `strike`와 `ball` 변수의 값을 0으로 초기화
- 한 뒤 다시 숫자를 입력받아 게임을 계속 진행한다.
- 3스트라이크인 경우, true를 리턴하며 게임 종료 문구를 출력한다.


    3스트라이크
    3개의 숫자를 모두 맞히셨습니다! 게임 종료
### (6) 게임을 진행하는 기능 
- `main(String[] args)`에서 숫자야구를 진행하는 기능.
- `ShootBall`클래스의 인스턴스 `randomBall`과 `inputBall`을 생성한다.
- (2)번기능 `randomNumGenerator()`를 통해 `randomBall`의 수를 정한다.
- (3)번 기능 `inputNumGenerator()`를 통해 `inputBall`의 수를 정한다.
- `baseballReferee()`의 리턴값을 통해 게임의 승패를 확인한다.
  - flase 일 시 (3)번 기능부터 다시 실행시킨다.
  - true 일 시 프로그램을 종료한다. 
- 게임을 승리할 시 게임을 종료할지, 새로운 게임을 시작할지 고르게 해주는 개능을 추가한다.