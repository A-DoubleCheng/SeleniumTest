import utils.EntBasesContents;
import utils.EntBusinessCard;
import utils.EntMember;
import utils.EntUpContents;

import java.sql.*;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
public class MysqlConnect {
    //定义MySQL数据库的连接地址
    public static final String DBURL = "jdbc:mysql://192.168.2.203:3306/masterdata?autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=false";
    public static final String DBURL_maptest = "jdbc:mysql://192.168.2.203:3306/maptest?autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=false";
    //MySQL数据库的连接用户名和连接密码
    public static final String DBUSER = "root";
    public static final String DBPASS = "root";
    public static final String SQLNAME = "com.mysql.jdbc.Driver";

    public String mysqlConn(String sql) {
        Connection conn = null;
        int id;
        String name = null;
        String count = null;
        try{
            Class.forName(SQLNAME);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
//         sql = "SELECT id,name,count(1) FROM yunmap GROUP BY name having count(1) > 1 LIMIT 1";
        try {
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()){
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                count = resultSet.getString("count(1)");
                System.out.println("id: " + id + ", name: " + name + ", count: " + count);
            }
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return name;
    }

    public boolean batchInsertBases(List<EntBasesContents> list) throws ClassNotFoundException, SQLException {
        Class.forName(SQLNAME);
        Connection connection = DriverManager.getConnection(DBURL_maptest, DBUSER, DBPASS);

        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bases_enterprise VALUES (?,?,?,?,?,?,?,?,?,?)");
        int i = 1;
        for(EntBasesContents entBasesContents: list){
            preparedStatement.setInt(1,i);
            preparedStatement.setString(2,entBasesContents.getCategory());
            preparedStatement.setString(3,entBasesContents.getName());
            preparedStatement.setString(4,entBasesContents.getAddress());
            preparedStatement.setString(5,entBasesContents.getTele());
            preparedStatement.setString(6,entBasesContents.getFax());
            preparedStatement.setString(7,entBasesContents.getUrl());
            preparedStatement.setString(8,entBasesContents.getEmail());
            preparedStatement.setString(9,entBasesContents.getMainproduct());
            preparedStatement.setString(10,entBasesContents.getIntroduce());

            preparedStatement.executeUpdate();
            i++;
        }

        connection.commit();

        preparedStatement.close();

        connection.close();

        return true;
    }


    public boolean batchInsertUp(List<EntUpContents> list) throws ClassNotFoundException, SQLException {
        Class.forName(SQLNAME);
        Connection connection = DriverManager.getConnection(DBURL_maptest, DBUSER, DBPASS);

        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO upstream VALUES (?,?,?,?,?,?,?,?,?)");
        int i = 1;
        for(EntUpContents entUpContents: list){
            preparedStatement.setInt(1,i);
            preparedStatement.setString(2,entUpContents.getName());
            preparedStatement.setString(3,entUpContents.getDirect());
            preparedStatement.setString(4,entUpContents.getProducttype());
            preparedStatement.setString(5,entUpContents.getAddress());
            preparedStatement.setString(6,entUpContents.getContract());
            preparedStatement.setString(7,entUpContents.getTele());
            preparedStatement.setString(8,entUpContents.getProductnum());
            preparedStatement.setString(9,entUpContents.getMainproduct());

            preparedStatement.executeUpdate();
            i++;
        }

        connection.commit();

        preparedStatement.close();

        connection.close();
        return true;
    }

    public boolean batchInsertCard(List<EntBusinessCard> list) throws ClassNotFoundException, SQLException {
        Class.forName(SQLNAME);
        Connection connection = DriverManager.getConnection(DBURL_maptest, DBUSER, DBPASS);

        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO businesscard VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        int i = 1;
        for(EntBusinessCard entBusinessCard: list){
            preparedStatement.setInt(1,i);
            preparedStatement.setString(2,entBusinessCard.getProperty());
            preparedStatement.setString(3,entBusinessCard.getRole());
            preparedStatement.setString(4,entBusinessCard.getName());
            preparedStatement.setString(5,entBusinessCard.getDirect());
            preparedStatement.setString(6,entBusinessCard.getPostcode());
            preparedStatement.setString(7,entBusinessCard.getRealaddress());
            preparedStatement.setString(8,entBusinessCard.getEnttype());
            preparedStatement.setString(9,entBusinessCard.getLine());
            preparedStatement.setString(10,entBusinessCard.getMainproduct());
            preparedStatement.setString(11,entBusinessCard.getMainproductpic());
            preparedStatement.setString(12,entBusinessCard.getScale());
            preparedStatement.setString(13,entBusinessCard.getUrl());
            preparedStatement.setString(14,entBusinessCard.getFax());
            preparedStatement.setString(15,entBusinessCard.getWorkshopstatus());
            preparedStatement.setString(16,entBusinessCard.getCapacity());
            preparedStatement.setString(17,entBusinessCard.getContract());
            preparedStatement.setString(18,entBusinessCard.getTele());
            preparedStatement.setString(19,entBusinessCard.getEmail());
            preparedStatement.setString(20,entBusinessCard.getIntroduce());


            preparedStatement.executeUpdate();
            i++;
        }

        connection.commit();

        preparedStatement.close();

        connection.close();
        return true;
    }

    public boolean batchInsertMember(List<EntMember> list) throws ClassNotFoundException, SQLException {
        Class.forName(SQLNAME);
        Connection connection = DriverManager.getConnection(DBURL_maptest, DBUSER, DBPASS);

        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EntMember VALUES (?,?,?,?,?,?,?,?,?,?)");
        int i = 1;
        for(EntMember entMember: list){
            preparedStatement.setInt(1,i);
            preparedStatement.setString(2,entMember.getName());
            preparedStatement.setString(3,entMember.getProperty());
            preparedStatement.setString(4,entMember.getAddress());
            preparedStatement.setString(5,entMember.getDirect());
            preparedStatement.setString(6,entMember.getTele());
            preparedStatement.setString(7,entMember.getFax());
            preparedStatement.setString(8,entMember.getUrl());
            preparedStatement.setString(9,entMember.getEmail());
            preparedStatement.setString(10,entMember.getProduct());

            preparedStatement.executeUpdate();
            i++;
        }

        connection.commit();

        preparedStatement.close();

        connection.close();
        return true;
    }

}
