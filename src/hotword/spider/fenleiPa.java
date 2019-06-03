package hotword.spider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class fenleiPa {
    static String url="http://www.xinhuanet.com/info/index.htm";
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	/**
    	 * ��ȡ��վ  https://www.ofweek.com/
    	 * ���ఴ��������վ�ϵķ֣�����
    	 * �г������ơ��ȵ㡢�ӵ㡢�ƾ������� 
    	 * Ŀǰ6��
    	 */
    	
    	
    	 /**
         * ��ַǰ׺��
         * �г�����  "https://www.ofweek.com/CATList-8400-SHICHANGYUANJIU-"
         * ���Ʒ��� "https://www.ofweek.com/CATListNew-25000-8000-"
         * �ȵ���� "https://www.ofweek.com/CATListNew-25000-10000-"
         * �ӵ���� "https://www.ofweek.com/CATList-8500-BIANJISHIDIAN-"
         * �ƾ����� "https://finance.ofweek.com/finance/75011/100/100/"
         * �������� "https://www.ofweek.com/CATListNew-73000-0-"
         */
  
    	String shichangPre = "https://www.ofweek.com/CATList-8400-SHICHANGYUANJIU-";
    	String qushiPre = "https://www.ofweek.com/CATListNew-25000-8000-";
    	String redianPre = "https://www.ofweek.com/CATListNew-25000-10000-";
    	String shidianPre = "https://www.ofweek.com/CATList-8500-BIANJISHIDIAN-";
    	String caijingPre = "https://finance.ofweek.com/finance/75011/100/100/";
    	String jishuPre = "https://www.ofweek.com/CATListNew-73000-0-";
			
       String content = Blog("�г�",shichangPre );
       /* Blog("����",qushiPre );
        Blog("�ȵ�",redianPre );
        Blog("�ӵ�",shidianPre );
        Blog("�ƾ�",caijingPre );
        Blog("����",jishuPre );*/
       System.out.println(content);
        
    }

    /**
     * ��ȡָ���������µ�����
     */
    public static String Blog(String type,String typeURL) {
        Document doc,doc1;
       String content = "";
        try {
        	if(type == "�ƾ�") {
        		System.out.println("�ƾ�----");
        		for (int i = 1; i < 2; i++) { //ÿ��������ȡ��ҳ��
	        		doc = Jsoup.connect(typeURL + i + ".html").get();
	        		Elements ListDiv = doc.getElementsByAttributeValue("class","model_right model_right2").select("h3");
	        		for (Element element :ListDiv) {
		            	String title = element.text();
		            	
		        		System.out.println(type + "-page"+ i+ "-------------------------------------");
		                System.out.println("----html()--" + element.html());
	            		System.out.println("----text()--" + title);
	            		
	            		content += (title +"\n");
	            		//д���ļ�
			           // writeFileByLine(title+"\r\n", "E:\\��ȡ\\" + type + ".txt");
	        		}
	            }
        		
        	}else {
        	
	        	for (int i = 1; i < 2; i++) { //ÿ��������ȡ��ҳ��
	        		doc = Jsoup.connect(typeURL + i + ".html").get();
	        		Elements ListDiv = doc.getElementsByAttributeValue("class","wen").select("h3");
	        		for (Element element :ListDiv) {
		            	String title = element.text();
		            	
		        		System.out.println(type + "-page"+ i+ "-------------------------------------");
		                System.out.println("----html()--" + element.html());
	            		System.out.println("----text()--" + title);
		            
	            		content += (title +"\n");
	            		//д���ļ�
			          //  writeFileByLine(title+"\r\n", "E:\\��ȡ\\" + type + ".txt");
		                
		              
	        		}
	            }
        	}
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return content;
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
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(writer != null) {
				
			}
		}	
		
	}
	

}
