package hotword.bean;

/**
 * �ȴ���
 * @author Administrator
 *
 */
public class HotWord {
	/**
	 * ��ȡ��վ  https://www.ofweek.com/
	 * ���ఴ��������վ�ϵķ֣�����
	 * ��ҵ���г������ơ��ȵ㡢�ӵ㡢�ƾ������� 
	 * Ŀǰ7��
	 */
	
	private int id;
	private String name;//�ȴ�����
	private String type;//�ȴʷ���
	private String wordExplain;//�ȴʽ���
	
	
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
