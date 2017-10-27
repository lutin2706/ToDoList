package be.tf.java.base.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import com.google.gson.Gson;

import be.tf.java.base.model.ToDoItem;

public class ToDoListService {

	private final String PATH = "./toDoList.tdl";
	private Gson gson = new Gson();

	public ArrayList<ToDoItem> listerAllItems() {
		ArrayList<ToDoItem> allItems = new ArrayList<ToDoItem>();

		try {
			if (Files.exists(Paths.get(PATH))) {

				ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(PATH));
				for (String line : lines) {
					ToDoItem item = gson.fromJson(line, ToDoItem.class);
					allItems.add(item);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allItems;
	}

	public ArrayList<ToDoItem> listerToDoItems() {
		ArrayList<ToDoItem> undoneItems = new ArrayList<ToDoItem>();
		for (ToDoItem item : this.listerAllItems()) {
			if (!item.isDone())
				undoneItems.add(item);
		}
		return undoneItems;
	}

	public void ajouterItem(ToDoItem item) {
		String jsonItem = gson.toJson(item) + System.lineSeparator();
		try {
			Files.write(Paths.get(PATH), jsonItem.getBytes(StandardCharsets.UTF_8), 
					StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cocherItem(int index) {
		//		item.setDone(true);
		ArrayList<ToDoItem> items = listerAllItems();
		items.get(index).setDone(true);

		String lines = "";

		for (ToDoItem toDoItem : items) {
			lines += gson.toJson(toDoItem) + System.lineSeparator();
		}
		try {
			Files.write(Paths.get(PATH), lines.getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
