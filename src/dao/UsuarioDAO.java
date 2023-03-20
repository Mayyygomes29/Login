package dao;

import Controle.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conn;

    public ResultSet autenticacaousuario(Usuarios objusuario) {
        conn = new conexao().conexaoBD();

        try {
            String sql = "select * from usuario where usuario = ? and senha = ? ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuario.getNomeBD());
            pstm.setString(2, objusuario.getSenhaBD());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            return null;
        }

    }
}
