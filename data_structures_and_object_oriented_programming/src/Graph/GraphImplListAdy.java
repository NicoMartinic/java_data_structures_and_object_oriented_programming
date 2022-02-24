package Graph;

import Structures.Generic_linked_list;
import Structures.Generic_list;

/**
 * Implementation of the graph with list of adyacentes
 *
 */

public class GraphImplListAdy<T> implements Graph<T> {
	Generic_list<Vertex<T>> vertex = new Generic_linked_list<Vertex<T>>();


	@Override
	public void addVertex(Vertex<T> v) {
		if(!vertex.Includes(v)){
			vertex.AddToTheEnd(v);
			((VertexImplListAdy<T>) v).setPosition(vertex.size());
		}
	}

	public void deleteVertex(Vertex<T> v) {
		int index = ((VertexImplListAdy<T>)v).getPosition();
		if(index >=0){
			Vertex<T> vert;
			vertex.begin();
			while(!vertex.end()){
				vert = vertex.next();
				disconnect(vert, v);
			}
			
			boolean exit = false;
			vertex.begin();
			while(!vertex.end() && !exit){
				vert = vertex.next();
				if(vert.equals(v)){
					vertex.Remove(vert);
					exit = true;
				}
			}

			for(;index<vertex.size();index++){
				vert = vertex.Element(index);
				((VertexImplListAdy<T>)vert).setPosition(vert.getPosition()-1);
			}
		}
	}

	public void connect(Vertex<T> origin, Vertex<T> destiny) {
		((VertexImplListAdy<T>) origin).connect(destiny);
	}

	public void connect(Vertex<T> origin, Vertex<T> destiny, int weigth) {
		((VertexImplListAdy<T>) origin).connect(destiny,weigth);
	}

	@Override
	public void disconnect(Vertex<T> origin, Vertex<T> destiny) {
		((VertexImplListAdy<T>) origin).disconnect(destiny);
	}

	@Override
	public boolean isItAdjacent(Vertex<T> origen, Vertex<T> destiny) {
		return ((VertexImplListAdy<T>) origen).isItAdjacent(destiny);
	}

	@Override
	public boolean isEmpty() {
		return vertex.IsEmpty();
	}

	@Override
	public Generic_list<Vertex<T>> listOfVertex() {
		return vertex;
	}

	@Override
	public int weight(Vertex<T> origin, Vertex<T> destiny) {
		return ((VertexImplListAdy<T>) origin).weight(destiny);
	}
	
    @Override
	public Generic_list<Edge<T>> ListOfAdjacent(Vertex<T> v){
		return ((VertexImplListAdy<T>) v).getAdjacent();
	}
	
    @Override
	public Vertex<T> vertex(int position){
		return vertex.Element(position);
	}



}