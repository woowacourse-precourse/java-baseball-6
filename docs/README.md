### 구현 시나리오
1. pinNumberInRange() 사용하여 compurter(리스트)에 임의의 서로 다른 숫자 3개 저장
2. 사용자가 값을 입력하면 컴퓨터가 값 판별
   -  `예외처리` 조건 (IllegalArgumentException 오류 반환)
      * 입력 길이가 3이 아닐 경우
      * 동일 숫자가 중복될 경우
3. 받은 값에 따라 볼, 스트라이크, 낫싱 출력
4. 3스트라이크가 될 때까지 값 입력 요청 반복
5. 3스트라이크가 되면 계속(1)/종료(2) 입력하여 2일 경우 반복 중단, 1일 경우 1번부터 재진행
   - 1, 2 이외의 값 입력할 경우 `예외처리`


### 코드 작성 중 이슈
1. 코드 실행 시 한글 깨짐 현상 발생   
   1. [File]-[Settings..]-[File Encodings]의 Project Encoding 값을 "UTF-8"로 설정
   2. [File]-[Settings..]-[File Encodings]의 Default encoding for properties files 값 "UTF-8"로 설정
   3. 로컬의 '[설치경로]\bin'에 존재하는 idea64.exe.vmoptions 파일 메모장으로 열기
   4. 맨 아래에 "-Dfile.encoding=UTF-8" 추가 후 저장
   5. Intellij 재시작


### 새로 알게 된 점
1. 입력 받은 숫자를 하나씩 배열에 넣는 방법
   1. 일단 String 형식으로 값을 받음
   2. 받은 값을 새 배열 String에 split("")을 사용하여 하나씩 쪼개서 저장
   3. Integer형 ArrayList 선언
   4. for문 사용하여 배열 String 값들을 ArrayList에 저장
      - 숫자 중복 방지를 위해 int로 변환한 contains(<i>str</i>)가 false인 것만 저장
      - String > int로 형변환 불가능할 경우 자동으로 예외 발생
2. 강제 예외 처리 방법
    - throw를 통해 강제로 예외 발생 시킬 수 있음

### 추가 개선점
1. 기능별로 메소드 분리
   - 컴퓨터 숫자 설정
   - 사용자가 입력한 숫자 쪼개서 저장
   - 볼/스트라이크/낫싱 계산 및 출력
   - 3스트라이크 후 게임 재시작/종료 확인
   - checkException 메소드를 통해 예외처리 관리