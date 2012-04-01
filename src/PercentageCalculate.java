import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PercentageCalculate {
    String filePath = "/home/anthony/JaveSideProjects/NumberSortingPercentage/testFile";
    int longestStringLength = 0;

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<Item>();

        PercentageCalculate pc = new PercentageCalculate();

        items = pc.getSortedPercentagesMap();

        items = pc.getTopHits(items, 30);

        pc.getLongestStringLength(items);

        pc.printHeaders();

        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext(); ) {
            Item next = iterator.next();

            String spaces = pc.getSpaces(next);
            System.out.println(next.getName() + spaces + ": " + next.getHits() + ": " + next.getPercentage());
        }
    }

    private void printHeaders() {
        String nameTitle = "Name";
        System.out.println(nameTitle + getSpaces(nameTitle.length()) + "Hits : Percentage");
    }

    //when called with just int parameter, just return full number of spaces minus that int
    private String getSpaces(int length) {
        String spaces = "";
        for (int i = 0; i < longestStringLength - length; i++) {
            spaces += " ";
        }
        return spaces;
    }

    private String getSpaces(Item next) {
        String spaces = "";
        for (int i = 0; i < longestStringLength - next.getName().length(); i++) {
            spaces += " ";
        }
        return spaces;
    }

    private void getLongestStringLength(ArrayList<Item> items) {
        Item longestStringItem = new Item("a", 0);
        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext(); ) {
            Item next = iterator.next();
            if (next.getName().length() > longestStringItem.getName().length()) {
                longestStringItem = next;
            }
        }

        longestStringLength = longestStringItem.getName().length();
    }

    private ArrayList<Item> getTopHits(ArrayList<Item> items, int numToTake) {
        ArrayList<Item> subList = new ArrayList<Item>();

        for (int i = 0; i < numToTake; i++) {
            subList.add(items.get(i));
        }

        return subList;
    }

    private ArrayList<Item> getSortedPercentagesMap() {
        ArrayList<Item> items = new ArrayList<Item>();
        
        try {
            items = readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(items, new HitsComparator());

        items = calculatePercentages(items);

        return items;
    }

    private ArrayList<Item> calculatePercentages(ArrayList<Item> items) {
        double largest = (double) items.get(0).getHits();

        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext(); ) {
            Item next = iterator.next();
            next.calcPercentage(largest);
        }

        return items;
    }

    private ArrayList<Item> readFile() throws IOException {
        BufferedReader bufferedReader;
        FileReader fileReader;

        ArrayList<Item> termsAndScores = new ArrayList<Item>();
        fileReader = new FileReader(filePath.trim());

        bufferedReader = new BufferedReader(fileReader);
        String currentLine;
        String[] pieces;

        while ((currentLine = bufferedReader.readLine()) != null) {
            pieces = currentLine.split(" : ");
            termsAndScores.add(new Item(pieces[1], Integer.parseInt(pieces[0])));
        }
        
        System.out.println(termsAndScores.size());
        return termsAndScores;
    }

}