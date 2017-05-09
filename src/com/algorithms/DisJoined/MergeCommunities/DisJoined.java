import java.util.*;
import java.math.*;

class Node(){
	public Node parent;
	public int data;
	public Node left;
	public Node right;
	public int rank;
}

public class DisJoined{
	Object[] hashTable;

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		int numberOfPeople = sc.nextInt();
		int numberOfQueries = sc.nextInt();
		hashTable = new Object[numberOfPeople];


	}

	public Node findSet(int n, int numberOfPeople){
		return getFromHashTable(n, numberOfPeople);
	}

	public Node Union(Node u, Node v ){
		if (u.rank < v.rank){

		}
		
	}

	public Node addInHashTable(int number, int numberOfPeople){
		int index = getHash(number, numberOfPeople);
		Node n = new Node();
		n.data = number;
		if (hashTable[index] == null){
			hashTable[index] = new ArrayList<Node>();	
		}

		(ArrayList<Node>hashTable[index]).add(n);

		hashTable[index] = n;
		return hashTable[index];
	}

	public Node getFromHashTable(int number, int numberOfPeople){
		int index = getHash(number, numberOfPeople);
		Node found = null;
		if (hashTable[index]!= null){
			ArrayList<Node> bucket = (ArrayList<Node>)hashTable[index];
			// Collision WorstCase( O(numberOfPeople) )
			for(Node n : bucket){
				if (n.data == number){
					found = n;
					break;
				}
			}
		}
		return found;
	}

	public index getHash(int number, numberOfPeople){
		return number % numberOfPeople;;
	}

}