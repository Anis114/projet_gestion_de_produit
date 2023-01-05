package com.example.projet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {
    public Helper(@Nullable Context context) {
        super(context,"productManager", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE produit(_id INTEGER PRIMARY KEY, nom TEXT, prix REAL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
db.execSQL("DROP TABLE IF EXISTS produit");
onCreate(db);
    }
   public  void  insertProduit(Produit p){
        SQLiteDatabase db =this.getWritableDatabase();
       ContentValues cv= new ContentValues();
       cv.put("nom",p.getNom());
       cv.put("prix",p.getPrix());
       db.insert("produit",null,cv);
       db.close();
    }
    public  void updateProduit(Produit p){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("nom",p.getNom());
        cv.put("prix",p.getPrix());
        db.update("produit",cv,"id=?",new  String[]{String.valueOf(p.getId())});
        db.close();
    }
    public  void deleteProduit(int  id)
    { SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv= new ContentValues();
       db.delete("produit","_id=?",new  String[]{String.valueOf(id)});
       close();

    }
    public Cursor getAllProduits()
    {SQLiteDatabase db =this.getReadableDatabase();
        Cursor c =db.rawQuery("SELECT * FROM produit",null);
        return c;
    }
public Produit getOneProduit(int id){
    SQLiteDatabase db =this.getReadableDatabase();
    Cursor c= db.query("produit",new String[]{"_id","nom","prix"},"_id=?",
            new String[]{String.valueOf(id)},null,null,null);
    c.moveToFirst();
    Produit p= new Produit(c.getString(1), c.getInt(0),c.getDouble(2));
return  p;}
}
