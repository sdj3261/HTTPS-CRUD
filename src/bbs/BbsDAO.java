package bbs;
 
import java.sql.*;
import java.util.*;
 
public class BbsDAO {
    private Connection conn;            // DB�� �����ϴ� ��ü
    private ResultSet rs;                // DB data�� ���� �� �ִ� ��ü  (Ctrl + shift + 'o') -> auto import
    
    public BbsDAO(){ 
        try {
            String dbURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
            String dbID = "root";
            String dbPassword = "0000";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getDate() // ����ð��� �־��ֱ�����
    {
        String SQL = "SELECT NOW()"; // ����ð��� ��Ÿ���� mysql
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return rs.getString(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ""; // �����ͺ��̽� ����
    }
    
    public int getNext()
    {
        String SQL = "SELECT bbsID FROM BBS ORDER BY bbsID DESC"; // ������������ ���� �������� ���� ���� �����´�
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return rs.getInt(1) + 1; // �� ���� �Խñ��� ��ȣ
            }
            return 1; // ù ��° �Խù��� ���
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // �����ͺ��̽� ����
    }
    public int write(String bbsTitle, String userID, String bbsContent) {
        String SQL = "INSERT INTO BBS VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, getNext());
            pstmt.setString(2, bbsTitle);
            pstmt.setString(3, userID);
            pstmt.setString(4, getDate());
            pstmt.setString(5, bbsContent);
            pstmt.setInt(6, 1);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // �����ͺ��̽� ����
    }
    public ArrayList<Bbs> getList(int pageNumber)
    {
        String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10"; // ������������ ���� �������� ���� ���� �����´�
        ArrayList<Bbs> list = new ArrayList<Bbs>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, getNext() - (pageNumber - 1 ) * 10);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Bbs bbs = new Bbs();
                bbs.setBbsID(rs.getInt(1));
                bbs.setBbsTitle(rs.getString(2));
                bbs.setUserID(rs.getString(3));
                bbs.setBbsDate(rs.getString(4));
                bbs.setBbsContent(rs.getString(5));
                bbs.setBbsAvailable(rs.getInt(6));
                list.add(bbs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; 
    }
//    ����¡ ó���� ���� �Լ�
    public boolean nextPage(int pageNumber) {
        String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1"; 
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, getNext() - (pageNumber - 1 ) * 10);
            rs = pstmt.executeQuery();
            if (rs.next())
            {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    
    public int update(int bbsID, String bbsTitle, String bbsContent) {

		String SQL = "UPDATE BBS SET bbsTitle = ?, bbsContent = ?, WHERE bbsID = ?";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, bbsTitle);

			pstmt.setString(2, bbsContent);

			pstmt.setInt(3, bbsID);

			return pstmt.executeUpdate();



		} catch (Exception e) {

			e.printStackTrace();

		}

		return -1; // �����ͺ��̽� ����

	}
    
    public int delete(int bbsID) {

		String SQL = "UPDATE BBS SET bbsAvailable = 0 WHERE bbsID = ?";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);   

			pstmt.setInt(1, bbsID);

			return pstmt.executeUpdate();



		} catch (Exception e) {

			e.printStackTrace();

		}

		return -1; // �����ͺ��̽� ����

	}
    
    public Bbs getBbs(int bbsID)
    {
            String SQL = "SELECT * FROM BBS WHERE bbsID = ?"; 
            try {
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                pstmt.setInt(1, bbsID);
                rs = pstmt.executeQuery();
                if (rs.next())
                {
                    Bbs bbs = new Bbs();
                    bbs.setBbsID(rs.getInt(1));
                    bbs.setBbsTitle(rs.getString(2));
                    bbs.setUserID(rs.getString(3));
                    bbs.setBbsDate(rs.getString(4));
                    bbs.setBbsContent(rs.getString(5));
                    bbs.setBbsAvailable(rs.getInt(6));
                    return bbs;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null; 
        }
    }