public class Solution {
	public int strStr(final String haystack, final String needle) {
	    if (haystack.isEmpty() && needle.isEmpty()){
	        return -1;
	    } else if (haystack.isEmpty()){
	        return 0;
	    } else if (needle.isEmpty()){
	        return -1;
	    }
	    
	    // len based checks
	    if (needle.length() > haystack.length()){
	        return -1;
	    } else if (needle.length() == haystack.length()){
	        return verify(0, needle.length() - 1, haystack, needle);
	    }
	    
	    int nCount = 0;
	    int index = -1;
	    int prime = 7919;
	    int base = 12;
	    int patternHash = getHash(needle, prime, base);
	    StringBuilder b = new StringBuilder();
	    for (int i = 0 ; i < needle.length(); i++){
	        b.append(haystack.charAt(i));
	    }
	    int firstHash = getHash(b.toString(), prime, base);
	    //System.out.println("first hash is "+firstHash);
	    if (firstHash == patternHash){
	        int ret = verify(0, needle.length() - 1, haystack, needle);
	        if (ret == 0){
	            return 0;
	        }
	    }
	    
	    int rollingHash = firstHash;
	    //System.out.println("rolling hash is "+rollingHash);
	    for (int i = 1; i <= haystack.length() - needle.length(); i++){
	        rollingHash = getRollingHash(haystack.charAt(i-1), rollingHash, 
	        haystack.charAt(i + needle.length() - 1), prime, base, needle); 
	        //System.out.println("rolling hash is "+rollingHash+" and pattern hash is "+patternHash);
	        if (rollingHash == patternHash){
	            int ret = verify(i, i + needle.length() - 1, haystack, needle);
    	        if (ret == 0){
    	            return i;
    	        }
	        }
	    }
	    return -1;
	}
	
	public int verify(int start, int end, String haystack, String needle){
	    int pos = 0;
	    for (int i = start; i <= end; i++){
	        if (haystack.charAt(i) != needle.charAt(pos++)){
	            return -1;
	        }
	    }
	    return 0;
	}
	
	public int getHash(String value, int prime, int base){
	    Integer hashVal = 0;
	    for (int i = 0; i < value.length(); i++){
	        int alphabase = getAlphVal(value.charAt(i));
	        String character = String.valueOf(value.charAt(i));
	        hashVal += (((alphabase) % prime) * (int)((long)Math.pow(base, 2) % prime)) % prime;;
	    }
	    return hashVal;
	}
	
	public int getRollingHash(Character S0, int SiHash, Character Si1, int prime, int base, String pattern){
    	
	    Integer old1stHash = (((getAlphVal(S0)) % prime) * (int)((long)Math.pow(base, 2) % prime)) % prime;
	    Integer newHash = (((getAlphVal(Si1)) % prime) * (int)((long)Math.pow(base, 2) % prime)) % prime;
	    
	    return SiHash - old1stHash + newHash;
	}
	
	public int getAlphVal(Character c){
	    int alpVal = (int)c;
        int alphabase = -1;
	    if ((int)'a' <= alpVal && alpVal <= 'z'){
            alphabase = alpVal - (int)'a' + 1;
        } else if ((int)'A' <= alpVal && alpVal <= 'Z'){
            alphabase = alpVal - (int)'A' + 1 + 26;
        }
        return alphabase;
	}
	
	
}

