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
  * 创建word文档 步骤:    
  * 1,建立文档    
  * 2,创建一个书写器    
  * 3,打开文档    
  * 4,向文档中写入数据    
  * 5,关闭文档   
  */   
 public class Java2word {    
   
  public static void main(String[] args) {    
 creatDoc("C:/Users/Administrator/Desktop/test/信息化热词.doc");
  }

/*  public static void fenleiPut(Document document, String type,String number) {
	  HotWordDaoImpl wordDao = new HotWordDaoImpl();
	  List<HotWord> hotwords = null;
	  String wordExplain = null;

	  //分类：市场、趋势、热点、视点、财经、技术
	  
  	   try {
  		//start一个分类下
  		   //分类
  		  Paragraph p = new Paragraph("市场",new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
  		  document.add(p);
  		  hotwords = wordDao.load_type("市场");	   
  		  for(HotWord hotword : hotwords) {
		  //热词名称
  			  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
  			  document.add(word);  
  			  //热词解释
  			  wordExplain = wordDao.getExplain(hotword.getName());
  			  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
  			  document.add(p); 
  		  }
  		 //end一个分类下
	  } catch (DocumentException e) {    
		  e.printStackTrace();    
	  } 

 }	 */  

  
  public static void creatDoc(String path) {
	  //设置纸张的大小  
	  Document document = new Document(PageSize.A4);   
	  try {    
		  //创建word文档
	   RtfWriter2.getInstance(document,new FileOutputStream(path));    
	   //打开文档
	   document.open();    
	      
	  //创建段落
	  Paragraph p = new Paragraph("信息化热词",new Font(Font.NORMAL, 15, Font.BOLD, new Color(0, 0, 0)) );    
	  //设置段落为居中对齐
	  p.setAlignment(Paragraph.ALIGN_CENTER);    
	  //写入段落
	  document.add(p);  
	      
	  
	  HotWordDaoImpl wordDao = new HotWordDaoImpl();
	  List<HotWord> hotwords = null;
	  String wordExplain = null;

	  //分类：市场、趋势、热点、视点、财经、技术
	  
	//start一个分类下
	   //分类
	   p = new Paragraph("一、市场",new Font(Font.NORMAL, 14, Font.BOLD, new Color(0, 0, 0)) );       
	   document.add(p);
	   hotwords = wordDao.load_type("市场");	   
	   for(HotWord hotword : hotwords) {
		   //热词名称
		  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
		  document.add(word);  
		  //热词解释
		  wordExplain = wordDao.getExplain(hotword.getName());
		  System.out.println("---"+wordExplain);
		  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
		  document.add(p); 
	  }
	//end一个分类下
	   
	 //start一个分类下
	   //分类
	   p = new Paragraph("二、趋势",new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
	   document.add(p);
	   hotwords = wordDao.load_type("趋势");	   
	   for(HotWord hotword : hotwords) {
		   //热词名称
		  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
		  document.add(word);  
		  //热词解释
		  wordExplain = wordDao.getExplain(hotword.getName());
		  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
		  document.add(p); 
	  }
	//end一个分类下
	   
	 //start一个分类下
	   //分类
	   p = new Paragraph("三、热点",new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
	   document.add(p);
	   hotwords = wordDao.load_type("热点");	   
	   for(HotWord hotword : hotwords) {
		   //热词名称
		  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
		  document.add(word);  
		  //热词解释
		  wordExplain = wordDao.getExplain(hotword.getName());
		  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
		  document.add(p); 
	  }
	//end一个分类下	   
	   
	 //start一个分类下
	   //分类
	   p = new Paragraph("四、视点",new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
	   document.add(p);
	   hotwords = wordDao.load_type("视点");	   
	   for(HotWord hotword : hotwords) {
		   //热词名称
		  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
		  document.add(word);  
		  //热词解释
		  wordExplain = wordDao.getExplain(hotword.getName());
		  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
		  document.add(p); 
	  }
	//end一个分类下	   
	   
	 //start一个分类下
	   //分类
	   p = new Paragraph("五、财经",new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
	   document.add(p);
	   hotwords = wordDao.load_type("财经");	   
	   for(HotWord hotword : hotwords) {
		   //热词名称
		  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
		  document.add(word);  
		  //热词解释
		  wordExplain = wordDao.getExplain(hotword.getName());
		  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
		  document.add(p); 
	  }
	//end一个分类下	   
	   
	 //start一个分类下
	   //分类
	   p = new Paragraph("六、技术",new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
	   document.add(p);
	   hotwords = wordDao.load_type("技术");	   
	   for(HotWord hotword : hotwords) {
		   //热词名称
		  Paragraph word = new Paragraph(hotword.getName(),new Font(Font.NORMAL, 12, Font.BOLD, new Color(0, 0, 0)) );       
		  document.add(word);  
		  //热词解释
		  wordExplain = wordDao.getExplain(hotword.getName());
		  p = new Paragraph("	"+wordExplain +"\r\n",new Font(Font.NORMAL, 12, Font.NORMAL, new Color(0, 0, 0))  );       
		  document.add(p); 
	  }
	//end一个分类下	   
	  System.out.println("文档已成功生成！");
	   
	      //关流
	      document.close();    
	  } catch (FileNotFoundException e) {    
	   e.printStackTrace();    
	  } catch (DocumentException e) {    
	   e.printStackTrace();    
	  } 
}    
 }   