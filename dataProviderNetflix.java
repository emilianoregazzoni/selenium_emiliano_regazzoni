package pruebaJunio;

import org.testng.annotations.DataProvider;
import pratico14.DataFactory;

public class dataProviderNetflix {

    @DataProvider(name = "credenciales")
    public Object[][] credenciales() {
        String fakeMail1 = DataFactory.getMail();
        String fakeMail2 = DataFactory.getMail();
        String fakeMail3 = DataFactory.getMail();
        return new Object[][]{
                {fakeMail1},
                {fakeMail2},
                {fakeMail3}
        };
    }
}
