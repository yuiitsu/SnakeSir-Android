package zoba.me.snakesir;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * Created by onlyfu on 11/15/2015.
 */
public class GameView extends View {

    private int positionX;
    private int positionY;
    private int bodyWidth;
    private int bodyHeight;
    private int direction;

    Paint p = new Paint();
    SnakeSir snakeSir;

    public GameView(Context context) {
        super(context);

        snakeSir = new SnakeSir();

        direction = 2;
    }

    public GameView(Context context, AttributeSet set) {
        super(context, set);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        p.setColor(Color.BLACK);

        // 画蛇
        snakeSir.setHeadDirection(direction);
        snakeSir.run(canvas, p);

        // 画食物
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getBodyWidth() {
        return bodyWidth;
    }

    public int getBodyHeight() {
        return bodyHeight;
    }
}
