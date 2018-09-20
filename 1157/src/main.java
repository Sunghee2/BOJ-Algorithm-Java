import java.util.Scanner;

public class main {
	public static String count(String word) {
		int[] count_arr = new int[27];
		
		for(char alphabet : word.toCharArray()) {
			count_arr[alphabet-64]++;
		}

		int max_count = count_arr[1];
		String result = "1";
		
		for(int i = 2; i<27; i++) {
			if(count_arr[i] > max_count) {
				max_count = count_arr[i];
				result = Integer.toString(i);
			} else if(count_arr[i] == max_count) {
				result += "&" + Integer.toString(i);
			}
		}
		
		if(result.contains("&")) { 
			return "?";
		} else {
			return String.valueOf((char)(Integer.parseInt(result)+'A'-1));
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		System.out.println(count(word.toUpperCase()));
	}
}
	//시간초과된 코드
//	public static char[] sort(String word) {
//		char[] word_arr = word.toCharArray();
//		Arrays.sort(word_arr);
//		return word_arr;
//	}
//
//	public static ArrayList<String> split(char[] sorted_arr) {
//		ArrayList<String> split_arr = new ArrayList<String>();
//		int length = 0;
//		split_arr.add(length, Character.toString(sorted_arr[0]));
//		for(int i = 1; i < sorted_arr.length; i++) {
//			if(split_arr.get(length).charAt(0)==sorted_arr[i]) {
//				split_arr.add(length, split_arr.get(length) + Character.toString(sorted_arr[i]));
//				split_arr.remove(length+1);
//			} else {
//				length++;
//				split_arr.add(length, Character.toString(sorted_arr[i]));
//			}
//		}
//		return split_arr;
//	}
//	
//	public static String count(ArrayList<String> split_arr) {
//		String result = Character.toString(split_arr.get(0).charAt(0));
//		int max_length = split_arr.get(0).length();
//		
//		for(int i = 1; i < split_arr.size(); i++) {
//			if(split_arr.get(i).length() > max_length) {
//				result = Character.toString(split_arr.get(i).charAt(0));
//				max_length = split_arr.get(i).length();
//			} else if (split_arr.get(i).length() == max_length) {
//				result += Character.toString(split_arr.get(i).charAt(0));
//			}
//		}
//		
//		if(result.length()>1) {
//			return "?";
//		} else {
//			return result.toUpperCase();
//		}
//		
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String word = sc.nextLine();
//		System.out.println(count(split(sort(word))));
//	}
//}
