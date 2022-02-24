package Structures;

public class Generic_heap<T> {
	private Generic_list<T> l = new Generic_linked_list<T>();
	
	public void stack (T data) {
		l.AddToTheBeginning(data);
	}
	public T unstack (T data) {
		T data1 = l.Element(1);
		l.DeleteIn(1);
		return data1;
	}
	public T top () {
		return l.Element(1);
	}
	public boolean isEmpty () {
		return l.IsEmpty();
	}
}
