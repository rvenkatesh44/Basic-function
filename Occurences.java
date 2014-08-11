import java.util.*;
class Occurences
{
	public static void main(String args[])
	{
		HashMap<String,Integer> hw = new HashMap<String,Integer>();

		
		String s[] = "The quick brown fox jumps over the lazy dog".split("");
		int occur=0,values;
		for(int i=0;i<s.length;i++)
		{    
			for(int j=0;j<s.length;j++)
			{
				if(s[i].equals(s[j]) && !(s[i].equals(" ")) && (!(hw.containsKey(s[i]))) )
				{
					occur++;
					hw.put(s[i],occur);
					
				}
				
			}

			occur=0;
		}

		Iterator iterator = hw.keySet().iterator();  
   
				while (iterator.hasNext()) {  
			   String key = iterator.next().toString();  
			   String value = hw.get(key).toString();  
			   
			   System.out.println(key + "  " + value);  
			}    

		}
}