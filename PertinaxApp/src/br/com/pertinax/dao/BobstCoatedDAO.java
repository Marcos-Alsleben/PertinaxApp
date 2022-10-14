/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pertinax.dao;

import br.com.pertinax.jdbc.ConnectionFactory;
import br.com.pertinax.model.BobstCoated;
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
public class BobstCoatedDAO {

    private Connection con;

    public BobstCoatedDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Metodo cadastrarBobst
    public void cadastrarBobst(BobstCoated obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "insert into tb_bobst_coated (nome,grm_cartao,pertinax,fresa1,fresa2) "
                    + " values (?,?,?,?,?)";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setInt(2, obj.getGrm_cartao());
            stmt.setFloat(3, obj.getPertinax());
            stmt.setFloat(4, obj.getFresa1());
            stmt.setFloat(5, obj.getFresa2());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    //Metodo AlterarBobst
    public void alterarBobst(BobstCoated obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "update tb_bobst_coated set nome=?, grm_cartao=?, pertinax=?, fresa1=?, fresa2=? where id=?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setInt(2, obj.getGrm_cartao());
            stmt.setFloat(3, obj.getPertinax());
            stmt.setFloat(4, obj.getFresa1());
            stmt.setFloat(5, obj.getFresa2());
            stmt.setInt(6, obj.getId());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    //Metodo ExcluirBobst
    public void excluirBobst(BobstCoated obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "delete from tb_bobst_coated where id=?";

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

    //Metodo ListarBobstCoated
    public List<BobstCoated> listarBobstCoated() {

        try {

            // Passo 1 criar a lista
            List<BobstCoated> lista = new ArrayList<>();

            // Passo 2 criar o comando sql, organizar e executar
            String sql = "select * from tb_bobst_coated";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                BobstCoated obj = new BobstCoated();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setGrm_cartao(rs.getInt("grm_cartao"));
                obj.setPertinax(rs.getFloat("pertinax"));
                obj.setFresa1(rs.getFloat("fresa1"));
                obj.setFresa2(rs.getFloat("fresa2"));

                lista.add(obj);

            }
            con.close();
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }

    }

    //Metodo PesquisarBobstCoated por nome
    public List<BobstCoated> pesquisarNomeBobstCoated(String nome, String gramatura) {

        try {

            // Passo 1 criar a lista
            List<BobstCoated> lista = new ArrayList<>();

            // Passo 2 criar o comando sql, organizar e executar
            String sql = "select * from tb_bobst_coated where nome like? and grm_cartao like?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, gramatura);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                BobstCoated obj = new BobstCoated();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setGrm_cartao(rs.getInt("grm_cartao"));
                obj.setPertinax(rs.getFloat("pertinax"));
                obj.setFresa1(rs.getFloat("fresa1"));
                obj.setFresa2(rs.getFloat("fresa2"));

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
