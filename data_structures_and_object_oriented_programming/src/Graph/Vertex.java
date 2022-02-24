package Graph;

/**
 * Represents a Vertex of a graph.
 *
 */
public interface Vertex<T> {
	
	public T data();
	public void setData(T data);
	public int getPosition();

}
