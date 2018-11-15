package com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthtrack.Alimento;
import com.healthtrack.dao.DAOInterface;
import com.healthtrack.singleton.ConnectionManager;

public class AlimentoDAO implements DAOInterface<Alimento> {
	private Connection con;
	
	
	@Override
	public void cadastrar(Alimento alimento, int usuarioId) {
		PreparedStatement ps = null;
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con
				.prepareStatement(
						"INSERT INTO T_ALIMENTO (ds_alimento, qt_calorias, comentarios, t_usuario_id, dt_cadastro) "
						+ "VALUES (?, ?, ?, ?, ?)"
				);

			ps.setString(1, alimento.getDescAlimento());
			ps.setDouble(2, alimento.getCalorias());
			ps.setString(3, alimento.getComentarios());
			ps.setInt(4, usuarioId);
			ps.setDate(5, alimento.getDataCadastro());
			ps.executeQuery();
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
	}

	@Override
	public void atualizar(Alimento alimento, int usuarioId) {
		PreparedStatement ps = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con
				.prepareStatement("UPDATE T_ALIMENTO SET ds_alimento = ?, qt_calorias = ?, comentarios = ?, t_usuario_id = ?");
			
			ps.setString(1, alimento.getDescAlimento());
			ps.setDouble(2, alimento.getCalorias());
			ps.setString(3, alimento.getComentarios());
			ps.setInt(4, usuarioId);
			
			
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
	public Alimento buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Alimento> listar(int usuarioId) {

		PreparedStatement ps = null;
		ArrayList<Alimento> alimentos = new ArrayList<Alimento>();
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con.prepareStatement(
					"SELECT * FROM T_ALIMENTO "
					+ "WHERE T_ALIMENTO.T_USUARIO_ID = ? "
					+ "ORDER BY (SELECT MAX(T_ALIMENTO.ROWID) FROM T_ALIMENTO) DESC"
					);
			
			ps.setInt(1, usuarioId);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Alimento alimento = new Alimento();
				alimento.setDescAlimento(rs.getString("DS_ALIMENTO"));
				alimento.setCalorias(rs.getInt("QT_CALORIAS"));
				alimento.setComentarios(rs.getString("COMENTARIOS"));
				alimento.setDataCadastro(rs.getDate("DT_CADASTRO"));
				alimentos.add(alimento);
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

		return alimentos;
	}
}
