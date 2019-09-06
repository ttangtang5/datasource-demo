package com.tang.config;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-03 22:43
 * @Version 1.0
 **/
public enum DataSourceType {

    SOURCE_FIRST("first", "默认数据源"),
    SOURCE_SECOND("second", "数据源二");

    private String name;

    private String description;

    DataSourceType(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * @param hashKey
     * @return
     */
    public static String getByKey(String hashKey){
        //根据hashkey来获取所需要的数据源
        int i = Math.abs(hashKey.hashCode()) % DataSourceType.values().length;
        return DataSourceType.values()[i].getName();
    }

}
