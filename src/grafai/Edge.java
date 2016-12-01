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

public class Edge implements Comparable<Edge> {

    private Vertex one, two;
    private int weight;
    
    /**
     * 
     * @param one The first vertex in the Edge
     * @param two The second vertex in the Edge
     */
    public Edge(Vertex one, Vertex two){
        this(one, two, 1);
    }
    
    /**
     * 
     * @param one The first vertex in the Edge
     * @param two The second vertex of the Edge
     * @param weight The weight of this Edge
     */
    public Edge(Vertex one, Vertex two, int weight){
        this.one = (one.getNumber()<two.getNumber()) ? one : two;
        this.two = (this.one == one) ? two : one;
        this.weight = weight;
    }
    
    
    /**
     * 
     * @param current
     * @return The neighbor of current along this Edge
     */
    public Vertex getNeighbor(Vertex current){
        if(!(current.equals(one) || current.equals(two))){
            return null;
        }
        
        return (current.equals(one)) ? two : one;
    }
    
    /**
     * 
     * @return Vertex this.one
     */
    public Vertex getOne(){
        return this.one;
    }
    
    /**
     * 
     * @return Vertex this.two
     */
    public Vertex getTwo(){
        return this.two;
    }
    
    
    /**
     * 
     * @return int The weight of this Edge
     */
    public int getWeight(){
        return this.weight;
    }
    
    
    /**
     * 
     * @param weight The new weight of this Edge
     */
    public void setWeight(int weight){
        this.weight = weight;
    }
    
    

    public int compareTo(Edge other){
        return this.weight - other.weight;
    }
    

    public String toString(){
        return "({" + one + ", " + two + "}, " + weight + ")";
    }
    

    public int hashCode(){
        return (one.getNumber() + two.getNumber());
    }
    
 
    public boolean equals(Object other){
        if(!(other instanceof Edge)){
            return false;
        }
        
        Edge e = (Edge)other;
        
        return e.one.equals(this.one) && e.two.equals(this.two);
    }
    public boolean containsVertex(Vertex vertex)
    {
        return (vertex.equals(this.one)||vertex.equals(this.two));
    }
}
