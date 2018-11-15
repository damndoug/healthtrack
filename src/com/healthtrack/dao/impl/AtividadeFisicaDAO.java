package com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthtrack.AtividadeFisica;
import com.healthtrack.dao.DAOInterface;
import com.healthtrack.singleton.ConnectionManager;

public class AtividadeFisicaDAO implements DAOInterface<AtividadeFisica> {
	
	Connection con;
	

	@Override
	public void cadastrar(AtividadeFisica atividade, int usuarioId) {
		PreparedStatement ps = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con
					.prepareStatement(
							"INSERT INTO T_EXERCICIO (ds_exercicio, qt_calorias, qt_tempo_minutos, t_usuario_id, dt_cadastro) "
							+ "VALUES (?, ?, ?, ?, ?)"
					);

			ps.setString(1, atividade.getDescAtividade());
			ps.setDouble(2, atividade.getCalorias());
			ps.setInt(3, atividade.getTempo());
			ps.setInt(4, usuarioId);
			ps.setDate(5, atividade.getDataCadastro());
			
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
	public void atualizar(AtividadeFisica atividade, int usuarioId) {
		PreparedStatement ps = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con
				.prepareStatement("UPDATE T_EXERCICIO SET ds_exercicio = ?, qt_calorias = ?, qt_tempo_minutos = ?, t_usuario_id = ?");
			
			ps.setString(1, atividade.getDescAtividade());
			ps.setDouble(2, atividade.getCalorias());
			ps.setInt(3, atividade.getTempo());
			ps.setInt(4, usuarioId);
			
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
	public AtividadeFisica buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AtividadeFisica> listar(int usuarioId) {
		PreparedStatement ps = null;
		ArrayList<AtividadeFisica> atividades = new ArrayList<AtividadeFisica>();
		
		try {
			con = ConnectionManager.getInstance().getConnection();

			ps = con.prepareStatement(
					"SELECT * FROM T_EXERCICIO "
					+ "WHERE T_EXERCICIO.T_USUARIO_ID = ? "
					+ "ORDER BY (SELECT MAX(T_EXERCICIO.ROWID) FROM T_EXERCICIO) DESC"
					);
			
			ps.setInt(1, usuarioId);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				AtividadeFisica atividade = new AtividadeFisica();
				atividade.setDescAtividade(rs.getString("DS_EXERCICIO"));
				atividade.setCalorias(rs.getInt("QT_CALORIAS"));
				atividade.setTempo(rs.getInt("QT_TEMPO_MINUTOS"));
				atividade.setDataCadastro(rs.getDate("DT_CADASTRO"));
				atividades.add(atividade);
			}
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
		return atividades;
	}

}
