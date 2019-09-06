package com.tang.multidatasource.config;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-06 15:59
 * @Version 1.0
 **/
public enum DataSourceType {

    SOURCE_MASTER("fooDataSource", "默认数据源"),
    SOURCE_SALVE("barDataSource", "bar数据源");

    private String value;

    private String name;

    private DataSourceType(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
