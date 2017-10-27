package be.tf.java.base.gui;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import be.tf.java.base.model.ToDoItem;
import be.tf.java.base.service.ToDoListService;

public class AffichageConsole {
	Scanner scanner;
	ToDoListService toDoList; 

	public AffichageConsole(ToDoListService toDoList) {
		this.toDoList = toDoList;
	}

	public void mainMenu() {
		boolean enCours = true;
		scanner = new Scanner(System.in);

		System.out.println("*************");
		System.out.println("* SuperTask *");
		System.out.println("*************");
		System.out.println("\nBonjour et bienvenue dans notre programme de gestion des tâches");
		do {
			System.out.println("\nQue souhaitez-vous faire ? [1]Créer une nouvelle tâche [2]Lister les tâches à faire [3]Cocher une tâche"
					+ " [4]Lister toutes les tâches [9]Quitter le programme");
			int choix = Integer.parseInt(scanner.nextLine());
			switch(choix) {
			case 1: // Créer une nouvelle tâche
				ToDoItem item = encodeNewItem();
				toDoList.ajouterItem(item);
				System.out.println("\n\n\n\n\n\n\n\n\n\nTâche ajoutée à la liste");
				break;
			case 2: // Lister les tâches encore à faire
				System.out.println("\n\n\n\n\n\n\n");
				AffichageConsole.afficherListe(toDoList.listerToDoItems());
				break;
			case 3: // Cocher une tâche
				System.out.println("\n\n\n\n\n\n\n");
				ArrayList<ToDoItem> listeAFaire = toDoList.listerToDoItems();
				afficherListe(listeAFaire);
				System.out.println("\nQuelle tâche voulez-vous cocher ?");
//				ToDoItem itemToCheck = listeAFaire.get(Integer.parseInt(scanner.nextLine())-1);
				toDoList.cocherItem(Integer.parseInt(scanner.nextLine())-1);
				break;
			case 4: // Lister toutes les tâches
				System.out.println("\n\n\n\n\n\n\n");
				AffichageConsole.afficherListe(toDoList.listerAllItems());
				break;
			case 9: // Quitter
				enCours = false;
				break;
			default:
				System.out.println("\n\n\n\n\n\n\nVotre choix n'est pas correct, veuillez choisir une option dans la liste");
			}
		} while (enCours);
		scanner.close();
		System.out.println("Au revoir, et au plaisir de vous revoir !");
	}

	public ToDoItem encodeNewItem () {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nVeuillez encoder votre nouvelle tâche");
		System.out.println("Intitulé:");
		String title = scanner.nextLine();
		System.out.println("Priorité [1-10]: ");
		int priority = Integer.parseInt(scanner.nextLine());
		System.out.println("Durée (jours):");
		long duration = Long.parseLong(scanner.nextLine());
		System.out.println("Description:");
		String description = scanner.nextLine();
		ToDoItem newItem = new ToDoItem(title, priority, duration, description);
		return newItem;
	}
	
	public static void afficherListe(ArrayList<ToDoItem> items) {
		System.out.println("id\tPriorité\tIntitulé\tDone\tDate de création\tDate de fin\tDescription");
		if (items.size() == 0) {
			System.out.println("Aucune tâche à afficher");
			return;
		} 
		
		int i = 1;
		for (ToDoItem item : items) {
			System.out.println(i + "\t" + item.getPriority() + "\t\t" + item.getTitle() + "\t\t" + (item.isDone()?"X":"") + "\t" + 
					afficheDate(item.getCreationDate()) + "\t\t" + afficheDate(item.getDueDate()) + "\t" + item.getDescription());
			i++;
		}
	}
	
	private static String afficheDate(LocalDateTime date) {
		return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
	}

}
