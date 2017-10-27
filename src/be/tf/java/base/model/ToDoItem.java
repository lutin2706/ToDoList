package be.tf.java.base.model;

import java.time.LocalDateTime;

public class ToDoItem {
	
	private String title;
	private String description;
	private int priority;
	private LocalDateTime creationDate;
	private LocalDateTime dueDate;
	private boolean done;
	
	public ToDoItem(String title, int priority, long duration, String description) {
		this.title = title;
		this.creationDate = LocalDateTime.now();
		this.dueDate = creationDate.plusDays(duration);
		this.priority = priority;
		this.done = false;
		this.description = description;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public boolean isDone() {
		return done;
	}

	public int getPriority() {
		return priority;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}
}
