//Giovana Carnevali -  RM566196
//Henrique Vicente - RM564116
//Yasmin Amorin - RM563645
package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;



public class FilmeController {

    public String inserirFilme(
            String titulo,
            String genero,
            String produtora)
            throws ClassNotFoundException, SQLException {

        String resultado;

        Connection con =
                ConnectionFactory.abrirConexao();

        Filme filme =
                new Filme();

        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);

        FilmeDAO filmeDAO =
                new FilmeDAO(con);

        resultado =
                filmeDAO.inserir(filme);

        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String alterarFilme(
            int codigo,
            String titulo,
            String genero,
            String produtora)
            throws ClassNotFoundException, SQLException {

        String resultado;

        Connection con =
                ConnectionFactory.abrirConexao();

        Filme filme =
                new Filme();

        filme.setCodigo(codigo);
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);

        FilmeDAO filmeDAO =
                new FilmeDAO(con);

        resultado =
                filmeDAO.alterar(filme);

        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String excluirFilme(
            int codigo)
            throws ClassNotFoundException, SQLException {

        String resultado;

        Connection con =
                ConnectionFactory.abrirConexao();

        Filme filme =
                new Filme();

        filme.setCodigo(codigo);

        FilmeDAO filmeDAO =
                new FilmeDAO(con);

        resultado =
                filmeDAO.excluir(filme);

        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String listarTodosFilmes()
            throws ClassNotFoundException, SQLException {

        String resultado = "";

        Connection con =
                ConnectionFactory.abrirConexao();

        FilmeDAO filmeDAO =
                new FilmeDAO(con);

        ArrayList<Filme> listaFilme =
                filmeDAO.listarTodos();

        for (int i = 0; i < listaFilme.size(); i++) {

            resultado =
                    resultado
                            + "Código: "
                            + listaFilme.get(i).getCodigo()
                            + "\n";

            resultado =
                    resultado
                            + "Título: "
                            + listaFilme.get(i).getTitulo()
                            + "\n";

            resultado =
                    resultado
                            + "Gênero: "
                            + listaFilme.get(i).getGenero()
                            + "\n";

            resultado =
                    resultado
                            + "Produtora: "
                            + listaFilme.get(i).getProdutora()
                            + "\n";

            resultado =
                    resultado
                            + "-------------------------\n";
        }

        ConnectionFactory.fecharConexao(con);

        return resultado;
    }
}
