package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.view.ListarUsuariosView;

public class ListarUsuariosControle {
	private ListarUsuariosView listener;

	public ListarUsuariosControle() {
		this.listener = new ListarUsuariosView();
		listener.setLocationRelativeTo(null);
		listener.setVisible(true);
		configurarListeners();
		carregarUsuarios();
	}

	private class ListarUsuariosListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();

			switch (comando) {
			case "btFechar":
				listener.dispose();
				break;
			case "btCadastrar":
//				abrirCAdastroUsuario(null);
				break;
			}
		}
	}
	
	private void configurarListeners() {
		listener.addListarUsuariosListener(new ListarUsuariosListner());
		listener.addWindowListener(new JanelaAberturaListner());
	}

	public void abrirCAdastroUsuario(Usuario user) {
//		new CadastrarUsuarioControle(this,user);
	}
	
	private class JanelaAberturaListner extends WindowAdapter{
		public void WindowOpened(WindowEvent e) {
//			carregarUsuarios();
		}
	}
	public void carregarUsuarios() throws SQLException{
		try {
		ArrayList<Usuarios> listaUsuarios = listarUsuarios();
		if (listaUsuarios.isEmpty()) {
			listener.mostrarUsuariosTabela(listaUsuarios);
			
		}
	}	catch (SQLException e) {
		new MensagemView("Erro ao carregar usuários!", 0);
	}
	
	public ArrayList<Usuario> listarUsuarios() throws SQLException{
		UsuarioDAO dao = new UsuarioDAO();
		return dao.selecionarUsuarios();
		
	}
 }
}