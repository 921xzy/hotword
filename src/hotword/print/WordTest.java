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
 * 生成文档
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
	       // 要填充的数据, 注意map的key要和word中${xxx}的xxx一致  
	      Map<String,String> dataMap = new HashMap<String,String>();  
	      HotWordDaoImpl wordDao = new HotWordDaoImpl();
			List<HotWord> hotwords = null;
			String wordExplain = null;
			
			/*start一个分类*/
			hotwords = wordDao.load_type_limit10("财经");
			/*for(HotWord word : hotwords) {
				wordExplain = wordDao.getExplain(word.getName());
				word.setWordExplain(wordExplain);
			}*/
			for(int i = 1;i<11;i++) {
				dataMap.put("word"+i , hotwords.get(i-1).getName());
				dataMap.put("explain"+i, hotwords.get(i-1).getWordExplain());
			}
			/*end一个分类*/
			 
			/*start一个分类*/
			hotwords = wordDao.load_type_limit10("技术");
			for(int i = 11;i<21;i++) {
				dataMap.put("word"+i , hotwords.get(i-11).getName());
				dataMap.put("explain"+i, hotwords.get(i-11).getWordExplain());
			}
			/*end一个分类*/
			
			/*start一个分类*/
			hotwords = wordDao.load_type_limit10("趋势");
			for(int i = 21;i<31;i++) {
				dataMap.put("word"+i , hotwords.get(i-21).getName());
				dataMap.put("explain"+i, hotwords.get(i-21).getWordExplain());
			}
			/*end一个分类*/
			
			/*start一个分类*/
			hotwords = wordDao.load_type_limit10("热点");
			for(int i = 31;i<41;i++) {
				dataMap.put("word"+i , hotwords.get(i-31).getName());
				dataMap.put("explain"+i, hotwords.get(i-31).getWordExplain());
			}
			/*end一个分类*/
			
			/*start一个分类*/
			hotwords = wordDao.load_type_limit10("视点");
			for(int i = 41;i<51;i++) {
				dataMap.put("word"+i , hotwords.get(i-41).getName());
				dataMap.put("explain"+i, hotwords.get(i-41).getWordExplain());
			}
			/*end一个分类*/
			
			/*start一个分类*/
			hotwords = wordDao.load_type_limit10("市场");
			for(int i = 51;i<61;i++) {
				dataMap.put("word"+i , hotwords.get(i-51).getName());
				dataMap.put("explain"+i, hotwords.get(i-51).getWordExplain());
			}
			/*end一个分类*/
			
			System.out.println("word已成功生成！");

	      
	    //Configuration用于读取ftl文件  
	      Configuration configuration = new Configuration();  
	      configuration.setDefaultEncoding("utf-8");  
	        
	      /*以下是两种指定ftl文件所在目录路径的方式, 注意这两种方式都是 
	       * 指定ftl文件所在目录的路径,而不是ftl文件的路径 
	       */  
	      //指定路径的第一种方式(根据某个类的相对路径指定)  
	      configuration.setClassForTemplateLoading(this.getClass(),"");  
	        
	      //指定路径的第二种方式,我的路径是C:/a.ftl  
	      //configuration.setDirectoryForTemplateLoading(new File("E:/"));  
	        
	        
	      // 输出文档路径及名称  
	     File outFile = new File("E:/信息化领域热词分类分析及解释.doc");  
	       
	     //以utf-8的编码读取ftl文件  
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
        configuration.setClassForTemplateLoading(this.getClass(), "/com");  //FTL文件所存在的位置  
        Template t=null;  
        try {
//            t = configuration.getTemplate("wordModel.ftl"); //文件名
            t = configuration.getTemplate("myword.ftl"); //文件名
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
        dataMap.put("title", "标题说的太对了");  
        dataMap.put("year", "2012");  
        dataMap.put("month", "2");  
        dataMap.put("day", "13");  
        dataMap.put("auditor", "唐鑫");  
        dataMap.put("phone", "13020265912");  
        dataMap.put("weave", "占文涛");  
//      dataMap.put("number", 1);  
//      dataMap.put("content", "内容"+2);  
          
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();  
        for (int i = 0; i < 10; i++) {  
            Map<String,Object> map = new HashMap<String,Object>();  
            map.put("number", i);  
            map.put("content", "内容"+i);  
            list.add(map);  
        }
        dataMap.put("list", list);  
    }  
}
