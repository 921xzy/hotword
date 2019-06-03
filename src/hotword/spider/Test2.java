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

public class Test2 {
    static String url="http://www.xinhuanet.com/info/index.htm";
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        // TODO Auto-generated method stub
        //BolgBody();
        //test();
        Blog();
        
    	//article();
        /*
         * Document doc = Jsoup.connect("http://www.oschina.net/")
         * .data("query", "Java") // ������� .userAgent("I �� m jsoup") // ����
         * User-Agent .cookie("auth", "token") // ���� cookie .timeout(3000) //
         * �������ӳ�ʱʱ�� .post();
         */// ʹ�� POST �������� URL

        /*
         * // ���ļ��м��� HTML �ĵ� File input = new File("D:/test.html"); Document doc
         * = Jsoup.parse(input,"UTF-8","http://www.oschina.net/");
         */
    }

    /**
     * ��ȡָ��HTML �ĵ�ָ����body
     * @throws IOException
     */
    private static void BolgBody() throws IOException {
        // ֱ�Ӵ��ַ��������� HTML �ĵ�
        String html = "<html><head><title> ��Դ�й����� </title></head>"
                + "<body><p> ������ jsoup ��Ŀ��������� </p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.body());
        System.out.println("****************************************");
        
        // �� URL ֱ�Ӽ��� HTML �ĵ�
        Document doc2 = Jsoup.connect(url).get();
        String title = doc2.body().toString();
        System.out.println(title);
    }

    /**
     * ��ȡ�����ϵ����±��������
     */
    public static void article() {
        Document doc;
        try {
            doc = Jsoup.connect("http://www.cnblogs.com/zyw-205520/").get();
            Elements ListDiv = doc.getElementsByAttributeValue("class","postTitle");
            for (Element element :ListDiv) {
                Elements links = element.getElementsByTag("a");
                for (Element link : links) {
                    String linkHref = link.attr("href");
                    String linkText = link.text().trim();
                    System.out.println(linkHref);
                    System.out.println(linkText);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    /**
     * ��ȡָ���������µ�����
     */
    public static void Blog() {
        Document doc,doc1;
        String keywords = "��Ϣ��";
        try {
        	for (int i = 1; i < 301; i++) {
        		//��ҳ��ѡ��ʱ������  Sequence=1
        		doc = Jsoup.connect("http://www.ofweek.com/newquery.action?type=1&subtype=0&keywords=" + keywords +"&pagenum=" + i + "&Sequence=1").get();
        		Elements ListDiv = doc.getElementsByAttributeValue("class","zixun").select("a");
        		for (Element element :ListDiv) {
	            	String linkHref = element.attr("href");
	            	String title = element.text();
	            	
	        		System.out.println("page"+ i+ "-------------------------------------");
	                System.out.println("----html()--" + element.html());
            		System.out.println("----text()--" + title);
	                System.out.println("***"+linkHref);
	                if("".equals(title) || title == null) { //��ȡ������img��ǩ
	                	//System.out.println("ͼƬ");
		              //  writeFileByLine("ͼƬ"+"\r\n", "E:\\��ȡ\\s����.txt");
	                	continue;
	                }else {
		                writeFileByLine(title+"\r\n", "E:\\��ȡ\\s����.txt");
	                }
	                

	                /*doc1 = Jsoup.connect(linkHref).get();
	                Elements ListDiv1 = doc1.getElementsByAttributeValue("class","article_con").select("p").removeAttr("img");
	                for (Element element1 :ListDiv1) {
	                	 System.out.println("-------------------------------------");
	                	System.out.println(element1.html());
	                	//��������Ϣת�����ı��ļ��洢�ڱ��ط�������
	                	writeFileByLine(element1.html()+"\r\n", "E:\\s1�ȴ�.txt");
	                }*/
        		}
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
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
