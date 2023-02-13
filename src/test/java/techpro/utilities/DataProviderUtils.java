package techpro.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
    @DataProvider
    public Object[][] musteriVerileri(){
        Object [][] musteriGirisBilgileri = {
                {"menejer1","12345"},
                {"menejer2","98765"},
                {"mejejer3","5678"}
        };
        return musteriGirisBilgileri;
    }
    @DataProvider
    public Object[][] musteriHizmetleriVerileri(){
        Object [][] musteriHizmetleriGirisBilgileri = {
                {"adam1","3456"},
                {"ali2","1234"},
                {"nancy3","7890"}
        };
        return musteriHizmetleriGirisBilgileri;
    }
    @DataProvider
    public Object[][] personelVerileri(){
        Object [][] personelGirisBilgileri = {
                {"rukiye1","abc1"},
                {"mehmet2","123r"},
                {"emin3","3edc"},
                {"baran3","4asd"},
                {"okumus3","6e45"}
        };
        return personelGirisBilgileri;
    }
    @DataProvider
    public Object[][] customerData(){
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        Object[][] musteriBilgileri = excelUtils.getDataArrayWithoutFirstRow();
        return musteriBilgileri;

    }
}
