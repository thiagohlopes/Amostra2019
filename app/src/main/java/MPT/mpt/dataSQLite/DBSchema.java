package MPT.mpt.dataSQLite;

import android.provider.BaseColumns;

public class DBSchema {

    public static final class ProdutoT implements BaseColumns {
        public static final String TABLENAME = "produto";
        public static final String PRICE = "p_price";
        public static final String TIMESTAMP = "p_timestamp";
        public static final String NAME = "p_name";
        public static final String DATE_PROMOTION = "p_date_promotion";
        public static final String AMOUNT = "p_amount";
        public static final String TYPE = "type";
        public static final String MARKET = "market";


        public static final String getCreationQuery() {
            return "CREATE TABLE " + TABLENAME + " (" +
                    _ID + " LONGINT PRIMARY KEY AUTOINCREMENT, " +
                    PRICE + " REAL, " +
                    TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                    NAME + "STRING, " +
                    AMOUNT + "INTEGER, " +
                    DATE_PROMOTION + "DATA," +
                    TYPE + " STRING," +
                    MARKET + "STRING" +
                    ")";
        }
    }
}
