/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pertinax.dao;

import br.com.pertinax.jdbc.ConnectionFactory;
import br.com.pertinax.model.CartonLaminado;
import br.com.pertinax.model.CartonLaminado;
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
public class CartonLaminadoDAO {

    private Connection con;

    public CartonLaminadoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Metodo cadastrarLaminado
    public void cadastrarLaminado(CartonLaminado obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "insert into tb_carton_laminado (faca,nome,grm_cartao,grm_laminado,grm_total,uv,pertinax,fresa1,fresa2,observacao) "
                    + " values (?,?,?,?,?,?,?,?,?,?)";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getFaca());
            stmt.setString(2, obj.getNome());
            stmt.setInt(3, obj.getGrm_cartao());
            stmt.setInt(4, obj.getGrm_laminado());
            stmt.setInt(5, obj.getGrm_total());
            stmt.setString(6, obj.getUv());
            stmt.setFloat(7, obj.getPertinax());
            stmt.setFloat(8, obj.getFresa1());
            stmt.setFloat(9, obj.getFresa2());
            stmt.setString(10, obj.getObservacao());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    //Metodo AlterarLaminado
    public void alterarLaminado(CartonLaminado obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "update tb_carton_laminado set faca=?, nome=?, grm_cartao=?, grm_laminado=?, "
                    + "grm_total=?, uv=?, pertinax=?, fresa1=?, fresa2=?, observacao=? where id=? ";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getFaca());
            stmt.setString(2, obj.getNome());
            stmt.setInt(3, obj.getGrm_cartao());
            stmt.setInt(4, obj.getGrm_laminado());
            stmt.setInt(5, obj.getGrm_total());
            stmt.setString(6, obj.getUv());
            stmt.setFloat(7, obj.getPertinax());
            stmt.setFloat(8, obj.getFresa1());
            stmt.setFloat(9, obj.getFresa2());
            stmt.setString(10, obj.getObservacao());
            stmt.setInt(11, obj.getId());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    //Metodo ExcluirLaminado
    public void excluirLaminado(CartonLaminado obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "delete from tb_carton_laminado where id=?";

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

    //Metodo ListarCartonLaminado
    public List<CartonLaminado> listarCartonLaminado() {

        try {

            // Passo 1 criar a lista
            List<CartonLaminado> lista = new ArrayList<>();

            // Passo 2 criar o comando sql, organizar e executar
            String sql = "select * from tb_carton_laminado";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                CartonLaminado obj = new CartonLaminado();

                obj.setId(rs.getInt("id"));
                obj.setFaca(rs.getString("faca"));
                obj.setNome(rs.getString("nome"));
                obj.setGrm_cartao(rs.getInt("grm_cartao"));
                obj.setGrm_laminado(rs.getInt("grm_laminado"));
                obj.setGrm_total(rs.getInt("grm_total"));
                obj.setUv(rs.getString("uv"));
                obj.setPertinax(rs.getFloat("pertinax"));
                obj.setFresa1(rs.getFloat("fresa1"));
                obj.setFresa2(rs.getFloat("fresa2"));
                obj.setObservacao(rs.getString("observacao"));

                lista.add(obj);

            }
            con.close();
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }

    }

    //Metodo PesquisarCartonLaminado
    public List<CartonLaminado> pesquisarCartonLaminado(String faca, String nome, String gramatura) {

        try {

            // Passo 1 criar a lista
            List<CartonLaminado> lista = new ArrayList<>();

            // Passo 2 criar o comando sql, organizar e executar
            String sql = "select * from tb_carton_laminado where faca like? and nome like? and grm_cartao like?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, faca);
            stmt.setString(2, nome);
            stmt.setString(3, gramatura);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                CartonLaminado obj = new CartonLaminado();

                obj.setId(rs.getInt("id"));
                obj.setFaca(rs.getString("faca"));
                obj.setNome(rs.getString("nome"));
                obj.setGrm_cartao(rs.getInt("grm_cartao"));
                obj.setGrm_laminado(rs.getInt("grm_laminado"));
                obj.setGrm_total(rs.getInt("grm_total"));
                obj.setUv(rs.getString("uv"));
                obj.setPertinax(rs.getFloat("pertinax"));
                obj.setFresa1(rs.getFloat("fresa1"));
                obj.setFresa2(rs.getFloat("fresa2"));
                obj.setObservacao(rs.getString("observacao"));

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
