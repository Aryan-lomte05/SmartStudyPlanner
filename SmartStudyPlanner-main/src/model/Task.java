package model;
import java.io.Serializable;
import java.time.LocalDate;


    public class Task implements Serializable {
        private String title;
        private String description;
        private LocalDate deadline;
        private boolean completed;

        public Task(String title, String description, LocalDate deadline) {
            this.title = title;
            this.description = description;
            this.deadline = deadline;
            this.completed = false;
        }

        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public LocalDate getDeadline() { return deadline; }
        public boolean isCompleted() { return completed; }

        public void markCompleted() { this.completed = true; }

        @Override
        public String toString() {
            return (completed ? "[✓] " : "[ ] ") + title + " - " + deadline.toString();
        }
    }


