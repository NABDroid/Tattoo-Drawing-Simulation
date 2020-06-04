package com.nabdroid313.tattoostore;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;



public class CursorMachine {


    Bitmap cursor;

    public CursorMachine(Resources res) {
        cursor = BitmapFactory.decodeResource(res, R.drawable.cursor);
        cursor = Bitmap.createScaledBitmap(cursor, 200, 200, false);
    }

    Bitmap getCursor(){
        return cursor;
    }
}
