import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	private static class Test2 implements Runnable {
//		ArrayList<String> dictionary;
//		String puzzle;
//		Map map;
//		
//		public Test2(ArrayList<String> dictionary, String puzzle, Map map) {
//			this.dictionary = dictionary;
//			this.puzzle = puzzle;
//			this.map = map;
//		}
//		
//		@Override
//		synchronized public void run() {
//			for(String word : dictionary) {
//				char[] arr_word = word.toCharArray();
//				boolean stopFlag = false;
//				for(int i = 0; i < word.length(); i++) {
//					int num = (new StringTokenizer(" "+word+" ", Character.toString(arr_word[i])).countTokens() -1) - (new StringTokenizer(" "+puzzle+" ", Character.toString(arr_word[i])).countTokens() -1);
//					if(puzzle.indexOf(arr_word[i])==-1 || num > 0){
//						stopFlag = true;
//						break;
//					}
//				}
//				if (!stopFlag) {
//					Thread t = new Thread(new Test(arr_word, map));
//					t.start();
////					while(t.isAlive()) {
////						try {
////							wait();
////						} catch (InterruptedException e) {
////							// TODO Auto-generated catch block
////							e.printStackTrace();
////						}
////					}
//					System.out.println(word);
//				}
//			}
//		}
		
		char[] word;
		String word_s;
		String puzzle;
		Map<Character, Integer> map;
		private boolean stopFlag = false;
		
		public Test2(String word, String puzzle, Map map) {
			this.word = word.toCharArray();
			this.word_s = word;
			this.puzzle = puzzle;
			this.map = map;
		}

		@Override
		public void run() {
			for(int i = 0; i < word.length; i++) {
				int num = (new StringTokenizer(" "+word_s+" ", Character.toString(word[i])).countTokens() -1) - (new StringTokenizer(" "+puzzle+" ", Character.toString(word[i])).countTokens() -1);
				if(puzzle.indexOf(word[i])==-1 || num > 0){
					stopFlag = true;
					break;
				}
			}
			if (!stopFlag) {
				String input_alphabet_check = "";
				for(int i = 0; i < word.length; i++) {
					if(input_alphabet_check.indexOf(Character.toString(word[i])) == -1) {
						map.put(word[i], map.get(word[i]) + 1);
						input_alphabet_check = input_alphabet_check + Character.toString(word[i]);
					}
//					System.out.println(word[i]+"³¡");
				}
//				Thread t = new Thread(new Test(word, map));
//				t.start();
//				System.out.println(word);
//				try {
//					t.join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
	}
	
	
	
	private static void count(ArrayList<String> dictionary, String puzzle, Map<Character, Integer> map) {
		String max_alphabet = "";
		String min_alphabet = "";
//		char[] max_alphabet = new char[9];
//		char[] min_alphabet = new char[9];
//		int max_index = 0, min_index = 0;
		int max = 0;
		int min = 9;
		
		
//		Thread t = new Thread(new Test2(dictionary, puzzle, map));
//		t.start();
//		try {
//			t.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		for(int i = 0; i < dictionary.size(); i++) {
			Thread t = new Thread(new Test2(dictionary.get(i), puzzle, map));
			t.start();
			
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		if(!t.isAlive()) {
//			System.out.println(t.activeCount());
			Set<Entry<Character, Integer>> entries = map.entrySet();
			for(Entry entry : entries) {
				char char_key =  (char) entry.getKey();
				String key = Character.toString(char_key);
				int value = (int) entry.getValue();
				
				if(max < value) {
					max_alphabet = key;
					max = value;
				} else if(max == value) {
					max_alphabet = max_alphabet + key;
				}
				
				if(min > value) {
					min_alphabet = key;
					min = value;
				} else if(min == value) {
					min_alphabet = min_alphabet + key;
				}
			}
			char[] arr_min = min_alphabet.toCharArray();
			Arrays.sort(arr_min);
			min_alphabet = new String(arr_min);
			
			char[] arr_max = max_alphabet.toCharArray();
			Arrays.sort(arr_max);
			max_alphabet = new String(arr_max);

			System.out.println(min_alphabet + " " + min + " " + max_alphabet + " " + max);
//		}
//		Set<Entry<Character, Integer>> entries = map.entrySet();
//		for(Entry entry : entries) {
//			char char_key =  (char) entry.getKey();
//			String key = Character.toString(char_key);
//			int value = (int) entry.getValue();
//			
//			if(max < value) {
//				max_alphabet = key;
////				max_index = 0;
////				max_alphabet[max_index++] = char_key;
//				max = value;
//			} else if(max == value) {
//				max_alphabet = max_alphabet + key;
////				max_alphabet[max_index++] = char_key;
//			}
//			
//			if(min > value) {
//				min_alphabet = key;
////				min_index = 0;
////				min_alphabet[min_index++] = char_key;
//				min = value;
//			} else if(min == value) {
//				min_alphabet = min_alphabet + key;
////				min_alphabet[min_index++] = char_key;
//			}
//		}
//		char[] arr_min = min_alphabet.toCharArray();
//		Arrays.sort(arr_min);
//		min_alphabet = new String(arr_min);
//		
//		char[] arr_max = max_alphabet.toCharArray();
//		Arrays.sort(arr_max);
//		max_alphabet = new String(arr_max);
////		Arrays.sort(max_alphabet);
////		Arrays.sort(min_alphabet);
////		
////		for(int i = 0; i< min_index; i++) {
////			System.out.print(min_alphabet[i]);
////		}
////		System.out.println(" " + min);
////		
////		for(int i = 0; i < max_index; i++) {
////			System.out.print(max_alphabet[i]);
////		}
////		System.out.print(" " + max + " ");
//
//		System.out.println(min_alphabet + " " + min + " " + max_alphabet + " " + max);
	}
	
	
	private static class Test implements Runnable {
//		String word;
		char[] word;
		String input_alphabet_check = "";
		Map<Character, Integer> map;
		
		public Test(char[] word, Map<Character, Integer> map) {
			this.word = word;
//			this.puzzle = puzzle;
			this.map = map;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < word.length; i++) {
				if(input_alphabet_check.indexOf(Character.toString(word[i])) == -1) {
					map.put(word[i], map.get(word[i]) + 1);
					input_alphabet_check = input_alphabet_check + Character.toString(word[i]);
				}
				System.out.println(word[i]+"³¡");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> dictionary = new ArrayList<>();
		
		while(true) {
			String word = sc.nextLine();
			if(word.equals("-")) {
				break;
			} 
			dictionary.add(word);
//			word.
		}

		while(true) {
			String puzzle = sc.nextLine();
			if(puzzle.equals("#")) {
				break;
			} else {
				Map<Character, Integer> map = new HashMap<Character, Integer>();
				char[] arr_puzzle_alphabet = puzzle.toCharArray();
				for(int i = 0; i < arr_puzzle_alphabet.length; i++) {
					map.put(arr_puzzle_alphabet[i], 0);
				}
				
				count(dictionary, puzzle, map);
//				wait();
			}
		}
	}
}
