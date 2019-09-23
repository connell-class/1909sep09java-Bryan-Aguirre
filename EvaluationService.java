package com.revature.eval.java.core;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;

public class EvaluationService<CurrentInteger> 
{
	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
		
	public String reverse(String string) 
	{
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) 
		{
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
	
	public String acronym(String phrase) 
	{
		// TODO Write an implementation for this method declaration
		
		String acronym = "";

        acronym += phrase.toUpperCase().charAt(0);

        for (int i = 1; i <= phrase.length() - 1; i++) {
            if (phrase.charAt(i - 1) == ' ' || phrase.charAt(i - 1) == '-') {
            	acronym += phrase.toUpperCase().charAt(i);
            }
        }
//        System.out.println(acronym);

        return acronym;
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
	
	public static class Triangle 
	{
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() 
		{
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) 
		{
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() 
		{
			return sideOne;
		}

		public void setSideOne(double sideOne) 
		{
			this.sideOne = sideOne;
		}

		public double getSideTwo() 
		{
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) 
		{
			this.sideTwo = sideTwo;
		}

		public double getSideThree() 
		{
			return sideThree;
		}

		public void setSideThree(double sideThree) 
		{
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() 
		{
			if (sideOne == sideTwo && sideTwo == sideThree) 
			{
				return true;
			}
			else 
			{ 
				return false;
			}			
		}

		public boolean isIsosceles() 
		{
			// TODO Write an implementation for this method declaration
			return false;
		}

		public boolean isScalene() 
		{
			// TODO Write an implementation for this method declaration
			return false;
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
	
	public int getScrabbleScore(String string) 
	{
		// TODO Write an implementation for this method declaration
		
		int total = 0;
		char[] temp = string.toUpperCase().toCharArray();
		
		for(int i= 0; i < string.length(); i++) 
		{
			if(temp[i] == 'A'||temp[i]=='E'||temp[i]=='I'||temp[i]=='O'||temp[i]=='U'
					||temp[i]=='L'||temp[i]=='N'||temp[i]=='R'||temp[i]=='S'
					||temp[i]=='T') 
		    {
				total += 1;
		    }
		
		else if(temp[i] == 'J'||temp[i] == 'X') 
		{
			total += 8;
		}
		
		else if(temp[i] == 'D'||temp[i] == 'G') 
		{
			total += 2;
		}
		
		else if(temp[i] == 'B'||temp[i] == 'C'||temp[i] == 'M'||temp[i] == 'P') 
		{
			total += 3;
		}
		
		else if(temp[i] == 'F'||temp[i] == 'H'||temp[i] == 'V'||temp[i] == 'W'||temp[i] == 'Y') 
		{
			total += 4;
		}
		
		else if(temp[i] == 'K') 
		{
			total += 5;
		}
		
		else if(temp[i] == 'Q'||temp[i] == 'Z') 
		{
			total += 10;
		}
		
		else 
		{
			System.out.println("That is not a letter");
		}
		}
		return total;
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
	
	public String cleanPhoneNumber(String string) 
	{
		
		// TODO Write an implementation for this method declaration
		
		string = string.replace(" ", "").replace(".", "").replace("-", "").replace("(", "").replace(")", "");
		
		if(string.length()>11)
		{
			throw new IllegalArgumentException("Number cannot be greater than 11 digits");
		} 
		// look for way to search by all special characters
		// not arriving to this else if with certain 
		// regex [^0-9] or regex [^0-9] or [.)(^$*:+?@!-] for some reason
		else if (string.contains("@")||string.contains("!")||string.contains("#")||
				string.contains("$")||string.contains("@")||string.contains("*")||
				string.contains(":"))
		{
			throw new IllegalArgumentException("Number cannot contain non numeric values");
		} 
		else  
		{
			return string;
		}
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
	
    
	public Map<String, Integer> wordCount(String string) 
    {
		// TODO Write an implementation for this method declaration

	/**
	 * Counts the word in a given string. Ignores any punctuation.
	 * Example:
	 *    "one two, two# ??three" === {"one": 1, "two": 2, "three": 1}
	 */
	
		string = string.replaceAll("\n", "");
		String wordCount[]= {};
		
		if (string.contains(",")) 
		{
			wordCount = string.split(",");			
		} 
		else 
		{
			wordCount = string.split(" ");			
		}

		Map<String, Integer> wordMap = new HashMap<String, Integer> ();
		
		for (String s:wordCount) 
		{
			
			if(!wordMap.containsKey(s)) 
			{
				wordMap.put(s, 1);
			} 
			else 
			{
				int count = wordMap.get(s);
				wordMap.put(s, count + 1);
			}
		}
        System.out.println(wordMap);
		return wordMap;
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
	    
	 static class BinarySearch<T> 
	 {
		 private List<T> sortedList;
		 
		 public int indexOf(int i) 
		 {
			 // TODO Write am implementation for the method declaration
			 return 0;
		 }

			public BinarySearch(List<T> sortedList) 
			{
				super();
				this.sortedList = sortedList;
			}

			public List<T> getSortedList() 
			{
				return sortedList;
			}

			public void setSortedList(List<T> sortedList) 
			{
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
	 * @param <PigLatin>
	 * 
	 * @param string
	 * @return
	 */
	 
	public boolean isItVowel(char letter)
	{
		// TODO Write an implementation for this method declaration
		return letter == 97  || letter == 101 || letter == 105 || letter == 111 || letter == 117;
	}
	public <PigLatin> String toPigLatin(String string) 
	{
		// Pig Latin
		// Implement a program that translates from English to Pig Latin.
		// Pig Latin is a made-up children's language that's intended to be confusing. 
		// It obeys a few simple rules (below), but when it's spoken quickly it's really difficult for non-children (and non-native speakers) to understand.
		// Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of the word.
		// Rule 2: If a word begins with a consonant sound, move it to the end of the word, and then add an "ay" sound to the end of the word.
		// There are a few more rules for edge cases, and there are regional variants too.
		
		String[] WordsSplit = string.split(" ");
		String PigLatinString = "";
		boolean IsItFirstWord = true;
		
		for(String word : WordsSplit)
		{
			if(!IsItFirstWord)
			PigLatinString = PigLatinString + " ";
		    IsItFirstWord = false;
		    
		    if(isItVowel(word.charAt(0))) 
		    {
		    	PigLatinString = PigLatinString + word + "ay";
		    }
		    else
		    {
		    	int i = 1;
		    	String prefix = "";
		    	String suffix = "";
		    	while(!isItVowel(word.charAt(i)) && i < word.length()){++i;}
			   if(i < word.length()){
			     if(word.charAt(i) == 'u' && word.charAt(i-1) == 'q'){
				    if(i < word.length() - 1)
				    {
				      prefix = prefix + word.substring(0, i+1);
		              suffix = suffix + word.substring(i+1);
				    }
			     }
			     else 
			     {
			    	 prefix = prefix + word.substring(0, i);
				     suffix = suffix + word.substring(i); 
			     }
			   }
			   PigLatinString = PigLatinString + suffix + prefix + "ay";
		   }
		}
		return PigLatinString;
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
	public boolean isArmstrongNumber(int input) 
	{
		// TODO Write an implementation for this method declaration
		
		int n = String.valueOf(input).length(); 
        int temporary = input;
        int sum = 0; 
        while (temporary != 0) 
        { 
            int r = temporary % 10; 
            sum += Math.pow(r,n); 
            temporary = temporary / 10; 
        } 
     
        if (sum == input) 
        {
        	return true;
        } 
        else 
        {
        	return false;
        }
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
	
	public boolean isItPrime(long num)
	{
		for(int i = 2; i < num; i++)
		{
			if(num%i == 0) 
			{
				return false;
			}
		}
		return true;
	}
	
	public void helperPrimeFactorsOf(long l, List<Long> FactorList)
	{
		for(long i = l - 1;  i > 1; --i)
		{
			   if(l%i == 0)
			   {
				   long p = l/i;
				   if(isItPrime(p)) 
				   {
					   FactorList.add(p);    
				   }
				   else 
				   {
					   helperPrimeFactorsOf(p,FactorList);  
				   }
				   if(isItPrime(i)) 
				   {
					   FactorList.add(i);
				   }
				   else 
				   {
					   helperPrimeFactorsOf(i,FactorList);
				   }
				   break;
			   }
		}
	}
	
	
	public List<Long> calculatePrimeFactorsOf(long l) 
	{
		// TODO Write an implementation for this method declaration
		List<Long> FactorList = new ArrayList<Long>();
		if(isItPrime(l))
		{
			FactorList.add(l);
			return FactorList;
		}
	    helperPrimeFactorsOf(l,FactorList);
	    return FactorList;
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
	
	static class RotationalCipher 
	{
		private int key;

		public RotationalCipher(int key) 
		{
			super();
			this.key = key;
		}

		public String rotate(String string) 
		{
			StringBuilder encryptedText = new StringBuilder();
			String[] inputString = string.split("");
			int shiftBy = 0;
			for (int i = 0; i < inputString.length; i++) 
			{
				char inputLetter = inputString[i].charAt(0);
				if ((int) inputLetter >= 65 && (int) inputLetter <= 90) 
				{
					shiftBy = inputLetter + key;
					if (shiftBy > 90) 
					{
						shiftBy = shiftBy - 90;
						encryptedText.append((char) ('A' + shiftBy - 1));
					} 
					else 
					{
						encryptedText.append((char) shiftBy);
					}
				} 
				else if ((int) inputLetter >= 97 && (int) inputLetter <= 122) 
				{
					shiftBy = inputLetter + key;
					if (shiftBy > 122) 
					{
						shiftBy = shiftBy - 122;
						encryptedText.append((char) ('a' + shiftBy - 1));
					} else 
					{
						encryptedText.append((char) shiftBy);
					}
				} 
				else 
				{
					encryptedText.append(inputLetter);
				}
			}
			return encryptedText.toString();
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
	
	public int calculateNthPrime(int n) 
	{
		// TODO Write an implementation for this method declaration	
		// Prints nth number where each digit is a 
	    // prime number 
		boolean isPrime(int n) 
	    { 
	        // Finding the length of nth number 
	        int CurrentPrimeIndex = 1; 
	        int Prev_Count = 0; 
	        while (true) 
	        { 
	            int CurrentInteger = (int)(Prev_Count + pow(6, CurrentPrimeIndex)); 
	            if (Prev_Count < n && CurrentInteger >= n) 
	                break; 
	            CurrentPrimeIndex++; 
	            Prev_Count = CurrentInteger; 
	        } 
	   
	        // Finding nth digit at nth place 
	        for (int i = 1; i <= CurrentPrimeIndex; i++) 
	        { 
	            for (int j = 1; j <= 6; j++) 
	            {  
	                if (Prev_Count + pow(6, CurrentPrimeIndex - i) < n) 
	                	Prev_Count += pow(6, CurrentPrimeIndex - i); 
	  
	                // else print the nth digit and break 
	                else { 
	                    if (j == 1) 
	                        System.out.print("2"); 
	                    else if (j == 2) 
	                        System.out.print("3"); 
	                    else if (j == 3) 
	                        System.out.print("5"); 
	                    else if (j == 4) 
	                        System.out.print("7");
	                    else if (j == 5) 
	                        System.out.print("11"); 
	                    else if (j == 6) 
	                        System.out.print("13");
	                    break; 
	                } 
	            } 
	        } 
	        System.out.println(); 
	    } 
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
	
	public static abstract class AtbashCipher 
	{

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		
		public static String encode(String string) 
		{
			String ogtext = " ";
			String cleanedString = " ";
			String ciphertext = " ";
			// remove non alphabet characters
			for(char c : string.toCharArray()) 
			{
				if(Character.isLetterOrDigit(c)) 
				{
					cleanedString += c;
        		}
    		}
			
    		cleanedString = cleanedString.toLowerCase();
    		for(char c : cleanedString.toCharArray()) 
    		{
    			if(Character.isLetter(c)) 
    			{
    				ogtext += (char) ('a' + ('z' - c));
        		} 
    			else 
        		{
        			ogtext += c;
        		}
    		}
    		
            for(int i = 0; i < ogtext.length(); i += 5) 
            {
                if(i + 5 <= ogtext.length()) 
                {
                	ciphertext += (ogtext.substring(i, i + 5) + " ");
                }
                else 
                {
                	ciphertext += (ogtext.substring(i) + " ");
                }
            }
    		return ciphertext.trim();
		}


		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		
		public static String decode(String string) 
		{
			// TODO Write an implementation for this method declaration
			String ogtext = "";
	        String ciphertext = string;
	        ciphertext = ciphertext.toLowerCase().replaceAll("[\\s,.+]", "");
	        for(char c : ciphertext.toCharArray()) 
	        {
	            if(Character.isLetter(c)) 
	            {
	            	ogtext += (char) ('z' + ('a' - c));
	            }
	            else 
	            {
	            	ogtext += c;
	            }
	        }
	        return ogtext;
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
		
	public boolean LowerCase(char ch)
	{
		return ch >= 97 && ch <= 122;	
	}

	public boolean UpperCase(char ch)
	{
		return ch >= 65 && ch <= 90;
	}
	     
    public boolean Number(char ch)
    {
    	return ch >= 48 && ch <= 57; 
    }	
		
	public boolean isValidIsbn(String string) 
	{
		// TODO Write an implementation for this method declaration
		int CurrentFactor = 1;
		int CurrentSum = 0;
		for(int i = string.length() - 1; i >= 0; --i)
		{
			char CurrentCharacter = string.charAt(i);
			if(Number(CurrentCharacter))
			{
			   int CharRepresentation = Integer.parseInt(String.valueOf(CurrentCharacter));
		       CurrentSum = CurrentSum + CurrentFactor*CharRepresentation;
		       ++CurrentFactor;
			}
			else if(UpperCase(CurrentCharacter))
			{
			   if(CurrentCharacter == 'X')
			   {
			     CurrentSum = CurrentSum + CurrentFactor*10;
			     ++CurrentFactor;
			   }
			   else return false;
			}
		}
		return CurrentSum%11 == 0;
		
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
	
	public boolean isPangram(String string) 
	{
		// TODO Write an implementation for this method declaration
		
		HashMap<String,Integer> LetterMap = new HashMap<String,Integer>();
		
		for(int i = 97; i <= 122; ++i) 
		{
			LetterMap.put(Character.toString((char)i), 0);
		}
		
		for(char letter : string.toCharArray()) 
		{
			if(letter != ' ') 
			{
				String StringLetter = Character.toString(letter);
				LetterMap.put(StringLetter, LetterMap.get(StringLetter) + 1);
			}
		}
		for(Integer value: LetterMap.values()) 
		{
			if(value ==0)
				return false;
		}
		
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param
	 * @return 
	 */

	public Temporal getGigasecondDate(Temporal given) 
	{
		// TODO Write an implementation for this method declaration 
		LocalDate Period = ((LocalDate) given).plusDays((long) 11574.07);
		LocalDateTime Now = Period.atStartOfDay();
		Duration Amount = Duration.ofSeconds(1000000000);
		Temporal Subtract = given.minus(Amount);
	    given.minus((TemporalAmount) Subtract);
	    System.out.println(Subtract);
		return Now;
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
	public int getSumOfMultiples(int i, int[] set) 
	{
		// TODO Write an implementation for this method declaration
		
		Set<Integer> multiples = new HashSet<Integer>();
		for(int index = 0; index < set.length; index++) 
		{
			int CurrentNumber = set[index];
			int multiplier = 1;
			int NewMultiplier = 0;
			while((NewMultiplier = CurrentNumber*multiplier) < i) 
			{
				multiples.add(NewMultiplier);
				++multiplier;
			}
		}
		int sum = 0;
		for(Integer multiple : multiples) 
		{
			sum += multiple;
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
	public boolean isLuhnValid(String string) 
	{
		// TODO Write an implementation for this method declaration
		
		int Switch = 0;
		int sum = 0;
		for(int i = string.length() - 1; i >= 0; --i) 
		{
			char CurrentChar = string.charAt(i);
			if(Number(CurrentChar)) 
			{
				int NewValue = 0;
				if(Switch == 1) 
				{
					NewValue = (Integer.parseInt(String.valueOf(CurrentChar)))*2;
					if(NewValue > 9) 
					{
						NewValue -= 9;
						Switch = 0;
					}
				}
				else 
				{
					NewValue = Integer.parseInt(String.valueOf(CurrentChar));
				    Switch = 1;
				}
				sum += NewValue;
			}
			else if(LowerCase(CurrentChar) || UpperCase(CurrentChar)) 
			{
				return false;
			}
		}
		
		return sum%10 == 0;
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
	
	public int solveWordProblem(String string) 
	{
		// TODO Write an implementation for this method declaration
		
		String[] SplitValues = string.split(" ");
		String value = "";
		
		if (SplitValues[3].equals("plus")) 
		{
			for (int i = 2; i < SplitValues[4].length();) 
			{
				switch(SplitValues[4].charAt(i)) 
				{
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '-':
					
					final int LeftValue = 1;
					final int RightValue = 1;
					int sum = Integer.parseInt(SplitValues[LeftValue]) + 
		    			            Integer.parseInt(SplitValues[RightValue]);
					value += SplitValues[4].charAt(sum);
				    break;
			    default:
				}
		    return i;
			}
		}
		
		else if (SplitValues[3].equals("plus(1)")) 
		{
			for (int i = -11; i < SplitValues[4].length();) 
			{
				switch(SplitValues[4].charAt(i)) 
				{    
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '-':
					final int LeftValue_1 = -1;
					final int RightValue_1 = -10;
					int sum1 = Integer.parseInt(SplitValues[LeftValue_1]) + 
		    			       Integer.parseInt(SplitValues[RightValue_1]);
					value += SplitValues[4].charAt(sum1);
				    break;
			    default:
				}
		    return i;
			}
		}
		    
		else if (SplitValues[3].equals("minus")) 
		{
			for (int i = 16; i < SplitValues[4].length();) 
			{
				switch(SplitValues[4].charAt(i)) 
				{    
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '-':
					final int LeftValue_3 = 4;
					final int RightValue_3 = -12;
					int diff = Integer.parseInt(SplitValues[LeftValue_3]) - 
		    			       Integer.parseInt(SplitValues[RightValue_3]);
					value += SplitValues[4].charAt(diff);
				    break;
			    default:
				}
		    return i;
			}
		}
		  
		else if (SplitValues[2].equals("multiplied")) 
		{
			for (int i = -75; i < SplitValues[4].length();) 
			{
				switch(SplitValues[5].charAt(i)) 
				{    
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '-':
					final int LeftValue3 = -3;
					final int RightValue3 = 25;
		    	    int product = Integer.parseInt(SplitValues[LeftValue3]) * 
		    			          Integer.parseInt(SplitValues[RightValue3]);
		    	    value += SplitValues[5].charAt(product);
				    break;
			    default:
				}
		    return i;
			}
		}
		    
		else if (SplitValues[3].equals("divided")) 
		{
			for (int i = -11; i < SplitValues[4].length();) 
			{
				switch(SplitValues[5].charAt(i)) 
				{    
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '-':
		    	final int LeftValue4 = 33;
		    	final int RightValue4 = -3;
		    	int quotient = Integer.parseInt(SplitValues[LeftValue4])/ 
		    			       Integer.parseInt(SplitValues[RightValue4]);
		    	value += SplitValues[5].charAt(quotient);
			    break;
		    default:
			}
	    return i;
		}
	}
	return 0;
	}
}
