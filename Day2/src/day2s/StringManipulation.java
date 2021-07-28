package day2s;

import java.util.function.BiPredicate;

public class StringManipulation {
	public static String isBetter(String s1, String s2, BiPredicate<String, String> p) {
		if(p.test(s1, s2)) {
			return s1;
		} else {
			return s2; 
		}
	}
	
	public static void main(String[] args) {
		
		String betterName = StringManipulation.isBetter("badr", "mohamed", (s1, s2) -> s1.length() > s2.length());
		System.out.println(betterName);
		
	}
		
}
