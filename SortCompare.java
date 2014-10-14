/*Written and tested by Yun Jung "Jenna" Lee originally on 4/16/2009
 * This code performs selection sort, insertion sort and merge sort for a randomly generated list and 
 * measures the time taken for each run. As a final output, the code compares three sorting algorithm in terms of speed. 
*/
import java.util.*;
import java.lang.*;

class SortCompare<E>
{
	List<E> list;

	public SortCompare()
	{
		list = new ArrayList<E>();
	}

	public void add(E e)
	{
		list.add(e);
	}

	public String toString()
	{
		return list.toString();
	}

	public void ranGenInteger(int n, int min, int max)
	{
		for (int i = 1; i <= n ; i++ )
		{
			list.add((E)new Integer((int)((max+1-min)*(Math.random()))+min));
		}
	}

	public void ranGenDouble(int n, double min, double max)
	{
		for (int i = 1; i<=n ; i++ )
		{
			list.add((E)new Double((max+1-min)*(Math.random())+min));
		}
	}

	public void ranGenString(int n, int length)
	{
		for (int i = 1; i <= n ; i++ )
		{
			char[] resp = new char[length];
			for (int j = 0; j<length ; j++ )
			{
				double det = Math.random();
				if (det>0.5)
				{
					resp[j]=(char)((int)(Math.random()*(91-65)+65));
				}
				else
				{
					resp[j]=(char)((int)(Math.random()*(123-97)+97));
				}
			}
			String t = new String(resp);
			list.add((E)t);
		}
	}

	private SortCompare<E> copy()
	{
		SortCompare<E> data = new SortCompare<E>();
		for (int i=0;i<list.size() ;i++ )
		{
			data.add(list.get(i));
		}
		return data;
	}

	public SortCompare<E> selectionSort()
	{
		SortCompare<E> data = new SortCompare<E>();
		data = copy();
		for (int i=0;i<data.list.size() ; i++ )
		{
			E min = data.list.get(i);
			int minIndex = i;
			for (int j = i; j < data.list.size() ; j++ )
			{
				if (((Comparable)data.list.get(j)).compareTo((Comparable)min)<0)
				{
					min = data.list.get(j);
					minIndex = j;
				}
			}
			swap(data, i, minIndex);
		}
		return data;
	}

	public long selectionSortTime() // Must be Modified; Copying Time should not be included
	{
		SortCompare<E> data = new SortCompare<E>();
		data = copy();
		long a = System.currentTimeMillis();
		for (int i=0;i<data.list.size() ; i++ )
		{
			E min = data.list.get(i);
			int minIndex = i;
			for (int j = i; j < data.list.size() ; j++ )
			{
				if (((Comparable)data.list.get(j)).compareTo((Comparable)min)<0)
				{
					min = data.list.get(j);
					minIndex = j;
				}
			}
			swap(data, i, minIndex);
		}
		long b = System.currentTimeMillis();
		return b-a;
	}

	private void swap(SortCompare<E> a, int i, int j)
	{
		E temp = a.list.get(i);
		a.list.set(i, a.list.get(j));
		a.list.set(j, temp);
	}

	public SortCompare<E> insertionSort()
	{
		SortCompare<E> data = new SortCompare<E>();
		data = copy();
		for (int i=1;i<data.list.size() ; i++ )
		{
			for (int j=i-1;j>=0 ; j-- )
			{
				if (((Comparable)data.list.get(j)).compareTo(((Comparable)data.list.get(i))) <= 0)
				{
					E res = data.list.remove(i);
					data.list.add(j+1, res);
					break;
				}
				else if (j==0)
				{
					E res = data.list.remove(i);
					data.list.add(0, res);
				}
			}
		}
		return data;
	}

	public long insertionSortTime()
	{
		SortCompare<E> data = new SortCompare<E>();
		data = copy();
		long a = System.currentTimeMillis();
		for (int i=1;i<data.list.size() ; i++ )
		{
			for (int j=i-1;j>=0 ; j-- )
			{
				if (((Comparable)data.list.get(j)).compareTo(((Comparable)data.list.get(i))) <= 0)
				{
					E res = data.list.remove(i);
					data.list.add(j+1, res);
					break;
				}
				else if (j==0)
				{
					E res = data.list.remove(i);
					data.list.add(0, res);
				}
			}
		}
		long b = System.currentTimeMillis();
		return b-a;
	}

	public SortCompare<E> mergeSort()
	{
		SortCompare<E> data = new SortCompare<E>();
		data = copy();
		data.doMergeSort(0, data.list.size()-1);
		return data;
	}

	public long mergeSortTime()
	{
		SortCompare<E> data = new SortCompare<E>();
		data = copy();
		long a = System.currentTimeMillis();
		data.doMergeSort(0, data.list.size()-1);
		long b = System.currentTimeMillis();
		return b-a;
	}

	private void doMergeSort(int left, int right) // left index ~ right index까지의 MyList를 MergeSort한다.
	{
		if (right-left!=0)
		{
			int div = (left+right)/2;
			doMergeSort(left, div);
			doMergeSort(div+1, right);

			int i = left;
			int j = div+1;
			
			while(i <= div && j <= right)
			{
				if (((Comparable)list.get(i)).compareTo((Comparable)list.get(j)) <=0)
				{
					list.add(list.get(i));
					i++;
				}
				else
				{
					list.add(list.get(j));
					j++;
				}
			}
			if (i!=div+1)
			{
				for (int t = i; t<=div ; t++ )
				{
					list.add(list.get(t));
				}
			}
			if (j!=right+1)
			{
				for (int t = j; t<=right ; t++ )
				{
					list.add(list.get(t));
				}
			}
			
			for (int k = right; k>=left ; k-- )
			{
				list.set(k, list.remove(list.size()-1));
			}
			
		}
	}
}
