package sample.SeleniumWeekDay8AMTambaram;

public class PermutationCombination {
	
	public void swap(int[] a, int i,int j)
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	public void permutation(int[]a , int startposition)
	{
		if(startposition==a.length-1)
		{
			printArray(a);
			return;
		}
		for(int i=startposition;i<a.length;i++)
		{
			swap(a,i,startposition);
			permutation(a , startposition+1);
			swap(a,i,startposition);
		}
	}
	
	public void printArray(int[] a)
{
	System.out.println("");
	for(int eachvalue : a)
	{
		System.out.print(eachvalue);
	}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationCombination p = new PermutationCombination();
		int[] per= {3,4,6,7};
		p.permutation(per,0);
	}

}
