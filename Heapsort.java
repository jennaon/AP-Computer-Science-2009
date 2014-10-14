/*Initially written by Yun Jung "Jenna" Lee in 3/30/2009 as a class assignment for AP Computer Science
*/
import java.util.*;

class HeapSort<E extends Comparable<E>>
{
	ArrayList<E> sorted;
	ArrayList<E> before;
	long ts;
	long tf;

	public ArrayList<E> getSortedList()
	{
		return sorted;
	}

	public long getSortingTime()
	{
		return tf-ts;
	}

	private void copy(List<E> list)
	{
		before = new ArrayList<E>();
		before.add(null);
		for(int i = 0; i<list.size(); i++)
		{
			add(list.get(i), before);
		}
	}

	protected void sort(List<E> list)
	{
		sorted = new ArrayList<E>();

		ts = System.currentTimeMillis();
		copy(list);

		int size= before.size();
		for(int i = 1; i<size; i++)
		{
			sorted.add(remove(before));
		}

		tf = System.currentTimeMillis();

	}

	private void add(E in, ArrayList<E> list)
	{
		list.add(in);
		upheap(list);
	}

	private E remove(ArrayList<E> list)
	{
		E root = list.get(1);
		list.set(1, list.get(list.size()-1));
		list.remove(list.size()-1);
		downheap(list);
		return root;
	}

	public E peek()
	{
		return sorted.get(1);
	}

	private void downheap(ArrayList<E> list)
	{
		int pointer = 1;
		int minchild;
		minchild=pointer*2;


		while(pointer < list.size() && minchild+1 < list.size())
		{
			
			if(list.get(minchild).compareTo(list.get(minchild+1))>0)
				minchild++;

			if(list.get(pointer).compareTo(list.get(minchild))>0)
			{
				E temp = list.get(pointer);
				list.set(pointer, list.get(minchild));
				list.set(minchild, temp);
			}
			pointer=minchild;
			minchild=pointer*2;

		}
	}

	private void upheap(ArrayList<E> list)
	{
		int pointer=list.size()-1;
		int parent;
		
		while(pointer != 1)
		{

			parent=(int)(pointer/2);	
			if(list.get(pointer).compareTo(list.get(parent))<0)
			{
				E temp = list.get(pointer);
				list.set(pointer, list.get(parent));
				list.set(parent, temp);
			}
			pointer=parent;
		}
	}
}

//quick이 제일 빠르다!
