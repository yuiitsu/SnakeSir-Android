package zoba.me.snakesir;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    private int tableWidth;
    private int tableHeight;

    public GameView gameView;
    private GameHandler gameHandler;

    public MainActivity() {
        tableWidth = 0;
        tableHeight = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gameView = new GameView(this);
        setContentView(gameView);

        gameHandler = new GameHandler(MainActivity.this);

        // 获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        // 获取屏幕宽和高
        tableWidth = metrics.widthPixels;
        tableHeight = metrics.heightPixels;

        // 定时器
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                gameHandler.sendEmptyMessage(0x123);
            }
        }, 0, 1000);
    }
}
