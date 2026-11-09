# SmartStudy Planner

**A desktop study planner in Java Swing: schedule tasks into time slots and have the planner order them by
deadline and priority.**

[![Java](https://img.shields.io/badge/Java-Swing-8B7CF6?style=flat-square)](#running-it)
[![Superseded](https://img.shields.io/badge/status-superseded%20by%20EduTask-ef4444?style=flat-square)](#status)

An early Java Swing project, built to practise data structures against a real interface rather than against
exercises: priority queues for task ordering, comparators for deadline against priority, and the Swing event
model for the UI.

## What it does

- Add study tasks with a deadline, a duration and a priority.
- Order the queue by deadline and priority.
- Lay tasks out across available time slots.

## Running it

```bash
cd SmartStudyPlanner-main
javac -d out $(find . -name "*.java")
java -cp out Main
```

An IntelliJ project is included.

## Status

**Superseded.** The same idea, carried much further, is in
[EduTask](https://github.com/Aryan-lomte05/EduTask): a cork board interface, custom categories, time slot
scheduling, AI quiz generation and a native Windows installer.

## Limits

- No persistence between runs.
- A nested `SmartStudyPlanner-main/` directory and IntelliJ `.idea/` files are committed, which should be
  cleaned up.
