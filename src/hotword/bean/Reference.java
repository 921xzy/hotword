package hotword.bean;

public class Reference {
	private String hotword;//�ȴ�����
	private String explain;//�ȴʽ���
	
	
	private String title;//�������ȴʵ���������
	private String introduce;//���µ���
	private String linkHref;//�������ȴʵ�������ַ����
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLinkHref() {
		return linkHref;
	}
	public void setLinkHref(String linkHref) {
		this.linkHref = linkHref;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getHotword() {
		return hotword;
	}
	public void setHotword(String hotword) {
		this.hotword = hotword;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}


	
}
