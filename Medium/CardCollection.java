package Medium;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class CardCollection {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> cards = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        cards.put("Hearts", new ArrayList<>());
        cards.put("Spades", new ArrayList<>());
        cards.put("Diamonds", new ArrayList<>());
        cards.put("Clubs", new ArrayList<>());
        
        cards.get("Hearts").add("Ace of Hearts");
        cards.get("Hearts").add("King of Hearts");
        cards.get("Spades").add("Queen of Spades");
        cards.get("Diamonds").add("5 of Diamonds");
        cards.get("Clubs").add("Jack of Clubs");
        
        System.out.print("Enter card symbol (Hearts, Spades, Diamonds, Clubs): ");
        String symbol = scanner.nextLine();

        if (cards.containsKey(symbol) && !cards.get(symbol).isEmpty()) {
            System.out.println("Cards found: " + cards.get(symbol));
        } else {
            System.out.println("No cards found for this symbol.");
        }
        
        scanner.close();
    }
}
