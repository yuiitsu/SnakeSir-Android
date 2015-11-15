package zoba.me.snakesir.bean;

/**
 * 每一个蛇身对象
 * Created by onlyfu on 11/15/2015.
 */
public class SnakeSirBody {

    // 身体前一步位置的坐标
    private int positionPreX;
    private int positionPreY;
    // 身体当前位置的坐标
    private int positionX;
    private int positionY;

    // 身体高宽
    private int bodyWidth;
    private int bodyHeight;

    // 前行方向，1/2/3/4分别对应上/右/下/左
    private int direction;

    public SnakeSirBody() {
        bodyWidth = 10;
        bodyHeight = 10;
        direction = 2;
    }

    public int getPositionPreX() {
        return positionPreX;
    }

    public void setPositionPreX(int positionPreX) {
        this.positionPreX = positionPreX;
    }

    public int getPositionPreY() {
        return positionPreY;
    }

    public void setPositionPreY(int positionPreY) {
        this.positionPreY = positionPreY;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getBodyWidth() {
        return bodyWidth;
    }

    public int getBodyHeight() {
        return bodyHeight;
    }
}
