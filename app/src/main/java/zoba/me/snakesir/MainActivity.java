package zoba.me.snakesir;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

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

        setContentView(R.layout.activity_main);

        gameView = new GameView(this);

        FrameLayout root = (FrameLayout) this.findViewById(R.id.root);
        gameView.setMinimumWidth(300);
        gameView.setMinimumHeight(500);
        //gameView.setBackgroundColor(Color.RED);
        root.addView(gameView);
        //setContentView(gameView);

        gameHandler = new GameHandler(MainActivity.this);

        // 获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        // 获取屏幕宽和高
        tableWidth = metrics.widthPixels;
        tableHeight = metrics.heightPixels;

        // 控制
        Button upButton = (Button) this.findViewById(R.id.upButton);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameView.setDirection(1);
            }
        });

        Button rightButton = (Button) this.findViewById(R.id.rightButton);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameView.setDirection(2);
            }
        });

        Button downButton = (Button) this.findViewById(R.id.downButton);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameView.setDirection(3);
            }
        });

        Button leftButton = (Button) this.findViewById(R.id.leftButton);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameView.setDirection(4);
            }
        });

        // 定时器
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                gameHandler.sendEmptyMessage(0x123);
            }
        }, 0, 100);
    }
}
