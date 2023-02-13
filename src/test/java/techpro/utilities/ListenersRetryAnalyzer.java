package techpro.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class ListenersRetryAnalyzer implements IAnnotationTransformer {
  //Bu sınıfın amacı Tüm FAIL TEST CASE LERİ BİR KEZ DAHA AUTOMATIK OLARAK RUN ETMEK İÇİN KULLANILLIR.
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        //Bu sınıf ListenersRetry sınıfına bağlıdır.
        annotation.setRetryAnalyzer(ListenersRetry.class);
    }
}
