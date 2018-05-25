package com.com.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018\5\16 0016.
 */

public class ImageViewCircle extends ImageView{
    private Paint paint;
    public ImageViewCircle(Context context){
        this(context, null);
    }
    public ImageViewCircle(Context context, AttributeSet attributeSet){
        this(context, attributeSet, 0);
    }
    public ImageViewCircle(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        paint = new Paint();
    }


    protected void  onDraw(Canvas canvas){

        Drawable drawable = getDrawable();

        if(null != drawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap bitmap1 = getCirBitmap(bitmap, 14);
            final Rect rect = new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight());
            final Rect rect1 = new Rect(0, 0, getWidth(), getHeight());
            paint.reset();
            canvas.drawBitmap(bitmap1, rect ,rect1, paint);
        }
        else {
            super.onDraw(canvas);
        }
    }


    private Bitmap getCirBitmap(Bitmap bitmap, int pixels){

        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Rect rect =new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        canvas.drawARGB(0,0, 0, 0);
        paint.setColor(color);
        int x = bitmap.getWidth();

        canvas.drawCircle(x/2, x/2, x/2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect ,rect, paint);
        return output;
    }
}
