package dao.independent;

public interface SqlService {
    String getSql(String key) throws SqlRetrievalFailureException;
}
