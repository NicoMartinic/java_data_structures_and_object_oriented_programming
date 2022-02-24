package Graph;

import Structures.Generic_linked_list;
import Structures.Generic_list;

public class VertexImplListAdy<T>
    implements Vertex<T> {
    private T data;
    private int position;
    private Generic_list<Edge<T>> adjacent;

    public VertexImplListAdy(T d) {
        data = d;
        adjacent = new Generic_linked_list<Edge<T>>();
    }

    @Override
    public T data() {
        return this.data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int getPosition() {
        return position;
    }

    public Generic_list<Edge<T>> getAdjacent() {
        return adjacent;
    }

    public void connect(Vertex<T> v) {
        connect(v, 1);
    }

    public void connect(Vertex<T> v, int weight) {
        Edge<T> edge = getEdge(v);

        if (edge == null) {
            Edge<T> a = new EdgeImpl<T>(v, weight);
            adjacent.AddToTheEnd(a);
        }
    }

    public void disconnect(Vertex<T> v) {
        Edge<T> edge = getEdge(v);

        if (edge != null) {
            adjacent.Remove(edge);
        }
    }

    public boolean isItAdjacent(Vertex<T> v) {
        Edge<T> edge = getEdge(v);

        return edge != null;
    }

    public int weight(Vertex<T> v) {
        Edge<T> edge = getEdge(v);

        int ret = 0;
        if (edge != null) {
            ret = edge.weigth();
        }

        return ret;
    }

    private Edge<T> getEdge(Vertex<T> v) {
        Edge<T> edge = null;
        Edge<T> auxEdge;
        adjacent.begin();
        while (!adjacent.end()) {
            auxEdge = adjacent.next();
            if (auxEdge.targetVertex() == v) {
                edge = auxEdge;
            }
        }
        return edge;
    }

    public void setPosition(int pos) {
        position = pos;
    }

}
