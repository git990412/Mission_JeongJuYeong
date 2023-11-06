package com.ll;

import lombok.NoArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Sql {
    private SimpleDb simpleDb;
    private StringBuilder sqlSb = new StringBuilder();
    private List<String> statement = new ArrayList<>();

    public Sql(SimpleDb simpleDb){
        this.simpleDb = simpleDb;
    }

    public Sql append(String str) {
        sqlSb.append(str);
        sqlSb.append("\n");
        return this;
    }
    public Sql append(String str, String str2) {
        statement.add(str2);
        sqlSb.append(str);
        sqlSb.append("\n");
        return this;
    }

    public long insert(){
        return simpleDb.insert(sqlSb.toString(), statement);
    }
}
