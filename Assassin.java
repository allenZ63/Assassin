package assassin;

import java.io.*;
import java.util.*;

public class Assassin {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("List Of Names.txt"));
        LinkedList<String> killList = new LinkedList();
        ArrayList<String> graveyard = new ArrayList();
        String text = "";
        int count = 0;

        while (text != null) {
            text = br.readLine();
            if (text == null) {
                break;
            }
            killList.add(text);
        }

        System.out.println("People playing: ");
        Iterator names = killList.iterator();
        while (names.hasNext()) {
            System.out.print(names.next() + " ");
            count++;
        }
        System.out.println("");
        System.out.println("");

        while (count > 1) {
            System.out.println("Who to delete?");
            Scanner sc = new Scanner(System.in);
            String target = sc.nextLine();

            boolean isPresent = false;
            Iterator itr1 = killList.iterator();
            while (itr1.hasNext()) {
                if (itr1.next().equals(target)) {
                    graveyard.add(target);
                    killList.remove(target);
                    isPresent = true;
                    count--;
                    break;
                }
            }

            if (isPresent == false) {
                System.out.println("Invalid Input");
            }

            Iterator itr2 = killList.iterator();
            System.out.println("");
            System.out.println("People Left: ");
            while (itr2.hasNext()) {
                System.out.print(itr2.next() + " ");
            }
            System.out.println("");
            System.out.println("");

            Iterator itr3 = graveyard.iterator();
            System.out.println("Graveyard: ");
            while (itr3.hasNext()) {
                System.out.print(itr3.next() + " ");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("-------------------------------------");
        }
        System.out.println(killList.getFirst() + " is the winner");
    }
}



