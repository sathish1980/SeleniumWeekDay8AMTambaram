package sample.SeleniumWeekDay8AMTambaram;

public class SwapProgram {
	
	public void swapNumber(int[] number)
	{

		for(int i=0;i<number.length;i++)
		{
			for(int j=i+1;j<number.length;j++)
			{
			int temp=number[i];
			number[i]=number[j];
			number[j]=temp;
			}
			
		}
		for(int eachvalue : number)
		{
			System.out.print(eachvalue);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapProgram s = new SwapProgram();
		int[] a1 = {1,2,3,5,7};
		s.swapNumber(a1);
	}

}
