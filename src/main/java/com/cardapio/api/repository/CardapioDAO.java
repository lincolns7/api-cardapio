/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.api.repository;

import com.cardapio.api.model.CardapioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class CardapioDAO {
    
    public List<CardapioBean> lerTodas(){
        List<CardapioBean> dados = new ArrayList();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM itens");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                CardapioBean cardapio = new CardapioBean();
                cardapio.setId(rs.getInt("id"));
                cardapio.setNome(rs.getString("nome"));
                cardapio.setPreco(rs.getInt("preco"));
                cardapio.setCategoria(rs.getString("categoria"));
                cardapio.setDisponivel(rs.getBoolean("disponivel"));
                dados.add(cardapio);
            }
        } catch(SQLException e ) {
            e.printStackTrace();
        }
        return dados;
    }
    
    public void adicionar(CardapioBean cardapio) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO itens (nome, preco, categoria, disponivel)"
                    + "VALUES (?,?,?,?,?)");
            stmt.setString(1, cardapio.getNome());
            stmt.setDouble(2, cardapio.getPreco());
            stmt.setString(3, cardapio.getCategoria());
            stmt.setBoolean(4, cardapio.isDisponivel());
            
            stmt.executeUpdate();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
