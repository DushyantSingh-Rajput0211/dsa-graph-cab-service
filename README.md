
# 🚕 Graph-Based Cab Routing System (DSA Project)

This project simulates a cab routing service using graph theory and shortest path algorithms. It was built as part of an academic project to demonstrate the application of **Dijkstra's Algorithm** in real-world transportation systems.

## 🧠 Core Concepts

- Graph Representation (Adjacency List)
- Dijkstra’s Algorithm for Shortest Path
- Java Object-Oriented Design
- Basic simulation of ride booking and travel cost/distance/time

## 📁 Project Structure

```
src/
└── com/
    └── neu/
        └── edu/
            └── info6205/
                ├── Edge.java
                ├── Graph.java
                └── RedEyeService.java
```

## 🚀 How to Run

### Requirements
- JDK 11 or later
- Any IDE (IntelliJ IDEA recommended)

### Steps
1. Clone or download this repository.
2. Open in IntelliJ (or any Java IDE).
3. Set the main class as: `com.neu.edu.info6205.RedEyeService`
4. Run the program.

Alternatively, using terminal:

```bash
javac -d out src/com/neu/edu/info6205/*.java
java -cp out com.neu.edu.info6205.RedEyeService
```

## ✨ Features

- Models locations as graph nodes
- Computes shortest path between source and destination
- Displays total distance and estimated travel cost
- Modular Java classes for easy extensibility

## 📌 Example Output

```
Welcome to RedEye Cab Services!
Enter Source: A
Enter Destination: E

Shortest Path: A -> B -> D -> E
Total Distance: 12 km
Estimated Fare: $9.60
```

## 📚 Algorithms Used

- Dijkstra’s Algorithm (Greedy approach)
- Priority Queue via Java’s Collections

## 👨‍💻 Authors

- Dushyant Singh Rajput – Java Developer, DSA Enthusiast

## 📝 License

This project is licensed under the MIT License.
