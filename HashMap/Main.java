package HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashTable ht = new HashTable();
		ht.put(1, "Dheeraj");
		ht.put(4, "Arvi");
		ht.put(7, "Mada");
		ht.put(11, "Agal");
		ht.put(10, "Sarnesh");
		System.out.println(ht.getValue(10));
		ht.remove(10);
	}

}
