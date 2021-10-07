import java.util.Scanner;
import java.util.Stack;

class Pelicula{
	private String titulo;
	private String genero;
	
	public Pelicula(String titulo, String genero) {
		super();
		this.titulo = titulo;
		this.genero = genero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", genero=" + genero + "]";
	}
	
}

interface RentaPeliculas{
	boolean insetarPeliculaRentada(Pelicula peli);
	public boolean eliminarPeliculaRentada();
	public boolean verificarPilaLlena();
	public boolean verficarPilaVacia();
	public void mostrarCima();
}

class ImplementacionPilaEstatica implements RentaPeliculas{
	private Pelicula pilaPelis[];
	private int cima;
	public ImplementacionPilaEstatica() {
		pilaPelis=new Pelicula[3];
		cima=-1;
	}
	@Override
	public boolean insetarPeliculaRentada(Pelicula peli) {
		if(verificarPilaLlena()) {
			return false;
		}else {
			cima++;
			pilaPelis[cima]=peli;
			return true;
		}
		
	}
	@Override
	public boolean eliminarPeliculaRentada() {
		if(verficarPilaVacia()==false) {
			pilaPelis[cima]=null;
			cima--;
			return true;
		}else {
			return false;
		}

	}
	@Override
	public boolean verificarPilaLlena() {
		if(cima==pilaPelis.length-1) {
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public boolean verficarPilaVacia() {
		if(cima==-1) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void mostrarCima() {
		if(verficarPilaVacia()==false) {
			System.out.println(pilaPelis[cima]);
		}else {
			System.out.println("La pila esta vacia");
		}
		
	}
	

}

class ImplementacionPilaDinamica implements RentaPeliculas{
	private Stack<Pelicula> pilaPelis=new Stack<Pelicula>();
	private int cima;
	public ImplementacionPilaDinamica() {
		this.cima =-1;
	}
	@Override
	public boolean insetarPeliculaRentada(Pelicula peli) {
			pilaPelis.push(peli);
			cima++;
			return true;
		}
	@Override
	public boolean eliminarPeliculaRentada() {
		if(cima>=0) {
		pilaPelis.pop();
		cima--;
		return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean verificarPilaLlena() {
		return false;
	}
	@Override
	public boolean verficarPilaVacia() {
		return pilaPelis.isEmpty();
	}
	@Override
	public void mostrarCima() {
		System.out.println(pilaPelis.peek());
	}
	
}

public class PruebaPilas {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		ImplementacionPilaEstatica pe =new ImplementacionPilaEstatica();
		ImplementacionPilaDinamica pd =new ImplementacionPilaDinamica();
		Pelicula[] pila=new Pelicula[5];
		
		pila[0]=new Pelicula("Las cronicas de Spiderwick","Fantasia");
		pila[1]=new Pelicula("Terminator","Ciencia Ficcion");
		
		pe.insetarPeliculaRentada(pila[0]);
		pe.mostrarCima();
		pe.eliminarPeliculaRentada();
		pe.mostrarCima();
	}

}
