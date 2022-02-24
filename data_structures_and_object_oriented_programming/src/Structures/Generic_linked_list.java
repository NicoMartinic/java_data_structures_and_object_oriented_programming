package Structures;

public class Generic_linked_list<T> extends Generic_list<T> {
	/* first node of the list, if the list is empty, start is null */
	
	private Generic_node<T> start;

	/* current node that is updated as we go through the list, if the list is empty, current is null */
	
	private Generic_node<T> current;

	/* last node of the list, if the list is empty, end is null*/
	
	private Generic_node<T> end;

	/* amount of nodes in the list*/
	
	private int size;

	@Override
	public void begin() {
		current = start;
	}

	@Override
	public T next() {
		T elem = this.current.getData();
		this.current= this.current.getNext();
		return elem;
	}

	@Override
	public boolean end() {
		return (this.current == null);
	}

	@Override
	public T Element(int pos) {
		if (pos < 1 || pos > this.size) // not valid position
			return null;
		Generic_node<T> n = this.start;
		while (pos-- > 1)
			n = n.getNext();
		return n.getData();
	}

	@Override
	public boolean AddIn(T elem, int pos) {
		if (pos < 1 || pos > this.size + 1) // not valid position
			return false;
		this.size++;
		Generic_node<T> aux = new Generic_node<T>();
		aux.setData(elem);
		if (pos == 1) { // insert at the beginning
			aux.setNext(start);
			this.start = aux;
			if (size == 1) {
				this.end = this.start;
			}
		} else {
			Generic_node<T> n = this.start;
			Generic_node<T> ant = null;
			int currentPosition = 1;
			while (!(n == null) && (currentPosition < pos)) {
				ant = n;
				n = n.getNext();
				currentPosition++;
			}
			aux.setNext(n);
			ant.setNext(aux);

			if (aux.getNext() == null)
				this.end= aux;
		}
		return true;
	}

	@Override
	public boolean AddToTheBeginning(T elem) {
		Generic_node<T> aux = new Generic_node<T>();
		aux.setData(elem);

		if (this.start == null) {
			this.start = aux;
			this.current = aux;
			this.end = aux;
		} else {
			aux.setNext(this.start);
			this.start = aux;
		}
		this.size++;
		return true;
	}

	@Override
	public boolean AddToTheEnd(T elem) {
		Generic_node<T> aux = new Generic_node<T>();
		aux.setData(elem);
		if (this.start == null) {
			this.start = aux;
			this.current = aux;
			this.end = aux;
		} else {
			end.setNext(aux);
			end = aux;
		}
		size++;
		return true;
	}

	@Override
	public boolean Remove(T elem) {
		Generic_node<T> n = this.start;
		Generic_node<T> ant = null;
		while ((n != null) && (!n.getData().equals(elem))) {
			ant = n;
			n = n.getNext();
		}
		if (n == null)
			return false;
		else {
			if (ant == null)
				this.start = this.start.getNext();
			else
				ant.setNext(n.getNext());
			this.size--;
			return true;
		}
	}

	@Override
	public boolean DeleteIn(int pos) {
		if (pos < 1 || pos > this.size) // invalid position
			return false;
		this.size--;
		if (pos == 1) {
			this.start = this.start.getNext();
			return true;
		}
		Generic_node<T> n = this.start;
		Generic_node<T> ant = null;
		while (!(n == null) && (pos > 1)) {
			pos--;
			ant = n;
			n = n.getNext();
		}
		ant.setNext(n.getNext());
		if (ant.getNext() == null)
			this.end = ant;
		return true;
	}

	@Override
	public boolean Includes(T elem) {
		Generic_node<T> n = this.start;
		while (!(n == null) && !(n.getData().equals(elem)))
			n = n.getNext();
		return !(n == null);
	}

	@Override
	public String toString() {
		String str = "";
		Generic_node<T> n = this.start;
		while (n != null) {
			str = str + n.getData() + " -> ";
			n = n.getNext();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return str;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean IsEmpty() {
		return this.size() == 0;
	}

	@Override
	public boolean ReplaceAt(T elem, int pos) {
		if (pos < 1 || pos > this.size) // Invalid position
			return false;
		Generic_node<T> n = this.start;
		while (!(n == null) && (pos > 1)) {
			pos--;
			n = n.getNext();
		}
		n.setData(elem);
		return true;
	}

	@Override
	public Generic_list<T> Clone() {
		Generic_list<T> newList = new Generic_linked_list<T>();
		this.begin();
		while (!this.end()) {
			newList.AddToTheEnd(this.next());
		}
		return newList;
	}
	
	public boolean equals(Object o) {
		if (this==o)
			return true;
		Generic_linked_list<T> list = (Generic_linked_list<T>) o;
		for (int i=1; i<= list.size(); i++) {
			if (!list.Element(i).equals(this.Element(i)))
				return false;
		}
		return true;
		
	}

}
