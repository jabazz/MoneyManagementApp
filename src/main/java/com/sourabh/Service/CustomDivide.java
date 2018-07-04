package com.sourabh.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CustomDivide {
	
	public static void calculateIndividualPairTransaction(Map<String, Double> items) {
		
		Set<String> set = new HashSet<String>();
		Set<String> removeSet = new HashSet<String>();
		
		
		String pay = "";
		
		
		
		
		while(!items.isEmpty()){
		for (Entry<String, Double> entry : items.entrySet()) {
			for (Entry<String, Double> check : items.entrySet()) {
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
				}
				
				}}
		}
		for(String t : removeSet){
			items.remove(t);
		}
		if(!items.isEmpty()){
		distribution(set,items);}
		}
		
		for(String p: set){
			  System.out.println(p);
		}
		
	}

	private static void distribution(Set<String> set, Map<String, Double> items) {
		double max = Collections.max(items.values());
		double min = Collections.min(items.values());
		Set<String> removeSet = new HashSet<String>();
		if (max != 0 || min != 0) {
			String max_key = getKeyForValue(items, max);
			String min_key = getKeyForValue(items, min);
			double result = max + min;
			if (result >= 0.0) {
				String pay = max_key + " will get from " + min_key + " : " + Math.abs(min) + "\n";
				set.add(pay);
				items.put(max_key, result);
				removeSet.add(min_key);
			} else {
				String pay = max_key + " will get from " + min_key + " : " + Math.abs(max) + "\n";
				set.add(pay);
				items.put(min_key, result);
				removeSet.add(max_key);
			}
			for (String t : removeSet) {
				items.remove(t);
			}
		}

	}

	private static String getKeyForValue(Map<String, Double> items, double max) {
		for (String key : items.keySet()) {
			if (items.get(key) == (max))
				return key;
		}
		return null;
	}

}
