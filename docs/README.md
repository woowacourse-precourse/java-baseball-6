# 기능 정리


- 점수 판별하는 메소드
- 판별한 점수 바탕으로 출력을 해주는 메소드
- 입력을 받는 메소드
  - 제공된 라이브러리의 `Console`클래스를 사용한다.
  - `readLine()` : 자체적으로 `Scanner`를 생성해서 `String`을 돌려주는 함수
  - 문자열로 돌려주기 때문에 가공 후 배열이든 리스트로 반환하고, 만약 문자가 파싱되지 않을 경우 `IllegalArgumentException`을 발생시킨다.
  - 한글자씩 파싱하되 각 숫자가 이미 있는지?
    - 이미 있다면 `IllegalArgumentException`
    - 없다면 리스트에 넣기
  - 숫자가 3개 초과하거나 미만이라면 에러
  - 숫자가 아닌 경우에도 에러
- 컴퓨터가 가질 숫자를 생성하는 함수
- 


#### 입력을 받는 메소드
- name : getNumbers
- parameters : 없음
- return : `List<Integer>` 
  - 부호가 없는 정수를 원소로 가지고 크기가 3인 정수 리스트
- error : 다음의 경우 `IllegalArgumentException`를 발생시키고 종료
  - 1 ~ 9의 범위를 벗어난 경우
  - 숫자가 아닌 경우
  - 이미 있는 원소를 중복으로 입력한 경우
  - 원소가 3개를 초과하거나 미만일 경우 
- description : 게임을 진행하기 위해 `Console`클래스의 `readLine`으로 입력받은 `String`을 각각 하나의 숫자로 변환시켜 `List`에 추가하는 메소드
  -`getBytes()` 메소드로 각각
#### 입력을 받는 메소드2


#### 힌트를 계산하는 메소드
- name : 
- parameters : 
- return : 크기가 2인 `int[]`, 0번부터 1번까지 각각 스트라이크, 볼의 개수를 가진다.
- description : 입력받은 수들과 컴퓨터가 가지고 있는 수들을 비교한 후 힌트를 계산해주는 메소드
- 
