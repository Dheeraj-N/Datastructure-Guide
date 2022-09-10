package LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 LinkedList list1 = new LinkedList();
     list1.append(1);
     list1.append(2);
     list1.append(3);
     list1.display();
     System.out.println(list1.size());
     
     list1.addFirst(5);
     list1.addFirst(6);
     list1.display();
     System.out.println(list1.getKthNodeFromEnd(1));
     /*list1.reverse();
     list1.display();
     
     System.out.println(list1.indexOf(8));
     System.out.println(list1.indexOf(5));
     
     System.out.println(list1.contains(5));
     
     list1.deleteFirst();
     list1.display();
     
     list1.deleteLast();
     list1.display();
     
     System.out.println(list1.size());
     
     list1.reverse();
     list1.display();
     */
	}

}
