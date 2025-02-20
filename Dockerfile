FROM openjdk:17-slim

WORKDIR /app

RUN apt update && apt upgrade -y
RUN apt install maven -y

CMD ["sleep", "infinity"]
