package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		//make new answer string
		//add first letter of phrase to answer
		//iterate through each char of phrase
		//if space or dash, add next char to answer
		//turn to all caps
		String answer = "";
		answer += phrase.charAt(0);
		//System.out.println(answer);
		for(int i=0; i<phrase.length(); i++) {
			if(phrase.charAt(i) == ' ' || phrase.charAt(i) == '-') {
				if(i != phrase.length() - 1) {
					answer += phrase.charAt(i+1);
				}
			}
		}
		answer = answer.toUpperCase();
		return answer;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}
		
		//1==3
		//1==2
		//2==3
		public int numEqual() {
			int numEqual = 0;
			if(sideOne == sideTwo) {
				numEqual++;
			}
			if(sideOne == sideThree) {
				numEqual++;
			}
			if(sideTwo == sideThree) {
				numEqual++;
			}
			return numEqual;
		}
		public boolean isEquilateral() {
			return numEqual() == 3 ? true : false;
		}

		public boolean isIsosceles() {
			return numEqual() == 1 ? true : false;
		}

		public boolean isScalene() {
			return numEqual() == 0 ? true : false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		//turn input string into lower case
		string = string.toLowerCase();
		int score = 0;
		for(int i=0; i<string.length(); i++) {
			score += getLetterScore(string.charAt(i));
		}

		return score;
	}
	
	public int getLetterScore(char letter) {
		//index 0-9 1 point
		//index 10-11 2 points
		//index 12-15 3 points
		//index 16-20 4 points
		//index 21 5 points
		//index 22-23 8 points
		//index 24-25 10 points
		String letterScores = "aeioulnrstdgbcmpfhvwykjxqz";
		int index = letterScores.length();
		for(int i=0; i<letterScores.length(); i++) {
			if(letter == letterScores.charAt(i)) {
				index = i;
			}
		}
		if(index >= 0 && index <= 9) {
			return 1;
		}
		else if(index == 10 || index == 11) {
			return 2;
		}
		else if(index >= 12 && index <= 15) {
			return 3;
		}
		else if(index >= 16 && index <= 20) {
			return 4;
		}
		else if(index == 21) {
			return 5;
		}
		else if(index == 22 || index == 23) {
			return 8;
		}
		else if(index == 24 || index == 25) {
			return 10;
		}
		else {
			return 0;
		}	
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException{
		//make new answer string
		//go through input string
		//if char at i is a number from 0-9 (ascii 48-57), add to answer string
		//if answer string length is not 10 or 11, return false
		//if answer string length is 11 and first digit is not 1, return false
		//if answer string length is 11, remove first digit
		//if 1st or 4th digit are 0 or 1, return false
		StringBuilder answer = new StringBuilder("");
		for(int i=0; i<string.length(); i++) {
			if(string.charAt(i) >= 48 && string.charAt(i) <= 57) {
				answer.append(string.charAt(i));
			}
		}
		if(answer.length() != 10 && answer.length() != 11)
			throw new IllegalArgumentException();
		if(answer.length() == 11) {
			if(answer.charAt(0) != 1)
				throw new IllegalArgumentException();
			answer.deleteCharAt(0);
		}
		if(answer.charAt(0) == 0 || answer.charAt(0) == 1) {
			throw new IllegalArgumentException();
		}
		if(answer.charAt(3) == 0 || answer.charAt(3) == 1) {
			throw new IllegalArgumentException();
		}
		return answer.toString();
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		//split string into array
		//for each element of array
		//if string is not already in map, add to map and set number to 1
		//if already in map, increment number by 1
		//if string is empty string, do not add to map
		String[] stringArray = string.split("[ ,\\s]");
		Map<String, Integer> answer = new HashMap<String, Integer>();
		for(int i=0; i<stringArray.length; i++) {
			if(!"".equals(stringArray[i])) {
				if(!answer.containsKey(stringArray[i])) {
					answer.put(stringArray[i], 1);
				}
				else {
					answer.replace(stringArray[i], answer.get(stringArray[i]) + 1);
				}
			}
		}
		return answer;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			//set left and right indices
			//find middle element of array
			//compare t to middle of array
			//if same, return index
			//if t is greater, set left index to middle
			//if t is less, set right index to middle
			//repeat until array size is too small
			
			int left = 0;
			int right = sortedList.size()-1;
			int middle;
			
			//while list hasnt folded in on itself
			while(left <= right) {
				
				//find index of middle
				middle = left + (right - left)/2;
				
				//System.out.println(left + " " + middle + " " + right);
				
				//compare t to middle
				if(t.compareTo(sortedList.get(middle)) == 0)
					return middle;
				else if(t.compareTo(sortedList.get(middle)) > 0) {
					left = middle + 1;
				}
				else
					right = middle;
			}
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		//turn string into array of words
		//for each word, turn to pig latin and add to new string
		String[] sentenceArray = string.split(" ");
		String answer = "";
		answer += wordToPigLatin(sentenceArray[0]);
		for(int i=1; i<sentenceArray.length; i++) {
			answer += " " + wordToPigLatin(sentenceArray[i]);
		}
		return answer;
	}
	/**
	 * 
	 * @param letter the letter to check if vowel or not
	 * @param countY whether or not y counts as a vowel
	 * @return true if vowel false if not
	 */
	public boolean isVowel(char letter, boolean countY) {
		switch(letter){
		case 'a':
			return true;
		case 'e':
			return true;
		case 'i':
			return true;
		case 'o':
			return true;
		case 'u':
			return true;
		case 'y':
			if(countY)
				return true;
			else
				return false;
		default:
			return false;
		}
	}
	
	/**
	 * 
	 * @param a single word to turn to pig latin
	 * @return a single word in pig latin
	 */
	public String wordToPigLatin(String string) {
		//check if first letter is a vowel (not including y)
		//if so, add "ay" to end and return
		//if not, find first vowel (including y in word)
		//get index of first vowel
		//remove and store all letters between start and first vowel
		//add to end of word
		//add ay
		StringBuilder answer = new StringBuilder("");
		answer.append(string);
		
		//check if first letter is vowel
		//likely don't actually need this part
		if(isVowel(string.charAt(0), false)) {
			//if yes, add ay to end
			string += "ay";
		}
		//if not
		else {
			//edge cases							//can add more edge cases 
			//first letter is y
			//start loop from second letter
			//first two letters are qu
			//start loop from third letter
			//first two letters are th
			//start loop from third letter
			//get index of first vowel
			
			//first letter is y
			int vowelIndex = -1;
			if(string.charAt(0) == 'y') {
				for(int i=1; i<string.length(); i++) {
					if(isVowel(string.charAt(i), true)) {
						vowelIndex = i;
						break;
					}
				}
			}
			//first two letters are qu
			else if(string.charAt(0) == 'q' && string.charAt(1) == 'u') {
				for(int i=2; i<string.length(); i++) {
					if(isVowel(string.charAt(i), true)) {
						vowelIndex = i;
						break;
					}
				}
			}
			//first two letters are th
			else if(string.charAt(0) == 't' && string.charAt(1) == 'h') {
				for(int i=2; i<string.length(); i++) {
					if(isVowel(string.charAt(i), true)) {
						vowelIndex = i;
						break;
					}
				}
			}
			//non edge case
			else {
				for(int i=0; i<string.length(); i++) {
					if(isVowel(string.charAt(i), true)){
						vowelIndex = i;
						break;
					}
				}
			}
			//input has no vowels
			if(vowelIndex == -1) {
				return "go away";
			}
			//remove and store all letters between start and first vowel
			String firstLetters = string.substring(0,  vowelIndex);
			string = string.substring(vowelIndex);
			//add letters to end of word
			//add ay
			string += firstLetters + "ay";
		}
		return string;
	}

	
	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		//find armstrong number
		//get each digit
		//add digit to array
		//while original number is not 0
		//find remainder when divided by 10 and store as digit
		//divide original number by 10
		//increment counter
		//compare to input
		
		int input2 = input;
		//int counter = 0;
		List<Integer> digitList = new ArrayList<Integer>();
		//while input2 is not 0
		do {
			//get remainder and add to array
			digitList.add(input2 % 10);
			//divide input2 by 10
			input2 /= 10;
		}while(input2 != 0);
				
		//make armstrong number
		int armstrongSum = 0;
		//for each element in list
		for(int i=0; i<digitList.size(); i++) {
			//take element to power of list size and add to sum
			armstrongSum += Math.pow(digitList.get(i), digitList.size());
		}
		
		//compare calculated sum to input
		return armstrongSum == input ? true : false;
		
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		//if number is prime, return list containing only that number
		//if not, find each multiple, then recursively call this function using that multiple
		if(isPrime(l)) {
			List<Long> prime = new ArrayList<Long>();
			prime.add(l);
			return prime;
		}
		else {
			//make empty list
			List<Long> multiples = new ArrayList<Long>();
			//find a factor
			long factor = - 1;
			for(int i=2; i<l; i++) {
				//check if multiple
				if(l % i == 0) {
					factor = i;
					break;
				}
			}
			//add factor to list
			multiples.add(factor);
			//find the factor that the first factor is multiplied by
			long otherFactor = l/factor;
			//call recursive function on other factor
			multiples.addAll(calculatePrimeFactorsOf(otherFactor));
			return multiples;
		}
	}
	
	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			//uppercase: 65-90
			//lowercase: 97-122
			//for each character in string
			//if not uppercase or lowercase, do nothing
			//if uppercase, set start to 65
			//if lowercase, set start to 97
			//take char value, subtract start, add key, mod 26, add start
			//add to new answer string
			String answer = "";
			//int start;
			for(int i=0; i<string.length(); i++) {
				if(string.charAt(i) >= 65 && string.charAt(i) <= 90) {
					//start = 65;
					//answer += (char) ((string.charAt(i) - start + key) % 26 + start);
					answer += getRotatedChar(string.charAt(i), 65, key);
				}
				else if(string.charAt(i) >= 97 && string.charAt(i) <= 122) {
					//start = 97;
					//answer += (char) ((string.charAt(i) - start + key) % 26 + start);
					answer += getRotatedChar(string.charAt(i), 97, key);
				}
				else {
					answer += string.charAt(i);
				}
			}
			return answer;
		}
		
		public char getRotatedChar(char initial, int start, int key) {
			return (char) ((initial - start + key) % 26 + start);
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) throws IllegalArgumentException{
		//while counter is less than i
		//call isPrime
		//if is prime, increment counter
		//increment counter
		if(i <= 0) {
			throw new IllegalArgumentException();
		}
		int counter = 2;
		int primeCounter = 1;
		while(primeCounter < i) {
			counter++;
			if(isPrime(counter)) {
				primeCounter++;
			}
		}
		return counter;
	}

	public boolean isPrime(long l) {
		//if even number, return false
		if(l > 2 && l % 2 == 0)
			return false;
		//if multiple found, return false
		for(int i=2; i<=Math.sqrt(l); i++) {
			if(l % i == 0)
				return false;
		}
		return true;
	}
	
	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			//turn string to all lowercase
			//if char code is between 97-122
			//new char code is 122-original+97
			//add char to charArray
			//add spaces to charArray
			//for each char in charArray
			//add to answer array
			//if multiple of 5th digit
			//add space
			
			//turn string to lower case
			string = string.toLowerCase();
			//for each char in string
			String onlyLetters = "";
			for(int i=0; i<string.length(); i++) {
				//if char code is between 97-122 (lower case letter)
				if(string.charAt(i) >= 97 && string.charAt(i) <= 122) {
					//get new char: 122-original+97
					//add to new string
					onlyLetters += (char) (122 - string.charAt(i) + 97); 
				}
				//if char code is between 48-57
				//add to string as it is
				else if(string.charAt(i) >= 48 && string.charAt(i) <= 57) {
					onlyLetters += string.charAt(i);
				}
//				onlyLetters += atbashChar(string.charAt(i));
			}
			
			//add spaces every five characters
			//unless its at the end
			String answer = "";
			//for each character
			for(int i=0; i<onlyLetters.length(); i++) {
				//copy character to answer
				answer += onlyLetters.charAt(i);
				//if multiple of 5, add space
				//unless its at the end !
				if((i+1) % 5 == 0 && i < onlyLetters.length() - 1) {
					answer += " ";
				}
			}
			return answer;
		}
		
//		public static char atbashChar(char input) {
//			//if char code is between 97-122 (lower case letter)
//			if(input >= 97 && input <= 122) {
//				//get new char: 122-original+97
//				//add to new string
//				return (char) (122 - input + 97); 
//			}
//			//if char code is between 48-57
//			//add to string as it is
//			else if(input >= 48 && input <= 57) {
//				return input;
//			}
//			else {
//				//throw exception
//				throw new IllegalArgumentException();
//			}
//		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			//for each character in string
			//if lower case letter (97-122)
			//convert using 122 - char code + 97
			//add to answer
			//if number (48-57)
			//add to answer
			String answer = "";
			for(int i=0; i<string.length(); i++) {
				//if char code is between 97-122 (lower case letter)
				if(string.charAt(i) >= 97 && string.charAt(i) <= 122) {
					//get new char: 122-original+97
					//add to new string
					answer += (char) (122 - string.charAt(i) + 97); 
				}
				//if char code is between 48-57
				//add to string as it is
				else if(string.charAt(i) >= 48 && string.charAt(i) <= 57) {
					answer += string.charAt(i);
				}
			}
			return answer;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		//check length of string, return false if not equal to 13
		//check for dashes, if not in the right place (1, 5, 11) return false
		//check digits, if first 9 not numeric, return false
		//check last digit, if not numeric or x, return false
		//do the calculation thing
		
		//check string length
		if(string.length() != 13)
			return false;
		//make list to store numbers
		List<Integer> numList = new ArrayList<Integer>();
		//for each digit
		for(int i=0; i<string.length(); i++) {
			//check dashes
			if(i == 1 || i == 5 || i == 11) {
				if(string.charAt(i) != '-')
					return false;
			}
			//check digits
			else if(i == 0 || i >= 2 && i <= 4 || i >= 6 && i <= 10) {
				if(!(string.charAt(i) >= 48 && string.charAt(i) <= 57))
					return false;
				else
					numList.add(Character.getNumericValue(string.charAt(i)));
			}
			//check last digit
			else if(i == 12)
				if(!((string.charAt(i) >= 48 && string.charAt(i) <= 57) || string.charAt(i) == 'X'))
					return false;
				else {
					if(string.charAt(i) == 'X')
						numList.add(10);
					else
						numList.add(Character.getNumericValue(string.charAt(i)));
				}
		}
		//System.out.println(Arrays.toString(numList.toArray()));
		//do calculations
		int sum = 0;
		for(int i=0; i<numList.size(); i++) {
			sum += numList.get(i) * (10 - i % 10);
		}
		if(sum % 11 !=0)
			return false;
		
		return true;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		//turn to lowercase
		//make map with char and boolean
		//for each letter in string, set value of in map to true
		
		//turn to lowercase
		string = string.toLowerCase();
		//make map of each character in alphabet
		Map<Character, Boolean> checklist = new HashMap<Character, Boolean>();
		//fill out map
		for(int i=97; i<=122; i++) {
			checklist.put((char) i, false);
		}
		
		//for each character in string
		for(int i=0; i<string.length(); i++) {
			//set corresponding value on map to true
			checklist.replace(string.charAt(i), false, true);
		}
		
//		for(Entry<Character, Boolean> entry: checklist.entrySet()) {
//			System.out.println("key: " + entry.getKey() + " + value: " + entry.getValue());
//		}
		
		//if all values in checklist are true, return true
		if(checklist.containsValue(false))
			return false;
		else
			return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		if(given instanceof LocalDate) {
			return (((LocalDate) given).atStartOfDay()).plus(Duration.ofSeconds(1000000000));
		}
		else if (given instanceof LocalDateTime) {
			return given.plus(Duration.ofSeconds(1000000000));
		}
		else {
			return null;
		}
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		//make set of multiples
		//for each number in input set
		//find all multiples below limit
		//add to set of multiples
		//find sum of set of multiples
				
		//make set
		Set<Integer> multiples = new TreeSet<Integer>();
		
		//for each number in input set
		for(int j=0; j<set.length; j++) {
			int max = i / set[j];
			//find all multiples of that number
			for(int k=1; k<=max; k++) {
				multiples.add(k * set[j]);
			}
		}
		
		//remove i from set
		multiples.remove(i);
		
		//sum multiples
		int sum = 0;
		for(int badName : multiples) {
			sum += badName;
		}
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		//check for invalid characters
		//turn to array of all numbers
		//double digits
		//find sum
		
		List<Integer> numList = new ArrayList<Integer>();
		//check for invalid characters
		for(int i=0; i<string.length(); i++) {
			//number or space
			if((string.charAt(i) >= 48 && string.charAt(i) <= 57) || string.charAt(i) == 32) {
				if(string.charAt(i) != 32) {
					//add to new list
					numList.add(Character.getNumericValue(string.charAt(i)));
				}
			}
			//if not, return false
			else {
				return false;
			}
		}
		
//		for(int i=0; i<numList.size(); i++) {
//			System.out.println(numList.get(i) + " ");
//		}
		
		if(numList.size() <= 1)
			return false;
		
		//double digits starting from end
		for(int i=numList.size()-2; i>=0; i-=2) {
			int newDigit = numList.get(i) * 2;
			if(newDigit >= 10)
				newDigit -= 9;
			numList.set(i, newDigit);
		}
		
		//find sum
		int sum = 0;
		for(int i=0; i<numList.size(); i++) {
			sum += numList.get(i);
		}
		
		//check if sum is divisible by 10
		if(sum % 10 == 0)
			return true;
		else
			return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		//split string into words
		String[] words = string.split("[ ?]");
		//System.out.println(Arrays.toString(words));
		//find numbers
		//for each element in array
		//parse int
		//catch exception
		List<Integer> operands = new ArrayList<Integer>();
		for(int i=0; i<words.length; i++) {
			try {
				operands.add(Integer.parseInt(words[i]));
			}
			catch (NumberFormatException oops){
				
			}
		}
		
		//get operator
		//see if one of the words is an operation
		int result = 0;
		for(int i=0; i<words.length; i++) {
			switch (words[i]) {
			case "plus":
				result = operands.get(0) + operands.get(1);
				break;
			case "minus":
				result = operands.get(0) - operands.get(1);
				break;
			case "multiplied":
				result = operands.get(0) * operands.get(1);
				break;
			case "divided":
				result = operands.get(0) / operands.get(1);
				break;
			default:
				break;
			}
		}
		
//		for(int i=0; i<operands.size(); i++) {
//			System.out.println(operands.get(i));
//		}
		return result;
	}

}
