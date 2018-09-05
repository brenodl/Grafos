import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Graph{
	
	//número de vertices
	private final int n;
	
	//número de arestas
	private int m;
	
	private HashMap<Integer, ArrayDeque<Integer>> adj;
	
	private int R[]; //Vetor com n de cidades para distancia
	
	
	public Graph(int n){ //Construtor incia a quantidade de vertices 
		
		if(n<0) {
			
			throw new IllegalArgumentException("O número de vértices deve ser maior que zero!");
		}
		this.n = n;
		this.m = 0;
		this.adj = new HashMap<>();
		R = new int[n];
		for(int i= 0; i<n; i++) {
			
			adj.put(i, new ArrayDeque<Integer>());
			
		}
	}
	
	private boolean verificaVertice(int u) {
		
		return (u>0)|| (u<=n);
	}
	
	
	public void addAresta(int u, int v) {
		
		
		if(!verificaVertice(u)) {
			
			throw new IndexOutOfBoundsException("Vétice de origem fora da faixa");	
		}
		
		if(!verificaVertice(v)) {
					
			throw new IndexOutOfBoundsException("Vétice de origem fora da faixa");
					
		}
		m++;
		
		if(!adj.get(u).contains(v)) 
		adj.get(u).add(v);
		
		if(!adj.get(v).contains(u))
		adj.get(v).add(u);
	}
	
	
	public void MostrarGrafo() {
		
		for(int i = 0; i<adj.size();i++) {
				
			System.out.println("["+i+"]"+"->"+adj.get(i));	
		}	
		System.out.println();
	}
	
	public void bfs(int v){
		
	        boolean visited[] = new boolean[n];
	        LinkedList<Integer> queue = new LinkedList<Integer>();
	        List<Integer> level = new ArrayList<Integer>();
	        
		    for(int i = 0; i<n;i++) {
		        	level.add(0);
		    }
	        
	        visited[v] = true;
	        queue.add(v);
	        while (!queue.isEmpty()){
	            v = queue.poll();
	           
	            Iterator<Integer> i = adj.get(v).iterator();
	            
	            while (i.hasNext()){
	                int aux = i.next();
	                
	                if (!visited[aux]){
	                	
	                    visited[aux] = true;
	                    level.set(aux, level.get(v)+1);
	                    queue.add(aux);
	                }
	            } 
	        }  
	        
	        for(int i = 1; i<level.size();i++) {
	        	
	        	R[i] = Collections.frequency(level, i);  	
	        }
		}
	
	
	public void printVetor() {
		
		for(int i = 1; i<R.length;i++) {
			
			System.out.print(R[i]+" ");
			
		}	
	}
}
