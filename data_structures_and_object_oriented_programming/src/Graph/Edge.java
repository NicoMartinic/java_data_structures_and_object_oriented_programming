package Graph;

/**
 * Represents an edge of a {@link Graph}
 */
public interface Edge<T> {
	
	public Vertex<T> targetVertex();
	public int weigth();

}
