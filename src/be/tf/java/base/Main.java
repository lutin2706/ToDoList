package be.tf.java.base;

import be.tf.java.base.gui.AffichageConsole;
import be.tf.java.base.service.ToDoListService;
import be.tf.java.base.tester.ToDoListServiceTester;

public class Main {

	public static void main(String[] args) {
		//		ToDoListServiceTester testeur = new ToDoListServiceTester();

		// Test du fonctionnement des listes
		//		testeur.testListAll();
		//		
		//		testeur.testAddItems();
		//		testeur.testListAll();
		//		
		//		testeur.testCheckTask();
		//		
		//		testeur.testListToDo();
		//		testeur.testListAll();

		// test du GUI
		//		testeur.testEncodeNewItem();
		//		testeur.testListAll();
		ToDoListService toDoList = new ToDoListService(); 

		AffichageConsole gui = new AffichageConsole(toDoList);
		gui.mainMenu();
	}

}
