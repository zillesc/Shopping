package ninja.zilles;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Shopping {
    private static final int STARTING_NUM_CATS = 7;
    private static int numCats = STARTING_NUM_CATS;
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("ninja.zilles.Resources", new UTF8Control());
    private static final double[] catLimits = {0, 1, 2};
    private static final String[] catStrings = {resourceBundle.getString("nocats"),
            resourceBundle.getString("onecat"), resourceBundle.getString("ncats")};
    private static final ChoiceFormat catChoice = new ChoiceFormat(catLimits, catStrings);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(resourceBundle.getString("welcome"));
        while (true) {
            String template = catChoice.format(numCats);
            System.out.println(MessageFormat.format(template, numCats));
            String input = scanner.nextLine();
            if (input.equals(resourceBundle.getString("done"))) {
                return;
            }
            int numPurchased = Integer.parseInt(input);
            if (numPurchased > numCats) {
                System.out.println(resourceBundle.getString("sorry"));
            } else {
                numCats -= numPurchased;
                System.out.println(MessageFormat.format(resourceBundle.getString("congratz"), numPurchased));
            }
        }
    }
}
