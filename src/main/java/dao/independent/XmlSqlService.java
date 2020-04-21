package dao.independent;

import dao.independent.jaxb.SqlType;
import dao.independent.jaxb.Sqlmap;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class XmlSqlService implements SqlService {
    private Map<String, String> sqlMap = new HashMap<>();
    private String sqlmapFile;


    public XmlSqlService() {
//        String contextPath = Sqlmap.class.getPackage().getName();
//        try {
//            JAXBContext context = JAXBContext.newInstance(contextPath);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            InputStream is = UserDao.class.getResourceAsStream("independent/sqlmap.xml");
//            Sqlmap sqlmap = (Sqlmap) unmarshaller.unmarshal(is);
//
//            for (SqlType sqlType : sqlmap.getSql()) {
//                sqlMap.put(sqlType.getKey(), sqlType.getValue());
//            }
//        } catch (JAXBException e) {
//            throw new RuntimeException();
//        }
    }

    @PostConstruct
    public void loadSql(){
        String contextPath = Sqlmap.class.getPackage().getName();
        try {
            JAXBContext context = JAXBContext.newInstance(contextPath);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InputStream is = UserDao.class.getResourceAsStream(this.sqlmapFile);
            Sqlmap sqlmap = (Sqlmap) unmarshaller.unmarshal(is);

            for (SqlType sqlType : sqlmap.getSql()) {
                sqlMap.put(sqlType.getKey(), sqlType.getValue());
            }
        } catch (JAXBException e) {
            throw new RuntimeException();
        }
    }
    public void setSqlmapFile(String sqlmapFile) {
        this.sqlmapFile = sqlmapFile;
    }

    @Override
    public String getSql(String key) throws SqlRetrievalFailureException {
        String sql = sqlMap.get(key);
        if (sql == null) {
            throw new SqlRetrievalFailureException(key + "를 이용해서 SQL을 찾을 수 없습니다.");
        }
        return sql;
    }
}
