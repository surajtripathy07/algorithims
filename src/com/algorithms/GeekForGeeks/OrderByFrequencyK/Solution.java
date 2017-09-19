import java.util.*;

class Solution {

	static class Value{
		String obj;
		Integer count;
		Value(String obj){
			this.obj = obj;
			count = 1;
		}
		
		@Override
		public boolean equals(Object ob){
			Value v = (Value) ob;

			if (v == null) return false;
			return obj.equals(v.obj);
		}
	
		@Override	
		public int hashCode(){
			return obj.hashCode();
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.nextLine();
		TreeSet<Value> kSet = new TreeSet<Value>(new Comparator<Value>(){
			public int compare(Value v1, Value v2){
				if (v1.equals(v2)) return 0;
				int cmp = Integer.compare(v2.count, v1.count);
				if (cmp == 0) return 1;
				else return cmp;
			}
		});
		Map<String, Value> gV = new HashMap<String, Value>(); 
		while(true){
			String inp = sc.nextLine();
			if (gV.containsKey(inp)){
				Value v = gV.get(inp);
				kSet.remove(v);
				v.count++;
				kSet.add(v);
			} else {
				Value v = new Value(inp);
				gV.put(inp, v);
				kSet.add(v);	
			}
			int i = 0;
			for (Value v : kSet){
				if (i < k){
					System.out.print(v.obj+" ");
				} else {
					break;
				}
				i++;
			}
			System.out.println();
		}
		
	}

}
