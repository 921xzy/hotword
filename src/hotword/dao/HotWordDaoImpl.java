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
		   hotwords = wordDao.load_type("热点");
		    for(HotWord word : hotwords)
		   {
		    	System.out.println(word.getName());
		    	getExplain(word.getName());
		   }*/
	
	}
	
	/**
	 查询id，查询出热词
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

	
	
	
	//将分好的热词和分类写入数据库
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
	 * 根据热词获取百度百科的解释
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
	        			System.out.println("暂无百科解释");
	        			explain = "暂无百科解释";
	        		}
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
		return explain;
	}
	
	//查找某个热词
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
	 * 按分类查找热词
	 * 用于根据分类生成热词目录
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
			System.out.println("热词分类查询");
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
	 * 按分类查找热词
	 * 用于根据分类生成热词word文档
	 * 每个分类只查前10个热词
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
			System.out.println("热词分类查询前10");
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
	
	//将解释写入数据库
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
