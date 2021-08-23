import java.util.*;

// The adjacent vertices to a given vertex.
class Neighbors {
	List<Integer> neighbors = new ArrayList<Integer>();
	
	public static void main(String [] args) {
	}
	
	void add(int neighbor) {
		neighbors.add(neighbor);
	}
	
	int get(int index) {
		return neighbors.get(index);
	}
	
	int size() {
		return neighbors.size();
	}
}

// Class for a full graph
public class Graph {
	List<Neighbors> vertices = new ArrayList<Neighbors>();
	List<Integer> codes = new ArrayList<Integer>();
	
	public static void main(String [] args) {
	}
	
	void add_vertex() {
		vertices.add(new Neighbors());
		codes.add(0);
	}
	
	void add_vertices(int num) {
		for(int i=0; i<num; i++) {
			add_vertex();
		}
	}
	
	void add_edge(int u, int v) {
		vertices.get(u).add(v);
		vertices.get(v).add(u);
	}
	
	int get_neighbor(int vertex, int nbd_num) {
		return vertices.get(vertex).get(nbd_num);
	}
	
	int apply_code(int vertex_num) {
		List<Integer> nbd_codes = new ArrayList<Integer>();
		for(int i=0; i<vertices.get(vertex_num).size(); i++) {
			int nbd_num = get_neighbor(vertex_num, i);
			nbd_codes.add(codes.get(nbd_num));
		}
		Collections.sort(nbd_codes);
		return nbd_codes.hashCode();
	}
	
	void apply_codes() {
		List<Integer> new_codes = new ArrayList<Integer>();
		for(int i=0; i<vertices.size(); i++) {
			new_codes.add(apply_code(i));
		}
		for(int i=0; i<vertices.size(); i++) {
			codes.set(i, new_codes.get(i));
		}
	}
	
	int overall_code() {
		List<Integer> copy_codes = new ArrayList<Integer>();
		for(int i=0; i<codes.size(); i++) {
			copy_codes.add(codes.get(i));
		}
		Collections.sort(copy_codes);
		return copy_codes.hashCode();
	}
	
	void display_codes() {
		for (int i=0; i<codes.size(); i++) {
			System.out.println(codes.get(i));
		}
	}
}