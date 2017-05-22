package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
public class DoReadExcel {

    public List<EntBasesContents> readBasesExcel() throws IOException {
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(new FileInputStream("D:\\buyal\\铝业企业基础数据.xlsx"));

        EntBasesContents entBasesContents = null;

        List<EntBasesContents> list = new ArrayList<EntBasesContents>();

        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){
            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

            if(hssfSheet == null){
                continue;
            }

            for(int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++){
                XSSFRow hssfRow = hssfSheet.getRow(rowNum);

                if(hssfRow != null){
                    entBasesContents = new EntBasesContents();
                    entBasesContents.setCategory(hssfRow.getCell(0) == null ?"":getValue(hssfRow.getCell(0)));
                    entBasesContents.setName(hssfRow.getCell(1) == null ?"":getValue(hssfRow.getCell(1)));
                    entBasesContents.setAddress(hssfRow.getCell(2) == null ?"":getValue(hssfRow.getCell(2)));
                    entBasesContents.setTele(hssfRow.getCell(3) == null ?"":getValue(hssfRow.getCell(3)));
                    entBasesContents.setFax(hssfRow.getCell(4) == null ?"":getValue(hssfRow.getCell(4)));
                    entBasesContents.setUrl(hssfRow.getCell(5) == null ?"":getValue(hssfRow.getCell(5)));
                    entBasesContents.setEmail(hssfRow.getCell(6) == null ?"":getValue(hssfRow.getCell(6)));
                    entBasesContents.setMainproduct(hssfRow.getCell(7) == null ?"":getValue(hssfRow.getCell(7)));
                    entBasesContents.setIntroduce(hssfRow.getCell(8) == null ?"":getValue(hssfRow.getCell(8)));

                    list.add(entBasesContents);
                }
            }

        }
        return list;
    }

    public List<EntUpContents> readUpStreamExcel() throws IOException {
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(new FileInputStream("D:\\buyal\\上游信息整理.xlsx"));

        EntUpContents ent = null;
        List<EntUpContents> list = new ArrayList<EntUpContents>();

        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){
            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

            if(hssfSheet == null){
                continue;
            }

            for(int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++){
                XSSFRow hssfRow = hssfSheet.getRow(rowNum);

                if(hssfRow != null){
                    ent = new EntUpContents();
                    ent.setName(hssfRow.getCell(0) == null ?"":getValue(hssfRow.getCell(0)));
                    ent.setDirect(hssfRow.getCell(1) == null ?"":getValue(hssfRow.getCell(1)));
                    ent.setProducttype(hssfRow.getCell(2) == null ?"":getValue(hssfRow.getCell(2)));
                    ent.setAddress(hssfRow.getCell(3) == null ?"":getValue(hssfRow.getCell(3)));
                    ent.setContract(hssfRow.getCell(4) == null ?"":getValue(hssfRow.getCell(4)));
                    ent.setTele(hssfRow.getCell(5) == null ?"":getValue(hssfRow.getCell(5)));
                    ent.setProductnum(hssfRow.getCell(6) == null ?"":getValue(hssfRow.getCell(6)));
                    ent.setMainproduct(hssfRow.getCell(7) == null ?"":getValue(hssfRow.getCell(7)));
                    list.add(ent);
                }
            }

        }
        return list;
    }

    public List<EntBusinessCard> readCardExcel() throws IOException {
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(new FileInputStream("D:\\buyal\\名片总和.xlsx"));

        EntBusinessCard card = null;
        List<EntBusinessCard> list = new ArrayList<EntBusinessCard>();

        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){
            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

            if(hssfSheet == null){
                continue;
            }

            for(int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++){
                XSSFRow hssfRow = hssfSheet.getRow(rowNum);

                if(hssfRow != null){
                    card = new EntBusinessCard();
                    card.setProperty(hssfRow.getCell(0) == null ?"":getValue(hssfRow.getCell(0)));
                    card.setRole(hssfRow.getCell(1) == null ?"":getValue(hssfRow.getCell(1)));
                    card.setName(hssfRow.getCell(2) == null ?"":getValue(hssfRow.getCell(2)));
                    card.setDirect(hssfRow.getCell(3) == null ?"":getValue(hssfRow.getCell(3)));
                    card.setPostcode(hssfRow.getCell(4) == null ?"":getValue(hssfRow.getCell(4)));
                    card.setRealaddress(hssfRow.getCell(5) == null ?"":getValue(hssfRow.getCell(5)));
                    card.setEnttype(hssfRow.getCell(6) == null ?"":getValue(hssfRow.getCell(6)));
                    card.setLine(hssfRow.getCell(7) == null ?"":getValue(hssfRow.getCell(7)));
                    card.setMainproduct(hssfRow.getCell(8) == null ?"":getValue(hssfRow.getCell(8)));
                    card.setMainproductpic(hssfRow.getCell(9) == null ?"":getValue(hssfRow.getCell(9)));
                    card.setScale(hssfRow.getCell(10) == null ?"":getValue(hssfRow.getCell(10)));
                    card.setUrl(hssfRow.getCell(11) == null ?"":getValue(hssfRow.getCell(11)));
                    card.setFax(hssfRow.getCell(12) == null ?"":getValue(hssfRow.getCell(12)));
                    card.setWorkshopstatus(hssfRow.getCell(13) == null ?"":getValue(hssfRow.getCell(13)));
                    card.setCapacity(hssfRow.getCell(14) == null ?"":getValue(hssfRow.getCell(14)));
                    card.setContract(hssfRow.getCell(15) == null ?"":getValue(hssfRow.getCell(15)));
                    card.setTele(hssfRow.getCell(17) == null ?"":getValue(hssfRow.getCell(17)));
                    card.setEmail(hssfRow.getCell(18) == null ?"":getValue(hssfRow.getCell(18)));
                    card.setIntroduce(hssfRow.getCell(19) == null ?"":getValue(hssfRow.getCell(19)));

                    list.add(card);
                }
            }

        }
        return list;
    }

    public String getValue(XSSFCell hssfCell){
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}
