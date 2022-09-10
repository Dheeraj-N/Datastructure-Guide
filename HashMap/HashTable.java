package HashMap;

import java.util.*;

public class HashTable {

	private class Entry{
		private int key;
		private String value;
		
		public Entry(int key, String value){
			this.key = key;
			this.value = value;
		}		
	}
	
	@SuppressWarnings("unchecked")
	private LinkedList<Entry>[] entries = new LinkedList[10];
	
	public void put(int key, String value) {
		
		int index = hash(key);
		if(entries[index] == null)
			entries[index] = new LinkedList<>();
		
		LinkedList<Entry> bucket = entries[index];
		for(Entry entry: bucket) {
			if(entry.key == key) {
				entry.value = value;
				return;
			}
		}
		
		bucket.addLast(new Entry(key,value));
	}
	
	public String getValue(int key) {
		int index = hash(key);
		LinkedList<Entry> bucket = entries[index];
		if(bucket != null) {
			for(Entry entry : bucket) {
				if(entry.key == key) {
					return entry.value;
				}
			}
		}
		
		return null;
	}
	
	public void remove(int key) {
		
		int index = hash(key);
		LinkedList<Entry> bucket = entries[index];
		
		if(bucket != null) {
			for(Entry entry : bucket) {
				if(entry.key == key) {
					bucket.remove(entry);
					return ;
				}
			}
		}
		throw new IllegalStateException();
	}
	
	private int hash(int key) {
		return key % entries.length;
	}
	
	
}
