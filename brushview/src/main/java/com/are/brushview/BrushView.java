/**
 *   Copyright (C) 2017 ARuizE
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
*/

package com.are.brushview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Andres on 03/01/2017.
 */

public class BrushView extends View {
    private int radius;
    private int left = 10;
    private int top = 10;
    private Paint circle, square;
    private int color = Color.BLUE;
    private int alphaValue = 255;

    public BrushView(Context context) {
        super(context);
        initWith(context, null);
    }

    public BrushView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWith(context, attrs);
    }

    public BrushView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initWith(context, attrs);
    }

    private void initWith(Context context, AttributeSet attrs) {
        circle = new Paint();
        square = new Paint();

        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BrushView);

        radius = typedArray.getInt(R.styleable.BrushView_brush_size, 5);
        alphaValue = typedArray.getInt(R.styleable.BrushView_brush_alpha, 255);
        color = typedArray.getInt(R.styleable.BrushView_brush_color, Color.BLUE);

        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        circle.setAntiAlias(true);
        circle.setStyle(Paint.Style.FILL);
        circle.setColor(color);
        circle.setAlpha(alphaValue);

        square.setAntiAlias(true);
        square.setStyle(Paint.Style.STROKE);
        square.setStrokeWidth(5);
        square.setColor(Color.BLUE);

        canvas.drawCircle(getWidth()/2, getHeight()/2, getRadius(), circle);
        canvas.drawRect(left, top, getWidth()-left, getHeight()-top, square);

    }

    public void setRadius(int radius) {
        this.radius = radius;
        invalidate();
    }

    public int getRadius() {
        return radius;
    }

    public void setColor(int color){
        this.color = color;
        circle.setColor(color);
        invalidate();
    }

    public int getColor(){
        return color;
    }

    public void setAlphaValue(int alphaValue){
        this.alphaValue = alphaValue;
        circle.setAlpha(alphaValue);
        invalidate();
    }

    public int getAlphaValue(){
        return alphaValue;
    }
}
