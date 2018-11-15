package com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthtrack.PressaoArterial;
import com.healthtrack.dao.DAOInterface;
import com.healthtrack.singleton.ConnectionManager;

public class PressaoArterialDAO implements DAOInterface<PressaoArterial> {
	Connection con;
	
	@Override
	public void cadastrar(PressaoArterial pressaoArterial, int usuarioId) {
		PreparedStatement ps = null;

		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con
				.prepareStatement(
						"INSERT INTO T_PRESSAO_ARTERIAL (qt_pressao_arterial, t_usuario_id, dt_cadastro) "
						+ "VALUES (?, ?, ?)"
				);

			ps.setString(1, pressaoArterial.getPressaoArterial());
			ps.setInt(2, usuarioId);
			ps.setDate(3, pressaoArterial.getDataCadastro());
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
	public void atualizar(PressaoArterial pressao, int usuarioId) {
		PreparedStatement ps = null;
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con
				.prepareStatement("UPDATE T_PRESSAO_ARTERIAL SET qt_pressao_arterial = ?, t_usuario_id = ?");
			
			ps.setString(1, pressao.getPressaoArterial());
			ps.setInt(2, usuarioId);
			
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
	public PressaoArterial buscar(int id) {
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
	public ArrayList<PressaoArterial> listar(int usuarioId) {
		PreparedStatement ps = null;
		ArrayList<PressaoArterial> pressoes = new ArrayList<PressaoArterial>();
		
		try {		
			con = ConnectionManager.getInstance().getConnection();
			ps = con.prepareStatement(
					"SELECT * FROM T_PRESSAO_ARTERIAL "
					+ "WHERE T_PRESSAO_ARTERIAL.T_USUARIO_ID = ? "
					+ "ORDER BY (SELECT MAX(T_PRESSAO_ARTERIAL.ROWID) FROM T_PRESSAO_ARTERIAL) DESC"
					);
			
			ps.setInt(1, usuarioId);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				PressaoArterial pressaoArterial = new PressaoArterial();
				pressaoArterial.setPressaoArterial(rs.getString("QT_PRESSAO_ARTERIAL"));
				pressaoArterial.setDataCadastro(rs.getDate("DT_CADASTRO"));
				pressoes.add(pressaoArterial);
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

		return pressoes;
	}
	

}
