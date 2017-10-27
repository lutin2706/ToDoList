package be.tf.java.base.tester;

import be.tf.java.base.gui.AffichageConsole;
import be.tf.java.base.model.ToDoItem;
import be.tf.java.base.service.ToDoListService;

public class ToDoListServiceTester {

	ToDoItem item1 = new ToDoItem("Tâche 1", 1, 10, "");
	ToDoItem item2 = new ToDoItem("Tâche 2", 2, 5, "");
	ToDoListService items = new ToDoListService();

	public void testAddItems() {
		System.out.println("\nAjoute item1 à la liste ...");
		items.ajouterItem(item1);
		
		System.out.println("\nAjoute item2 à la liste ...");
		items.ajouterItem(item2);				
	}
	
	public void testListAll() {
		System.out.println("\nListe toutes les tâches ...");
		AffichageConsole.afficherListe(items.listerAllItems());
	}

	public void testListToDo() {
		System.out.println("\nListe les tâches encore à faire ...");
		AffichageConsole.afficherListe(items.listerToDoItems());
	}
	
	public void testCheckTask() {
		System.out.println("\nCoche item1 ...");
		items.cocherItem(1);
	}
	
	public void testEncodeNewItem() {
		AffichageConsole encodage = new AffichageConsole(items);
		ToDoItem newItem = encodage.encodeNewItem();
		items.ajouterItem(newItem);
	}

}
