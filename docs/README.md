# 🎮 숫자 야구 게임 프로젝트 구조 🎮

## 🗂 폴더 구조

### 🛠 Interfaces
- [x] **🔡 Input**: 🎯 입력을 위한 인터페이스
- [x] **📤 Output**: 🎯 출력을 위한 인터페이스
- [x] **🎲 Game**: 🎯 다양한 게임을 위한 인터페이스
- [x] **🖼 View**: 🎯 다른 뷰 (예. Swing) 를 위한 인터페이스 (🤖 전략 패턴 이용)

### 🧰 Utils
- [x] **🔄 Convertor**: 🎯 데이터 타입 변환을 위한 클래스
- [x] **🛡 Validator**: 🎯 예외 처리를 위한 클래스 (🔒 싱글톤 패턴 이용)

### 🏗 Classes
- [x] **🚀 Main**: 🎯 실행을 위한 클래스
- [x] **⚾ BaseballGame**: 🎯 야구 게임 로직 (🎲 Game 인터페이스 구현)
- [x] **💻 Console**: 🎯 콘솔 입력/출력 (🔡 Input, 📤 Output 인터페이스 구현)

### 🏢 Domain
- [x] **🔴 Balls**: 🎯 볼들을 관리하는 일급 컬렉션
- [x] **🎾 Ball**: 🎯 BallIndex와 BallNumber를 가지고 있는 클래스
- [x] **🔢 BallIndex**: 🎯 볼의 인덱스와 예외 처리
- [x] **🔠 BallNumber**: 🎯 볼의 번호와 예외 처리
- [x] **🎰 NumberGenerator**: 🎯 랜덤 볼 생성
- [x] **👮‍♂  BallComparator**: 🎯 게임 판정
- [x] **📜 GameResult**: 🎯 게임 결과 저장(record를 이용)

### 🚥 Enums
- [x] **⏩ 실행 여부**: 🎯 게임 실행 여부를 위한 Enum

### 🧪 테스트 코드
- [x] **🔄ConverterTest**: 🎯 타입 변환 테스트
- [x] **🔴BallTest**: 🎯 Ball 도메인 생성 테스트
- [x] **🎰NumberGeneratorTest**: 🎯 랜덤 숫자 생성 테스트
- [x] **👮‍♂BallComparatorTest**: 🎯 n 스트라이크 n 볼 검증 테스트


