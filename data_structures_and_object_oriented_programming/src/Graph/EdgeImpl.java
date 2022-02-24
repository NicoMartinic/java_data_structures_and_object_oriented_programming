package Graph;


public class EdgeImpl<T> implements Edge<T> {
	private Vertex<T> destiny;
	private int weigth;
	
	public EdgeImpl(Vertex<T> dest, int p){
		destiny = dest;
		weigth = p;
	}
	
	@Override
	public Vertex<T> targetVertex() {
		return destiny;
	}

	@Override
	public int weigth() {
		return weigth;
	}

}
