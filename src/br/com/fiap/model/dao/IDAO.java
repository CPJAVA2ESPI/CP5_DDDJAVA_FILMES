//Giovana Carnevali -  RM566196
//Henrique Vicente - RM564116
//Yasmin Amorin - RM563645
//Murilo Macedo - RM563397

package br.com.fiap.model.dao;

import java.util.ArrayList;

    public interface IDAO {

        public String inserir(Object object);

        public String alterar(Object object);

        public String excluir(Object object);

        public ArrayList<Object> listarTodos();

    }


