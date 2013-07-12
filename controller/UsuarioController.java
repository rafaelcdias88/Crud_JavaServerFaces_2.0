package br.facape.nti.crudBye.controller;

import java.sql.Connection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.primefaces.event.RowEditEvent;

import br.facape.nti.crudBye.banco.BancoCrudBye;
import br.facape.nti.crudBye.bean.UsuarioBean;
import br.facape.nti.crudBye.model.UsuarioModel;

@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController {

	UsuarioBean usuario = new UsuarioBean();

	UsuarioModel usuarioModel = new UsuarioModel();

	DataModel<UsuarioBean> listaUsuario;
	
	UsuarioBean usuarioSelecionado;
	
	
	public UsuarioBean getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(UsuarioBean usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public void cadastrarUsuario() {

		Connection conn = null;
		BancoCrudBye bd = new BancoCrudBye();

		try {

			conn = bd.getConnection();

			if (conn != null) {

				usuarioModel.cadastrarUsuario(conn, usuario);

				listaUsuario = null;

				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				bd.closeConnection();
			}
		}

	}

	public DataModel<UsuarioBean> getListaUsuario() {

		Connection conn = null;
		BancoCrudBye bd = new BancoCrudBye();

		try {

			conn = bd.getConnection();

			if (conn != null) {

				if (listaUsuario == null) {

					listaUsuario = new ListDataModel<UsuarioBean>(
							usuarioModel.getListaUsuario(conn));
				}
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaUsuario;
	}

	public void editar(RowEditEvent event) {

		UsuarioBean usuario = (UsuarioBean) event.getObject();
		Connection conn = null;
		BancoCrudBye bd = new BancoCrudBye();

		try {

			conn = bd.getConnection();

			if (conn != null) {

				usuarioModel.atualizarusuario(conn, usuario);

				listaUsuario = null;

				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				bd.closeConnection();
			}
		}

	}

	public void excluir(UsuarioBean usuarioSelecionado){

		//UsuarioBean usuario = (UsuarioBean) event.getObject();
		
		UsuarioBean usuario = (UsuarioBean) this.usuarioSelecionado;
		Connection conn = null;
		BancoCrudBye bd = new BancoCrudBye();
		
		System.out.println("Dexter");

		try {

			conn = bd.getConnection();

			if (conn != null) {

				usuarioModel.apagarUsuario(conn, usuario);

				listaUsuario = null;

				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				bd.closeConnection();
			}
		}

	}

}