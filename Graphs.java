import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Graphs {
	Graph graph1 = new Graph();
	Graph graph2 = new Graph();
	int num_vertices = 0;
	
	public static void main(String [] args) {
	}
	
	public boolean read_data(String file_name) {
		int num_lines_read = 0;
		boolean found_space = false; // false is we have not found the space yet separating the two graphs
		try {
		      File myObj = new File(file_name);
			  if (!myObj.exists()) {
			  	System.out.println("That file cannot be found.");
				return false;
			  }
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
				if (num_lines_read == 0) {
					num_vertices = Integer.parseInt(data);
					// Initialize the vertices
					graph1.add_vertices(num_vertices);
					graph2.add_vertices(num_vertices);
				}
				else if (data.length() == 0) {
					found_space = true;
				}
				else {
					int start_vertex = Integer.parseInt(data.split(",")[0]);
					int end_vertex = Integer.parseInt(data.split(",")[1]);
					if (found_space) {
						graph2.add_edge(start_vertex, end_vertex);
					}
					else {
						graph1.add_edge(start_vertex, end_vertex);
					}
				}
				num_lines_read++;
			}
		    myReader.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		return true;
	}
	
	public void apply_codes() {
		for (int i=0; i<num_vertices; i++) {
			graph1.apply_codes();
			graph2.apply_codes();
		}
	}
	
	void display() {
		if (graph1.overall_code() == graph2.overall_code()) {
			System.out.println("The two graphs pass the Weisfeiler-Lehman test. They might be isomorphic.");
		}
		else {
			System.out.println("The two graphs fail the Weisfeiler-Lehman test. They are not isomorphic.");
		}
	}
}