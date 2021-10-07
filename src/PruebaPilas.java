
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
	public boolean eliminarPeliculaRectada();
	public boolean verificarPilaLlena();
	public boolean verficarPilaVacia();
	public void mostrarCima();
}

public class PruebaPilas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
