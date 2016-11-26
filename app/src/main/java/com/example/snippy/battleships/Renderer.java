package com.example.snippy.battleships;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.ArrayList;

import static com.example.snippy.battleships.Player.EnemyState;

/**
 * Created by Snippy on 2016-11-25.
 */

public class Renderer extends ImageView {

    GameStateProvider provider;
    Paint gridPaint;
    Paint backgroundPaint;
    Drawable background;
    ArrayList<Drawable> ships;

    public Renderer(Context context) {
        super(context);
        init();
    }

    public Renderer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Renderer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        gridPaint = new Paint();
        gridPaint.setColor(Color.WHITE);
        gridPaint.setStyle(Paint.Style.STROKE);
        gridPaint.setStrokeWidth(1);

//        background = getResources().getDrawable(R.drawable.bg, null);
        backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.BLACK);
        backgroundPaint.setStyle(Paint.Style.FILL);

        ships = new ArrayList<>();
        //1-mast lifeboat
        ships.add(getResources().getDrawable(R.drawable.lifeboat, null));
        //2-mast cruiser
        ships.add(getResources().getDrawable(R.drawable.cruiser, null));
        //3-mast submarine
        ships.add(getResources().getDrawable(R.drawable.submarine, null));
        //4-mast destroyer
        ships.add(getResources().getDrawable(R.drawable.destroyer, null));
        //5-mast aircraft carrier
        ships.add(getResources().getDrawable(R.drawable.aircraft_carrier, null));
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        EnemyState[][] grid;
        if (provider != null) {
            grid = provider.getCurrentState();
        }

        //smaller canvas dim
        float dim = (canvas.getWidth() < canvas.getHeight()) ? canvas.getWidth() : canvas.getHeight();

        //draw background
        canvas.drawColor(Color.BLACK);
        canvas.drawRect(0,0,dim, dim, backgroundPaint);

        //grid horizontal lines
        for (int i = 1; i <= 11; i++) {
            canvas.drawLine(0, i*dim/11, dim, i*dim/11, gridPaint);
        }
        //grid vertical lines
        for (int i = 1; i <= 11; i++) {
            canvas.drawLine(i*dim/11, 0, i*dim/11, dim, gridPaint);
        }

        ships.get(1).draw(canvas);
    }

    void setGameStateProvider(GameStateProvider provider) {
        this.provider = provider;
    }
}
