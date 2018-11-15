package com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthtrack.Peso;
import com.healthtrack.dao.DAOInterface;
import com.healthtrack.singleton.ConnectionManager;

public class PesoDAO implements DAOInterface<Peso> {
	Connection con;
	
	@Override
	public void cadastrar(Peso peso, int usuarioId) {
		PreparedStatement ps = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con
				.prepareStatement("INSERT INTO T_PESO (qt_peso, comentarios, t_usuario_id, dt_cadastro) "
						+ "VALUES (?, ?, ?, ?)");
			ps.setDouble(1, peso.getPeso());
			ps.setString(2, peso.getComentario());
			ps.setInt(3, usuarioId);
			ps.setDate(4, peso.getDataCadastro());
			ps.executeQuery();
			
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
	public void atualizar(Peso peso, int usuarioId) {
		PreparedStatement ps = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con
				.prepareStatement("UPDATE T_EXERCICIO SET qt_peso = ?, comentarios = ?, t_usuario_id = ?");
			
			ps.setDouble(1, peso.getPeso());
			ps.setString(2, peso.getComentario());
			ps.setInt(3, usuarioId);
			
			ps.executeQuery();
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
		PreparedStatement ps = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con
				.prepareStatement("");
			
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
	public Peso buscar(int id) {
		PreparedStatement ps = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con
				.prepareStatement("");
			
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
		return null;
	}

	@Override
	public ArrayList<Peso> listar(int usuarioId) {
		PreparedStatement ps = null;
		ArrayList<Peso> pesos = new ArrayList<Peso>();
		
		try {		
			con = ConnectionManager.getInstance().getConnection();
			ps = con.prepareStatement(
					"SELECT * FROM T_PESO "
					+ "WHERE T_PESO.T_USUARIO_ID = ? "
					+ "ORDER BY (SELECT MAX(T_PESO.ROWID) FROM T_PESO) DESC"
					);
			
			ps.setInt(1, usuarioId);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Peso peso = new Peso();
				peso.setPeso(rs.getDouble("QT_PESO"));
				peso.setComentario(rs.getString("COMENTARIOS"));
				peso.setDataCadastro(rs.getDate("DT_CADASTRO"));
				pesos.add(peso);
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

		return pesos;
	}
}
