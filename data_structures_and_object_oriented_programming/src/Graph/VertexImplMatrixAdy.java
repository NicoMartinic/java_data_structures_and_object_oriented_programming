
package Graph;

public class VertexImplMatrixAdy<T> implements Vertex<T> {
	private T data;
	private int position;
	
	public VertexImplMatrixAdy(T d) {
		data = d;
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

	public void setPosition(int position) {
		this.position = position;
	}

}
