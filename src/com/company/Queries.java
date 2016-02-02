package com.company;

/**
 * Created by DanNetoff on 30.01.2016.
 */
public class Queries {

    public static final String SELECT_FILIALS_LIST_BY_ENABL= "SELECT number_filial, code_filial FROM filials WHERE enabl = ?";

    public static final String IMPORT_INTO_DAILY_DATA_FROM_FILIALS = "INSERT INTO dailyData (codeFilial,loadDate,loadStatus) " +
            "SELECT code_filial,now(),0 FROM filials " +
            " WHERE enabl=true";

    public static final String SELECT_COUNT_BY_DATE = "SELECT count(id) FROM dailyData WHERE loadDate = ? ";

    public static final String SELECT_COUNT_BY_STATUS = "SELECT count(id) FROM dailyData WHERE loadStatus = ? ";

    public static final String INSERT_INTO_LOAD_DATA = "1";
}
