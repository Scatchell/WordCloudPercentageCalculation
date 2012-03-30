import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: anthony
 * Date: 30/3/12
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class PercentageCalculate {
    String filePath = "/home/anthony/JaveSideProjects/NumberSortingPercentage/testFile";

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        PercentageCalculate pc = new PercentageCalculate();

        numbers = pc.getPercentages();
    }

    private ArrayList<Integer> getPercentages() {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        
        try {
            map = readFile();
            System.out.println(map.toString());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        
        
        
        return null;

    }

    private TreeMap<String, Integer> readFile() throws IOException {
        BufferedReader bufferedReader;
        FileReader fileReader;

        HashMap<String, Integer> termsAndScores = new HashMap<String, Integer>();
        ValueComparator vc = new ValueComparator(termsAndScores);
        TreeMap<String,Integer> sorted_map = new TreeMap(vc);

        fileReader = new FileReader(filePath.trim());

        bufferedReader = new BufferedReader(fileReader);
        String currentLine;

        String[] stuff;

        while ((currentLine = bufferedReader.readLine()) != null) {
            stuff = currentLine.split(" : ");
            termsAndScores.put(stuff[1], Integer.parseInt(stuff[0]));
        }
        sorted_map.putAll(termsAndScores);

        return sorted_map;
    }

}