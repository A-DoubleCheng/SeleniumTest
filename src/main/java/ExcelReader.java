import utils.DoReadExcel;
import utils.EntBusinessCard;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
public class ExcelReader {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        DoReadExcel doReadExcel = new DoReadExcel();
//        List<EntBasesContents> list = excelReader.readBasesExcel();
//        List<EntUpContents> list = excelReader.readUpStreamExcel();
        List<EntBusinessCard> list = doReadExcel.readCardExcel();
        MysqlConnect mysqlConnect = new MysqlConnect();
//        boolean flag = mysqlConnect.batchInsertBases(list);
//        boolean flag = mysqlConnect.batchInsertUp(list);
        boolean flag = mysqlConnect.batchInsertCard(list);
        if(!flag){
            System.out.println("error!");
        }
    }

    }

