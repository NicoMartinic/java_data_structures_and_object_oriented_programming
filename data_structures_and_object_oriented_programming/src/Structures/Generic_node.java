package Structures;

/* This class represents a linked list node. */

public class Generic_node<T> {
	private T data;
	private Generic_node<T> next;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Generic_node<T> getNext() {
		return next;
	}
	public void setNext(Generic_node<T> next) {
		this.next = next;
	}

}