FROM openjdk:17-slim

WORKDIR /app

RUN apt update && apt install -y fontconfig fonts-dejavu fonts-liberation libxext6 libxrender1 libxtst6 libfreetype6 libxi6

CMD ["sleep", "infinity"]
