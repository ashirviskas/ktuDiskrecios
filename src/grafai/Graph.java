/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafai;

/**
 *
 * @author Matas
 */
import java.util.*;


public class Graph {
    private int score;
    private HashMap<Integer, Vertex> vertices;
    private HashMap<Integer, Edge> edges;
    
    public Graph(){
        this.vertices = new HashMap<Integer, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
    }
    
   
    public Graph(ArrayList<Vertex> vertices){
        this.vertices = new HashMap<Integer, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
        
        for(Vertex v: vertices){
            this.vertices.put(v.getNumber(), v);
        }
        
    }
    
   
    public boolean addEdge(Vertex one, Vertex two){
        return addEdge(one, two, 1);
    }
    
    
    public boolean addEdge(Vertex one, Vertex two, int weight){
        if(one.equals(two)){
            return false;   
        }
       
        //ensures the Edge is not in the Graph
        Edge e = new Edge(one, two, weight);
        if(edges.containsKey(e.hashCode())){
            return false;
        }
       
        //and that the Edge isn't already incident to one of the vertices
        else if(one.containsNeighbor(e) || two.containsNeighbor(e)){
            return false;
        }
            
        edges.put(e.hashCode(), e);
        one.addNeighbor(e);
        two.addNeighbor(e);
        return true;
    }
    
    public boolean containsEdge(Edge e){
        if(e.getOne() == null || e.getTwo() == null){
            return false;
        }
        
        return this.edges.containsKey(e.hashCode());
    }
    
    
    public Edge removeEdge(Edge e){
       e.getOne().removeNeighbor(e);
       e.getTwo().removeNeighbor(e);
       return this.edges.remove(e.hashCode());
    }
    

    public boolean containsVertex(Vertex vertex){
        return this.vertices.get(vertex.getNumber()) != null;
    }
    
    public Vertex getVertex(Integer number){
        return vertices.get(number);
    }
    

    public boolean addVertex(Vertex vertex, boolean overwriteExisting){
        Vertex current = this.vertices.get(vertex.getNumber());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }
            
            while(current.getNeighborCount() > 0){
                this.removeEdge(current.getNeighbor(0));
            }
        }
        
        
        vertices.put(vertex.getNumber(), vertex);
        return true;
    }
    

    public Vertex removeVertex(Integer number){
        Vertex v = vertices.remove(number);
        
        while(v.getNeighborCount() > 0){
            this.removeEdge(v.getNeighbor((0)));
        }
        
        return v;
    }
    
 
    public Set<Integer> vertexKeys(){
        return this.vertices.keySet();
    }
    

    public Set<Edge> getEdges(){
        return new HashSet<Edge>(this.edges.values());
    }
    public boolean allVerticesHaveNeighbours()
    {
        boolean result = true;
        for (Vertex vertex: this.vertices.values()) {
                    if (vertex.getNeighbors().size() < 2)
                        return false;
        }       
        return result;        
    }
    public boolean isConnected(Vertex start)
    {
        int[] prec = new int[this.vertices.size()];
        Vertex current = start;
        int n = 0;
        ArrayList<Edge> unvisited = start.getNeighbors();
        while(!unvisited.isEmpty() || !current.equals(start))
        {
            if(!unvisited.isEmpty()){
                Vertex next = unvisited.get(0).getNeighbor(current);
                prec[next.getNumber()]=current.getNumber();
            }
            /*unvisited = vertex.getNeighbors();
            for (int i = 0; i < vertex.getNeighborCount(); i++)
            {
                unvisited.remove(vertex.getNeighbor(i));
            }*/
        }
        return false;
    }
    public void setGraphScore()
    {
        int score = 0;
        for (Edge edge:this.edges.values())
        {
            score+=edge.getWeight();
        }
        this.score = score;
    }
    public Graph[] getTwoConnectedGraphs()
    {
        Graph[] graphs = new Graph[2];
        //ArrayList<Edge> edges = new ArrayList<Edge>();
        Graph temp = new Graph();
        for (Vertex vertex:this.vertices.values())
        {
            
        }
        return graphs;
    }
    
}
