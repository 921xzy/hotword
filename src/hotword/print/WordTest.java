package hotword.print;
import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.io.Writer;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;

import com.hankcs.hanlp.classification.corpus.Document;

import freemarker.template.Configuration;  
import freemarker.template.Template;  
import freemarker.template.TemplateException;
import hotword.bean.HotWord;
import hotword.dao.HotWordDaoImpl;  
  
/**
 * �����ĵ�
 * @author Administrator
 *
 */
public class WordTest {
      
    private Configuration configuration = null;  
      
    public WordTest(){  
        configuration = new Configuration();  
        configuration.setDefaultEncoding("UTF-8");  
    }  
      
    
    public void exportSimpleWord() throws Exception{  
	       // Ҫ��������, ע��map��keyҪ��word��${xxx}��xxxһ��  
	      Map<String,String> dataMap = new HashMap<String,String>();  
	      HotWordDaoImpl wordDao = new HotWordDaoImpl();
			List<HotWord> hotwords = null;
			String wordExplain = null;
			
			/*startһ������*/
			hotwords = wordDao.load_type_limit10("�ƾ�");
			/*for(HotWord word : hotwords) {
				wordExplain = wordDao.getExplain(word.getName());
				word.setWordExplain(wordExplain);
			}*/
			for(int i = 1;i<11;i++) {
				dataMap.put("word"+i , hotwords.get(i-1).getName());
				dataMap.put("explain"+i, hotwords.get(i-1).getWordExplain());
			}
			/*endһ������*/
			 
			/*startһ������*/
			hotwords = wordDao.load_type_limit10("����");
			for(int i = 11;i<21;i++) {
				dataMap.put("word"+i , hotwords.get(i-11).getName());
				dataMap.put("explain"+i, hotwords.get(i-11).getWordExplain());
			}
			/*endһ������*/
			
			/*startһ������*/
			hotwords = wordDao.load_type_limit10("����");
			for(int i = 21;i<31;i++) {
				dataMap.put("word"+i , hotwords.get(i-21).getName());
				dataMap.put("explain"+i, hotwords.get(i-21).getWordExplain());
			}
			/*endһ������*/
			
			/*startһ������*/
			hotwords = wordDao.load_type_limit10("�ȵ�");
			for(int i = 31;i<41;i++) {
				dataMap.put("word"+i , hotwords.get(i-31).getName());
				dataMap.put("explain"+i, hotwords.get(i-31).getWordExplain());
			}
			/*endһ������*/
			
			/*startһ������*/
			hotwords = wordDao.load_type_limit10("�ӵ�");
			for(int i = 41;i<51;i++) {
				dataMap.put("word"+i , hotwords.get(i-41).getName());
				dataMap.put("explain"+i, hotwords.get(i-41).getWordExplain());
			}
			/*endһ������*/
			
			/*startһ������*/
			hotwords = wordDao.load_type_limit10("�г�");
			for(int i = 51;i<61;i++) {
				dataMap.put("word"+i , hotwords.get(i-51).getName());
				dataMap.put("explain"+i, hotwords.get(i-51).getWordExplain());
			}
			/*endһ������*/
			
			System.out.println("word�ѳɹ����ɣ�");

	      
	    //Configuration���ڶ�ȡftl�ļ�  
	      Configuration configuration = new Configuration();  
	      configuration.setDefaultEncoding("utf-8");  
	        
	      /*����������ָ��ftl�ļ�����Ŀ¼·���ķ�ʽ, ע�������ַ�ʽ���� 
	       * ָ��ftl�ļ�����Ŀ¼��·��,������ftl�ļ���·�� 
	       */  
	      //ָ��·���ĵ�һ�ַ�ʽ(����ĳ��������·��ָ��)  
	      configuration.setClassForTemplateLoading(this.getClass(),"");  
	        
	      //ָ��·���ĵڶ��ַ�ʽ,�ҵ�·����C:/a.ftl  
	      //configuration.setDirectoryForTemplateLoading(new File("E:/"));  
	        
	        
	      // ����ĵ�·��������  
	     File outFile = new File("E:/��Ϣ�������ȴʷ������������.doc");  
	       
	     //��utf-8�ı����ȡftl�ļ�  
	     Template t =  configuration.getTemplate("print(import).ftl","utf-8");  
	     Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);  
	        t.process(dataMap, out);  
	        out.close();  
	   }  
    
    public static void main(String[] args) throws Exception {  
        /*test.createWord();*/  
    	WordTest test = new WordTest(); 
        test.exportSimpleWord();
    	
    		
    }  
      
    public void createWord(){  
        Map<String,Object> dataMap=new HashMap<String,Object>();  
        getData(dataMap);  
        configuration.setClassForTemplateLoading(this.getClass(), "/com");  //FTL�ļ������ڵ�λ��  
        Template t=null;  
        try {
//            t = configuration.getTemplate("wordModel.ftl"); //�ļ���
            t = configuration.getTemplate("myword.ftl"); //�ļ���
        } catch (IOException e) {
            e.printStackTrace();  
        }
        File outFile = new File("D:/outFilessa"+Math.random()*10000+".doc");  
        Writer out = null;  
        try {  
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));  
        } catch (FileNotFoundException e1) {  
            e1.printStackTrace();  
        }  
           
        try {  
            t.process(dataMap, out);  
        } catch (TemplateException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    private void getData(Map<String, Object> dataMap) {  
        dataMap.put("title", "����˵��̫����");  
        dataMap.put("year", "2012");  
        dataMap.put("month", "2");  
        dataMap.put("day", "13");  
        dataMap.put("auditor", "����");  
        dataMap.put("phone", "13020265912");  
        dataMap.put("weave", "ռ����");  
//      dataMap.put("number", 1);  
//      dataMap.put("content", "����"+2);  
          
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();  
        for (int i = 0; i < 10; i++) {  
            Map<String,Object> map = new HashMap<String,Object>();  
            map.put("number", i);  
            map.put("content", "����"+i);  
            list.add(map);  
        }
        dataMap.put("list", list);  
    }  
}
