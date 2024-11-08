package com.gilbertomorales.conexao;

import java.sql.Connection;
import java.sql.*;

public class Conexao {
    
    public Connection getConexao(){ 
        
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova?Timezone=true&serverTimezone=UTC", "root", "laboratorio");
            
            System.out.println("Conexão efetuada com sucesso.");
            return conn;

            
            
        }catch(Exception e){
            System.out.println("Erro ao conectar-se ao banco: " +e.getMessage());
            return null;
        }
        
        
        
    }
    
}
