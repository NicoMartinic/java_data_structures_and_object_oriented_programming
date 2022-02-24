package Graph;

import Structures.Generic_list;

/**
 * It represents the graph, where the structure as a whole is maintained.
 * 
 *
 */
public interface Graph<T> {

	/**
	 * Add a vertex to the Graph.
	 * Verify that the vertex does not exist in the Graph
	 * 
	 * @param v
	 */
	public void addVertex(Vertex<T> v);
	
	/**
	 * Delete the vertex of the Graph.
	 * In case the vertex has connections with other vertices, all its connections are eliminated.
	 * 
	 * @param v
	 */
	public void deleteVertex(Vertex<T> v);
	
	/**
	 * Connects the origin vertex with the destination vertex.
	 * Verifies that both vertices exist, otherwise it does not make any connection.
	 * 
	 * @param origin
	 * @param destiny
	 */
	public void connect(Vertex<T> origin, Vertex<T> destiny);
	
	/**	 
	* Connects the source vertex with the destination vertex with weight.
	* Verifies that both vertices exist, otherwise it does not make any connection
	*
	* @param origin
	* @param destiny
	* @param weight
	*/
	public void connect(Vertex<T> origin, Vertex<T> destiny, int weigth);
	
	/**
	 * Disconnects the source vertex with the destination.
	 * Verifies that both vertices exist, otherwise it does not perform any disconnection
	 * If the destination-->origin connection exists, it remains unchanged.
	 *
	 * @param origin
	 * @param destiny
	 */
	public void disconnect(Vertex<T> origin, Vertex<T> destiny);
	
	/**
	 * Returns true if source is adjacent to destination. false otherwise.
	 * 
	 * @param origin
	 * @param destiny
	 * @return
	 */
	public boolean isItAdjacent(Vertex<T> origin, Vertex<T> destiny);
	
	/**
	 * Returns the weight between two vertices.
	 * If it is not a weighted graph, it is convenient to use the isAdjacent method.
	 * 
	 * @param origin
	 * @param destiny
	 * @return
	 */
	public int weight(Vertex<T> origin, Vertex<T> destiny);

	
	/**
	 * Returns true if the graph does not contain any vertices. False otherwise.
	 * 
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Return the list of vertexs
	 * 
	 * @return
	 */
	public Generic_list<Vertex<T>> listOfVertex();
		
	/**
	 * Returns the list of neighbors of a vertex
	 * 
	 * @param v
	 * @return
	 */
	public Generic_list<Edge<T>> ListOfAdjacent(Vertex<T> v);
	
	/**
	 * Get a vertex given its position	 * 
	 * @param position
	 * @return
	 */
	public Vertex<T> vertex(int position);

}
