package hotword.bean;

/**
 * 热词类
 * @author Administrator
 *
 */
public class HotWord {
	/**
	 * 爬取网站  https://www.ofweek.com/
	 * 分类按照新闻网站上的分：包含
	 * 企业、市场、趋势、热点、视点、财经、技术 
	 * 目前7个
	 */
	
	private int id;
	private String name;//热词名称
	private String type;//热词分类
	private String wordExplain;//热词解释
	
	
	public String getWordExplain() {
		return wordExplain;
	}
	public void setWordExplain(String wordExplain) {
		this.wordExplain = wordExplain;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
