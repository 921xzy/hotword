package hotword.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import hotword.util.DBUtil;

import hotword.bean.HotWord;

public class HotWordDaoImpl{
	public static void main(String[] args) {
		/*HotWordDaoImpl wordDao = new HotWordDaoImpl();
		   List<HotWord> hotwords = new ArrayList();
		   hotwords = wordDao.load_type("�ȵ�");
		    for(HotWord word : hotwords)
		   {
		    	System.out.println(word.getName());
		    	getExplain(word.getName());
		   }*/
	
	}
	
	/**
	 ��ѯid����ѯ���ȴ�
	 * @return
	 */
	public List<HotWord> loadspell(int id ) {
		Connection connection = DBUtil.getConnection();
		
		String sql = "select * from hotword where id  = ?";
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<HotWord> users = new ArrayList<HotWord>();
		HotWord user = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				user = new HotWord();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setType(resultSet.getString("type"));
				users.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return  users;
		}

	
	
	
	//���ֺõ��ȴʺͷ���д�����ݿ�
	public void add(HotWord hotWord) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		String sql = "insert into hotword(name,type) values (?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, hotWord.getName());
			preparedStatement.setString(2, hotWord.getType());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
	}



	/**
	 * �����ȴʻ�ȡ�ٶȰٿƵĽ���
	 * @param word
	 * @return
	 */
	public static String getExplain(String word) {
		 Document doc;
		 String explain = null;
	        try {       	
	        		doc = Jsoup.connect("https://baike.baidu.com/item/" + word).get();
	        		Elements ListDiv = doc.getElementsByAttributeValue("class","lemma-summary");
	        		//System.out.println(ListDiv.size());
	        		explain = ListDiv.text().toString();
	        		System.out.println("--"+ListDiv.text().toString());
	        		if("".contentEquals(explain) ) {
	        			System.out.println("���ްٿƽ���");
	        			explain = "���ްٿƽ���";
	        		}
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
		return explain;
	}
	
	//����ĳ���ȴ�
	public HotWord load(String word) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		
		String sql = "select * from hotword where name = ?";
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		HotWord hotword = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,word);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				hotword = new HotWord();
				hotword.setId(resultSet.getInt("id"));
				hotword.setName(resultSet.getString("name"));
				hotword.setType(resultSet.getString("type"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return  hotword;

	}
	
	
	public List<HotWord> load() {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		
		String sql = "select * from hotword";
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<HotWord> hotwords = new ArrayList<HotWord>();
		HotWord hotword = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			System.out.println("123456");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				hotword = new HotWord();
				hotword.setId(resultSet.getInt("id"));
				hotword.setName(resultSet.getString("name"));
				hotword.setType(resultSet.getString("type"));

				hotwords.add(hotword);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return  hotwords;

	}
	
	/**
	 * ����������ȴ�
	 * ���ڸ��ݷ��������ȴ�Ŀ¼
	 * @return
	 */
	public List<HotWord> load_type(String type) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		
		String sql = "select * from hotword where type = ? ";
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<HotWord> hotwords = new ArrayList<HotWord>();
		HotWord hotword = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,type);
			System.out.println("�ȴʷ����ѯ");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				hotword = new HotWord();
				hotword.setId(resultSet.getInt("id"));
				hotword.setName(resultSet.getString("name"));
				hotword.setType(resultSet.getString("type"));

				hotwords.add(hotword);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return  hotwords;

	}
	
	/**
	 * ����������ȴ�
	 * ���ڸ��ݷ��������ȴ�word�ĵ�
	 * ÿ������ֻ��ǰ10���ȴ�
	 * @return
	 */
	public List<HotWord> load_type_limit10(String type) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		
		String sql = "select * from hotword where type = ? limit 10 ";
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<HotWord> hotwords = new ArrayList<HotWord>();
		HotWord hotword = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,type);
			System.out.println("�ȴʷ����ѯǰ10");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				hotword = new HotWord();
				hotword.setId(resultSet.getInt("id"));
				hotword.setName(resultSet.getString("name"));
				hotword.setType(resultSet.getString("type"));

				hotwords.add(hotword);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return  hotwords;

	}
	
	//������д�����ݿ�
			public void update(HotWord hotWord) {
				// TODO Auto-generated method stub
				Connection connection = DBUtil.getConnection();
				String sql = "update hotword set wordExplain = ? where name = ? ";
				PreparedStatement preparedStatement = null;
				try {
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, hotWord.getWordExplain());
					preparedStatement.setString(2, hotWord.getName());
					
					preparedStatement.executeUpdate();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					
					
					DBUtil.close(preparedStatement);
					DBUtil.close(connection);
				}
			}


}
