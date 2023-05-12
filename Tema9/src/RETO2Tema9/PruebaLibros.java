package RETO2Tema9;

public class PruebaLibros {

	public static void main(String[] args) {
		
		Libros misLibros = new Libros();
		System.out.println("Catálogo libros: ");
		misLibros.verCatalogoAsc();
		System.out.println();
		//misLibros.insertLibro(987, "Programar con Java", "Alfonso Jiménez", "Paraninfo", 384, 50);
		System.out.println();
		//misLibros.deleteLibro(987);
		//System.out.println("Catálogo libros: ");
		misLibros.updateCopias(15, 1725);
		System.out.println("Catálogo actualizado: ");
		misLibros.verCatalogoAsc();
		
	}//main

}
