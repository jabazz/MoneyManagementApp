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
		int max ;
		int min ; 
		String pay = "";
		items.put("A", 70);
		items.put("B", 60);
		items.put("G", 50);
		items.put("C", -30);
		items.put("D", -30);
		items.put("E", -50);
		items.put("F", -70);
		// Double min = Collections.min(map.values());
		// lambda
		
		while(!items.isEmpty()){
		for (Entry<String, Integer> entry : items.entrySet()) {
			for (Entry<String, Integer> check : items.entrySet()) {
				if (check.getValue() + entry.getValue() == 0) {
					if (entry.getValue() > 0 && check.getValue() < 0) {
						pay = entry.getKey() + " will get from" + check.getKey() + " : " + entry.getValue()+"\n";
						} 
					else if (entry.getValue() < 0 && check.getValue() > 0){
						pay = check.getKey() + " will get from" + entry.getKey() + " : " + check.getValue()+"\n";
					}
					set.add(pay);
					removeSet.add(check.getKey());
					removeSet.add(entry.getKey());
					//items.remove(check.getKey(),check.getValue());
					//items.remove(entry.getKey(), entry.getValue());
				}
				
			}
		}items.remove(removeSet);
		
		System.out.println(set);
		for(String t : removeSet){
			items.remove(t);
		}
		System.out.println(removeSet);
		System.out.println(items);
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		treeMap.putAll(items);
		System.out.println(items);
		//System.out.println(treeMap.firstEntry().getValue()+treeMap.lastEntry().getValue());
		int balance = treeMap.firstEntry().getValue()+treeMap.lastEntry().getValue();
		if(balance  >  0){
			items.replace(treeMap.firstKey(), balance);
			items.remove(treeMap.lastKey());
			pay = treeMap.firstKey() + " will get from" + treeMap.lastKey() + " : " +treeMap.lastEntry().getValue()+"\n";
			set.add(pay);
		}
		else{
			items.replace(treeMap.lastKey(), balance);
			items.remove(treeMap.firstKey());
			pay = treeMap.firstKey() + " will get from" + treeMap.lastKey() + " : " + treeMap.firstEntry().getValue()+"\n";
			set.add(pay);
		}
		//System.out.println(items);
	}
		System.out.println(set);
	}
}
