package hotword.dao;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hotword.bean.Reference;

//�ȴ�����
public class ReferenceDaoImpl {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*List<Reference> refs = getURL("�Ƽ���");
		int i = 1;  
		for(Reference ref : refs) {
			System.out.println(i+"***************************");
			System.out.println("����--"+ref.getTitle());
			System.out.println("����--"+ref.getIntroduce());
			System.out.println("����--"+ref.getLinkHref());
			i++;
		}*/
		
		
		/*String explain = getExplain("�Ƽ���");
		System.out.println("--"+explain);*/
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
	        		System.out.println(ListDiv.text().toString());
	        		explain = ListDiv.text().toString();
	        	/*	for (Element element :ListDiv) {
		            	System.out.println(element.text());

	        		}
	        */
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
		return explain;
	}
	
	
	
	
	
	
	
	
	/**
	 * �����ȴʻ�ȡ�������ø��ȴʵ����»����ŵ�href��ַ�����⡢������Ϣ
	 * @param word
	 * @return
	 */
	public static List<Reference> getURL(String word) {
		 Document doc,doc1;
	        List<Reference> refs = new ArrayList<>();
	        Reference ref = null;
	        try {
	        	int num = 0; //��¼��ȡ���������ȴʵ���������  ÿ���ȴ�ֻ��¼������ǰʮƪ��������
	        	
	        	for (int i = 1; i < 50; i++) {//ҳ��
	        		
	        		//��ҳ��ѡ��ʱ������  Sequence=1
	        		doc = Jsoup.connect("http://www.ofweek.com/newquery.action?type=1&subtype=0&keywords=" + word +"&pagenum=" + i + "&Sequence=1").get();
	        		Elements ListDiv = doc.getElementsByAttributeValue("class","zixun");
	        		for (Element element :ListDiv) {
	        			if(num >= 10){
		        			break;
		        		}
		            	System.out.println("page"+ i+ "-------------------------------------");
		            	System.out.println(element.select("a").text());

		            	System.out.println("p---"+element.select("p"));
		            	
		            	
		            	//���±���
		            	String title = element.select("a").text();
		            	//���µ���
		            	String introduce = element.select("p").text();
		            	//��������
		            	String linkHref = element.select("a").attr("href");

		            	//�����ȡ�������±�����ߵ��������а���Ҫ��ѯ���ȴʣ���д����󼯺�
		            	if(title.contains(word) || introduce.contains(word)) {
		            		ref = new Reference();
		            		ref.setTitle(title);
		            		ref.setIntroduce(introduce);
		            		ref.setLinkHref(linkHref);
		            		refs.add(ref);
		            		System.out.println(title+"----yyyyyyy");
		            		System.out.println(num + "***" + linkHref);
		            		num++;
		            	}	
		                
	        		}
	            
	        	}
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
		return refs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    /**
	 * ������һ����д�뵽�ļ���
	 * @param content ����
	 * @param filePath �ļ�·��
	 * @return void ��
	 */
	public static void writeFileByLine(String content,String filePath) {
		File file = null;
		PrintWriter writer = null;
		
		try {
			 //��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
            FileWriter writer1 = new FileWriter(filePath, true);
            writer1.write(content);
            writer1.close();
			
					
		/*//����һ��д����ļ�
		file = new File(filePath);
		//��ȡ����ļ����Ķ���
		writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
		//д�뵽�ļ�������
		writer.print(content);
		//ˢ��ͬ��һ��
		writer.flush();*/
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(writer != null) {
				
			}
		}	
		
	}
	
	
	
	

}
