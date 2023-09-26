package sample.SeleniumWeekDay8AMTambaram;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class uniqueValue {
	
	public void uniqueValues(String eachValue)
	{
	
		char[] convertToArray = eachValue.toCharArray();
		LinkedHashSet<Character> l =new LinkedHashSet<>();
		for(char eachValues : convertToArray)
		{
			if(l.contains(eachValues))
			{
				l.remove(eachValues);
			}
			else
			{
			l.add(eachValues);
			}
		}
		
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		uniqueValue u = new uniqueValue();
		u.uniqueValues("abcdbefggd");
	}

}
