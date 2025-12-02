package it.exprivia.progetto.repositories;

public interface IRepositoryWrite<T> {

    // scrittura

    boolean Insert(T obj);

    boolean Update(T obj);

    boolean Delete(int id);
}
