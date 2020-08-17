import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        		String String = br.readLine();    
		String Pattern = br.readLine();   
		
		ArrayList<Integer> list = KMP(String, Pattern);              
		System.out.println(list.size());                        
        
		for(int i=0; i<list.size(); i++) {                      
			System.out.print(list.get(i)+1+" ");
		}
		
	}
	
	public static int[] getPi(String pattern) {  
		int patternLen = pattern.length();     
		int []pi = new int[patternLen];                              
		
		for(int i=1, j=0; i<patternLen; i++) {      
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) { 
				j = pi[j-1];                                        
			}if(pattern.charAt(i) == pattern.charAt(j)) {            
				pi[i] = ++j;                                         
			}
		}
		return pi;     
	}
	

	public static ArrayList<Integer> KMP(String str, String pattern) { 
		ArrayList<Integer> list = new ArrayList<>();     
		int [] pi = getPi(pattern);                                    
		int strLen = str.length();
		int patternLen = pattern.length();              
		int j = 0;                                        
		
		for(int i=0; i<strLen; i++) {                  
			while(j > 0 && str.charAt(i)!= pattern.charAt(j)) {    
				j = pi[j-1];                                      
			}if(str.charAt(i)== pattern.charAt(j)) {               
				if(j== patternLen-1) {                           
					list.add(i-patternLen+1);                   
					j = pi[j];                                   
				}else {                                   
					j++;                                  
				}
			}
		}
		return list;                                       
	}
}
