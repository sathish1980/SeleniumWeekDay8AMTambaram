package sample.SeleniumWeekDay8AMTambaram;

import java.util.LinkedHashSet;

public class Concecutiverepereatedcharc {
	
	public void conce(String value)
	{
		char[] convertTochar = value.toCharArray();
		boolean identified = false; 
		LinkedHashSet<String> ls = new LinkedHashSet<>();
		for (int i=0;i<convertTochar.length;i++)
		{
			int count=1;
			if(!ls.contains(String.valueOf(convertTochar[i])))
			{
			for(int j=i+1;j<convertTochar.length;j++)
			{
				if(convertTochar[i]==convertTochar[j])
				{
					count= count+1;
					identified=true;
					ls.add(String.valueOf(convertTochar[i]));
				}
				else
				{
					break;
				}
				
			}
		}
			
			if(identified && count !=1)
			{
			System.out.print(convertTochar[i]+""+count);
			}
			
		}
	}
	
	public void anotherconce(String value)
	{
	
		char[] convertTochar = value.toCharArray();
		int count =1;
		for (int i=0;i<convertTochar.length;i++)
		{
			
			for (int j=i+1;j<convertTochar.length;j++)
			{
				if(convertTochar[i]==convertTochar[j])
				{
					count= count+1;
				}
				else
				{
					i=j-1;
					break;
				}
			}
		if(count>1)
		{
				System.out.print(convertTochar[i]+""+count);
				count=1;
		}	
		}
	}
	
	public void repetcharc(String value) 
	{
		char[] chararray = value.toCharArray();
		for(int i=0;i<chararray.length;i++)
		{
			if(Character.isDigit(chararray[i]))
			{
				int a = Integer.parseInt(String.valueOf(chararray[i]));
				for(int j=1;j<=a;j++)
				{
					System.out.print(chararray[i-1]);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Concecutiverepereatedcharc c = new Concecutiverepereatedcharc();
		//c.anotherconce("saathhiiishkkaaastt");
		c.repetcharc("a2s3d1e4");
	}

}
