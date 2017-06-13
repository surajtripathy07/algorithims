import java.util.*;

class Solution{

	static boolean isRotated(String oS, String rs){
		StringBuilder right = new StringBuilder(rs);
		StringBuilder left = new StringBuilder(rs);
		left.reverse();
		String osL = new StringBuilder(oS).reverse().toString();
//		System.out.println(right.toString()+" " + left.toString());
		for (int i = 0; i < rs.length(); i++){
			// Right rotate HarryP rryPHa
			char end = right.charAt(right.length() - 1);
			right.setLength(right.length() - 1);
			StringBuilder nrb = new StringBuilder();
			nrb.append(end);
			nrb.append(right);
//			System.out.println("new right "+nrb.toString());
			if (nrb.toString().equals(oS)){
				return true;
			}
			right = nrb;
			
			// Left roatate HarryP yPHarr | PyrraH rraHPy
			end = left.charAt(left.length() - 1);
                        left.setLength(left.length() - 1);
                        StringBuilder nlb = new StringBuilder();
			nlb.append(end);
                        nlb.append(left);
//			System.out.println("new left "+nlb.toString());
                        if (nlb.toString().equals(osL)){
                                return true;
                        }
                        left = nlb;			
		}
		return false;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String originalString = sc.nextLine();
		String rotatedString = sc.nextLine();
		System.out.println(isRotated(originalString, rotatedString));
	}

}
