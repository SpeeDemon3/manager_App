package arb.project.manager.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

	// Recupera un registro en concreto segun su id
	// Devolvera (o no) un objeto de tipo generico de la clase 
	Optional<T> get(long id); 
	
	// Recuperar todos los registros
	// Devuelve una lista de objetos de ese tipo generico
	List<T> getAll();
	
	// Guarda el objeto en la base de datos
	void save(T t);
	
	// Actualiza un objeto
	void update(T t);
	
	// Borrar un objeto
	void delete(T t);

	
}
