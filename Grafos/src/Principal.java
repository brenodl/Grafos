import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args){
		
		int T[];
		Graph a;
		int capital = 0;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Digite os valores: ");
		String[] output = in.next().split(",");
		
		T = new int[output.length]; 
		
		for(int i = 0; i<output.length;i++) {
			
			T[i] = Integer.parseInt(output[i]);
			
			if(i == T[i])
				capital = i;	
		}
		a = new Graph(T.length);
		int tam = T.length;
		
		for(int i = 0; i<(T.length);i++) {
			
			a.addAresta(i, T[i]);
		}
		
		
		a.MostrarGrafo();
		a.bfs(capital);
		a.printVetor();
	}
}