package techpro.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//BU SINIF SADECE FAIL OLAN TEST CASELERİ TEKRAR ÇALIŞTIRMAK İÇİN KULLANILIR
public class ListenersRetry implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount=2;
//maxRetryCount çalışma sayısını belirler
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
