import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.NoSuchElementException;

public class FindMaxOccurrenceOfAChar {
	public static void main (String[] args) {
		String myString = "AABBCCAAABCEEEEFFFFASDAAAAAAAABBBCCCFFFAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBBASWEADFREDBBCCDDCCCDD";
		
		FindMaxOccurrenceOfAChar obj = new FindMaxOccurrenceOfAChar();
		int maxCount = obj.findMaxmCharacter(myString);
		System.out.println("Maxm count = " + maxCount);
	}

	int findMaxmCharacter(String myString) {
		Map<Character, Integer> myMap = new HashMap<Character, Integer>();
		
		int count = 0;
		for (int i=0; i<myString.length(); i++) {
			char ch = myString.charAt(i);
			if(!myMap.containsKey(ch)) {
				count = 1;
				myMap.put(ch, count);				
			}
			else {
				count = myMap.get(ch);
				count++;
				myMap.put(ch, count);
			}		
		}	
		
		System.out.println("Map items - " + myMap);
		Collection<Integer> values = myMap.values();
		System.out.println("Values - " + values);
		Integer maxCount = myMap.values().stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
		return maxCount;
	}
}