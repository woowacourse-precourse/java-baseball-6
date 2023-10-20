## 1. 기능 구현 목록
1. 게임 시작
   1. 1부터 9까지 서로 다른 수로 이루어진 3자리수 랜덤값 생성 
   2. 게임 시작 View - 시작 문구 출력
   3. 게임 진행 호출
2. 게임 진행 
   1. 숫자 입력 문구 출력 
   2. 숫자 입력 
      1. Controller의 파라미터로 전달 
      2. 입력받은 수 검증 
         1. 숫자인지 확인
         2. 세 자리인지 확인
         3. 서로 다른 숫자인지 확인
      3. 정답과 비교하여 결과값 반환
         4. 같은 수 같은 자리 : 스트라이크
         5. 같은 수 다른 자리 : 볼
         6. 같은 수 없음 : 낫싱
         7. 모두 맞음 : 3개의 숫자를 모두 맞히셨습니다!
   3. 결과값 출력 
      1. 숫자를 맞춘 경우, Controller 호출 
      2. 아닐 경우, 다시 반복
3. 게임 종료 
   1. 1일 경우, 다시 시작 
   2. 2일 경우, 종료
         </br>

## 2. 패키지 구조
```bash
com.woowacourse.java-baseball-6
┣ controller
┃ ┗ GameController.java
┃
┣ model
┃   
┣ view 
┃ ┣ startView.java
┃ ┣ proceedView.java
┃ ┗ EndView.java
```
</br>

## 3. Git 커밋 컨벤션
```
type: subject
```
### Commit Type
* feat: 새로운 기능 추가
* fix: 버그 수정
* docs: 문서 수정
* refactor: 코드 리팩토링
* test: 테스트 코드, 리팩토링 테스트 코드 추가
* style: 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우

### Subject
* 50자를 넘기지 않고, 마침표를 붙이지 않습니다.
* 과거 시제를 사용하지 않고 명령어로 작성합니다.
  </br>

## 4. Java 코드 컨벤션
https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java#java-style-guide