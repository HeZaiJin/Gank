package com.haozhang.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/**
 * SlantedTextView 倾斜的文字 不要设置背景
 * @author HaoZhang
 * @date 2016/6/29.
 */
public class SlantedTextView extends View {

    private Paint mPaint;
    private TextPaint mTextPaint;
    private float mSlantedLength = 40;
    private float mTextSize = 16;
    private int mSlantedBackgroundColor = Color.RED;
    private int mTextColor = Color.WHITE;
    private String mSlantedText = "";
    private int mMode = 0;

    public SlantedTextView(Context context) {
        this(context, null);
    }

    public SlantedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public SlantedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SlantedTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.SlantedTextView);

        mTextSize = array.getDimension(R.styleable.SlantedTextView_slantedTextSize, mTextSize);
        mTextColor = array.getColor(R.styleable.SlantedTextView_slantedTextColor, mTextColor);
        mSlantedLength = array.getDimension(R.styleable.SlantedTextView_slantedLength, mSlantedLength);
        mSlantedBackgroundColor = array.getColor(R.styleable.SlantedTextView_slantedBackgroundColor, mSlantedBackgroundColor);
        mSlantedText = array.getString(R.styleable.SlantedTextView_slantedText);
        if (array.hasValue(R.styleable.SlantedTextView_slantedMode)) {
            mMode = array.getInt(R.styleable.SlantedTextView_slantedMode, 0);
        }
        array.recycle();

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        mPaint.setAntiAlias(true);
        mPaint.setColor(mSlantedBackgroundColor);

        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        drawBackground(canvas);
        drawText(canvas);
    }


    public void drawBackground(Canvas canvas) {
        Path path = new Path();
        int w = getWidth();
        int h = getHeight();
        if (w != h) throw new IllegalStateException("SlantedTextView's width must equal to height");
        if (mMode == 0) {
            path.lineTo(w, h);
            path.lineTo(w, h - mSlantedLength);
            path.lineTo(mSlantedLength, 0);
        }else {
            path.moveTo(w,0);
            path.lineTo(0, h);
            path.lineTo(0,h - mSlantedLength);
            path.lineTo(w-mSlantedLength, 0);
        }
        path.close();
        canvas.drawPath(path, mPaint);

        canvas.save();
    }

    public void drawText(Canvas canvas) {
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float fontHeight = fontMetrics.bottom - fontMetrics.top;
        float textBaseY = getHeight() - (getHeight() - fontHeight) / 2 - fontMetrics.bottom;
        double offset = mSlantedLength / 4 - 1;
        float toY = (float) (textBaseY - offset);
        int angle =  45;
        if (mMode == 1){
            angle = -45;
            offset = -offset;
        }
        float toX = (float) (getWidth() / 2 + offset);
        canvas.rotate(angle, toX, toY);
        canvas.drawText(mSlantedText, toX, toY, mTextPaint);
    }

    public void setText(String str) {
        mSlantedText = str;
        postInvalidate();
    }

    public void setText(int res) {
        String str = getResources().getString(res);
        if (!TextUtils.isEmpty(str)) {
            setText(str);
        }
    }

    public String getText() {
        return mSlantedText;
    }

    public void setSlantedBackgroundColor(int color) {
        mSlantedBackgroundColor = color;
        postInvalidate();
    }

    public void setTextColor(int color) {
        mTextColor = color;
        postInvalidate();
    }

}
