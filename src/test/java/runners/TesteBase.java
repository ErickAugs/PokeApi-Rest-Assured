package runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentManager;

import java.lang.reflect.Method;

public class TesteBase {

    protected static ExtentReports relatorio;
    protected static ExtentTest teste;

    @BeforeSuite
    public void configurarSuite() {
        relatorio = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void configurarTeste(Method metodo) {
        teste = relatorio.createTest(metodo.getName());
    }

    @AfterMethod
    public void finalizarTeste(ITestResult resultado) {
        if (resultado.getStatus() == ITestResult.FAILURE) {
            teste.fail(resultado.getThrowable());
        } else if (resultado.getStatus() == ITestResult.SUCCESS) {
            teste.pass("Teste passou com sucesso");
        } else if (resultado.getStatus() == ITestResult.SKIP) {
            teste.skip("Teste ignorado");
        }
    }

    @AfterSuite
    public void finalizarSuite() {
        relatorio.flush();
    }
}
