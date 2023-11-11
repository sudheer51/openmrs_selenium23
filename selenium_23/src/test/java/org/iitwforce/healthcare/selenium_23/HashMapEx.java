package org.iitwforce.healthcare.selenium_23;

import java.util.HashMap;
import java.util.Set;

public class HashMapEx {
	
	public static void main(String[] args) {
		HashMap<Integer,String> hashMap1 = new HashMap<Integer,String>();
		hashMap1.put(1,"ANU");
		hashMap1.put(2,"Sri");
		hashMap1.put(2,"Aditi");
		System.out.println(hashMap1.get(2));
		Set<Integer> hashMapKeys= hashMap1.keySet();
		for(Integer i : hashMapKeys)
		{
			String value = hashMap1.get(i);
			System.out.println("value::" + value);
		}
		
		HashMap<Integer,String> hashMap2 = new HashMap<Integer,String>();
		hashMap2.put(1,"Anu");
		hashMap2.put(2,"Sri");
		hashMap2.put(2,"Aditi");
		System.out.println(hashMap1.get(2));
		Set<Integer> hashMapKeys2= hashMap1.keySet();
		for(Integer i : hashMapKeys2)
		{
			String value = hashMap2.get(i);
			System.out.println("value::" + value);
		}
		System.out.println(hashMap1);
 
		System.out.println(hashMap2);
		
	
		
	}

}
