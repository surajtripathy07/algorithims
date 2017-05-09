import java.util.*;/*

Pretty print a json object using proper indentation.

    Every inner brace should increase one indentation to the following lines.
    Every close brace should decrease one indentation to the same line and the following lines.
    The indents can be increased with an additional ‘\t’

Example 1:

Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
Output : 
{ 
    A:"B",
    C: 
    { 
        D:"E",
        F: 
        { 
            G:"H",
            I:"J"
        } 
    }     
}

Example 2:

Input : ['foo', {'bar':['baz',null,1.0,2]}]
Output : 
[
    "foo", 
    {
        "bar":
        [
            "baz", 
            null, 
            1.0, 
            2
        ]
    }
]

[] and {} are only acceptable braces in this case.

Assume for this problem that space characters can be done away with.

Your solution should return a list of strings, where each entry corresponds to a single line. The strings should not have “\n” character in them.
*/

public class JsonIndent {
//{A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
	public ArrayList<String> prettyJSON(String a) {
		ArrayList<String> json = new ArrayList<String>();
		boolean addtab = false;
		StringBuffer tab = new StringBuffer("");
		StringBuilder b = new StringBuilder();

		for(int i = 0; i < a.length(); i++){
			char c = a.charAt(i);

			if (addtab){
				tab.append("\t");
				b.append(tab);
				addtab = false;
			}

			if (c == '{' || c =='['){
				if (b.length() != 0 && !(b.replace("\t").toString().isEmpty())){
					json.add(b.toString());
					b.setLength(0);
				}
				b.append(tab);
				b.append(c);
				addtab = true;
				json.add(b.toString());
				b.setLength(0);
				continue;
			} else if (c == ','){
				b.append(c);
				json.add(b.toString());
				b.setLength(0);
				b.append(tab);
				continue;
			} else if (c == '}' || c == ']'){
				if (b.length() != 0){
					json.add(b.toString());	
					b.setLength(0);
				}
				tab.setLength(tab.length() - 1);
				b.append(tab);
				b.append(c);
				json.add(b.toString());
				b.setLength(0);
				continue;
			}
			else {
				b.append(c);
			}
		} 

		return json;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String unformjson = sc.next();
		JsonIndent j = new JsonIndent();
		ArrayList<String> arr = j.prettyJSON(unformjson);
		for (String s : arr){
			System.out.println(s);
		}
	}
}

