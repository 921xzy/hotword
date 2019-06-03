package hotword.print;

import java.awt.Color;    
import java.io.FileNotFoundException;    
import java.io.FileOutputStream;
import java.util.List;

import com.lowagie.text.Document;    
import com.lowagie.text.DocumentException;    
import com.lowagie.text.Font;    
import com.lowagie.text.PageSize;    
import com.lowagie.text.Paragraph;    
import com.lowagie.text.rtf.RtfWriter2;

import hotword.bean.HotWord;
import hotword.dao.HotWordDaoImpl;  
/**   
  * ����word�ĵ� ����:    
  * 1,�����ĵ�    
  * 2,����һ����д��    
  * 3,���ĵ�    
  * 4,���ĵ���д������    
  * 5,�ر��ĵ�   
  */   
 public class Java2word {    
   
  public static void main(String[] args) {    
 creatDoc("C:/Users/Administrator/Desktop/test/��Ϣ���ȴ�.doc");
  }

/*  public static void fenleiPut(Document document, String type,String number) {
	  HotWordDaoImpl wordDao = new HotWordDaoImpl();
	  List<HotWord> hotwords = null;
	  String wordExplain = null;

	  //���ࣺ�г������ơ��ȵ㡢�ӵ㡢�ƾ�������
	  
  	   try {
  		//startһ��������
  		   //����
  		  Paragraph p = new Paragraph("�г�",new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
  		  document.add(p);
  		  hotwords = wordDao.load_type("�г�");	   
  		  for(HotWord hotword : hotwords) {
		  //�ȴ�����
  			  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
  			  document.add(word);  
  			  //�ȴʽ���
  			  wordExplain = wordDao.getExplain(hotword.getName());
  			  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
  			  document.add(p); 
  		  }
  		 //endһ��������
	  } catch (DocumentException e) {    
		  e.printStackTrace();    
	  } 

 }	 */  

  
  public static void creatDoc(String path) {
	  //����ֽ�ŵĴ�С  
	  Document document = new Document(PageSize.A4);   
	  try {    
		  //����word�ĵ�
	   RtfWriter2.getInstance(document,new FileOutputStream(path));    
	   //���ĵ�
	   document.open();    
	      
	  //��������
	  Paragraph p = new Paragraph("��Ϣ���ȴ�",new Font(Font.NORMAL, 15, Font.BOLD, new Color(0, 0, 0)) );    
	  //���ö���Ϊ���ж���
	  p.setAlignment(Paragraph.ALIGN_CENTER);    
	  //д�����
	  document.add(p);  
	      
	  
	  HotWordDaoImpl wordDao = new HotWordDaoImpl();
	  List<HotWord> hotwords = null;
	  String wordExplain = null;

	  //���ࣺ�г������ơ��ȵ㡢�ӵ㡢�ƾ�������
	  
	//startһ��������
	   //����
	   p = new Paragraph("һ���г�",new Font(Font.NORMAL, 14, Font.BOLD, new Color(0, 0, 0)) );       
	   document.add(p);
	   hotwords = wordDao.load_type("�г�");	   
	   for(HotWord hotword : hotwords) {
		   //�ȴ�����
		  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
		  document.add(word);  
		  //�ȴʽ���
		  wordExplain = wordDao.getExplain(hotword.getName());
		  System.out.println("---"+wordExplain);
		  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
		  document.add(p); 
	  }
	//endһ��������
	   
	 //startһ��������
	   //����
	   p = new Paragraph("��������",new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
	   document.add(p);
	   hotwords = wordDao.load_type("����");	   
	   for(HotWord hotword : hotwords) {
		   //�ȴ�����
		  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
		  document.add(word);  
		  //�ȴʽ���
		  wordExplain = wordDao.getExplain(hotword.getName());
		  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
		  document.add(p); 
	  }
	//endһ��������
	   
	 //startһ��������
	   //����
	   p = new Paragraph("�����ȵ�",new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
	   document.add(p);
	   hotwords = wordDao.load_type("�ȵ�");	   
	   for(HotWord hotword : hotwords) {
		   //�ȴ�����
		  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
		  document.add(word);  
		  //�ȴʽ���
		  wordExplain = wordDao.getExplain(hotword.getName());
		  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
		  document.add(p); 
	  }
	//endһ��������	   
	   
	 //startһ��������
	   //����
	   p = new Paragraph("�ġ��ӵ�",new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
	   document.add(p);
	   hotwords = wordDao.load_type("�ӵ�");	   
	   for(HotWord hotword : hotwords) {
		   //�ȴ�����
		  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
		  document.add(word);  
		  //�ȴʽ���
		  wordExplain = wordDao.getExplain(hotword.getName());
		  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
		  document.add(p); 
	  }
	//endһ��������	   
	   
	 //startһ��������
	   //����
	   p = new Paragraph("�塢�ƾ�",new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
	   document.add(p);
	   hotwords = wordDao.load_type("�ƾ�");	   
	   for(HotWord hotword : hotwords) {
		   //�ȴ�����
		  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
		  document.add(word);  
		  //�ȴʽ���
		  wordExplain = wordDao.getExplain(hotword.getName());
		  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
		  document.add(p); 
	  }
	//endһ��������	   
	   
	 //startһ��������
	   //����
	   p = new Paragraph("��������",new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
	   document.add(p);
	   hotwords = wordDao.load_type("����");	   
	   for(HotWord hotword : hotwords) {
		   //�ȴ�����
		  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
		  document.add(word);  
		  //�ȴʽ���
		  wordExplain = wordDao.getExplain(hotword.getName());
		  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
		  document.add(p); 
	  }
	//endһ��������	   
	  System.out.println("�ĵ��ѳɹ����ɣ�");
	   
	      //����
	      document.close();    
	  } catch (FileNotFoundException e) {    
	   e.printStackTrace();    
	  } catch (DocumentException e) {    
	   e.printStackTrace();    
	  } 
}    
 }   