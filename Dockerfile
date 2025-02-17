# OpenJDK 17 기반 이미지 사용
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# JAR 파일 복사
COPY build/libs/wiko-be.jar app.jar

# 환경 변수 설정 (실제 환경에서 오버라이드 가능)
ENV SERVER_PORT=8080

# 실행 명령어
CMD ["java", "-jar", "app.jar"]
