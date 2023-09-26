package sample.SeleniumWeekDay8AMTambaram;

import java.util.ArrayList;
import java.util.LinkedHashSet;



public class FindtheLongestPrefix {
	
	String[] value = {"para","paper","param","pap","pepsi","peps"};
	
	public String getLongestCommonPrefix()
	{
		if(value.length==0)
			System.out.println("ther is no enough value in the array");
		String firstValue = value[0];
		for(String eachValue :value)
		{
			while(eachValue.indexOf(firstValue)!=0)
			{
				firstValue=firstValue.substring(0,firstValue.length()-1);
				
			}
			
		}
		return firstValue;
	}
	
	public void getLongestuniquePrefix()
	{
		LinkedHashSet<String> as = new LinkedHashSet<>();
		//if(value.length==0)
			//return "ther is no enough value in the array");
		
		for(int i=0;i<value.length;i++)
		{
			String firstValue = value[i];
			System.out.println("The i Value: "+firstValue);
			for(int j=0;j<value.length;j++)
			{
				String identified = "No";
				String nextValue = value[j];
				if(firstValue.equals(nextValue) && i!=j)
				{
					identified="yes";
					as.add(nextValue);
				}
				else
				{
					for(int k=0;k<nextValue.length();k++)
						
					//while(nextValue.indexOf(firstValue)!=0)
					{	
						nextValue=nextValue.substring(0,nextValue.length()-1);
						if(firstValue.equals(nextValue) &identified=="No")
						{
							as.add(nextValue);
							break;
						}
					}
				}
			}
			
		}
		System.out.println(as);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindtheLongestPrefix F = new FindtheLongestPrefix();
		//String V= F.getLongestCommonPrefix();
		//System.out.println(V);
		F.getLongestuniquePrefix();
		
	}

}
