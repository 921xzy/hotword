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

//热词引用
public class ReferenceDaoImpl {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*List<Reference> refs = getURL("云计算");
		int i = 1;  
		for(Reference ref : refs) {
			System.out.println(i+"***************************");
			System.out.println("标题--"+ref.getTitle());
			System.out.println("导读--"+ref.getIntroduce());
			System.out.println("链接--"+ref.getLinkHref());
			i++;
		}*/
		
		
		/*String explain = getExplain("云计算");
		System.out.println("--"+explain);*/
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
	 * 根据热词获取近期引用该热词的文章或新闻的href地址、标题、导读信息
	 * @param word
	 * @return
	 */
	public static List<Reference> getURL(String word) {
		 Document doc,doc1;
	        List<Reference> refs = new ArrayList<>();
	        Reference ref = null;
	        try {
	        	int num = 0; //记录获取到的引用热词的文章数量  每个热词只记录爬到的前十篇引用文章
	        	
	        	for (int i = 1; i < 50; i++) {//页码
	        		
	        		//网页内选择按时间排序  Sequence=1
	        		doc = Jsoup.connect("http://www.ofweek.com/newquery.action?type=1&subtype=0&keywords=" + word +"&pagenum=" + i + "&Sequence=1").get();
	        		Elements ListDiv = doc.getElementsByAttributeValue("class","zixun");
	        		for (Element element :ListDiv) {
	        			if(num >= 10){
		        			break;
		        		}
		            	System.out.println("page"+ i+ "-------------------------------------");
		            	System.out.println(element.select("a").text());

		            	System.out.println("p---"+element.select("p"));
		            	
		            	
		            	//文章标题
		            	String title = element.select("a").text();
		            	//文章导读
		            	String introduce = element.select("p").text();
		            	//文章链接
		            	String linkHref = element.select("a").attr("href");

		            	//如果爬取到的文章标题或者导读内容中包含要查询的热词，就写入对象集合
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
	 * 将内容一行行写入到文件中
	 * @param content 内容
	 * @param filePath 文件路径
	 * @return void 无
	 */
	public static void writeFileByLine(String content,String filePath) {
		File file = null;
		PrintWriter writer = null;
		
		try {
			 //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer1 = new FileWriter(filePath, true);
            writer1.write(content);
            writer1.close();
			
					
		/*//创建一个写入的文件
		file = new File(filePath);
		//获取输出文件流的对象
		writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
		//写入到文件内容中
		writer.print(content);
		//刷新同步一次
		writer.flush();*/
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(writer != null) {
				
			}
		}	
		
	}
	
	
	
	

}
