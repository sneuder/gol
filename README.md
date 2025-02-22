# Game of Life - Project Setup Guide

## Description

This project is an implementation of Conway's Game of Life in Java. It simulates cellular automaton behavior, following simple rules to evolve over time. The application runs using Maven and is containerized with Docker Compose for easy deployment.

## Running the Project

1 - Using Maven

To run the project with arguments:

```mvn clean package```

2 - Using Docker Compose

To build and run the application in Docker:

```docker-compose up -d```

This will start the application inside a container, using the configurations from docker-compose.yml.

3 - Using the container's terminal

```docker exec -it <container_name> bash```

4 - Runing the project

```mvn exec:java -Dexec.args="10 6 10 1000 '(2,2)(2,3)(2,4)'" -q```

- First arg is the amount of rows.
- Second arg is the amount of columns.
- Third arg is the amount of generations.
- Fourth arg is the amount of millisecond per generation.
- Fith arg is the positionn of init state of cells. (x, y), where ```x``` is the position of row, and ```y``` is the position of column.
