package MPT.mpt.dataSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAOProdutos {

    public static final void insertProduto(Context context, Produto produto) {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DBSchema.ProdutoT.PRICE, produto.getPrice());
        db.insert(DBSchema.ProdutoT.TABLENAME, null, cv);
        db.close();
    }

    public static final void execQueryProduto(Context context, String sql) {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    public static final ArrayList<Produto> getAllProdutos(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Produto> produtos = new ArrayList<>();

        // SELECT * FROM produto;

        Cursor cursor = db.query(
                DBSchema.ProdutoT.TABLENAME,
                null,
                null,
                null,
                null,
                null,
                DBSchema.ProdutoT.TIMESTAMP
        );

        while(cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(DBSchema.ProdutoT._ID));
            float price = cursor.getFloat(cursor.getColumnIndex(DBSchema.ProdutoT.PRICE));
            String timeStamp = cursor.getString(cursor.getColumnIndex(DBSchema.ProdutoT.TIMESTAMP));
            String name = cursor.getString(cursor.getColumnIndex(DBSchema.ProdutoT.NAME));
            String date_promotion = cursor.getString(cursor.getColumnIndex(DBSchema.ProdutoT.DATE_PROMOTION));
            String type = cursor.getString(cursor.getColumnIndex(DBSchema.ProdutoT.TYPE));
            String market = cursor.getString(cursor.getColumnIndex(DBSchema.ProdutoT.MARKET));

            int amount = cursor.getInt(cursor.getColumnIndex(DBSchema.ProdutoT.AMOUNT));
            Produto produto = new Produto( price,  id,  timeStamp,  name,  amount,  date_promotion,  type,  market);
            produtos.add(produto);
        }

        cursor.close();
        db.close();

        return produtos;
    }
}
