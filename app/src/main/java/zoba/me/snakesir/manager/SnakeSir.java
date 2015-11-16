package zoba.me.snakesir.manager;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

import zoba.me.snakesir.bean.SnakeSirBody;

/**
 * 蛇的操作类
 * Created by onlyfu on 11/15/2015.
 */
public class SnakeSir {

    // 起始坐标
    final int startPositionX = 80;
    final int startPositionY = 80;

    // 初始蛇身长度
    final int snakeBodyLen = 15;

    // 蛇头前进方向
    private int headDirection = 2;

    private List<SnakeSirBody> snakeBody = new ArrayList<>();

    public SnakeSir() {
        System.out.println("init");
    }

    /**
     * 初始化snakeSir
     */
    public void init(Canvas canvas, Paint p) {

        System.out.println("init >>>> ");
        for (int i = 0; i < snakeBodyLen; i++) {

            SnakeSirBody snakeSirBody = new SnakeSirBody();

            if (i > 0) {
                SnakeSirBody snakeSirBodyPre = snakeBody.get(i - 1);
                System.out.println("init >>>> " + i + " >> x: " + (snakeSirBodyPre.getPositionX() -
                        snakeSirBodyPre.getBodyWidth()));
                snakeSirBody.setPositionX(snakeSirBodyPre.getPositionX() -
                        snakeSirBodyPre.getBodyWidth());
                snakeSirBody.setPositionY(snakeSirBodyPre.getPositionY());
            } else {
                System.out.println("init >>>> " + i + " >> x: " + startPositionX);
                snakeSirBody.setPositionPreX(startPositionX);
                snakeSirBody.setPositionPreY(startPositionY);
                snakeSirBody.setPositionX(startPositionX);
                snakeSirBody.setPositionY(startPositionY);
            }

            canvas.drawRect(snakeSirBody.getPositionX(), snakeSirBody.getPositionY(),
                    snakeSirBody.getPositionX() + snakeSirBody.getBodyWidth(),
                    snakeSirBody.getPositionY() + snakeSirBody.getBodyHeight(),
                    p);

            snakeBody.add(snakeSirBody);
        }
    }

    /**
     * 移动
     * @param canvas
     * @param p
     */
    public void run(Canvas canvas, Paint p) {

        int snakeBodyLen = snakeBody.size();
        if (snakeBodyLen == 0) {
            init(canvas, p);
        } else {

            for (int i = 0; i < snakeBodyLen; i++) {

                SnakeSirBody snakeSirBody = snakeBody.get(i);
                int x = 0;
                int y = 0;

                if (i == 0) {
                    if (headDirection == 1) {
                        // 北
                        x = snakeSirBody.getPositionX();
                        y = snakeSirBody.getPositionY() - snakeSirBody.getBodyHeight();

                    } else if (headDirection == 2) {
                        // 东
                        x = snakeSirBody.getPositionX() + snakeSirBody.getBodyWidth();
                        y = snakeSirBody.getPositionY();
                    } else if (headDirection == 3) {
                        // 南
                        x = snakeSirBody.getPositionX();
                        y = snakeSirBody.getPositionY() + snakeSirBody.getBodyHeight();
                    } else if (headDirection == 4) {
                        // 西
                        x = snakeSirBody.getPositionX() - snakeSirBody.getBodyWidth();
                        y = snakeSirBody.getPositionY();
                    }
                } else {
                    SnakeSirBody snakeSirBodyPre = snakeBody.get(i - 1);
                    x = snakeSirBodyPre.getPositionPreX();
                    y = snakeSirBodyPre.getPositionPreY();
                }

                System.out.println(i + " >> xPre: " + snakeSirBody.getPositionPreX());
                System.out.println(i + " >> x: " + x);

                snakeBody.get(i).setPositionPreX(snakeSirBody.getPositionX());
                snakeBody.get(i).setPositionPreY(snakeSirBody.getPositionY());

                snakeBody.get(i).setPositionX(x);
                snakeBody.get(i).setPositionY(y);
                snakeBody.get(i).setDirection(headDirection);

                canvas.drawRect(x, y,
                        x + snakeSirBody.getBodyWidth(),
                        y + snakeSirBody.getBodyHeight(),
                        p);
            }
        }
    }

    public int getHeadDirection() {
        return headDirection;
    }

    public void setHeadDirection(int headDirection) {
        this.headDirection = headDirection;
    }
}
