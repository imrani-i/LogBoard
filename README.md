## 구현 내용 정리

### 1. proto 정의
- `src/main/proto/log.proto` 파일 작성
  - `LogRequest`, `LogResponse`, `LogService` 정의
  - `option java_package`로 패키지 강제 지정

### 2. 코드 생성
- `./gradlew build` 실행 시, `protoc`가 자동으로 Java 코드 생성
  - 생성 위치: `build/generated/source/proto/...`
  - 생성된 클래스
    - `LogRequest`, `LogResponse` (message)
    - `LogServiceGrpc` (stub, 서버/클라이언트 코드)
  - `java_package` 옵션 덕분에 `import com.example.logproto.*` 가능

### 3. gRPC 서버 구현
- `LogServiceImpl` 클래스 작성
  - `LogServiceGrpc.LogServiceImplBase` 상속
  - 클라이언트 요청 로그 출력 + `"OK"` 응답 반환

### 4. gRPC 서버 설정
- `GrpcServerConfig` 작성
  - Spring Boot 실행 시 gRPC 서버 자동 실행
  - 포트 `9090`에서 대기

  
