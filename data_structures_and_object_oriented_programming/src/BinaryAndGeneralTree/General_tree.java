package BinaryAndGeneralTree;

import Structures.Generic_linked_list;
import Structures.Generic_list;
import Structures.Generic_queue;

public class General_tree<T> {

	private T data;

	private Generic_list<General_tree<T>> sons = new Generic_linked_list<General_tree<T>>();

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setSons(Generic_list<General_tree<T>> sons) {
		if (sons ==null)
			this.sons = new Generic_linked_list<General_tree<T>>();
		else
			this.sons = sons;
	}

	public General_tree(T data) {
		this.data = data;
	}

	public General_tree(T data, Generic_list<General_tree<T>> sons) {
		this(data);
		if (sons == null)
			this.sons = new Generic_linked_list<General_tree<T>>();
		else
			this.sons = sons;
	}

	public Generic_list<General_tree<T>> getSons() {
		return this.sons;
	}

	public void addSon(General_tree<T> son) {

		this.getSons().AddToTheEnd(son);
	}

	public boolean isLeaf() {

		return !this.hasSons();
	}
	
	public boolean hasSons() {
		return !this.sons.IsEmpty();
	}
	
	public boolean isEmpty() {

		return this.data == null && !this.hasSons();
	}

	

	public void deleteSon(General_tree<T> hijo) {
		if (this.hasSons()) {
			Generic_list<General_tree<T>> sons = this.getSons();
			if (sons.Includes(hijo)) 
				sons.Remove(hijo);
		}
	}
	
	public void pre_Order() {
		 System.out.println(this.getData());
		 Generic_list<General_tree<T>> lsons = this.getSons();
		 lsons.begin();
		 while (!lsons.end()) {
			 lsons.next().pre_Order();
		 }
	}
	
	public void post_Order() {
		 Generic_list<General_tree<T>> lsons = this.getSons();
		 lsons.begin();
		 while (!lsons.end()) {
			 lsons.next().post_Order();
		 }
		System.out.println(this.getData());
	}
	
	public void by_level() {
		Generic_queue<General_tree<T>> queue = new Generic_queue<General_tree<T>>();
		queue.queue(this);
		queue.queue(null);
		while(!queue.isEmpty()) {
			General_tree<T> a  =  queue.dequeue();
			if(a != null) {
				System.out.print(a.getData()+ " ");
				Generic_list<General_tree<T>> sons = a.getSons();
				sons.begin();
				while(!sons.end()) {
					General_tree<T> h = sons.next();
					queue.queue(h);
				}
			}
			else if (!queue.isEmpty()) {
				System.out.println();
				queue.queue(null);
			}
		}
	}
	
	public Integer height() {
		if (!this.isEmpty()) {
			if(this.isLeaf()) 
				return 0;
			else {
				Generic_list<General_tree<T>> sons = this.getSons();
				General_tree<T> oneSon = null;
				int max = 0;
				int height = 0;
				sons.begin();
				while (!sons.end()) {
					oneSon = sons.next();
					height = oneSon.height();
					if(max < height)
						max = height;
				}
				return 1 + max;
			}
		}
		return -1;
	}

	public Integer level(T data) {
		Generic_queue<General_tree<T>> queue = new Generic_queue<General_tree<T>>();
		queue.queue(this);
		queue.queue(null);
		int level = 0;
		while(!queue.isEmpty()) {
			General_tree<T> a  =  queue.dequeue();
			if(a != null) {
				if(a.getData() == data)
					return level;
				Generic_list<General_tree<T>> hijos = a.getSons();
				hijos.begin();
				while(!hijos.end()) {
					General_tree<T> h = sons.next();
					queue.queue(h);
				}
			}
			else if (!queue.isEmpty()) {
				level++;
				System.out.println();
				queue.queue(null);
			}
		}
		return -1;
	}

	public Integer wide() {
		if (this.isEmpty()) {
			return 0;
		}
			if(this.isLeaf()) {
				return 1;
			}
			else {
				Generic_queue<General_tree<T>> queue = new Generic_queue<General_tree<T>>();
				queue.queue(this);
				queue.queue(null);
				int max = 0;
				int wide = 0;
				while(!queue.isEmpty()) {
					General_tree<T> a  =  queue.dequeue();
					if(a != null) {
						wide++;
						Generic_list<General_tree<T>> sons = a.getSons();
						sons.begin();
						while(!sons.end()) {
							General_tree<T> h = sons.next();
							queue.queue(h);
						}
					}
					else if (!queue.isEmpty()) {
						if (max < wide)
							max = wide;
						queue.queue(null);
						wide = 0;
					}
				}
				return max;
			}
	}

}