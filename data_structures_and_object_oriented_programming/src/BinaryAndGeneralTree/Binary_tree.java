package BinaryAndGeneralTree;

import Structures.Generic_queue;

public class Binary_tree<T> {
	private T data;
	private Binary_tree<T> leftSon;   
	private Binary_tree<T> rightSon; 

	
	public Binary_tree() {
		super();
	}

	public Binary_tree(T data) {
		this.data = data;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Ask before invoking getLeftSon/getRightSon()
	 * @return
	 */
	public Binary_tree<T> getLeftSon() {
		return this.leftSon;
	}

	public Binary_tree<T> getRightSon() {
		return this.rightSon;

	}

	public void AddLeftSon(Binary_tree<T> son) {
		this.leftSon = son;
	}

	public void AddRightSon(Binary_tree<T> son) {
		this.rightSon = son;
	}

	public void deleteLeftSon() {
		this.leftSon = null;
	}

	public void deleteRightSon() {
		this.rightSon = null;
	}

	public boolean isEmpty() {
		return this.getData() == null && !this.hasLeftSon() && !this.hasRightSon();
	}

	public boolean isLeaf() {
		return (!this.hasLeftSon() && !this.hasRightSon());

	}

	@Override
	public String toString() {
		return this.getData().toString();
	}

	 
	public boolean hasLeftSon() {
		return this.leftSon!=null;
	}

	 
	public boolean hasRightSon() {
		return this.rightSon!=null;
	}

	

	public boolean isFull() {
		 Binary_tree<T> tree = null;
		 Generic_queue<Binary_tree<T>> queue = new Generic_queue<Binary_tree<T>>();
		 boolean full = true;
		 queue.queue(this);
		 int cant_nodes=0;
		 queue.queue( null);
		 int level = 0;
		 while (!queue.isEmpty() && full) {
			 tree = queue.dequeue();
			 if (tree != null) {
				 System. out.print(tree.getData() + " ");
				 if(tree.hasLeftSon()) {
					 if (!tree.getLeftSon().isEmpty()) {
						 queue.queue(tree.getLeftSon());
						 cant_nodes++;
						 } 
				 }
				 if(tree.hasRightSon()) {
				 	if (!tree.getRightSon().isEmpty()) {
						 queue.queue(tree.getRightSon());
						 cant_nodes++;
						 }
				 }
			 		} else if (!queue.isEmpty()) {
						 if (cant_nodes == Math.pow(2, ++level)){
							 queue.queue( null);
							 cant_nodes = 0;
							 System. out.println();
						 }
						 else full = false;}
		 				}
		 return full;
		}
	
	public boolean isFullWithoutPrint() {
		 Binary_tree<T> tree = null;
		 Generic_queue<Binary_tree<T>> queue = new Generic_queue<Binary_tree<T>>();
		 boolean full = true;
		 queue.queue(this);
		 int cant_nodes=0;
		 queue.queue( null);
		 int level = 0;
		 while (!queue.isEmpty() && full) {
			 tree = queue.dequeue();
			 if (tree != null) {
				 if(tree.hasLeftSon()) {
				 if (!tree.getLeftSon().isEmpty()) {
					 queue.queue(tree.getLeftSon());
					 cant_nodes++;
					 } 
				 }
				 if(tree.hasRightSon()) {
				 	if (!tree.getRightSon().isEmpty()) {
						 queue.queue(tree.getRightSon());
						 cant_nodes++;
						 }
				 }
			 		} else if (!queue.isEmpty()) {
						 if (cant_nodes == Math.pow(2, ++level)){
							 queue.queue( null);
							 cant_nodes = 0;
						 }
						 else full = false;}
		 				}
		 return full;
		}

	public void printPreorder() {
		System.out.println(this.getData());
		if(this.hasLeftSon()) {
			this.getLeftSon().printPreorder();
		}
		if(this.hasRightSon()) {
			this.getRightSon().printPreorder();
		}
	}
	
	public int amountOfLeafs() {
		int leafs = 0;
		int leafs1 = 0;
		if (this.isEmpty()) {
			return 0;
		}
		else if(this.isLeaf()) {
				return 1;
			}
		else {
			if(this.hasLeftSon()) {
				leafs = this.getRightSon().amountOfLeafs();
			}
			if(this.hasRightSon()) {
				leafs1 = this.getRightSon().amountOfLeafs();
			}
		}
		return leafs + leafs1;
	}
	
	public void betweenLevels( int min, int max) {
		if ((min >= 0) && (min <= max)) {
			Binary_tree<T> a = null;
			Generic_queue<Binary_tree<T>> queue = new Generic_queue<Binary_tree<T>>();
			queue.queue(this);
			queue.queue(null);
			int level = 0;
			while((!queue.isEmpty()) && (level <= max)) {
				a =  queue.dequeue();
				if(a != null) {
					if ((level >= min) && (level <= max))
						System.out.print(a.getData()+ " ");
					if(a.hasLeftSon())
						queue.queue(a.getLeftSon());
					if(a.hasRightSon()) 
						queue.queue(a.getRightSon());
				}
				else if (!queue.isEmpty()) {
					System.out.println();
					level++;
					queue.queue(null);
				}
			}
		}
	}
	
}

