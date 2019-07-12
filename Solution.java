package com.solution;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * This Java class contains all the functions of sets operations that can by applied to two sets
 * The Universe is integers from 1 to 100, so several functions are hardcoded with that parameter
 * 
 * 
 * */
public class Solution {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el conjunto A separando por coma cada numero");

		String[] integers = sc.nextLine().split(",");
		
		ArrayList<Integer> listA = new ArrayList<>(integers.length);

		TreeSet<Integer> setA = new TreeSet<>();
		
		for (String s : integers) {

			setA.add(Integer.parseInt(s));

		}
		
		setA.forEach((temp) -> {
			
			listA.add(temp);
			
		});
		

		System.out.println("Introduce el conjunto B separando por coma cada numero");

		integers = sc.nextLine().split(",");

		ArrayList<Integer> listB = new ArrayList<>(integers.length);
		
		TreeSet<Integer> setB = new TreeSet<>();
		
		for (String s : integers) {

			setB.add(Integer.parseInt(s));

		}
		
		setB.forEach((temp) -> {
			
			listB.add(temp);
			
		});
		

		System.out.println("------------------------------------------------------");
		printIntersection(listA, listB);
		System.out.println("------------------------------------------------------");
		printUnion(listA, listB);
		System.out.println("------------------------------------------------------");
		printDifference(listA, listB);
		System.out.println("------------------------------------------------------");
		printDifference(listB, listA);
		System.out.println("------------------------------------------------------");
		printSimetricDifference(listA, listB);
		System.out.println("------------------------------------------------------");
		printComplement(listA);
		System.out.println("------------------------------------------------------");
		printComplement(listB);
		System.out.println("------------------------------------------------------");
		printCartesianProduct(listA, listB);
		System.out.println("------------------------------------------------------");
		printCartesianProduct(listB, listA);
		System.out.println("------------------------------------------------------");
		printCartesianProduct(listA, listA);
		System.out.println("------------------------------------------------------");
		printCartesianProduct(listB, listB);
		System.out.println("------------------------------------------------------");
		printSetPower(listA);
		System.out.println("------------------------------------------------------");
		printSetPower(listB);
		System.out.println("------------------------------------------------------");
		cardinality(listA);
		System.out.println("------------------------------------------------------");
		cardinality(listA);

		
		sc.close();
		
	}

	private static void cardinality(ArrayList<Integer> listA) {
		
		System.out.println("La cardinalidad del conjunto es : " + listA.size());
		
	}

	private static void printSetPower(ArrayList<Integer> listA) {
		
		System.out.println("El conjunto potencia es: ");
		System.out.print("{");
		
		char[] charArray;
		long power = (long) Math.pow(2, listA.size());
		
		for (int i = 0; i < power; i++) {
			
			charArray = Integer.toBinaryString(i).toCharArray();
			System.out.print("{");
			
			for (int j = charArray.length-1, k = 0; j >= 0 ; j--,k++) {
				
				if (charArray[j] == '1') {
					
					System.out.print(listA.get(k));
					
					if (j>0) {
						
						System.out.print(",");
						
					}
					
				}
			
			}
			
			if (i < power - 1) {
				System.out.print("},");
			}
			
		}
		
		System.out.println("}}");
	
		

	}

	private static void printCartesianProduct(ArrayList<Integer> listA, ArrayList<Integer> listB) {
		System.out.println("El producto cartesiano del primer conjunto por el segundo conjunto es: ");
		System.out.print("{");
		
		for (int i = 0; i < listA.size(); i++) {
			
			for (int j = 0; j < listB.size(); j++) {
				
				System.out.print("(" + listA.get(i) + "," + listB.get(j) + ")");
				if (j < listB.size()-1) {
					System.out.print(",");
				}
			}
			
			if (i < listA.size()-1) {
				System.out.print(",");
			}
		}
		
		System.out.println("}");

	}

	private static void printComplement(ArrayList<Integer> listA) {
		System.out.println("El complemento del conjunto es: ");
		System.out.print("{");
		for (int i = 1; i <= 100; i++) {
			
			if (!listA.contains(i)) {
				System.out.print(i);
				if (i < 100) {
					System.out.print(",");
				}
			}
			
			
			
		}
		System.out.println();
	}

	private static void printSimetricDifference(ArrayList<Integer> listA, ArrayList<Integer> listB) {
		TreeSet<Integer> myset = new TreeSet<>();
		
		listA.forEach((temp) -> {
			if (!listB.contains(temp)) {
				myset.add(temp);
			}
		});
		
		listB.forEach((temp) -> {
			if (!listA.contains(temp)) {
				myset.add(temp);
			}
		});
		System.out.println("La diferencia simetrica del conjunto A con el conjunto B es:");
		System.out.print("{");
		AtomicInteger counter = new AtomicInteger(0);
		int setLength = myset.size();
		myset.forEach((temp) -> {
			System.out.print(temp);
			if (counter.incrementAndGet() < setLength) {
				System.out.print(",");
			}
			
		});
		System.out.println("}");


	}

	private static void printDifference(ArrayList<Integer> listA, ArrayList<Integer> listB) {
		
		TreeSet<Integer> myset = new TreeSet<>();
	
		listA.forEach((temp) -> {
			if (!listB.contains(temp)) {
				myset.add(temp);
			}
		});
		System.out.println("La diferencia del primer conjunto menos el segundo conjunto es:");
		System.out.print("{");
		AtomicInteger counter = new AtomicInteger(0);
		int setLength = myset.size();
		myset.forEach((temp) -> {
			System.out.print(temp);
			if (counter.incrementAndGet() < setLength) {
				System.out.print(",");
			}
			
		});
		System.out.println("}");

	}

	private static void printUnion(ArrayList<Integer> listA, ArrayList<Integer> listB) {
		TreeSet<Integer> myset = new TreeSet<>();
		
		for (int i = 0; i < listA.size() || i < listB.size(); i++) {
			
			if (i < listA.size()) {
				myset.add(listA.get(i));
			}
			if (i < listB.size()) {
				myset.add(listB.get(i));
			}
			
		}
		
		System.out.println("La union del conjunto A con el conjunto B es:");
		System.out.print("{");
		
		AtomicInteger counter = new AtomicInteger(0);
		int setLength = myset.size();
		myset.forEach((temp) -> {
			System.out.print(temp);
			if (counter.incrementAndGet() < setLength) {
				System.out.print(",");
			}
			
		});
		System.out.println("}");
	}

	private static void printIntersection(ArrayList<Integer> listA, ArrayList<Integer> listB) {
		TreeSet<Integer> myset = new TreeSet<>();
		
		listA.forEach((temp) -> {
			if (listB.contains(temp)) {
				myset.add(temp);
			}
		});
		System.out.println("La interseccion del conjunto A con el conjunto B es:");
		System.out.print("{");
		
		AtomicInteger counter = new AtomicInteger(0);
		int setLength = myset.size();
		myset.forEach((temp) -> {
			System.out.print(temp);
			if (counter.incrementAndGet() < setLength) {
				System.out.print(",");
			}
			
		});
		System.out.println("}");

	}

}
