FROM eclipse-temurin:17-jre-focal

# target 디렉토리의 JAR 파일을 app.jar로 복사
ADD target/*.jar app.jar

# 컨테이너에서 열 포트
EXPOSE 8080

# 애플리케이션 실행 명령
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]
