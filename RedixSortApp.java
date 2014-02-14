class RedixSortApp 
{
	public static void main(String[] args) 
	{
		int maxDigits = 3;
		int base = 8;
		int maxItems = 15;
		
		ArrayRad arr = new ArrayRad(maxDigits, base, maxItems);
		
		long maxKey = arr.getMaxKey();
		System.out.println("maxKey=" + maxKey);
		for(int j=0; j<maxItems; j++)
		{
			long n = (int)(java.lang.Math.random()*maxKey);
			arr.insert(n);
		}
		
		System.out.println("Unsorted array:");
		arr.display();
		System.out.println("");
		
		arr.radixSort();
		
		System.out.println("\nSorted array:");
		arr.display();
		
		System.out.println("Converting to base 8");
		arr.convert8();
	}
}
