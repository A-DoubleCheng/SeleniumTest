import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import utils.EntMember;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
public class FilteHtml {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException, SQLException, ClassNotFoundException {
        String html = new String(Files.readAllBytes(Paths.get("D:\\buyal\\会员信息编号.html")));

        List<Object> table = new JXDocument(html).sel("//table[@style='border-collapse:collapse; float:left; margin:0pt 9pt; width:427.1pt']/tbody");

        String name = null;
        String property = null;
        String address = null;
        String direct = null;
        String tele = null;
        String fax = null;
        String url = null;
        String email = null;
        String product = null;

        List<EntMember> list = new ArrayList<>();
        for(Object o: table){
//            System.out.println(o);
            name = new JXDocument(o.toString()).sel("//body/p[2]/span/text()").toString();
            name = name.replaceAll("\\[","").replaceAll("\\]","").replaceAll("，","").replaceAll(",","");
            System.out.println(name);

            property = new JXDocument(o.toString()).sel("//body/p[4]/span/text()").toString();
            property = property.replaceAll("\\[","").replaceAll("\\]","").replaceAll("，","").replaceAll(",","");
            System.out.println(property);

            address = new JXDocument(o.toString()).sel("//body/p[6]/span/text()").toString();
            address = address.replaceAll("\\[","").replaceAll("\\]","").replaceAll("，","").replaceAll(",","");
            System.out.println(address);

            direct = new JXDocument(o.toString()).sel("//body/p[8]/span/text()").toString();
            direct = direct.replaceAll("\\[","").replaceAll("\\]","").replaceAll("，","").replaceAll(",","");
            System.out.println(direct);

            tele = new JXDocument(o.toString()).sel("//body/p[10]/span/text()").toString();
            tele = tele.replaceAll("\\[","").replaceAll("\\]","").replaceAll("，","").replaceAll(",","").replaceAll("=","").replaceAll("\\+","");
            System.out.println(tele);

            fax = new JXDocument(o.toString()).sel("//body/p[12]/span/text()").toString();
            fax = fax.replaceAll("\\[","").replaceAll("\\]","").replaceAll("，","").replaceAll(",","").replaceAll("=","").replaceAll("\\+","");
            System.out.println(fax);

            url = new JXDocument(o.toString()).sel("//body/p[14]/span/text()").toString();
            url = url.replaceAll("\\[","").replaceAll("\\]","").replaceAll("，","").replaceAll(",","");
            System.out.println(url);

            email = new JXDocument(o.toString()).sel("//body/p[16]/span[1]/text()").toString();
            email = email.replaceAll("\\[","").replaceAll("\\]","").replaceAll("，","").replaceAll(",","");
            System.out.println(email);

            product = new JXDocument(o.toString()).sel("//body/p[17]/allText()").toString();
            product = product.replaceAll("\\[","").replaceAll("\\]","").replaceAll("，","").replaceAll(",","").replaceAll("产品：","");
            System.out.println(product);

            EntMember entMember = new EntMember();
            entMember.setName(name);
            entMember.setProperty(property);
            entMember.setAddress(address);
            entMember.setDirect(direct);
            entMember.setTele(tele);
            entMember.setFax(fax);
            entMember.setUrl(url);
            entMember.setEmail(email);
            entMember.setProduct(product);
            list.add(entMember);
        }

        boolean flag = new MysqlConnect().batchInsertMember(list);


    }
}
