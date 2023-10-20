## 필요한 기능
#### (1) 초기설정
- 우선 스트라이크와 볼의 개수를 저장할 정수형 변수 `strike`와 `ball`을 생성한다.
- 3개의 숫자를 편하게 비교하기 위해서는 배열에 저장하는것이 좋다고 생각했다.
- 10 크기의 1차원 정수형 변수를 저장하는 배열 `random_num`을 셍성한다.
- 동일한 조건의 배열 `input_num`을 셍성한다.
- 이 `random_num`과 `input_num`은 전부 0으로 초기화 한다.
- 세자리 수가 주어질 때 숫자의 자릿수에 따라 배열에 저장한다.
##### 예시
    세 자리 수가 456 인 경우:{0,0,0,0,1,2,3,0,0,0}

    세 자리 수가 723 인 경우: {0,0,2,3,0,0,0,1,0,0}

    세 자리 수가 185 인 경우: {0,1,0,0,0,3,0,0,2,0}
- 게임시작 문구를 출력해준다.


    숫자 야구 게임을 시작합니다.
### (2) 랜덤으로 서로 다른 3자리의 수를 생성하는 기능
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
### (3) 사용자가 입력하는 수를 입력받는 기능
- scanner를 사용하여 입력받는다.


    숫자를 입력해주세요 : 123
- 입력받은 수를 (1)의 조건에 맞게 `input_num`에 저장한다..

### (4) 사용자에게 입력받은 수가 잘못됐을 때 인식하는 기능
- 다음과 같은 조건에서 `IllegalArgumentException`를 발생시키는 기능을 구현한다. 


  1. 중복된 수가 있을 시.
  2. 3자리수보다 적거나 많이 입력했을 시.
  3. 숫자가 아닌 문자를 입력했을 시.

### (5) 사용자가 입력한 수와 컴퓨터의 수를 대조해주는 기능
- 반복문으로 `random_num`과 `input_num`의 같은 인덱스에 있는 값들로 and 연산을 수행한다.
  - and 연산을 수행했을 때의 값이 0이라면
    - 다음 인덱스로 넘어간다.
  - and 연산을 수행했을 때의 값이 0이 아니라면
    - `strike`에 1을 더해주고
    - `random_num`과 `input_num`의 값을 대조하여 같다면, `ball`에도 1을 더해준다.
### (6) strike, ball 여부를 알려주는 기능
- `strike`와 `ball`의 값을 바탕으로 볼, 스트라이크 여부를 출력해준다.


    숫자를 입력해주세요 : 123
    1볼 1스트라이크
    숫자를 입력해주세요 : 145
    1볼
    숫자를 입력해주세요 : 671
    2볼
- 두 변수의 값이 0이라면 낫싱을 출력해준다.


    낫싱
- 위와 같이 3스트라이크가 아닐 때는
  - `input_num`의 값을 모두 0으로 초기화 
  - `strike`와 `ball` 변수의 값을 0으로 초기화
- 한 뒤 다시 숫자를 입력받아 게임을 계속 진행한다.
- 3스트라이크인 경우, 게임 종료 문구와 함께 게임을 종료시킨다.


    3스트라이크
    3개의 숫자를 모두 맞히셨습니다! 게임 종료
## 필요한 기능
#### (1) 초기설정
- 우선 스트라이크와 볼의 개수를 저장할 정수형 변수 `strike`와 `ball`을 생성한다.
- 3개의 숫자를 편하게 비교하기 위해서는 배열에 저장하는것이 좋다고 생각했다.
- 10 크기의 1차원 정수형 변수를 저장하는 배열 `random_num`을 셍성한다.
- 동일한 조건의 배열 `input_num`을 셍성한다.
- 이 `random_num`과 `input_num`은 전부 0으로 초기화 한다.
- 세자리 수가 주어질 때 숫자의 자릿수에 따라 배열에 저장한다.
##### 예시
    세 자리 수가 456 인 경우:{0,0,0,0,1,2,3,0,0,0}

    세 자리 수가 723 인 경우: {0,0,2,3,0,0,0,1,0,0}

    세 자리 수가 185 인 경우: {0,1,0,0,0,3,0,1,0,0}
- 게임시작 문구를 출력해준다.


    숫자 야구 게임을 시작합니다.
### (2) 랜덤으로 서로 다른 3자리의 수를 생성하는 기능
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
### (3) 사용자가 입력하는 수를 입력받는 기능
- scanner를 사용하여 입력받는다.


    숫자를 입력해주세요 : 123
- 입력받은 수를 (1)의 조건에 맞게 `input_num`에 저장한다..

### (4) 사용자에게 입력받은 수가 잘못됐을 때 인식하는 기능
- 다음과 같은 조건에서 `IllegalArgumentException`를 발생시키는 기능을 구현한다. 


  1. 중복된 수가 있을 시.
  2. 3자리수보다 적거나 많이 입력했을 시.
  3. 숫자가 아닌 문자를 입력했을 시.

### (5) 사용자가 입력한 수와 컴퓨터의 수를 대조해주는 기능
- 반복문으로 `random_num`과 `input_num`의 같은 인덱스에 있는 값들로 and 연산을 수행한다.
  - and 연산을 수행했을 때의 값이 0이라면
    - 다음 인덱스로 넘어간다.
  - and 연산을 수행했을 때의 값이 0이 아니라면
    - `strike`에 1을 더해주고
    - `random_num`과 `input_num`의 값을 대조하여 같다면, `ball`에도 1을 더해준다.
### (6) strike, ball 여부를 알려주는 기능
- `strike`와 `ball`의 값을 바탕으로 볼, 스트라이크 여부를 출력해준다.


    숫자를 입력해주세요 : 123
    1볼 1스트라이크
    숫자를 입력해주세요 : 145
    1볼
    숫자를 입력해주세요 : 671
    2볼
- 두 변수의 값이 0이라면 낫싱을 출력해준다.


    낫싱
- 위와 같이 3스트라이크가 아닐 때는
  - `input_num`의 값을 모두 0으로 초기화 
  - `strike`와 `ball` 변수의 값을 0으로 초기화
- 한 뒤 다시 숫자를 입력받아 게임을 계속 진행한다.
- 3스트라이크인 경우, 게임 종료 문구와 함께 게임을 종료시킨다.


    3스트라이크
    3개의 숫자를 모두 맞히셨습니다! 게임 종료
