package cn.mysqltools;

/**
 * 数据库表中的列
 * Created by Shinelon on 2017/7/23.
 */
public class Column {
    private String dataBaseName; // 所属数据库名
    private String tableName;  // 所属表名
    private String columnName; // 列名
    private String columnType; // 列类型
    private String remarks; // 列的注释

    public Column() {
    }

    public Column(String dataBaseName, String tableName, String columnName, String columnType, String remarks) {
        this.dataBaseName = dataBaseName;
        this.tableName = tableName;
        this.columnName = columnName;
        this.columnType = columnType;
        this.remarks = remarks;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
