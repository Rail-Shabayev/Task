import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Task {
	public static void main(String[] args) throws IOException{
		String link = "https://www.simbirsoft.com/";
		Document doc = Jsoup.connect(link).get();
		String text = doc.body().text();
		List<String> allWords = new ArrayList<>(Arrays.asList(
				text.split("[ ,., ?!;:()\"\n\r\t\\[\\]]+")));
		printWords(allWords);
	}
	
	private static void printWords(List<String> allWords) {
		List<String> words = new ArrayList<>();
		for (String word : allWords) {
			if (words.contains(word) == false && Character.isLetter(word.charAt(0))) {
				words.add(word);
				System.out.println(word + " - " + Collections.frequency(allWords, word));
			}
		}
	}
}
