package week8.WordCount;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String text = scanner.nextLine();

        String[] words = text.split("[ \t\n\r\f,.;:!?()]+");

        Map<String, Integer> wordCountMap = new TreeMap<>();

        for (String word : words) {
            word = word.toLowerCase(); 
            if (!wordCountMap.containsKey(word)) {
                wordCountMap.put(word, 1);
            } else {
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
