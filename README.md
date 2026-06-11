# DSA Practice in Java

This workspace is a small Java practice project for interview-style data structures and algorithms. It contains custom linked list implementations and sample algorithm exercises that are useful for revision and hands-on learning.

## What’s inside

- `src/App.java` — a sample driver that demonstrates:
  - the 3-sum problem,
  - binary search on a sorted array,
  - linked list operations and algorithm practice.
- `src/LinkedList.java` — a custom singly linked list implementation with methods such as:
  - `append`, `prepend`, `removeFirst`, `removeLast`,
  - `get`, `set`, `insert`, `remove`,
  - `reverse`, `findKthFromEnd`, `removeDuplicates`, `partitionList`, and `swapInPais`.
- `src/DoublyLinkedList.java` — a basic doubly linked list starter implementation.

## Folder structure

- `src/` — Java source files
- `bin/` — compiled class files
- `lib/` — project libraries, including Lombok and MySQL Connector/J
- `.vscode/` — editor settings for Java development in VS Code

## How to run

From the project root, compile and run the sample application with:

```bash
javac -cp "lib/*" -d bin src/*.java
java -cp "bin;lib/*" App
```

If you are using macOS or Linux, replace the Windows `;` classpath separator with `:`.

## Purpose

This repository is intended for:

- practicing core DSA concepts,
- testing linked list logic,
- experimenting with interview problems in Java,
- building confidence for coding interviews and problem-solving sessions.

