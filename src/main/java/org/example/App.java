package org.example;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.enumGlobal.Action;
import org.example.pojo.Environment;
import org.example.pojo.Player;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException {
        boolean end = false;
        Environment environment = new Environment();

        Player player = new Player();

        char itemToGather = '-';

        boolean addedToInventory = false;

        boolean showInventory = false;

        while (!end){

            ArrayList<Integer> coordinates = player.getCoordinates();
            ArrayList<ArrayList<Character>> background = environment.getBackground();
            HashMap<String, Integer> inventory = player.getInventory();

            System.out.println(environment);

            if (addedToInventory){
                System.out.println("Un objet a été ajouté à votre inventaire !");
                addedToInventory = false;
            }

            if (showInventory){
                System.out.println("Voici votre inventaire :");
                for (String key : inventory.keySet()){
                    System.out.println(key+" : "+inventory.get(key));
                }
            }

            System.out.println("Que faire ?");

            System.out.println(Arrays.asList(Action.values()));

            Scanner sc = new Scanner(System.in);

            String action = null;

            boolean verif = false;

            while (!verif){
                action = sc.nextLine();
                for (Action c : Action.values()) {
                    if (c.name().toLowerCase().equals(action.toLowerCase())) {
                        verif = true;
                    }
                }
                if (!verif){
                    System.out.println("Commande invalide !");
                    sc.next();
                }
            }

            switch (action.toUpperCase()){
                case "GAUCHE":
                    if (coordinates.get(0) > 0){

                        ArrayList<Character> lineToEdit = background.get(coordinates.get(1));
                        lineToEdit.set(coordinates.get(0),itemToGather);
                        background.set(coordinates.get(1),lineToEdit);

                        coordinates.set(0,coordinates.get(0)-2);

                        player.setCoordinates(coordinates);

                        lineToEdit = background.get(coordinates.get(1));
                        itemToGather = lineToEdit.get(coordinates.get(0));
                        lineToEdit.set(coordinates.get(0),'▧');
                        background.set(coordinates.get(1),lineToEdit);

                        environment.setBackground(background);
                    }
                    break;
                case "DROITE":
                    if (coordinates.get(0) < environment.getWidth()-2){

                        ArrayList<Character> lineToEdit = background.get(coordinates.get(1));
                        lineToEdit.set(coordinates.get(0),itemToGather);
                        background.set(coordinates.get(1),lineToEdit);

                        coordinates.set(0,coordinates.get(0)+2);

                        player.setCoordinates(coordinates);

                        lineToEdit = background.get(coordinates.get(1));
                        itemToGather = lineToEdit.get(coordinates.get(0));
                        lineToEdit.set(coordinates.get(0),'▧');
                        background.set(coordinates.get(1),lineToEdit);

                        environment.setBackground(background);
                    }
                    break;
                case "HAUT":
                    if (coordinates.get(1) > 0){

                        ArrayList<Character> lineToEdit = background.get(coordinates.get(1));
                        lineToEdit.set(coordinates.get(0),itemToGather);
                        background.set(coordinates.get(1),lineToEdit);

                        coordinates.set(1,coordinates.get(1)-1);

                        player.setCoordinates(coordinates);

                        lineToEdit = background.get(coordinates.get(1));
                        itemToGather = lineToEdit.get(coordinates.get(0));
                        lineToEdit.set(coordinates.get(0),'▧');
                        background.set(coordinates.get(1),lineToEdit);

                        environment.setBackground(background);
                    }
                    break;
                case "BAS":
                    if (coordinates.get(1) < environment.getHeight()-1){

                        ArrayList<Character> lineToEdit = background.get(coordinates.get(1));
                        lineToEdit.set(coordinates.get(0),itemToGather);
                        background.set(coordinates.get(1),lineToEdit);

                        coordinates.set(1,coordinates.get(1)+1);

                        player.setCoordinates(coordinates);

                        lineToEdit = background.get(coordinates.get(1));
                        itemToGather = lineToEdit.get(coordinates.get(0));
                        lineToEdit.set(coordinates.get(0),'▧');
                        background.set(coordinates.get(1),lineToEdit);

                        environment.setBackground(background);
                    }
                    break;
                case "RAMASSER":
                    if (itemToGather=='-'){
                        itemToGather = 'X';

                        inventory.put("Herbe",inventory.get("Herbe")+1);
                        addedToInventory = true;

                        player.setInventory(inventory);

                        System.out.println();
                    }
                    break;
                case "INVENTAIRE":
                    showInventory = true;
                    break;
                case "END":
                    end = true;
            }
        }
        HashMap<String, Integer> inventory = player.getInventory();
        System.out.println("Fin du jeu ! Vous avez récolté les objets suivants au cours de votre aventure :");

        for (String key : inventory.keySet()){
            System.out.println(key+" : "+inventory.get(key));
        }
    }
}
