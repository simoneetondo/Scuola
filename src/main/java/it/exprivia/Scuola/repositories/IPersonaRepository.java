package it.exprivia.Scuola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// INFERENZA DEL GENERICO TIPO
// T = TYPE
// IRepository ha bisogno del tipo, se metto studente nell'IRepository va a mettere l'oggetto student anche in teacher
// stiamo defindendo in maniera dinamica quello che è il tipo all'interno della repository

/**/

// PRINCIPIO DELLA SEGREGAZIONE

public interface IPersonaRepository<T> extends  JpaRepository<T, Integer> {

    // lettura

    T getById(int id);

    List<T> getAll();
    
    //
    
    boolean Insert(T obj);

    boolean Update(T obj);

    boolean Delete(int id);
}
