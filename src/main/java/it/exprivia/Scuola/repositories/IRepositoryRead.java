package it.exprivia.progetto.repositories;

import java.util.List;

// INFERENZA DEL GENERICO TIPO
// T = TYPE
// IRepository ha bisogno del tipo, se metto studente nell'IRepository va a mettere l'oggetto student anche in teacher
// stiamo defindendo in maniera dinamica quello che è il tipo all'interno della repository

/**/

// PRINCIPIO DELLA SEGREGAZIONE

public interface IRepositoryRead<T> {

    // lettura

    T getById(int id);

    List<T> getAll();
}
