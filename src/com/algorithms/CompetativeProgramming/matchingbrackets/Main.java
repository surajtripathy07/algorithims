import java.lang.*;

class Main
{

	public static void main(String args[]) throws java.lang.Exception
	{
		java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
	
		Integer.parseInt(r.readLine());
		String[] brackets = (r.readLine()).split(" ");

		int maxDepth = 0, posDepth = 0, btwnLen = 0, bStartPos = 0;

		int md = 0, sp = 0, blen = 0;

		for (int i = 0; i < brackets.length; i++)
		{
			if (md == 0)
			{
				blen = i - sp;
				if (blen > btwnLen)
				{
					btwnLen = blen;
					bStartPos = sp;
				}
				sp = i;
			}
			
			if (brackets[i].equals("1"))
			{
				md++;
			}
			else
			{
				md--;
			}

			if (md > maxDepth)
			{
				posDepth = i;
				maxDepth = md;
			}
		}
		// check end condition
		if (md == 0)
                {
                     blen = brackets.length - sp ;
                     if (blen > btwnLen)
                     {
                         btwnLen = blen;
                         bStartPos = sp;
                     }
                }
		System.out.println(maxDepth + " " +(posDepth+1)+" "+btwnLen+" "+(bStartPos+1));
	}
}
