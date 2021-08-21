import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

// The adjacent vertices to a given vertex.
class Neighbors {
	List<Integer> neighbors = new ArrayList<Integer>();
	
	public static void main(String [] args) {
	}
	
	void add(int neighbor) {
		neighbors.add(neighbor);
	}
}

public class Graph {
	List<Neighbors> vertices1 = new ArrayList<Neighbors>();
	List<Neighbors> vertices2 = new ArrayList<Neighbors>();
	
	public static void main(String [] args) {
	}
	
	public void read_graph() {
		int num_lines_read = 0;
		boolean found_space = false; // false is we have not found the space yet separating the two graphs
		try {
		      File myObj = new File("graphs.dat");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
				if (num_lines_read == 0) {
					int num_vertices = Integer.parseInt(data);
					// Initialize the vertices
					for (int i = 0; i < num_vertices; i++) {
						vertices1.add(new Neighbors());
						vertices2.add(new Neighbors());
					}
				}
				else if (data.length() == 0) {
					System.out.println("New graph");
					found_space = true;
				}
				else {
					int start_vertex = Integer.parseInt(data.split(",")[0]);
					int end_vertex = Integer.parseInt(data.split(",")[1]);
					vertices1.get(start_vertex).add(end_vertex);
					vertices2.get(end_vertex).add(start_vertex);
				}
				num_lines_read++;
			}
		    myReader.close();
		} catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
	void display() {
	}
}