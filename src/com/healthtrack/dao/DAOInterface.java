package com.healthtrack.dao;

import java.util.ArrayList;

public interface DAOInterface<T> {
	void cadastrar(T item, int usuarioId);
	void atualizar(T item, int usuarioId);
	void remover(int codigo, int usuarioId);
	T buscar(int id);
	ArrayList<T> listar(int usuarioId);
}
