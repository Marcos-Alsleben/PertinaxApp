/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pertinax.dao;

import br.com.pertinax.jdbc.ConnectionFactory;
import br.com.pertinax.model.CartonCoated;
import br.com.pertinax.model.CartonCoated;
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
public class CartonCoatedDAO {
    
    private Connection con;

    public CartonCoatedDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Metodo cadastrarCoated
    public void cadastrarCoated(CartonCoated obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "insert into tb_carton_coated (faca,nome,grm_cartao,uv,pertinax,fresa1,fresa2,observacao) "
                    + " values (?,?,?,?,?,?,?,?)";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getFaca());
            stmt.setString(2, obj.getNome());
            stmt.setInt(3, obj.getGrm_cartao());     
            stmt.setString(4, obj.getUv());
            stmt.setFloat(5, obj.getPertinax());
            stmt.setFloat(6, obj.getFresa1());
            stmt.setFloat(7, obj.getFresa2());
            stmt.setString(8, obj.getObservacao());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }
    
    //Metodo AlterarCoated
    public void alterarCoated(CartonCoated obj){
        try {

            //1 passo  - criar o comando sql
            String sql = "update tb_carton_coated set faca=?, nome=?, grm_cartao=?, uv=?, pertinax=?, "
                    + "fresa1=?, fresa2=?, observacao=? where id=? ";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getFaca());
            stmt.setString(2, obj.getNome());
            stmt.setInt(3, obj.getGrm_cartao());     
            stmt.setString(4, obj.getUv());
            stmt.setFloat(5, obj.getPertinax());
            stmt.setFloat(6, obj.getFresa1());
            stmt.setFloat(7, obj.getFresa2());
            stmt.setString(8, obj.getObservacao());
            stmt.setInt(9, obj.getId());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
   
    }
    
    //Metodo ExcluirCoated
    public void excluirCoated(CartonCoated obj){
        try {

            //1 passo  - criar o comando sql
            String sql = "delete from tb_carton_coated where id=?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());            

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
   
    }
    
    //Metodo ListarCartonCoated
    public List<CartonCoated> listarCartonCoated() {

        try {

            // Passo 1 criar a lista
            List<CartonCoated> lista = new ArrayList<>();

            // Passo 2 criar o comando sql, organizar e executar
            String sql = "select * from tb_carton_coated";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                CartonCoated obj = new CartonCoated();

                obj.setId(rs.getInt("id"));
                obj.setFaca(rs.getString("faca"));
                obj.setNome(rs.getString("nome"));
                obj.setGrm_cartao(rs.getInt("grm_cartao"));
                obj.setUv(rs.getString("uv"));
                obj.setPertinax(rs.getFloat("pertinax"));
                obj.setFresa1(rs.getFloat("fresa1"));
                obj.setFresa2(rs.getFloat("fresa2"));
                obj.setObservacao(rs.getString("observacao"));

                lista.add(obj);

            }
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }

    }
    
    //Metodo PesquisarCartonCoated
    public List<CartonCoated> pesquisarCartonCoated(String faca, String nome, String gramatura) {

        try {

            // Passo 1 criar a lista
            List<CartonCoated> lista = new ArrayList<>();

            // Passo 2 criar o comando sql, organizar e executar
            String sql = "select * from tb_carton_coated where faca like? and nome like? and grm_cartao like?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, faca);
            stmt.setString(2, nome);
            stmt.setString(3, gramatura);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                CartonCoated obj = new CartonCoated();

                obj.setId(rs.getInt("id"));
                obj.setFaca(rs.getString("faca"));
                obj.setNome(rs.getString("nome"));
                obj.setGrm_cartao(rs.getInt("grm_cartao"));
                obj.setUv(rs.getString("uv"));
                obj.setPertinax(rs.getFloat("pertinax"));
                obj.setFresa1(rs.getFloat("fresa1"));
                obj.setFresa2(rs.getFloat("fresa2"));
                obj.setObservacao(rs.getString("observacao"));

                lista.add(obj);

            }
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }

    }
    
}
