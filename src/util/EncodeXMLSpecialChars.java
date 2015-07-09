package util;

/**
 * Created with IntelliJ IDEA.
 *
 * @author olupas
 * @since 3/27/2015
 */

import org.apache.commons.lang3.StringEscapeUtils;

import java.net.URLEncoder;

public class EncodeXMLSpecialChars {

    public static void main(String[] args) throws Exception{

        System.out.println(StringEscapeUtils.escapeXml10("interact!"));
        System.out.println(StringEscapeUtils.escapeXml10("r#Q3HiYuW&zDz9$0"));
        System.out.println(URLEncoder.encode("interact!", "UTF-8"));
        System.out.println(URLEncoder.encode("r#Q3HiYuW&zDz9$0", "UTF-8"));

    }
}
