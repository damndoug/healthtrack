package com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthtrack.Usuario;
import com.healthtrack.dao.DAOInterface;
import com.healthtrack.singleton.ConnectionManager;

public class UsuarioDAO implements DAOInterface<Usuario> {
	Connection con;

	@Override
	public void cadastrar(Usuario usuario, int usuarioId) {
		PreparedStatement ps = null;
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con
					.prepareStatement(
							"INSERT INTO T_USUARIO (nm_usuario, email, senha, t_sexo_id_sexo, dt_cadastro)"
							+ "VALUES (?, ?, ?, ?, ?)"
					);

			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getSexo());
			ps.setDate(5, usuario.getDataCadastro());

			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		}
	}


	@Override
	public void atualizar(Usuario usuario, int usuarioId) {
		PreparedStatement ps = null;
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con
				.prepareStatement("UPDATE T_USUARIO SET nm_usuario = ?, email = ?");
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		}
		
	}


	@Override
	public void remover(int codigo, int usuarioId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Usuario buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Usuario> listar(int usuarioId) {
		PreparedStatement ps = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {			
			con = ConnectionManager.getInstance().getConnection();
			
			ps = con.prepareStatement("SELECT * FROM T_USUARIO");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(rs.getString("NM_USUARIO"));;
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setSexo(rs.getInt("T_SEXO_ID_SEXO"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
			throw new RuntimeException(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return usuarios;
	}
	
	
	public boolean validarUsuario(String email, String senha) throws Exception  {

		PreparedStatement ps = null;
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			
			ps = con
				.prepareStatement(
						"SELECT * FROM T_USUARIO WHERE T_USUARIO.EMAIL = ? AND T_USUARIO.SENHA = ?"
				);

			Usuario usuario = new Usuario();
			
			usuario.setSenha(senha);
			usuario.setEmail(email);

			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		}
		
		return false;
	}


	public int getUserId(String email, String senha) throws Exception {
		PreparedStatement ps = null;
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			
			ps = con
				.prepareStatement(
						"SELECT * FROM T_USUARIO WHERE T_USUARIO.EMAIL = ? AND T_USUARIO.SENHA = ?"
				);

			Usuario usuario = new Usuario();
			
			usuario.setSenha(senha);
			usuario.setEmail(email);

			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				return rs.getInt("ID");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		}
		
		return 0;
	}
	
}
