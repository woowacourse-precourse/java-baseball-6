# 숫자야구

---

## 1. 기능 목록
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

### model
- Ball
  - int digits : 볼의 자리수 (0-3으로 제한됨)
  - int number : 볼의 번호 (0-9로 제한됨)
### controller
- Count : 사용자의 입력 비교, 결과 계산
  - ball : number 일치, digits 불일치
  - strike : number일치, digits 일치
- Play : 게임 진행, 다시 시작, 종료
- Generater : 컴퓨터의 랜덤balls값을 생성
### view
- 입력
- 출력
##  2. 입력 제한사항
- 임의의 숫자(0~9) "세개"가 연속으로 들어온다.
  - 특수문자, 문자열, 실수등 정수가 아닌 경우 return Exception
  - 두자리, 네자리 등 숫자 3개가 아닌 경우 return Exception
  - 세 자리 수 중 중복된 수가 있는 경우 return Exception