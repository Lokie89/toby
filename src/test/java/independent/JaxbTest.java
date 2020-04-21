package independent;

import dao.independent.jaxb.SqlType;
import dao.independent.jaxb.Sqlmap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
@RunWith(JUnit4.class)
public class JaxbTest {
    @Test
    public void readSqlmap() throws JAXBException, IOException {
        String contextPath = Sqlmap.class.getPackage().getName();
        JAXBContext context = JAXBContext.newInstance(contextPath);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        Sqlmap sqlmap = (Sqlmap) unmarshaller.unmarshal(
                getClass().getResourceAsStream("sqlmap.xml")
        );
        List<SqlType> sqlTypeList = sqlmap.getSql();

        assertThat(sqlTypeList.size(),is(3));
        assertThat(sqlTypeList.get(0).getKey(),is("add"));
        assertThat(sqlTypeList.get(0).getValue(),is("insert"));
        assertThat(sqlTypeList.get(1).getKey(),is("get"));
        assertThat(sqlTypeList.get(1).getValue(),is("select"));
        assertThat(sqlTypeList.get(2).getKey(),is("delete"));
        assertThat(sqlTypeList.get(2).getValue(),is("delete"));

    }
}
