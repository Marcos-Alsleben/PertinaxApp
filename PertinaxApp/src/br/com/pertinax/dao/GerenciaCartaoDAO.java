/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pertinax.dao;

import br.com.pertinax.jdbc.ConnectionFactory;
import br.com.pertinax.model.GerenciaCartao;
import br.com.pertinax.model.GerenciaCartao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mrs_a
 */
public class GerenciaCartaoDAO {

    private Connection con;

    public GerenciaCartaoDAO() {
        this.con = new ConnectionFactory().getConnection();

    }

    //Metodo cadastrarCartao
    public void cadastrarCartao(GerenciaCartao obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "insert into tb_cartao (nome) "
                    + " values (?)";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    //Metodo AlterarCartao
    public void alterarCartao(GerenciaCartao obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "update tb_cartao set nome=? where id=?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setInt(2, obj.getId());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    //Metodo ExcluirCartao
    public void excluirCartao(GerenciaCartao obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "delete from tb_cartao where id=?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    //Metodo ListarGerenciaCartao
    public List<GerenciaCartao> listarGerenciaCartao() {

        try {

            // Passo 1 criar a lista
            List<GerenciaCartao> lista = new ArrayList<>();

            // Passo 2 criar o comando sql, organizar e executar
            String sql = "select * from tb_cartao";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                GerenciaCartao obj = new GerenciaCartao();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));

                lista.add(obj);

            }
            con.close();
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }

    }
}
