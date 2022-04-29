package com.example.exercise08_07;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class myPictureView extends View {
    String imagePath = null;

    public myPictureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            int bX = (this.getWidth() - bitmap.getWidth()) / 2;
            int bY = (this.getHeight() - bitmap.getHeight()) / 2;
            canvas.scale(2, 2, this.getWidth()/2, this.getHeight()/2);
            canvas.drawBitmap(bitmap, bX, bY, null);
            bitmap.recycle();
        }
    }
}
