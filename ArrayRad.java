class ArrayRad 
{
	private int maxDigits;
	private int base;
	private int maxItems;
	private int nItems;
	private long maxKey;
	
	long dataArray[];
	FirstLastList[] listArray;
//--------------------------------------------------------------------------------------
	ArrayRad(int maxD, int b, int n)
	{
		maxDigits = maxD;
		base = b;
		maxItems = n;
		nItems = 0;
		
		dataArray = new long[maxItems];
		listArray = new FirstLastList[base];
		
		for(int j = 0; j<base; j++)
			listArray[j] = new FirstLastList();
		
		maxKey = 0;
		for(int j = 0; j<maxDigits; j++)
			maxKey = (maxKey*base) + (base-1);
	}
//----------------------------------------------------------------------------------------
	public void display()
	{
		for(int j=0; j<maxItems; j++)
			System.out.print(dataArray[j] + " ");
		System.out.println("");
	}
//----------------------------------------------------------------------------------------
	public void insert(long value)
	{ dataArray[nItems++] = value; }
//-----------------------------------------------------------------------------------------
	public long getMaxKey()
	{ return maxKey; }
//----------------------------------------------------------------------------------------
	public void radixSort()
	{
		for(int pos=0; pos<maxDigits; pos++)
		{
			for(int j = 0; j<nItems; j++)
			{
				long dataItem = dataArray[j];
				int digit = getDigit(pos, dataItem);
				listArray[digit].insertLast(dataItem);
			}
			int index = 0;
			for(int j =0; j<base; j++)
			{
				while(!listArray[j].isEmpty())
				{
					long dataItem = listArray[j].deleteFirst();
					dataArray[index++] = dataItem;
				}
			}
			System.out.println("Sorted on position " + (pos+1) );
			display();
		}
	}
//-------------------------------------------------------------------------------------------
	private int getDigit(int position, long dataItem)
	{
		int digit = 0;
		for(int j=0; j<=position; j++)
		{
			digit = (int)(dataItem % base);
			dataItem = dataItem / base;
		}
		return digit;
	}
//-------------------------------------------------------------------------------------------
	public void convert8()
	{
		for(int j=0; j<maxItems; j++)
		{
			int num = (int) dataArray[j];
			int a = num%8;
			num = num/8;
			int b = (num%8) * 10;
			num = num/8;
			int c = (num%8) * 100;
			int done = c+b+a;
			System.out.print(done + " ");
		}
	}
}
