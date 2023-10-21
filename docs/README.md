## 1. 기능 구현 목록
1. 게임 시작
   1. 1부터 9까지 서로 다른 수로 이루어진 3자리수 생성 
   2. 시작 문구 출력
   3. 게임 진행
2. 게임 진행 
   1. 숫자 입력 문구 출력 
   2. 숫자 입력  
   3. 입력받은 수 검증
      1. 숫자인지 확인
      2. 세 자리인지 확인
      3. 서로 다른 숫자인지 확인
   4. 힌트 출력
      1. 같은 수 같은 자리 : 스트라이크
      2. 같은 수 다른 자리 : 볼
      3. 같은 수 없음 : 낫싱
   5. 정답과 입력받은 수 비교
      1. 정답이라면 게임 종료
      2. 정답이 아니라면, 2-1 돌아감
3. 게임 종료 
   1. 1일 경우, 다시 시작
   2. 2일 경우, 종료   
</br>

## 2. MVC 기능 분리
### Controller

- GameController : 게임 시작, 종료
- ComputerController : 게임 진행

### Model

### View

- InputView - 입력
- OutputView - 출력    
</br>

## 2. 패키지 구조
```bash
com.woowacourse.java-baseball-6
┃ common
┃ ┗ RandomUtility.java
┃ 
┣ controller
┃ ┣ GameController.java
┃ ┗ ComputerController.java
┃ 
┣ model
┃   
┣ view 
┃ ┣ InputView.java
┃ ┗ OutputView.java
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