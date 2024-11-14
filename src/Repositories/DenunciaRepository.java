/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface DenunciaRepository<T> {
    void save(T entity);
    T findById(int id);
    List<T> findAll();
    void delete(int id);
}