package br.facape.nti.crudBye.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.facape.nti.crudBye.bean.UsuarioBean;

public class UsuarioModel {

	
	
	public void cadastrarUsuario(Connection con, UsuarioBean usuario){
		
				
		try {
			
			PreparedStatement st = con.prepareStatement("INSERT INTO USUARIO(USCLOGN, USCSENH, USCNOME, USCMAIL) VALUES (?, ?, ?, ?)");
			
			st.setString(1, usuario.getUsclogn());
			st.setString(2, usuario.getUscsenh());
			st.setString(3, usuario.getUscnome());
			st.setString(4, usuario.getUscmail());
			
			st.execute();
			st.close();
			
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	public ArrayList<UsuarioBean> getListaUsuario(Connection conn) {
		
		ArrayList<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		UsuarioBean usuario = new UsuarioBean();
		
		try {
			
			PreparedStatement sp = conn.prepareStatement("SELECT * FROM USUARIO");
			
			ResultSet rs = sp.executeQuery();
			
			while(rs.next()){
				
				usuario = new UsuarioBean();
				
				usuario.setUsncodg(rs.getString("usncodg"));
				usuario.setUsclogn(rs.getString("usclogn"));
				usuario.setUscmail(rs.getString("uscmail"));
				usuario.setUscnome(rs.getString("uscnome"));
				usuario.setUscsenh(rs.getString("uscsenh"));
				
				lista.add(usuario);
			}
			
			sp.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void atualizarusuario(Connection conn, UsuarioBean usuario){
	
		
		try {
			
			PreparedStatement sp = conn.prepareStatement("UPDATE USUARIO SET USCNOME = ?, USCSENH = ?, USCMAIL = ?, USCLOGN = ? WHERE USNCODG = ?");
	
			sp.setString(1, usuario.getUscnome());
			sp.setString(2, usuario.getUscsenh());
			sp.setString(3, usuario.getUscmail());
			sp.setString(4, usuario.getUsclogn());
			sp.setString(5, usuario.getUsncodg());
			
			sp.execute();
			
			sp.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	
	public void apagarUsuario(Connection conn, UsuarioBean usuario) {
		
		try {
			
			PreparedStatement sp = conn.prepareStatement("DELETE FROM USUARIO WHERE USNCODG = ?");
			
			sp.setString(1, usuario.getUsncodg());
			
			sp.execute();
			
			sp.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
