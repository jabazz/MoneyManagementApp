package com.sourabh.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		
			Set<String> set = new HashSet<String>();
			Set<String> removeSet = new HashSet<String>();
			Map<String, Integer> items = new HashMap<>();
			
			String pay = "";
			items.put("A", 70);
			items.put("B", 60);
			items.put("G", 50);
			items.put("C", -30);
			items.put("D", -30);
			items.put("E", -50);
			items.put("F", -70);
			items.put("H", 80);
			items.put("I", -40);
			items.put("J", -40);
			items.put("rajwah", 72);
			items.put("kumwar", -50);
			items.put("sanjay", -22);
			items.put("Raj", 50);
			items.put("Gaurav", -50);
			
			
			// Double min = Collections.min(map.values());
			// lambda
			
			while(!items.isEmpty()){
			for (Entry<String, Integer> entry : items.entrySet()) {
				for (Entry<String, Integer> check : items.entrySet()) {
					if(!removeSet.contains(entry.getKey()) && !removeSet.contains(check.getKey())){
					if (check.getValue() + entry.getValue() == 0) {
						
						if (entry.getValue() > 0 && check.getValue() < 0) {
							pay = entry.getKey() + " will get from " + check.getKey() + " : " + entry.getValue()+"\n";
							} 
						else if (entry.getValue() < 0 && check.getValue() > 0){
							pay = check.getKey() + " will get from " + entry.getKey() + " : " + check.getValue()+"\n";
						}
						set.add(pay);
						removeSet.add(check.getKey());
						removeSet.add(entry.getKey());
						//items.remove(check.getKey(),check.getValue());
						//items.remove(entry.getKey(), entry.getValue());
					}
					
					}}
			}
			//System.out.println(set);
			for(String t : removeSet){
				items.remove(t);
			}
			//System.out.println(items);
			if(!set.isEmpty() && !items.isEmpty()){
			distribution(set,items);}
			System.out.println(set);
			System.out.println(items);
			}
			
			System.out.println(set);
			
		}
	private static void distribution(Set<String> set, Map<String, Integer> items){
		int max = Collections.max(items.values());
		int min = Collections.min(items.values());
		Set<String> removeSet = new HashSet<String>();
		if (max != 0 || min != 0) {
			String max_key = getKeyForValue(items, max);
			String min_key = getKeyForValue(items, min);
			int result = max + min;
			if (result >= 0.0) {
				//System.out.println(max_key + " will get from" + min_key + " " + Math.abs(min));
				String pay = max_key + " will get from " + min_key + " " + Math.abs(min)+ "\n";
				set.add(pay);
				items.put(max_key, result);
				removeSet.add(min_key);
			} else {
				//System.out.println(max_key + " will get from" + min_key + " " + Math.abs(max));
				String pay = max_key + " will get from " + min_key + " " + Math.abs(max)+"\n";
				set.add(pay);
				items.put(min_key, result);
				removeSet.add(max_key);
			} 
			for(String t : removeSet){
				items.remove(t);
			}
		}
		
		
	}
	private static String getKeyForValue(Map<String, Integer> items, Integer value) {
		for (String key : items.keySet()) {
			if (items.get(key) == (value))
				return key;
		}
		return null;
	}
}
