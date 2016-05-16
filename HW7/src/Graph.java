import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;


/**
 * 
 * @author Patchara Pattiyathanee 5710546348
 * 30 Nov 2015
 *
 */
public class Graph {
    private final int V;
    private int E;
    private SList<Integer>[] adj;
    
    /**
     * Initializes an empty graph with V vertices and 0 edges.
     * param V the number of vertices
     */
    public Graph(int V) {
		//fill me in
    	this.V = V;
		this.E = 0;
		this.adj = (SList<Integer>[]) new SList[V];
		for (int i = 0; i < this.adj.length; i++) {
			this.adj[i] = new SList<Integer>();
		}
				
    }

    /**  
     * Initializes a graph by reading data from a file
     * The file format is the number of vertices V,
     * followed by the number of edges E,
     * followed by E pairs of vertices, with each entry separated by whitespace.
     */
    public Graph(Scanner in) {
		// fill me in
    	this(in.nextInt());
    	int temp = in.nextInt();
    	for (int i = 0; i < temp; i++) {
			int temp_v = in.nextInt();
			int temp_e = in.nextInt();
			this.addEdge(temp_v, temp_e);
		}
    	
    	
    }

    /**
     * Initializes a new graph that is a deep copy of G.
     */
    public Graph(Graph G) {
		// fill me in
    	 this.E = G.E();
    	 this.V = G.V();
    	 adj = new SList[V];
    	 for (int i = 0; i < V; i++) {
			this.adj[i] = new SList();
			Iterator<Integer> iter = G.adj(i).iterator();
			while(iter.hasNext()){
				adj[i].add(iter.next());
			}
		}
    }

    /**
     * Returns the number of vertices in the graph.
     */
    public int V() {
        // fill me in
    	return this.V;
    }

    /**
     * Returns the number of edges in the graph.
     */
    public int E() {
        // fill me in
    	return this.E;
    }

    // throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        // fill me in
    	if( v < 0 || v >= this.V ){
    		throw new IndexOutOfBoundsException() ;
    	}
    	
    }

    /**
     * Adds the undirected edge v-w to the graph.
     */
    public void addEdge(int v, int w) {
		// fill me in
    	this.validateVertex(v);
    	this.validateVertex(w);
    	this.E++;
    	adj[v].add(new Integer(w));
    	adj[w].add(new Integer(v));
    }


    /**
     * Returns the vertices adjacent to vertex v.
     */
    public Iterable<Integer> adj(int v) {
		// fill me in
    	this.validateVertex(v);
    	return adj[v];
    }

    /**
     * Returns the degree of vertex v.
     */
    public int degree(int v) {
		// fill me in
    	this.validateVertex(v);
    	return adj[v].size();
    }


    /**
     * Returns a string representation of the graph.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
		Scanner scanner;
		String CHARSET_NAME = "UTF-8";
		Locale LOCALE = Locale.US;
		File file = new File(args[0]);
		Graph G = null;
	    try {
            scanner = new Scanner(file, CHARSET_NAME);
            scanner.useLocale(LOCALE);
	        G = new Graph(scanner);
        }
        catch (IOException ioe) {
            System.err.println("Could not open " + file);
        }
		System.out.println(G);
		System.out.println("Make a deep copy and show:");
		System.out.println();
		Graph G1 = new Graph(G);
		System.out.println(G1);
    }

}