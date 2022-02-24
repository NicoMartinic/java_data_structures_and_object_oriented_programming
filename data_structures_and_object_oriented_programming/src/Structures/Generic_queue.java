package Structures;

public class Generic_queue <T> {
	private Generic_list<T> l = new Generic_linked_list<T>();
	
	public void queue(T data) {
		l.AddToTheEnd(data);
	}
	public T dequeue(){
		T data1 = l.Element(1);
		l.DeleteIn(1);
		return data1;
	} 
	public T tope() {
		T dato1 = l.Element(l.size());
		return dato1;
	}
	public boolean isEmpty() {
		return l.IsEmpty();
	}
	

}

