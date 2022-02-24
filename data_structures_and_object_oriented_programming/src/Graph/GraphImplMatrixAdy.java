/**
 * 
 */
package Graph;

import Structures.Generic_linked_list;
import Structures.Generic_list;

/**
 * Implementation of the graph with matrix
 * 
 *
 */
public class GraphImplMatrixAdy<T> implements Graph<T> {
    private int maxVertex;
    Generic_list<Vertex<T>> vertex;
    int[][] matrixAdy;

    public GraphImplMatrixAdy(int maxVert) {
        // To be list compatible the array starts at 1
        maxVertex = maxVert;
        vertex = new Generic_linked_list<Vertex<T>>();
        matrixAdy = new int[maxVertex + 1][maxVertex + 1];
        for (int i = 1; i <= maxVertex; i++) {
            for (int j = 0; j < maxVertex; j++) {
                matrixAdy[i][j] = 0;
            }
        }
    }

    @Override
    public void addVertex(Vertex<T> v) {
        if (!vertex.Includes(v)) {
        	vertex.AddToTheEnd(v);
            ((VertexImplMatrixAdy<T>) v).setPosition(vertex.size());
        }
    }

    @Override
    public void deleteVertex(Vertex<T> v) {

        int index = ((VertexImplMatrixAdy<T>) v).getPosition();
        // delete row
        for (int row = index; row <= vertex.size(); row++) {
            matrixAdy[row] = matrixAdy[row + 1];
        }
        // delete column
        for (int row = 0; row <= vertex.size(); row++) {
            for (int column = index; column < vertex.size(); column++) {
                matrixAdy[row][column] = matrixAdy[row][column + 1];
            }
        }
        vertex.Remove(v);
    }

    @Override
    public void connect(Vertex<T> origin, Vertex<T> destiny) {
        connect(origin, destiny, 1);

    }

    @Override
    public void connect(Vertex<T> origin, Vertex<T> destiny, int weight) {
        matrixAdy[((VertexImplMatrixAdy<T>) origin).getPosition()][((VertexImplMatrixAdy<T>) destiny)
            .getPosition()] = weight;
    }

    @Override
    public void disconnect(Vertex<T> origin, Vertex<T> destiny) {
        matrixAdy[((VertexImplMatrixAdy<T>) origin).getPosition()][((VertexImplMatrixAdy<T>) destiny).getPosition()] = 0;
    }

    @Override
    public boolean isItAdjacent(Vertex<T> origin, Vertex<T> destiny) {
        return matrixAdy[((VertexImplMatrixAdy<T>) origin).getPosition()][((VertexImplMatrixAdy<T>) destiny)
            .getPosition()] > 0;
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
        return matrixAdy[((VertexImplMatrixAdy<T>) origin).getPosition()][((VertexImplMatrixAdy<T>) destiny)
            .getPosition()];
    }

    @Override
    public Generic_list<Edge<T>> ListOfAdjacent(Vertex<T> v) {
        Generic_list<Edge<T>> ady = new Generic_linked_list<Edge<T>>();
        int vertexPos = ((VertexImplMatrixAdy<T>) v).getPosition();
        Edge<T> edge;
        for (int i = 1; i <= vertex.size(); i++) {
            if (matrixAdy[vertexPos][i] > 0) {
                edge = new EdgeImpl<T>(vertex.Element(i), matrixAdy[vertexPos][i]);
                ady.AddToTheEnd(edge);
            }
        }
        return ady;
    }

    @Override
    public Vertex<T> vertex(int position) {
        return vertex.Element(position);
    }

}
