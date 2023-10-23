**구현할 기능 목록**</br></br>

**makeRandomList(int length)**
- 길이가 length이고, 중복되지 않는 랜덤 숫자로 이루어진 List를 반환하는 함수이다.

**gaming(List<Integer> computerList)**
- 실질적으로 숫자 야구를 하는 함수이다.
- 입력받은 데이터가 3자리 숫자가 아닐 경우 오류를 발생시키고, 3자리 숫자일 경우 matching 함수를 실행한다.
- 3스트라이크가 아닌 경우, 다시 gaming 함수를 호출해 숫자를 입력하는 과정이 진행되도록 한다.

**checkInt(String gameInput)**
- gameInput이 정수로 이루어져있는지 확인하는 함수이다.
- 모두 정수로 이루어졌을 경우 true를, 그렇지 않은 경우 false를 반환한다.

**matching(String gameInput, List<Integer> computerList)**
- gameInput과 computerList를 비교하여 스크라이크, 볼 여부를 알려주는 함수이다.
- 3자리 숫자와 위치를 모두 맞춘 경우 true를 반환하고, 그 외에는 false를 반환한다.

**askFinish()**
- 종료 여부를 입력받는 함수이다.
- 재시작(1)을 선택한 경우 true를, 종료(2)를 선택한 경우 false를 반환한다.
- 1과 2 이외의 데이터를 입력했다면 오류를 발생시킨다.