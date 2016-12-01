/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafai;

import java.util.ArrayList;


public class Vertex {

    private ArrayList<Edge> neighborhood;
    private int number;
    

    public Vertex(int number){
        this.number = number;
        this.neighborhood = new ArrayList<Edge>();
    }
    
    

    public void addNeighbor(Edge edge){
        if(this.neighborhood.contains(edge)){
            return;
        }
        
        this.neighborhood.add(edge);
    }
    
    

    public boolean containsNeighbor(Edge other){
        return this.neighborhood.contains(other);
    }
    

    public Edge getNeighbor(int index){
        return this.neighborhood.get(index);
    }
    
    

    Edge removeNeighbor(int index){
        return this.neighborhood.remove(index);
    }
    

    public void removeNeighbor(Edge e){
        this.neighborhood.remove(e);
    }
    
    

    public int getNeighborCount(){
        return this.neighborhood.size();
    }
    
    

    public int getNumber(){
        return this.number;
    }
    
    

    public String toString(){
        return "Vertex " + number;
    }
    

    public int hashCode(){
        return this.number;
    }
    

    public boolean equals(Object other){
        if(!(other instanceof Vertex)){
            return false;
        }
        
        Vertex v = (Vertex)other;
        return this.number==v.number;
    }
    

    public ArrayList<Edge> getNeighbors(){
        return new ArrayList<Edge>(this.neighborhood);
    }
    
    
}