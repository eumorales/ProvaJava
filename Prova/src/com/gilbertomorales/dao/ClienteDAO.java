package com.gilbertomorales.dao;

import com.gilbertomorales.beans.Cliente;
import com.gilbertomorales.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public ClienteDAO() {
        this.conexao = new Conexao(); 
        this.conn = this.conexao.getConexao(); 
    }
    
    public void inserir(Cliente c){
        
        String sql = "INSERT INTO cliente (nome, cpf, endereco, telefone) VALUES (?,?,?, ?);";
        
        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            stmt.setString(1, c.getNome()); 
            stmt.setString(2, c.getCpf()); 
            stmt.setString(3, c.getEndereco()); 
            stmt.setString(4, c.getTelefone()); 
            
            stmt.execute(); 
            
        } catch(SQLException ex){
            
            System.out.println("Erro ao inserir: " +ex.getMessage());
        }
        
    }
    
    public Cliente consulta(int id){
        
        String sql = "SELECT * FROM cliente WHERE id = ?;";
        
        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Cliente c = new Cliente();
            
            rs.first();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setCpf(rs.getString("cpf"));
            c.setEndereco(rs.getString("endereco"));
            c.setTelefone(rs.getString("telefone"));
            
            return c;
            
        }catch(SQLException ex){
            System.out.println("Erro ao consultar dados: "+ex.getMessage());
            return null;
        }
    }
     
    
    public void atualizar(Cliente c){
        
        String sql = "UPDATE cliente set nome = ?, cpf = ?, endereco = ?, telefone = ? WHERE id = ?;";
        
        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getTelefone());
            stmt.setInt(4, c.getId());
            
            stmt.execute();
            
            
        }catch(SQLException ex){
            System.out.println("Erro ao atualizar os dados: " +ex.getMessage());
            
        }
    }
    
    
    public void excluir(int id){
        
        try{
            
            String sql = "DELETE FROM cliente WHERE id = ?;";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            
            
        }catch(SQLException ex){
            System.out.println("Erro ao excluir: " +ex.getMessage());
            
        }
        
        
    }
    
   public List<Cliente> getClientes(){
       
       String sql = "SELECT * FROM cliente";
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           
           ResultSet rs = stmt.executeQuery();
           List<Cliente> listaClientes = new ArrayList();
           while (rs.next()){
               
               Cliente c = new Cliente();
               c.setId(rs.getInt("id"));
               c.setNome(rs.getString("nome"));
               c.setCpf(rs.getString("cpf"));
               c.setEndereco(rs.getString("endereco"));
               c.setTelefone(rs.getString("telefone"));
               listaClientes.add(c);
               
           }
           return listaClientes;
           
           
       }catch(SQLException ex){
           System.out.println("Erro ao consultar: " + ex.getMessage());
           return null;
       }
       
   }
   
   
   public List<Cliente> getClientesNome(String nome){
        
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?;";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setString(1, "%"+ nome +"%");
            ResultSet rs = stmt.executeQuery();
            List<Cliente> listaClientes = new ArrayList();
            
            
            
           while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                listaClientes.add(c);
           }  
            return listaClientes;
            
        }catch(SQLException ex){
            
            System.out.println("Erro ao consultar: " + ex.getMessage());
            return null;
            
        }
    }
   
   
    
}
            
          
    

