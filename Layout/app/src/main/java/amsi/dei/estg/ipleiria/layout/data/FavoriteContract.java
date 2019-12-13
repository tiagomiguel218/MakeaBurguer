package amsi.dei.estg.ipleiria.layout.data;

import android.provider.BaseColumns;

public class FavoriteContract {

    public static final class FavoriteEntry implements BaseColumns{

        public static final String TABLE_NAME = "favorite";
        public static final String COLUMN_PRODUCTID = "productid";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_IMAGE = "image";

    }

}
