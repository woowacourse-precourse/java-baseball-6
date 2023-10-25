# 숫자 야구

## 요구사항

### 입력
- [ ] 서로 다른 3자리 숫자를 입력받는다
- [ ] 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수를 입력받는다
- [ ] 사용자 잘못된 값을 입력한 경우 IllegalArgumentException 발생시켜 프로그램 종료

### 출력
- [ ] 게임 시작 문구 출력
- [ ] 사용자가 입력한 수에 대한 결과를 볼, 스트라이크 개수 및 낫싱으로 표시한다
- [ ] 3개의 숫자를 모두 맞힐 경우 3스트라이크와 함께 게임 종료 메세지 출력

### 기능
#### 야구 게임
- [ ] 컴퓨터 야구 숫자를 랜덤으로 생성한다
- [ ] 컴퓨터 야구 숫자와 입력으로 들어오는 야구 숫자를 비교해 결과를 판단한다

#### 야구 숫자
- [ ] 3개의 숫자를 가지고 있다
- [ ] 다른 야구 숫자와의 비교를 통해 스트라이크, 볼, 낫싱을 판단한다
- [ ] 유효하지 않은 값이 들어올 경우 IllegalArgumentException 발생시킨다


### 커밋 컨벤션

[git commit type] : git commit message

```
feat (feature) 
fix (bug fix) 
docs (documentation) 
style (formatting, missing semi colons, …) 
refactor 
test (when adding missing tests) 
chore (maintain)
```

[Angular Js Commit Convention](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 차용
