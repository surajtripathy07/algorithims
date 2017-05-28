public class Solution {
    private class Person{
        int height;
        int inFront;
        Person(int height, int inFront){
            this.height = height;
            this.inFront = inFront;
        }
    }
    
	public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
	    ArrayList<Person> list = new ArrayList<Person>();
	    for (int i = 0; i < heights.size(); i++){
	        list.add(new Person(heights.get(i), infronts.get(i)));
	    }
	    
	    Collections.sort(list, new Comparator<Person>(){
	       public int compare(Person p1, Person p2){
	           return Integer.compare(p1.height, p2.height);
	       } 
	    });

	    int[] finalOrder = new int[list.size()];
	    for (int i = 0; i < list.size(); i++){
	        int empty = 0;
	        for (int j = 0; j < finalOrder.length; j++){
	            if (list.get(i).inFront == empty && finalOrder[j] == 0){
	                finalOrder[j] = list.get(i).height;
	                break;
	            }else if (finalOrder[j] == 0){
	                empty++;
	            }
	        }
	    }
	    
	    ArrayList<Integer> flist = new ArrayList<Integer>();
	    for (int i = 0; i < finalOrder.length; i++){
	        flist.add(finalOrder[i]);
	    }
	    return flist;
	}
}


